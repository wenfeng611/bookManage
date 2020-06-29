package cn.edu.suda.bookmanagement.handler;

import cn.edu.suda.bookmanagement.entity.User;
import cn.edu.suda.bookmanagement.repository.TeachTaskRepository;
import cn.edu.suda.bookmanagement.service.TermTakePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController extends Handler{
    @Autowired
    TermTakePlanService termTakePlanService;
    @Autowired
    TeachTaskRepository teachTaskRepository;

    @RequestMapping(value = "")
    public String index(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(value = "/loginout")
    public String loginoutindex(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(value = "/jcindex")
    public String jcindex(HttpServletRequest request) {
        return "jcindex";
    }

    @RequestMapping(value = "/xykcindex")
    public String xykcindex(HttpServletRequest request,Model model) {
        List<String> xnlist = teachTaskRepository.getXn();
        List<String> lblist = teachTaskRepository.getLb();
        List<String> kkxylist = teachTaskRepository.getKkxy();
        model.addAttribute("xnlist",xnlist);
        model.addAttribute("lblist",lblist);
        model.addAttribute("kkxylist",kkxylist);
        User user =(User) request.getSession().getAttribute("user");
        model.addAttribute("useracademic",user.getAcademic());
        return "xykcindex";
    }

    @RequestMapping(value = "/kcjcindex")
    public String kcjcindex(HttpServletRequest request,Model model) {
        List<String> list= termTakePlanService.getKkxy();

        model.addAttribute("xylist",list);
        return "kcjcindex";
    }

    @RequestMapping(value = "/jc/add")
    public String jcadd(HttpServletRequest request,Model model) {
        return "/jc/add";
    }
}
