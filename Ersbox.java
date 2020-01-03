import java.awt.*;


/******************************************************************************/

import java.awt.*;



/**

 * 方格类，是组成块的基本元素，用自己的颜色来表示块的外观

 */



/*此类实现了 Cloneable 接口，以指示 Object.clone() 方法可以合法地对该类实例进行按字段复制。



如果在没有实现 Cloneable 接口的实例上调用 Object 的 clone 方法，

则会导致抛出 CloneNotSupportedException 异常。



按照惯例，实现此接口的类应该使用公共方法重写 Object.clone（它是受保护的）。

请参阅 Object.clone()，以获得有关重写此方法的详细信息。



注意，此接口不 包含 clone 方法。

因此，因为某个对象实现了此接口就克隆它是不可能的。

即使 clone 方法是反射性调用的，也无法保证它将获得成功。

  *

  */



class ErsBox implements Cloneable {

    private boolean isColor;

    private Dimension size = new Dimension();



    /**

     * 方格类的构造函数

     * @param isColor 是不是用前景色来为此方格着色，

     *      true前景色，false用背景色

     */

    public ErsBox(boolean isColor) {

        this.isColor = isColor;

    }



    /**

     * 此方格是不是用前景色表现

     * @return boolean,true用前景色表现，false用背景色表现

     */

    public boolean isColorBox() {

        return isColor;

    }



    /**

     * 设置方格的颜色，

     * @param isColor boolean,true用前景色表现，false用背景色表现

     */

    public void setColor(boolean isColor) {

        this.isColor = isColor;

    }



    /**

     * 得到此方格的尺寸

     * @return Dimension,方格的尺寸

     */

    public Dimension getSize() {

        return size;

    }



    /**

     * 设置方格的尺寸

     * @param size Dimension,方格的尺寸

     */

    public void setSize(Dimension size) {

        this.size = size;

    }



    /**

     * 覆盖Object的Object clone()，实现克隆

     * @return Object,克隆的结果

     */

    public Object clone() {

        Object cloned = null;

        try {

            cloned = super.clone();

        } catch (Exception ex) {

            ex.printStackTrace();

        }



        return cloned;

    }

}