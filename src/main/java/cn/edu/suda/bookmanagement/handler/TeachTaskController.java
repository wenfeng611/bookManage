package cn.edu.suda.bookmanagement.handler;

import cn.edu.suda.bookmanagement.dto.TeachTaskSearchBean;
import cn.edu.suda.bookmanagement.entity.JC;
import cn.edu.suda.bookmanagement.entity.TeachTask;
import cn.edu.suda.bookmanagement.entity.TermBookPlan;
import cn.edu.suda.bookmanagement.entity.TermTakePlan;
import cn.edu.suda.bookmanagement.service.TeachTaskService;
import cn.edu.suda.bookmanagement.service.TermBookPlanService;
import cn.edu.suda.bookmanagement.service.TermTakePlanService;
import cn.edu.suda.bookmanagement.util.BeanUtil;
import cn.edu.suda.bookmanagement.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/restapi/teachtask")
public class TeachTaskController {
    @Autowired
    TeachTaskService teachTaskService;

    @Autowired
    TermTakePlanService termTakePlanService;

    @Autowired
    TermBookPlanService termBookPlanService;

    //通过专业先去termTakePlanService拿kcdm的list再去teachTaskService根据kcdm拿对应kc的数据
    @RequestMapping(value = "/courseinfo", method = RequestMethod.GET)
    public Map getCourseInfo(HttpServletRequest request,String syzy) {
        Map map = new HashMap();
        List<String> list = termTakePlanService.getKcdm(syzy);
        List<TeachTask> teachTaskList = teachTaskService.findByKcdm(list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",teachTaskList.size());
        map.put("data",teachTaskList);
        return map;
    }

    @RequestMapping(value = "/xycourse", method = RequestMethod.GET)
    public Map getXyCourse(HttpServletRequest request,String xn,String xq,String lb,String kkxy,String sh) {
        Map map = new HashMap();
        List<TeachTask> list = teachTaskService.findByXnAndXqAndLbAndKkxy(xn,xq,lb,kkxy);
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }


    @RequestMapping(value = "/defaultPlan", method = RequestMethod.POST)
    public void defaultPlan(HttpServletRequest request,String xn,String xq,String lb,String kkxy,String sh,String newxn) throws Exception{
        Map map = new HashMap();
        List<TeachTask> list = teachTaskService.findByXnAndXqAndLbAndKkxy(xn, xq, lb, kkxy);
        List<TeachTask> list2 = new ArrayList<>();
        List<TermBookPlan> allList = new ArrayList<>();
        List<TermBookPlan> allList2 = new ArrayList<>();
        List<TermTakePlan> qlist = new ArrayList<>();
        List<TermTakePlan> qlist2 = new ArrayList<>();
        
        list.forEach(teachTask -> {
            List<TermBookPlan> detaillist = termBookPlanService.findByXkkhAndXnAndXq(teachTask.getXkkh(),xn,xq,false);
            allList.addAll(detaillist);
        });
        allList.forEach(tbp->{
            TermBookPlan t =new TermBookPlan();
            try {
                BeanUtils.copyProperties(tbp,t);
            } catch (Exception e) {
                e.printStackTrace();
            }
            t.setSxh(null);
            t.setXn(newxn);
            t.setXglb("系统分配");
            t.setSh("0");
            t.setShrq("");
            t.setXkkh(t.getXkkh().replace(xn,newxn));
            t.setXgrq("");
            //tbp.setSxh("");
            allList2.add(t);
        }); //3,2 table
        termBookPlanService.save(allList2);

        list.forEach(teachTask -> {
            List<TermTakePlan> q = termTakePlanService.findByKcdmAndKkxy(teachTask.getKcdm(),kkxy,xn,xq);
            qlist.addAll(q);
        });
        for (TermTakePlan termTakePlan : qlist) {
            TermTakePlan t = new TermTakePlan();
            try {
                BeanUtils.copyProperties(termTakePlan,t);
            } catch (Exception e) {
                e.printStackTrace();
            }
            t.setId(null);
            t.setXn(newxn);
            t.setXkkh(UUID.randomUUID().toString());
            t.setTjsj(StringUtil.getDateString());
            t.setSh("0");
           // termTakePlan.setId("");
            qlist2.add(t);
        }
        termTakePlanService.save(qlist2);

        list.forEach(teachTask -> {
            TeachTask t = new TeachTask();
            try {
                BeanUtils.copyProperties(teachTask,t);
            } catch (Exception e) {
                e.printStackTrace();
            }
            t.setId(null);
            t.setXn(newxn);
            t.setXkkh(t.getXkkh().replace(xn,newxn));
            t.setSh("0");
            //teachTask.setId("");
            list2.add(t);
        }); //3,1 table
        teachTaskService.save(list2);

    }
}
