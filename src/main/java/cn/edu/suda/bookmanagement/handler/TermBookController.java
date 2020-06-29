package cn.edu.suda.bookmanagement.handler;

import cn.edu.suda.bookmanagement.entity.JC;
import cn.edu.suda.bookmanagement.entity.TermBookPlan;
import cn.edu.suda.bookmanagement.entity.TermTakePlan;
import cn.edu.suda.bookmanagement.service.JCService;
import cn.edu.suda.bookmanagement.service.TermBookPlanService;
import cn.edu.suda.bookmanagement.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/restapi/termbookplan")
public class TermBookController {
    @Autowired
    TermBookPlanService termBookPlanService;

    @Autowired
    private JCService jcService;

    //选课课号查到的默认教材
    @RequestMapping(value = "/historyJcxx",method = RequestMethod.GET)
    public Map getHistoryJcxx(HttpServletRequest request, String xkkh){
        List<TermBookPlan> list = termBookPlanService.findByXkkh(xkkh,false);
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }

    //删除教材计划
    @RequestMapping(value="/del",method = RequestMethod.POST)
    public void del(HttpServletRequest request,  String xkkh,String sxh){
        TermBookPlan t = termBookPlanService.findByXkkhAndJcsxh(xkkh,sxh);
        t.setIsdel(true);
        termBookPlanService.save(t);
    }


    @RequestMapping(value = "/addnewbook",method = RequestMethod.POST)
    public void addnewbook(HttpServletRequest request,  String xkkh,String sxh,String xn,String xq,String lb){
//        String xkkh=(String)map.get("xkkh");
//        String sxh=(String)map.get("sxh");
//        String xn=(String)map.get("xn");
//        String xq=(String)map.get("xq");
//        String lb=(String)map.get("xq");
        //List<TermBookPlan> list = termBookPlanService.findByXkkh(xkkh,false);
        JC jc=jcService.findBySxh(sxh);
        TermBookPlan t=new TermBookPlan();
        t.setSxh(UUID.randomUUID().toString());
        t.setXn(xn);
        t.setXq(xq);
        t.setXkkh(xkkh);
        t.setIsdel(false);
        t.setXglb("新添加");
        t.setH_jcmc(jc.getJcmc());
        t.setH_jczz(jc.getJczz());
        t.setH_bbh(jc.getBbh());
        t.setH_cbs(jc.getCbs());
        t.setJc_type("学生用书");
        t.setH_price(Double.parseDouble(jc.getPrice()));
        t.setH_bzsh(jc.getBzsh());
        t.setJsysl("1");
        t.setH_zhekou(75.0d);
        t.setXgrq(StringUtil.getDateString());
        t.setSh("0");
        t.setShrq("");
        t.setJcsxh(sxh);
        t.setBz("");
        t.setJc_webprice(Double.parseDouble(jc.getPrice())*0.75);
        termBookPlanService.save(t);
    }

}
