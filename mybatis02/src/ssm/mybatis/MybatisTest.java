package ssm.mybatis;

import ssm.mybatis.bean.Dog;
import ssm.mybatis.bean.Employee;
import ssm.mybatis.bean.Person;
import ssm.mybatis.dao.Dao;
import ssm.mybatis.dao.DogDao;
import ssm.mybatis.dao.PersonDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Abraham
 * @create 23:00/周二/27/07/2021
 */
public class MybatisTest {
    private static SqlSessionFactory factory;
    static{
        String resource="mybatis-config.xml";
        InputStream stream =null;
        try {
            stream = Resources.getResourceAsStream(resource);
           factory= new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(stream!=null)
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test(){
        SqlSession sqlSession = factory.openSession(true);//加入参数true，表示设置为自动提交
        Dao mapper = sqlSession.getMapper(Dao.class);
        Employee t = mapper.getTByIdAndEmpName(6,"耶和华");
        System.out.println(t);
        sqlSession.close();
    }
    @Test
    public void test1(){
        SqlSession sqlSession = factory.openSession(true);//加入参数true，表示设置为自动提交
        Dao mapper = sqlSession.getMapper(Dao.class);
        Employee e=new Employee(null,"嘻嘻",0,"2525@qq.com");
        int t = mapper.insert(e);
        System.out.println(t);//1
        sqlSession.close();
        System.out.println(e);//Employee{id=9, empname='嘻嘻', gender=0, email='2525@qq.com'}
        //Employee{id=10, empname='嘻嘻', gender=0, email='2525@qq.com'}
    }

    /**
     * test return list  Collection
     */
    @Test
    public void test2(){
        SqlSession sqlSession = factory.openSession(true);
        Dao mapper = sqlSession.getMapper(Dao.class);
        List<Employee> allEmployee = mapper.getAllEmployee();
        sqlSession.close();
        allEmployee.forEach(System.out::println);
    }

    /**
     * test return map by one instance
     */
    @Test
    public void test3(){
        SqlSession sqlSession = factory.openSession(true);
        Dao mapper = sqlSession.getMapper(Dao.class);
        Map<String, Object> oneReturnMap = mapper.getOneReturnMap(7);
        sqlSession.close();
        System.out.println(oneReturnMap);
        //{empname=华爸, gender=1, id=7, email=2323@qq.com}
    }

    @Test
    public void test4(){
        SqlSession sqlSession = factory.openSession(true);
        Dao mapper = sqlSession.getMapper(Dao.class);
        Map<Integer, Employee> allReturnMap = mapper.getAllReturnMap();
        System.out.println(allReturnMap);
        sqlSession.close();
        //{1=Employee{id=1, empname='稣哥', gender=1, email='123@qq.com'},
        // 6=Employee{id=6, empname='耶和华', gender=1, email='17775@qq.com'},
        // 7=Employee{id=7, empname='华爸', gender=1, email='2323@qq.com'},
        // 9=Employee{id=9, empname='嘻嘻', gender=0, email='2525@qq.com'},
        // 10=Employee{id=10, empname='嘻嘻', gender=0, email='2525@qq.com'}}
    }

    /**
     * 测试字段和属性名完全不对应的情况
     */
    @Test
    public void test5(){
        SqlSession sqlSession = factory.openSession(true);
        DogDao mapper = sqlSession.getMapper(DogDao.class);
        Dog it = mapper.getIt(1);
        System.out.println(it);//Dog{id=1, name='小黄'}
        sqlSession.close();
    }

    /**
     * 测试级联赋值和联合查询
     */
    @Test
    public void test6(){
        SqlSession sqlSession = factory.openSession(true);
        PersonDao mapper = sqlSession.getMapper(PersonDao.class);
        Person it = mapper.getPerson(1);
        System.out.println(it);//Person{pid=1, pname='黄大仙', dogs=[Dog{id=1, name='小黄'}, Dog{id=2, name='阿黄'}, Dog{id=3, name='阿黑'}]}
        sqlSession.close();
    }
    /**
     * 测试分步查询
     */
    @Test
    public void test7(){
        SqlSession sqlSession = factory.openSession(true);
        DogDao mapper = sqlSession.getMapper(DogDao.class);
        Dog dog = mapper.SimpleGetDog(2);
        System.out.println(dog);//Dog{id=2, name='阿黄', person=Person{pid=1, pname='黄大仙', dogs=[]}}
        sqlSession.close();
    }
    /**
     * 测试分步查询，延迟加载
     */
    @Test
    public void test8(){
        SqlSession sqlSession = factory.openSession();
        try {
            DogDao mapper = sqlSession.getMapper(DogDao.class);
            Dog dog = mapper.SimpleGetDog(2);
            System.out.println(dog.getName());

            Thread.sleep(3000);
            System.out.println(dog.getPerson().getPname());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }

    }





}
