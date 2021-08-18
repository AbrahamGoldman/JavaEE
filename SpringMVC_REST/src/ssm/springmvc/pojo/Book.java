package ssm.springmvc.pojo;

/**
 * @author Abraham
 * @create 10:17/周五/16/07/2021
 */
public class Book {
    private String bookName;
    private String author;
    private Double price;
    private Integer stock; //库存
    private Integer sale;
    private Address address;

    public Book(String bookName, String author, Double price, Integer stock, Integer sale, Address address) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.sale = sale;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sale=" + sale +
                ", address=" + address +
                '}';
    }
}
