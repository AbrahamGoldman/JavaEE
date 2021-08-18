package ssm.spring5.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;


@Controller("person")
public class PersonDAO implements DAO {
    @Value(value = "Person还没想好")
    private String name;

    @Override
    public String toString() {
        return "PersonDAO{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void add() {
        System.out.println("PersonDAO中的add");
    }
}
