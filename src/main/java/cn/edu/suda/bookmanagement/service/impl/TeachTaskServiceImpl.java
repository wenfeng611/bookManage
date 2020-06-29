package cn.edu.suda.bookmanagement.service.impl;

import cn.edu.suda.bookmanagement.dto.TeachTaskSearchBean;
import cn.edu.suda.bookmanagement.entity.TeachTask;
import cn.edu.suda.bookmanagement.entity.TermBookPlan;
import cn.edu.suda.bookmanagement.repository.TeachTaskRepository;
import cn.edu.suda.bookmanagement.repository.TermBookPlanRepository;
import cn.edu.suda.bookmanagement.service.TeachTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeachTaskServiceImpl implements TeachTaskService {
    @Autowired
    TeachTaskRepository teachTaskRepository;

    @Autowired
    TermBookPlanRepository termBookPlanRepository;

    //拿到kcdm的list去teachtask表中拿到对应的xkkh 在用xkkh去termbookplan表中拿数
    //数据中学期学年 教材顺序号 以及一些冗余字段记录教材信息

    @Override
    public List getAllKcByKcdm(List kcdm) {
        List finallist =new ArrayList(); //放选课课号
        List<TermBookPlan> finallisttbp = new ArrayList<>();
//        kcdm.forEach(dm->{
//           List list = teachTaskRepository.findXkkhByKcdm((String)dm);
//            finallist.addAll(list);
//        });
//        //得到所有专业对应的xkkh后去termbookplan中查
//        finallist.forEach(fl->{
//            List<TermBookPlan> list2 =termBookPlanRepository.findByXkkh((String)fl);
//            finallisttbp.addAll(list2);
//        });

        return finallisttbp;
    }

    @Override
    public List<TeachTask> findByKcdm(List kcdm) {
        List<TeachTask> list =new ArrayList<>();
        kcdm.forEach(dm->{
          List<TeachTask> dmlist =  teachTaskRepository.findByKcdm((String)dm);
          if(dmlist!=null && dmlist.size()>0) {
              TeachTask tt =dmlist.get(0);
              //TeachTaskSearchBean tt = dmlist.get(1);
              list.add(tt);
          }
        });
        return list;
    }

    public List<TeachTask> findByXnAndXqAndLbAndKkxyAndSh(String xn,String xq,String lb,String kkxy,String sh){
        return teachTaskRepository.findByXnAndXqAndLbAndKkxyAndSh(xn,xq,lb,kkxy,sh);
    }

    public List<TeachTask> findByXnAndXqAndLbAndKkxy(String xn,String xq,String lb,String kkxy){
        return teachTaskRepository.findByXnAndXqAndLbAndKkxy(xn,xq,lb,kkxy);
    }

    public List<TeachTask> save(List<TeachTask> list){
        return teachTaskRepository.save(list);
    }
}
