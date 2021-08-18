package ssm.springmvc.conversion;

import ssm.springmvc.crud.bean.Employee;
import ssm.springmvc.crud.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


/**
 * String :source
 * String -->Employee
 */
public class MyConversion implements Converter<String, Employee>{
    @Autowired
    DepartmentDao dao;

    /**
     * 把String转成Employee对象
     * @param s
     * @return
     */
    @Override
    public Employee convert(String s) {
        if(s.contains("-")){
            Employee employee=new Employee();
            String[] split = s.split("-");
           employee.setLastName(split[0]);
           employee.setEmail(split[1]);
           employee.setGender(Integer.parseInt(split[2]));
            Integer i = Integer.parseInt(split[3]);
            employee.setDepartment(dao.getDepartment(i));
            return employee;
        }
        return null;
    }
}
