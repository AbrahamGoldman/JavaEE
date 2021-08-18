package ssm.spring5.autowire;

/**
 * @author Abraham
 * @create 17:17/周六/10/07/2021
 */
public class Employee {
    private Department dep;

    public Department getDep() { return dep; }

    public void setDep(Department dep) { this.dep = dep; }

    @Override
    public String toString() {
        return "Employee{" +
                "dep=" + dep +
                '}';
    }
}
