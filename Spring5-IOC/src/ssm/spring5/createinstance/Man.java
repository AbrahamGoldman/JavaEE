package ssm.spring5.createinstance;

/**
 * @author Abraham
 * @create 21:58/周五/09/07/2021
 */
public class Man {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Man{" +
                "car=" + car +
                '}';
    }

}
