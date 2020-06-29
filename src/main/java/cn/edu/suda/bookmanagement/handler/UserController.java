package cn.edu.suda.bookmanagement.handler;

import cn.edu.suda.bookmanagement.entity.User;
import cn.edu.suda.bookmanagement.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userservice;

    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, User user, Model model){
        String username = user.getUsername();
        String password = user.getPassword();
        User user2 = userservice.findUserByNameAndPassword(username,password);
        if(user2 !=null){
            request.getSession().setAttribute("user",user2);
            model.addAttribute("user",user2);
            return "index";
        }else{
            model.addAttribute("msg","0");
            return "login";
        }
    }

    @RequestMapping(value ="/loginout",method = RequestMethod.POST)
    public String loginout(HttpServletRequest request){
        request.getSession().invalidate();
            return "login";
    }

}
