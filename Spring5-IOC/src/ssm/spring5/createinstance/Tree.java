package ssm.spring5.createinstance;

/**
 * @author Abraham
 * @create 16:44/周五/09/07/2021
 */
public class Tree {
    //如果要通过XML配置文件来注入属性，就必须有set方法，如果没有就报错
    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
