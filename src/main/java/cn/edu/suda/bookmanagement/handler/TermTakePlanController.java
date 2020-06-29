package cn.edu.suda.bookmanagement.handler;

import cn.edu.suda.bookmanagement.entity.TermTakePlan;
import cn.edu.suda.bookmanagement.service.TermTakePlanService;
import cn.edu.suda.bookmanagement.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/restapi/termtakeplan")
public class TermTakePlanController {
    @Autowired
    TermTakePlanService termTakePlanService;

    @RequestMapping(value = "/kkxy")
    public List list(HttpServletRequest request,String kkxy,String syzy) {
        List<String> list = termTakePlanService.getKkxy();
        List<Map> mapList = new ArrayList<>();
        list.forEach(xy->{
            Map<String, String> map = new HashMap<>();
            map.put("id", xy);
            map.put("text", xy);
            mapList.add(map);
        });
        return mapList;
    }

    @RequestMapping(value = "/xyzy",method = RequestMethod.GET)
    public List getzy(HttpServletRequest request,String kkxy,String syzy) {
        List<String> zylist = termTakePlanService.getSyzy(kkxy, syzy);
        List newList = new ArrayList();
        zylist.forEach(zy -> {
            //用，分割 全部放到新的数组里
            String[] arra = zy.split(",");
            for (int i = 0; i < arra.length; i++) {
                newList.add(arra[i]);
            }
        });
        //System.out.println(newList);
        Set<String> set = new HashSet<>();
        set.addAll(newList);
        List finallist =new ArrayList();
        finallist.addAll(set);
        return finallist;
    }

    @RequestMapping(value = "/historyjc",method = RequestMethod.GET)
    public Map historyjc(HttpServletRequest request,String kcdm,String kkxy,String syzy) {
        //List<TermTakePlan> list = termTakePlanService.findByKcdm(kcdm);
        List<TermTakePlan> list = termTakePlanService.findByKcdmAndKkxyAndSyzy(kcdm,kkxy,syzy);
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }

}
