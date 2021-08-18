package ssm.mybatis.mappertest;

import ssm.mybatis.bean.Teacher;
import ssm.mybatis.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Abraham
 * @create 10:49/周四/29/07/2021
 */
public class MapperTest {
    private static SqlSessionFactory factory;

    static {
        String resource = "mybatis-config.xml";
        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

@Test
public void test10(){
    SqlSession sqlSession = factory.openSession();
    TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
    List<Teacher> list=new ArrayList<>();
    for (int i = 0; i < 100; i++) {
        list.add(new Teacher(null,"小鱼儿"+i,"龙宫"+i,null,"捉螃蟹"+i));
    }
    mapper.insertList(list);
    sqlSession.commit();
    sqlSession.close();
}



    @Test
    public void test() {
        SqlSession sqlSession = factory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherById(2);
        sqlSession.clearCache();
        System.out.println(teacher);
//        Teacher teacher2 = new Teacher();
//        teacher2.setId(3);
//        teacher2.setName("春上");
//        mapper.updateTeacher(teacher2);
//        //sqlSession.clearCache();   刷新缓存

        //同样的调用：测试一级缓存
        Teacher teacher1 = mapper.getTeacherById(2);
        System.out.println(teacher1);
        sqlSession.clearCache();
        sqlSession.commit(); //只要提交了或者关闭会话，数据就会保存到二级缓存，跟刷不刷新没关系
        sqlSession.close();

        System.out.println("=================================================");
//开启两个会话，测试二级缓存
        SqlSession sqlSession2 = factory.openSession();
        TeacherMapper mapper2 = sqlSession2.getMapper(TeacherMapper.class);
      //  sqlSession2.clearCache();//只是刷新一级缓存，对二级缓存没任何影响
        Teacher teacher2 = mapper2.getTeacherById(2);  //依然能从二级缓存中拿到
        System.out.println(teacher2);
        sqlSession2.commit();
        sqlSession2.close();


    }
    @Test
    public void test9() {
        SqlSession sqlSession = factory.openSession(true);
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherById(2);
        System.out.println(teacher);
        sqlSession.close();
    }




    @Test
    public void test1() {
        SqlSession sqlSession = factory.openSession(true);
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.setId(10);
        teacher.setName("__");
        teacher.setBirth(new Date(2323445));

        List<Teacher> list = mapper.getListByCondition(teacher);
        System.out.println(list);
//        [Teacher{id=1, name='小苍', address='横须贺', birth=Thu Feb 05 00:00:00 GMT+08:00 2015, course='科技'},
//        Teacher{id=2, name='水井', address='北海道', birth=Sun Mar 05 00:00:00 GMT+08:00 2017, course='英语'},
//        Teacher{id=3, name='中野', address='东京', birth=Wed Aug 07 00:00:00 GMT+08:00 2019, course='艺术'}]
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = factory.openSession(true);
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.setId(3);
        teacher.setName("小苍");
        List<Teacher> list = mapper.getListByChoose(teacher);
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = factory.openSession(true);
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("苍老师");
        teacher.setAddress("坂田");
        teacher.setBirth(new Date());
        int i = mapper.updateTeacher(teacher);
        System.out.println(i);
        sqlSession.close();
    }
}
