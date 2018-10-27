package springBootP.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springBootP.domain.loginLog;

import java.util.Date;

@Repository
public class lofinLogDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertLoginLog(loginLog lo){
        String query = "insert into loginlog(?,?,?)";
        jdbcTemplate.update(query,new Object[]{lo.getUserId(),lo.getIp(),new Date()});
    }

}
