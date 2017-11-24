package com.baobaotao.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/17 0017
 * Time: 10:58
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName, String password){
        String sql = "select count(*) from t_user where user_name=? and password =?";
        String sql1 = "select * from t_user";
        List list = jdbcTemplate.queryForList(sql1);

        return jdbcTemplate.queryForObject(sql, new Object[]{userName, password},Integer.class);
    }

    public User findUserByUserName(final String userName){
        String sql = "SELECT * FROM t_user WHERE user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sql, new Object[]{userName},
                new RowCallbackHandler() {
                    
                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setUserName(userName);
                        user.setCredits(resultSet.getInt("credits"));
                    }
                }
        );
        return user;
    }

    public void updateLoginInfo(User user){
        String sql = "UPDATE t_user SET last_visit = ?, last_ip = ?, credits = ? " + " WHERE user_id = ?";
        jdbcTemplate.update(sql, new Object[]{user.getLastVisit(), user.getLastIp(),user.getCredits(), user.getUserId()});
    }
}
