package cn.edu.suda.bookmanagement.service.impl;

import cn.edu.suda.bookmanagement.entity.TermBookPlan;
import cn.edu.suda.bookmanagement.repository.TermBookPlanRepository;
import cn.edu.suda.bookmanagement.service.TermBookPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermBookPlanServiceImpl implements TermBookPlanService{
    @Autowired
    TermBookPlanRepository termBookPlanRepository;

    @Override
    public List<TermBookPlan> findByXkkh(String xkkh,boolean show) {
        return termBookPlanRepository.findByXkkhAndIsdel(xkkh,show);
    }

    public List<TermBookPlan> findByXkkhAndXnAndXq(String xkkh,String xn,String xq,boolean show){
        return termBookPlanRepository.findByXkkhAndXnAndXqAndIsdel(xkkh,xn,xq,show);
    }

    @Override
    public TermBookPlan findByXkkhAndJcsxh(String xkkh,String jcsxh){
        return termBookPlanRepository.findByXkkhAndJcsxhAndIsdel(xkkh,jcsxh,false);
    }

    @Override
    public TermBookPlan save(TermBookPlan t){
        return termBookPlanRepository.save(t);
    }

    @Override
    public List<TermBookPlan> save(List<TermBookPlan> list){
        return termBookPlanRepository.save(list);
    }
}
