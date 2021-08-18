package com.mybatis.test;


import com.mybatis.bean.Person;
import com.mybatis.bean.Teacher;
import com.mybatis.service.PersonMapper;
import com.mybatis.service.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;

import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

/**
 * C:\Program Files\javacode\JavaEE\Mybatis-Generator\generatorConfig.xml
 * @author Abraham
 * @create 15:51/周五/30/07/2021
 */
public class GeneratorTest {
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
            try {
                if (stream != null)
                    stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("C:\\Program Files\\javacode\\JavaEE\\Mybatis-Generator\\generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("好了");
    }
    @Test
    public void test(){
        SqlSession sqlSession = factory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.selectByPrimaryKey(3);
        System.out.println(teacher);//Teacher{id=3, name='春上', adress='东京', birthDate=Wed Aug 07 00:00:00 GMT+08:00 2019, className='艺术'}
    }
    
}