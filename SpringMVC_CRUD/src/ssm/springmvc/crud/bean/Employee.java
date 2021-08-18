package ssm.springmvc.crud.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class Employee {

	@Length(min = 6,max = 12)  //当前名字的长度为 1~5
    @NotNull
	private String lastName;

	@Email   //合规邮箱
	private String email;
	//1 male, 0 female
	private Integer gender;

	@JsonIgnore  //返回Json数据的时候忽略这个属性
	private Department department;

	private Integer id;

//	@DateTimeFormat(pattern="yyyy-MM-dd")
	//@Future//表示当前日期要是未来时间

	@DateTimeFormat(pattern = "yyyy-MM-dd")//约定了日期的格式
	@Past(message = "必须使用过去时间")  //当用户输入了未来时间，这里会提示。
	@JsonFormat(
			pattern = "yyyy-MM-dd HH:mm:ss", //如果不加这个注解就是输出时间戳，加了就是年月日时分秒
			timezone = "GMT+8")    //这个是用来确定时区，可以加也可以不加
	private Date birth=new Date();

	//	@NumberFormat(pattern="#,###,###.#")
	@NumberFormat(pattern = "#,###.##")  //约定了数字解析的格式
	private Float salary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email="
				+ email + ", gender=" + gender + ", department=" + department
				+ ", birth=" + birth + ", salary=" + salary + "]";
	}

	public Employee(Integer id, String lastName, String email, Integer gender,
			Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
}
