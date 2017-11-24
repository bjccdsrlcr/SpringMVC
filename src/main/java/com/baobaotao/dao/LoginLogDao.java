package com.baobaotao.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.LoginLog;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/17 0017
 * Time: 11:14
 */
@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog) throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        String sql = "INSERT INTO t_login_log(user_id, ip, login_datetime)" + "VALUES(?, ?, ?)";
//        Connection connection = dataSource.getConnection();
//        Statement statement = connection.createStatement();
        jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        jdbcTemplate.update(sql, new Object[]{loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()});
    }

}
