package ssm.spring5.autowire;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Abraham
 * @create 17:27/周六/10/07/2021
 */
public class Test {
    @org.junit.Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean7.xml");
        Employee bean = context.getBean("employee", Employee.class);
        System.out.println(bean); //Employee{dep=Department{name='技术部'}}
    }
    @org.junit.Test
    public void test2() throws SQLException {
     ApplicationContext context=new ClassPathXmlApplicationContext("bean8.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(dataSource);
        System.out.println(connection);
        connection.close();
//        {
//            CreateTime:"2021-07-10 20:18:13",
//                    ActiveCount:1,
//                PoolingCount:4,
//                CreateCount:5,
//                DestroyCount:0,
//                CloseCount:0,
//                ConnectCount:1,
//                Connections:[
//            {ID:15892131, ConnectTime:"2021-07-10 20:18:13", UseCount:0, LastActiveTime:"2021-07-10 20:18:13"},
//            {ID:484841769, ConnectTime:"2021-07-10 20:18:13", UseCount:0, LastActiveTime:"2021-07-10 20:18:13"},
//            {ID:879311295, ConnectTime:"2021-07-10 20:18:13", UseCount:0, LastActiveTime:"2021-07-10 20:18:13"},
//            {ID:1274247563, ConnectTime:"2021-07-10 20:18:13", UseCount:0, LastActiveTime:"2021-07-10 20:18:13"}
//	]
//        }
//        com.mysql.cj.jdbc.ConnectionImpl@58670130


    }
}
