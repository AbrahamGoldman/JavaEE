package ssm.mybatis.bean;

/**
 * @author Abraham
 * @create 15:40/周三/28/07/2021
 */
public class Dog {
    private int id;
    private String name;
    private Person person;

    public Dog() {

    }

    public Dog(int id, String name, Person person) {
        this.id = id;
        this.name = name;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
