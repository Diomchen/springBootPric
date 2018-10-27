package springBootP.webapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springBootP.domain.User;
import springBootP.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class LoginController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = {"/","/index.html"})
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = {"loginCheck.html"})
    public ModelAndView loginCheck(HttpServletRequest request , LoginCommand loginCommand){
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUsername(),loginCommand.getPassword());

        if(!isValidUser){
            return new ModelAndView("login","error","用户名或密码错误");
        }
        else{
            User user = userService.findUserByUser(loginCommand.getUsername());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.updateLoginInfo(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }

    }

}
