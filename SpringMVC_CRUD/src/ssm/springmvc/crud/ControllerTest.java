package ssm.springmvc.crud;

import ssm.springmvc.crud.bean.Department;
import ssm.springmvc.crud.bean.Employee;
import ssm.springmvc.crud.dao.DepartmentDao;
import ssm.springmvc.crud.dao.EmployeeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerTest {
    @Autowired
    private EmployeeDao dao;

    @Autowired
    private DepartmentDao depDao;

    @RequestMapping("goodNight")
    public String goodNight() {
        return "success";
    }

    /**
     * 转到列出员工的页面
     * @param model
     * @return
     */
    @RequestMapping("listAll")
    public String getAll(Model model) {
        Collection<Employee> all = dao.getAll();
        model.addAttribute("employees", all);
        return "list";
    }

    /**
     * 转发到添加页面
     * @param model
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(Model model) {
        //获取所有部门，然后将部门放到请求域中，供下拉列表的选择
        Collection<Department> departments = depDao.getDepartments();
        model.addAttribute("departments", departments);
        //这里需要往request域中放入“command” 对象，目的是方便我们添加和回显
        Employee employee = new Employee();
        System.out.println(employee);
        //Employee [id=null, lastName=null, email=null, gender=null, department=null, birth=null, salary=null]
        model.addAttribute("employee", employee); //放入空对象
        return "add";
    }

    /**
     * 真正的添加员工方法，约定了请求名和请求方式
     * 注解 @Valid Employee employee 告诉SpringMVC当前对象需要校验
     * 注解 @Valid Employee employee, BindingResult result 后面紧跟一个BindingResult是用来保存校验结果的
     * 可以根据不同的校验结果分别做出操作
     * @param employee
     * @return
     */
    @RequestMapping(value = "startAdd", method = RequestMethod.POST)
    private String startAdd(@Valid Employee employee, BindingResult result,Model model) {
        System.out.println("startAdd="+employee);
        boolean hasErrors = result.hasFieldErrors();
        System.out.println(hasErrors);
        if(hasErrors){ //如果校验结果有错误
            Map<String,String> map=new HashMap<>();

            //获取所有出现了错误的属性
            List<FieldError> fieldErrors = result.getFieldErrors();
            System.out.println(fieldErrors);

            //遍历，分别保存到Map中
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError);
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                map.put(field,message);
            }

            //将错误信息的Map保存到Model中，方便回显
            model.addAttribute("errorInfo",map);

            Collection<Department> departments = depDao.getDepartments();
            model.addAttribute("departments", departments);
            model.addAttribute("employee",employee);
            model.addAttribute("errors",fieldErrors); //这个必须要加吗？
            System.out.println("校验有误！！！");
            return "add";
        }else {
            dao.save(employee);
            return "redirect:/index.jsp";
        }
    }

    /**
     * value = "edit/{id}" 这里的id是PathVariable，是在路劲里面的，在?前面！！
     * 不是?后面的RequestParam
     * 转发到更新的页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "edit/{id}")
    private String toUpdate(@PathVariable("id")Integer id,Model model) {
        if(model.getAttribute("command")==null) {
            Employee employee = dao.get(id);
            model.addAttribute("employee", employee);
            Collection<Department> departments = depDao.getDepartments();
            model.addAttribute("departments",departments);
        }
        return "forward:/WEB-INF/pages/update.jsp";
    }

    /**
     * 更新的具体方法
     * @param employee
     * @param id
     * @return
     */
    @RequestMapping(value ="update/{id}",method = RequestMethod.PUT)
    public String startUpdate(Employee employee,@RequestParam("department.id")Integer id) {
        employee.setDepartment(depDao.getDepartment(id));
        System.out.println("startUpdate方法中的："+employee);
         dao.save(employee);
        return "redirect:/index.jsp";
    }

    /**
     * 只有?后面的参数携带了id,才会进入if，配置AOP，每次请求前，都调用这个方法
     * @param id
     * @param model
     */
    @ModelAttribute
    public void get(@RequestParam(value = "id",required = false )Integer id,Model model) {
        if(id!=null){
            Employee employee = dao.get(id);
            System.out.println("get="+employee);
            model.addAttribute("employee", employee);
        }
    }

    /**
     * 删除方法，我加入了method=Request.DELETE 以后，就无法删除了，
     * 虽然引入了JS，配置了单击事件和表单，但还是不行，我搞了一个小时，也不知道问题出在哪里，就取消了method=Request.DELETE
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        System.out.println(11);
        dao.delete(id);
        return "redirect:/index.jsp";
    }


    @RequestMapping("emploinfo")
    public String converter(@RequestParam("emp")Employee employee){
        dao.save(employee);
        return "redirect:/index.jsp";
    }

}
