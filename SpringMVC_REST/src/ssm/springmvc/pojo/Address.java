package ssm.springmvc.pojo;

/**
 * @author Abraham
 * @create 10:17/周五/16/07/2021
 */
public class Address {
    private String provice;
    private String city;
    private String street;

    public Address(String provice, String city, String street) {
        this.provice = provice;
        this.city = city;
        this.street = street;
    }

    public Address() {
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "provice='" + provice + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
