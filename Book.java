/*图书：
1.ISBN
2.作者
3.书名
4.价格
5.销量
6.评论数
排序方式：
1.按书名排序
2.按作者排序
3.按价格排序（从小到大或从大到小）
4.按销量排序
5.按评论数排序

1.设计图书类
 自然顺序
 按isbn从小到大
2.设计比较器
3.排序并打印
 */
public class Book implements  Comparable<Book> {
    public String  ISBN;
    public String author;
    public String title;
    public int price;
    public int sales;//销量
    public int comments;//评论数
    public Book(String ISBN, String author, String title, int price, int sales, int comments) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.price = price;
        this.sales = sales;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", comments=" + comments +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return ISBN.compareTo(o.ISBN);
    }
}
