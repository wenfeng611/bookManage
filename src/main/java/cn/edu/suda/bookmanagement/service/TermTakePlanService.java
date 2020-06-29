package cn.edu.suda.bookmanagement.service;

import cn.edu.suda.bookmanagement.entity.TermTakePlan;

import java.util.List;

public interface TermTakePlanService {
    List getKkxy();
    List getSyzy(String kkxy,String skxy);
    List getKcdm(String syzy);
    List getKcmc(String syzy);
    List<TermTakePlan> findByXkkh(String xkkh);
    List<TermTakePlan> findByKcdm(String kcdm);
    List<TermTakePlan> findByKcdmAndKkxyAndSyzy(String kcdm,String kkxy,String syzy);
    List<TermTakePlan> findByKcdmAndKkxy(String kcdm,String kkxy,String xn,String xq);
    List<TermTakePlan> save(List<TermTakePlan> list);
}
