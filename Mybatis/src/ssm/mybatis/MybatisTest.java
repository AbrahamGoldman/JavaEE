package ssm.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Abraham
 * @create 17:58/周一/26/07/2021
 */
public class MybatisTest {
    private static SqlSessionFactory sqlSessionFactory;

    static{
        //我们通过静态代码块来获取sqlSessionFactory ，这是一个单例
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(inputStream!=null)
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 测试查询
     */
    @Test
    public void test() {
        //根据全局配置文件创建一个SqlSessionFactory：这个工厂负责创建SqlSession对象
        //SqlSession：数据库的一次会话
        SqlSession sqlSession=null;
        try {
            //获取SqlSession，这个对象.getMapper(xxx.class);就能获取xxx接口的实现类对象
             sqlSession = sqlSessionFactory.openSession();
            Dao mapper = sqlSession.getMapper(Dao.class);
            //对象调用方法就能直接获取到数据库中的对象
            Employee t = mapper.getT(1);
            System.out.println(t);
        } finally {
            sqlSession.commit();
            sqlSession.close();//关闭连接
        }

    }

    /**
     * 测试插入
     */
    @Test
    public void test1(){
        //openSession()里面的参数Boolean 为设置是否自动提交，设置为true就是自动提交，默认是false也就是需要手动提交哦
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        dao.insert(new Employee("华爸",1,"2323@qq.com"));
       sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 测试删除
     */
    @Test
    public void test2(){
        SqlSession sqlSession =null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Dao dao = sqlSession.getMapper(Dao.class);
            boolean delete = dao.delete(6);
            System.out.println(delete); //true
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    /**
     * 测试修改
     */
    @Test
    public void test3(){
        SqlSession sqlSession=null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Dao dao = sqlSession.getMapper(Dao.class);
            int i = dao.upDate(new Employee(5, "耶和华", 1, "123555@qq.com"));
            System.out.println(i); //1
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }

    }

    /**
     * 测试在类的方法上加sql语句的注解
     */
    @Test
    public void test4(){
        SqlSession sqlSession=null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            AnnotationDao dao = sqlSession.getMapper(AnnotationDao.class);
            int i = dao.upDate(new Employee(6, "耶和华", 1, "17775@qq.com"));
            System.out.println(i); //1
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
    /**
     * 测试在类的方法上加sql语句的注解
     */
    @Test
    public void test5(){
        SqlSession sqlSession=null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            AnnotationDao dao = sqlSession.getMapper(AnnotationDao.class);
            Employee i = dao.getT(1);
            System.out.println(i); //Employee{id=1, empname='稣哥', gender=1, email='123@qq.com'}
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
