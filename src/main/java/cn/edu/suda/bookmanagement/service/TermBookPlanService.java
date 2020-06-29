package cn.edu.suda.bookmanagement.service;

import cn.edu.suda.bookmanagement.entity.TermBookPlan;

import java.util.List;

public interface TermBookPlanService {
    List<TermBookPlan> findByXkkh(String xkkh,boolean show);
    TermBookPlan findByXkkhAndJcsxh(String xkkh,String jcsxh);
    TermBookPlan save(TermBookPlan t);
    List<TermBookPlan> findByXkkhAndXnAndXq(String xkkh,String xn,String xq,boolean show);
    List<TermBookPlan> save(List<TermBookPlan> list);
}
