package ssm.spring5.autowire;

/**
 * @author Abraham
 * @create 17:17/周六/10/07/2021
 */
public class Department {
    private String name;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
