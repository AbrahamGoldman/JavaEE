package ssm.mybatis.bean;

import java.util.List;

/**
 * @author Abraham
 * @create 16:07/周三/28/07/2021
 */
public class Person {
    private int pid;
    private String pname;
    private List<Dog> dogs;

    public Person() {
    }

    public Person(int pid, String pname, List<Dog> dogs) {
        this.pid = pid;
        this.pname = pname;
        this.dogs = dogs;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", dogs=" + dogs +
                '}';
    }
}
