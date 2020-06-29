package cn.edu.suda.bookmanagement.handler;

import cn.edu.suda.bookmanagement.entity.SH;
import cn.edu.suda.bookmanagement.entity.TeachTask;
import cn.edu.suda.bookmanagement.entity.TermBookPlan;
import cn.edu.suda.bookmanagement.entity.TermTakePlan;
import cn.edu.suda.bookmanagement.repository.SHRepository;
import cn.edu.suda.bookmanagement.service.TeachTaskService;
import cn.edu.suda.bookmanagement.service.TermBookPlanService;
import cn.edu.suda.bookmanagement.service.TermTakePlanService;
import cn.edu.suda.bookmanagement.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/restapi/sh")
public class SHController extends  Handler {
    @Autowired
    SHRepository sHRepository;

    @Autowired
    TeachTaskService teachTaskService;

    @Autowired
    TermTakePlanService termTakePlanService;

    @Autowired
    TermBookPlanService termBookPlanService;

    @RequestMapping(value = "/commitsh", method = RequestMethod.POST)
    public void commitsh(HttpServletRequest request, String xn, String xq, String lb, String kkxy, String sh, String newxn) throws Exception {
        SH s = new SH();
        s.setId(UUID.randomUUID().toString());
        s.setXn(xn);
        s.setXq(xq);
        s.setLb(lb);
        s.setXy(kkxy);
        s.setIstj(true);
        sHRepository.save(s);
    }

    @RequestMapping(value = "/shplan", method = RequestMethod.POST)
    public String shplan(HttpServletRequest request, String xn, String xq, String lb, String kkxy, String sh, String newxn) throws Exception {
        Optional<SH> s = sHRepository.findByXnAndXqAndLbAndXyAndIstj(xn, xq, lb, kkxy, true);
        List<TeachTask> list = teachTaskService.findByXnAndXqAndLbAndKkxy(xn, xq, lb, kkxy);
        List<TermBookPlan> allList = new ArrayList<>();
        List<TermTakePlan> qlist = new ArrayList<>();
        if (s.isPresent()) {
            SH exist = s.get();
            if (!exist.isIssh()) {
                exist.setIssh(true);
                sHRepository.save(exist);

                list.forEach(teachTask -> {
                    List<TermBookPlan> detaillist = termBookPlanService.findByXkkhAndXnAndXq(teachTask.getXkkh(), xn, xq, false);
                    allList.addAll(detaillist);
                });
                allList.forEach(tbp -> {
                    tbp.setSh("1");
                    tbp.setShrq(StringUtil.getDateString());
                    tbp.setXgrq(StringUtil.getDateString());
                    //tbp.setSxh("");
                }); //3,2 table
                termBookPlanService.save(allList);

                list.forEach(teachTask -> {
                    List<TermTakePlan> q = termTakePlanService.findByKcdmAndKkxy(teachTask.getKcdm(), kkxy, xn, xq);
                    qlist.addAll(q);
                });
                for (TermTakePlan termTakePlan : qlist) {
                    termTakePlan.setSh("1");
                }
                termTakePlanService.save(qlist);

                list.forEach(teachTask -> {
                    teachTask.setSh("1");
                }); //3,1 table
                teachTaskService.save(list);
                return "true";
            } else {
                //被审核过
                return "shed";
            }
        } else {
            //未提交审核
            return "none";
        }
    }
}
