package springBootP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springBootP.dao.UserDao;
import springBootP.dao.lofinLogDao;
import springBootP.domain.User;
import springBootP.domain.loginLog;

@Service
public class UserService {
    private UserDao userDao;
    private lofinLogDao lo;

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Autowired
    public void setLofinLogDao(lofinLogDao lo){
        this.lo = lo;
    }

    public boolean hasMatchUser(String username,String password){
       return userDao.getMatchCount(username,password) > 0;
    }

    public User findUserByUser(String username){
        return userDao.finduserByUserName(username);
    }

    public void updateLoginInfo(User user){
        userDao.updateLoginInfo(user);
    }

    @Transactional//事务增强
    public void insertsuccess(User user){
        user.setCredits(5 + user.getCredits());
        loginLog loginLog = new loginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        lo.insertLoginLog(loginLog);
    }
}
