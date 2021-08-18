package ssm.spring5.beanlife;

/**
 * @author Abraham
 * @create 16:06/周六/10/07/2021
 */
public class TV {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        System.out.println("第二步：调用set方法做属性注入");
        this.price = price;
    }

    public TV(int price) {
        System.out.println("第一步：有参构造器");
        this.price = price;
    }

    public TV() {
        System.out.println("第一步：无参构造器");
    }

    /**
     * 初始化当前bean，前后都有后置处理器，在后置处理器里面完成第三步和第五步的操作
     */
    public void initialization(){
        System.out.println("第四步：初始化方法");
    }

    /**
     * 对象使用完后就销毁了，context调用close()方法以后，就会调用这个方法
     */
    public void destroy(){
        System.out.println("第七步：销毁当前bean");
    }

    @Override
    public String toString() {
        return "TV{" +
                "price=" + price +
                '}';
    }
}
