package ssm.spring5.arrrylistcollectionmap;

/**
 * @author Abraham
 * @create 10:16/周六/10/07/2021
 */
public class Book {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
