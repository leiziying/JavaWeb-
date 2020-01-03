
/*

俄罗斯方块游戏java代码

这里由五个类组成，每个类一个文件，

放在同一文件夹底下，运行ErsBlocksGame文件即可

*/



import javax.swing.*;

        import java.awt.*;

        import java.awt.event.*;



/**

 * 游戏主类，继承自JFrame类，负责游戏的全局控制。

 * 内含

 * 1, 一个GameCanvas画布类的实例引用，

 * 2, 一个保存当前活动块(ErsBlock)实例的引用，

 * 3, 一个保存当前控制面板（ControlPanel）实例的引用;

 */

public class ErsBlocksGame extends JFrame {

    /**

     *  每填满一行计多少分

     */

    public final static int PER_LINE_SCORE = 100;

    /**

     * 积多少分以后能升级

     */

    public final static int PER_LEVEL_SCORE = PER_LINE_SCORE * 20;

    /**

     * 最大级数是10级

     */

    public final static int MAX_LEVEL = 10;

    /**

     * 默认级数是5

     */

    public final static int DEFAULT_LEVEL = 5;



    private GameCanvas canvas;  //一个GameCanvas画布类的实例引用，

    private ErsBlock block;     //一个保存当前活动块(ErsBlock)实例的引用，

    private boolean playing = false;

    private ControlPanel ctrlPanel; //一个保存当前控制面板（ControlPanel）实例的引用;



    private JMenuBar bar = new JMenuBar();

    private JMenu

            mGame = new JMenu("Game"),

    mControl = new JMenu("Control"),

    mWindowStyle = new JMenu("WindowStyle"),

    mInfo = new JMenu("Information");

    private JMenuItem

            miNewGame = new JMenuItem("New Game"),

    miSetBlockColor = new JMenuItem("Set Block Color ..."),

    miSetBackColor = new JMenuItem("Set Background Color ..."),

    miTurnHarder = new JMenuItem("Turn up the level"),

    miTurnEasier = new JMenuItem("Turn down the level"),

    miExit = new JMenuItem("Eixt"),



    miPlay = new JMenuItem("Play"),

    miPause = new JMenuItem("Pause"),

    miResume = new JMenuItem("Resume"),

    miStop = new JMenuItem("Stop"),



    miAuthor = new JMenuItem("Author : apple@radiantek.com"),

    miSourceInfo = new JMenuItem("You can get the source code / document by email");





    private JCheckBoxMenuItem

            miAsWindows = new JCheckBoxMenuItem("Windows"),

    miAsMotif = new JCheckBoxMenuItem("Motif"),

    miAsMetal = new JCheckBoxMenuItem("Metal", true);





    /**

     * 主游戏类的构造函数

     * @param title String，窗口标题

     */

//   Dimension scrSize;

    public ErsBlocksGame(String title) {

        super(title);



        setSize(315, 392);

        /*

         *

         *Toolkit类的类方法 public static Toolkit getDefaultToolkit()获取默认工具包。

         *

         *Toolkit类的抽象方法 public abstract Dimension getScreenSize()

         *throws HeadlessException获取屏幕的大小。在具有多个显示屏的系统上，使用主显示屏。

         *从 GraphicsConfiguration 和 GraphicsDevice 可以获得多屏幕感知显示尺寸。

         *

         *返回：

         *此工具包的屏幕大小，以像素为单位。

         *

         **/

        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();

        setLocation((scrSize.width - getSize().width) / 2,

                (scrSize.height - getSize().height) / 2);

        //  System.out.println(scrSize.width+","+scrSize.height);



        createMenu();//创建菜单



        Container container = getContentPane();

        container.setLayout(new BorderLayout(6, 0));//水平间距为6，垂直间距为0



        canvas = new GameCanvas(20, 12);

        ctrlPanel = new ControlPanel(this);



        container.add(canvas, BorderLayout.CENTER);

        container.add(ctrlPanel, BorderLayout.EAST);



        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {

                stopGame();

                System.exit(0);

            }

        });



        addComponentListener(new ComponentAdapter() {

            public void componentResized(ComponentEvent ce) {

                //      System.out.println(scrSize.width+","+scrSize.height);

                canvas.fanning();

            }

        });



        setVisible(true);

        //  show();

        canvas.fanning();

    }



    /**

     * 让游戏“复位”

     */

    public void reset() {

        ctrlPanel.reset();

        canvas.reset();

    }



    /**

     * 判断游戏是否还在进行

     * @return boolean, true-还在运行，false-已经停止

     */

    public boolean isPlaying() {

        return playing;

    }



    /**

     * 得到当前活动的块

     * @return ErsBlock, 当前活动块的引用

     */

    public ErsBlock getCurBlock() {

        return block;

    }



    /**

     * 得到当前画布

     * @return GameCanvas, 当前画布的引用

     */

    public GameCanvas getCanvas() {

        return canvas;

    }



    /**

     * 开始游戏

     */

    public void playGame() {

        play();

        ctrlPanel.setPlayButtonEnable(false);

        miPlay.setEnabled(false);

        ctrlPanel.requestFocus();

    }



    /**

     * 游戏开始

     */

    private void play() {

        reset();

        playing = true;

        Thread thread = new Thread(new Game());

        thread.start();

    }



    /**

     * 游戏暂停

     */

    public void pauseGame() {

        if (block != null) block.pauseMove();



        ctrlPanel.setPauseButtonLabel(false);

        miPause.setEnabled(false);

        miResume.setEnabled(true);

    }



    /**

     * 让暂停中的游戏继续

     */

    public void resumeGame() {

        if (block != null) block.resumeMove();

        ctrlPanel.setPauseButtonLabel(true);

        miPause.setEnabled(true);

        miResume.setEnabled(false);

        ctrlPanel.requestFocus();

    }



    /**

     * 用户停止游戏

     */

    public void stopGame() {

        playing = false;

        if (block != null) block.stopMove();

        miPlay.setEnabled(true);

        miPause.setEnabled(true);

        miResume.setEnabled(false);

        ctrlPanel.setPlayButtonEnable(true);

        ctrlPanel.setPauseButtonLabel(true);

    }



    /**

     * 得到当前游戏者设置的游戏难度

     * @return int, 游戏难度1－MAX_LEVEL

     */

    public int getLevel() {

        return ctrlPanel.getLevel();

    }



    /**

     * 让用户设置游戏难度

     * @param level int, 游戏难度1－MAX_LEVEL

     */

    public void setLevel(int level) {

        if (level < 11 && level > 0) ctrlPanel.setLevel(level);

    }



    /**

     * 得到游戏积分

     * @return int, 积分。

     */

    public int getScore() {

        if (canvas != null) return canvas.getScore();

        return 0;

    }



    /**

     * 得到自上次升级以来的游戏积分，升级以后，此积分清零

     * @return int, 积分。

     */

    public int getScoreForLevelUpdate() {

        if (canvas != null) return canvas.getScoreForLevelUpdate();

        return 0;

    }



    /**

     * 当分数累计到一定的数量时，升一次级

     * @return boolean, ture-update successufl, false-update fail

     */

    public boolean levelUpdate() {

        int curLevel = getLevel();

        if (curLevel < MAX_LEVEL) {

            setLevel(curLevel + 1);

            canvas.resetScoreForLevelUpdate();

            return true;

        }

        return false;

    }







    /**

     * 报告游戏结束了

     */

    private void reportGameOver() {

        JOptionPane.showMessageDialog(this, "Game Over!");

    }



    /**

     * 建立并设置窗口菜单

     */

    private void createMenu() {

        bar.add(mGame);

        bar.add(mControl);

        bar.add(mWindowStyle);

        bar.add(mInfo);



        mGame.add(miNewGame);

        mGame.addSeparator();

        mGame.add(miSetBlockColor);

        mGame.add(miSetBackColor);

        mGame.addSeparator();

        mGame.add(miTurnHarder);

        mGame.add(miTurnEasier);

        mGame.addSeparator();

        mGame.add(miExit);



        mControl.add(miPlay);

        mControl.add(miPause);

        mControl.add(miResume);

        mControl.add(miStop);



        mWindowStyle.add(miAsWindows);

        mWindowStyle.add(miAsMotif);

        mWindowStyle.add(miAsMetal);



        mInfo.add(miAuthor);

        mInfo.add(miSourceInfo);



        setJMenuBar(bar);

        //添加快捷方式

        miPause.setAccelerator(

                KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));

        miResume.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));



        //以上为创建菜单



        //以下为实现事件接口

        miNewGame.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                stopGame();//用户停止游戏

                reset();//让游戏“复位”

                setLevel(DEFAULT_LEVEL);//设置游戏难度

            }

        });

        miSetBlockColor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                Color newFrontColor =       //用弹出对话框的方式，设置的俄罗斯方块的颜色

                        JColorChooser.showDialog(ErsBlocksGame.this,

                                "Set color for block", canvas.getBlockColor());

                if (newFrontColor != null)

                    canvas.setBlockColor(newFrontColor);

            }

        });

        miSetBackColor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                Color newBackColor =        //用弹出对话框的方式，设置背景色

                        JColorChooser.showDialog(ErsBlocksGame.this,

                                "Set color for block", canvas.getBackgroundColor());

                if (newBackColor != null)

                    canvas.setBackgroundColor(newBackColor);

            }

        });

        miTurnHarder.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                int curLevel = getLevel();//增加游戏难度

                if (curLevel < MAX_LEVEL) setLevel(curLevel + 1);

            }

        });

        miTurnEasier.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                int curLevel = getLevel();//降低游戏难度

                if (curLevel > 1) setLevel(curLevel - 1);

            }

        });

        miExit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                System.exit(0);//结束游戏

            }

        });

        miPlay.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                playGame();//开始游戏

            }

        });

        miPause.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                pauseGame();//暂停游戏

            }

        });

        miResume.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                resumeGame();//继续游戏

            }

        });

        miStop.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                stopGame();//停止游戏

            }

        });

        miAsWindows.addActionListener(new ActionListener() {//设置窗体风格为WindowsLookAndFeel

            public void actionPerformed(ActionEvent ae) {

                String plaf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

                setWindowStyle(plaf);

                canvas.fanning();

                ctrlPanel.fanning();

                miAsWindows.setState(true);

                miAsMetal.setState(false);

                miAsMotif.setState(false);

            }

        });

        miAsMotif.addActionListener(new ActionListener() {//设置窗体风格为MotifLookAndFeel

            public void actionPerformed(ActionEvent ae) {

                String plaf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";

                setWindowStyle(plaf);

                canvas.fanning();

                ctrlPanel.fanning();

                miAsWindows.setState(false);

                miAsMetal.setState(false);

                miAsMotif.setState(true);

            }

        });

        miAsMetal.addActionListener(new ActionListener() {//设置窗体风格为MetalLookAndFeel

            public void actionPerformed(ActionEvent ae) {

                String plaf = "javax.swing.plaf.metal.MetalLookAndFeel";

                setWindowStyle(plaf);

                canvas.fanning();

                ctrlPanel.fanning();

                miAsWindows.setState(false);

                miAsMetal.setState(true);

                miAsMotif.setState(false);

            }

        });

    }



    /**

     * 根据字串设置窗口外观

     * @param plaf String, 窗口外观的描述

     *

     *static   void   setLookAndFeel(String   className)

     *设置当前使用的LookAndFeel。参数是类名。

     *LookAndFeel类,顾名思义，LookAndFeel 封装了一个外观

     *

     *updateComponentTreeUI

     *public static void updateComponentTreeUI(Component c)简单的外观更改：

     *将树结构中的每个节点转到 updateUI() -- 也就是说，通过当前外观初始化其 UI 属性。

     *

     *

     */

    private void setWindowStyle(String plaf) {

        try {

            UIManager.setLookAndFeel(plaf);

            SwingUtilities.updateComponentTreeUI(this);

        } catch (Exception e) {

        }

    }



    /**

     * 一轮游戏过程，实现了Runnable接口

     * 一轮游戏是一个大循环，在这个循环中，每隔100毫秒，

     * 检查游戏中的当前块是否已经到底了，如果没有，

     * 就继续等待。如果到底了，就看有没有全填满的行，

     * 如果有就删除它，并为游戏者加分，同时随机产生一个

     * 新的当前块，让它自动下落。

     * 当新产生一个块时，先检查画布最顶上的一行是否已经

     * 被占了，如果是，可以判断Game Over了。

     */

    private class Game implements Runnable {

        public void run() {

            int col = (int) (Math.random() * (canvas.getCols() - 3));

            int style = ErsBlock.STYLES[(int) (Math.random() * 7)][(int) (Math.random() * 4)];



            while (playing) {

                if (block != null) {    //第一次循环时，block为空

                    if (block.isAlive()) {

                        try {

                            Thread.currentThread().sleep(100);

                        } catch (InterruptedException ie) {

                            ie.printStackTrace();

                        }

                        continue;

                    }

                }



                checkFullLine();        //检查是否有全填满的行



                if (isGameOver()) {     //检查游戏是否应该结束了

                    miPlay.setEnabled(true);

                    miPause.setEnabled(true);

                    miResume.setEnabled(false);

                    ctrlPanel.setPlayButtonEnable(true);

                    ctrlPanel.setPauseButtonLabel(true);



                    reportGameOver();

                    return;

                }



                block = new ErsBlock(style, -1, col, getLevel(), canvas);

                block.start();



                col = (int) (Math.random() * (canvas.getCols() - 3));

                style = ErsBlock.STYLES[(int) (Math.random() * 7)][(int) (Math.random() * 4)];



                ctrlPanel.setTipStyle(style);

            }

        }



        /**

         * 检查画布中是否有全填满的行，如果有就删除之

         */

        public void checkFullLine() {

            for (int i = 0; i < canvas.getRows(); i++) {

                int row = -1;

                boolean fullLineColorBox = true;

                for (int j = 0; j < canvas.getCols(); j++) {

                    if (!canvas.getBox(i, j).isColorBox()) {

                        fullLineColorBox = false;

                        break;

                    }

                }

                if (fullLineColorBox) {

                    row = i--;

                    canvas.removeLine(row);

                }

            }

        }



        /**

         * 根据最顶行是否被占，判断游戏是否已经结束了。

         * @return boolean, true-游戏结束了，false-游戏未结束

         */

        private boolean isGameOver() {

            for (int i = 0; i < canvas.getCols(); i++) {

                ErsBox box = canvas.getBox(0, i);

                if (box.isColorBox()) return true;

            }

            return false;

        }

    }



    /**

     * 程序入口函数

     * @param args String[], 附带的命令行参数

     */

    public static void main(String[] args) {

        new ErsBlocksGame("Russia Blocks by ZGX");

    }

}







/******************************************************************************/

/**

 * 块类，继承自线程类（Thread）

 * 由 4 * 4 个方格（ErsBox）构成一个块，

 * 控制块的移动、下落、变形等

 */

class ErsBlock extends Thread {

    /**

     * 一个块占的行数是4行

     */

    public final static int BOXES_ROWS = 4;

    /**

     * 一个块占的列数是4列

     */

    public final static int BOXES_COLS = 4;

    /**

     * 让升级变化平滑的因子，避免最后几级之间的速度相差近一倍

     */

    public final static int LEVEL_FLATNESS_GENE = 3;

    /**

     * 相近的两级之间，块每下落一行的时间差别为多少(毫秒)

     */

    public final static int BETWEEN_LEVELS_DEGRESS_TIME = 50;

    /**

     * 方块的样式数目为7

     */

    private final static int BLOCK_KIND_NUMBER = 7;

    /**

     * 每一个样式的方块的反转状态种类为4

     */

    private final static int BLOCK_STATUS_NUMBER = 4;

    /**

     * 分别对应对7种模型的28种状态

     */

    public final static int[][] STYLES = {// 共28种状态

            {0x0f00, 0x4444, 0x0f00, 0x4444}, // 长条型的四种状态

            {0x04e0, 0x0464, 0x00e4, 0x04c4}, // 'T'型的四种状态

            {0x4620, 0x6c00, 0x4620, 0x6c00}, // 反'Z'型的四种状态

            {0x2640, 0xc600, 0x2640, 0xc600}, // 'Z'型的四种状态

            {0x6220, 0x1700, 0x2230, 0x0740}, // '7'型的四种状态

            {0x6440, 0x0e20, 0x44c0, 0x8e00}, // 反'7'型的四种状态

            {0x0660, 0x0660, 0x0660, 0x0660}, // 方块的四种状态

    };



    private GameCanvas canvas;

    private ErsBox[][] boxes = new ErsBox[BOXES_ROWS][BOXES_COLS];

    private int style, y, x, level;

    private boolean pausing = false, moving = true;



    /**

     * 构造函数，产生一个特定的块

     * @param style 块的样式，对应STYLES的28个值中的一个

     * @param y 起始位置，左上角在canvas中的坐标行

     * @param x 起始位置，左上角在canvas中的坐标列

     * @param level 游戏等级，控制块的下落速度

     * @param canvas 画板

     */

    public ErsBlock(int style, int y, int x, int level, GameCanvas canvas) {

        this.style = style;

        this.y = y;

        this.x = x;

        this.level = level;

        this.canvas = canvas;



        int key = 0x8000;

        for (int i = 0; i < boxes.length; i++) {

            for (int j = 0; j < boxes[i].length; j++) {

                boolean isColor = ((style & key) != 0);

                boxes[i][j] = new ErsBox(isColor);

                key >>= 1;

            }

        }



        display();

    }



    /**

     * 线程类的run()函数覆盖，下落块，直到块不能再下落

     */

    public void run() {

        while (moving) {

            try {

                sleep(BETWEEN_LEVELS_DEGRESS_TIME

                        * (ErsBlocksGame.MAX_LEVEL - level + LEVEL_FLATNESS_GENE));

            } catch (InterruptedException ie) {

                ie.printStackTrace();   //printStackTrace()是超类Throwable的一个方法,

                //该方法的作用是打印出抛出异常时当前位置的调用层次关系.

            }

            //后边的moving是表示在等待的100毫秒间，moving没被改变

            if (!pausing) moving = (moveTo(y + 1, x) && moving);

        }

    }



    /**

     * 块向左移动一格

     */

    public void moveLeft() {

        moveTo(y, x - 1);

    }



    /**

     * 块向右移动一格

     */

    public void moveRight() {

        moveTo(y, x + 1);

    }



    /**

     * 块向下落一格

     */

    public void moveDown() {

        moveTo(y + 1, x);

    }



    /**

     * 块变型

     */

    public void turnNext() {

        for (int i = 0; i < BLOCK_KIND_NUMBER; i++) {

            for (int j = 0; j < BLOCK_STATUS_NUMBER; j++) {

                if (STYLES[i][j] == style) {

                    int newStyle = STYLES[i][(j + 1) % BLOCK_STATUS_NUMBER];

                    turnTo(newStyle);

                    return;

                }

            }

        }

    }



    /**

     * 暂停块的下落，对应游戏暂停

     */

    public void pauseMove() {

        pausing = true;

    }



    /**

     * 继续块的下落，对应游戏继续

     */

    public void resumeMove() {

        pausing = false;

    }



    /**

     * 停止块的下落，对应游戏停止

     */

    public void stopMove() {

        moving = false;

    }



    /**

     * 将当前块从画布的对应位置移除，要等到下次重画画布时才能反映出来

     */

    private void earse() {

        for (int i = 0; i < boxes.length; i++) {

            for (int j = 0; j < boxes[i].length; j++) {

                if (boxes[i][j].isColorBox()) {

                    ErsBox box = canvas.getBox(i + y, j + x);

                    if (box == null) continue;

                    box.setColor(false);

                }

            }

        }

    }



    /**

     * 让当前块放置在画布的对应位置上，要等到下次重画画布时才能看见

     */

    private void display() {

        for (int i = 0; i < boxes.length; i++) {

            for (int j = 0; j < boxes[i].length; j++) {

                if (boxes[i][j].isColorBox()) {

                    ErsBox box = canvas.getBox(y + i, x + j);

                    if (box == null) continue;

                    box.setColor(true);

                }

            }

        }

    }



    /**

     * 当前块能否移动到newRow/newCol所指定的位置

     * @param newRow int, 目的地所在行

     * @param newCol int, 目的地所在列

     * @return boolean, true-能移动，false-不能

     */

    private boolean isMoveAble(int newRow, int newCol) {

        earse();

        for (int i = 0; i < boxes.length; i++) {

            for (int j = 0; j < boxes[i].length; j++) {

                if (boxes[i][j].isColorBox()) {//

                    ErsBox box = canvas.getBox(newRow + i, newCol + j);

                    if (box == null || (box.isColorBox())) {

                        display();

                        return false;

                    }

                }

            }

        }

        display();

        return true;

    }



    /**

     * 将当前画移动到newRow/newCol所指定的位置

     * @param newRow int, 目的地所在行

     * @param newCol int, 目的地所在列

     * @return boolean, true-移动成功，false-移动失败

     */

    private synchronized boolean moveTo(int newRow, int newCol) {

        if (!isMoveAble(newRow, newCol) || !moving) return false;



        earse();

        y = newRow;

        x = newCol;



        display();

        canvas.repaint();



        return true;

    }



    /**

     * 当前块能否变成newStyle所指定的块样式，主要是要考虑

     * 边界以及被其它块挡住、不能移动的情况

     * @param newStyle int,希望改变的块样式，对应STYLES的28个值中的一个

     * @return boolean,true-能改变，false-不能改变

     */

    private boolean isTurnAble(int newStyle) {

        int key = 0x8000;

        earse();

        for (int i = 0; i < boxes.length; i++) {

            for (int j = 0; j < boxes[i].length; j++) {

                if ((newStyle & key) != 0) {//当找到正确的i,j是newstyle时才进行下面的判断

                    ErsBox box = canvas.getBox(y + i, x + j);

                    if (box == null || box.isColorBox()) {//如果指定的位置越界,或指定的位置以有box,则返回不行

                        display();//因为返回不能false时，turnto方法中的display();将不被执行

                        return false;

                    }

                }

                key >>= 1;

            }

        }

        display();

        return true;

    }



    /**

     * 将当前块变成newStyle所指定的块样式

     * @param newStyle int,将要改变成的块样式，对应STYLES的28个值中的一个

     * @return boolean,true-改变成功，false-改变失败

     */

    private boolean turnTo(int newStyle) {

        if (!isTurnAble(newStyle) || !moving) return false;



        earse();

        int key = 0x8000;

        for (int i = 0; i < boxes.length; i++) {

            for (int j = 0; j < boxes[i].length; j++) {

                boolean isColor = ((newStyle & key) != 0);

                boxes[i][j].setColor(isColor);

                key >>= 1;

            }

        }

        style = newStyle;



        display();

        canvas.repaint();



        return true;

    }

}

