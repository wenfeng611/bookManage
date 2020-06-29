package cn.edu.suda.bookmanagement.handler;

import cn.edu.suda.bookmanagement.entity.CourseJC;
import cn.edu.suda.bookmanagement.entity.JC;
import cn.edu.suda.bookmanagement.service.CourseJCService;
import cn.edu.suda.bookmanagement.service.JCService;
import cn.edu.suda.bookmanagement.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restapi/coursejc")
public class CourseJCController {
    @Autowired
    CourseJCService courseJCService;

    @Autowired
    private JCService jcService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map list(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
//        int page = StringUtil.str2Int(request.getParameter("page"),0);
//        int limit= StringUtil.str2Int(request.getParameter("limit"),10);
        List<CourseJC> list =  courseJCService.findAll();
        map.put("code",0);
        map.put("msg","");
        map.put("count",courseJCService.count());
        map.put("data",list);
        return map;
    }

    //点击课程名称显示教材(可能不止一本)
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Map showjc(HttpServletRequest request, String kcdm) {
        Map<String,Object> map = new HashMap<>();
        List<CourseJC> list =  courseJCService.findByKcdm(kcdm);
        List<JC> jclist = new ArrayList<>();
        list.forEach(courseJC -> {
            JC jc = jcService.findBySxh(courseJC.getJcsxh());
            jclist.add(jc);
        });
        map.put("code",0);
        map.put("msg","");
        map.put("count",jclist.size());
        map.put("data",jclist);
        return map;
    }
}
