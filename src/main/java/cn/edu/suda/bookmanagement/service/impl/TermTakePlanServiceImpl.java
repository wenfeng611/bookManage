package cn.edu.suda.bookmanagement.service.impl;

import cn.edu.suda.bookmanagement.entity.TermTakePlan;
import cn.edu.suda.bookmanagement.repository.TermTakePlanRepository;
import cn.edu.suda.bookmanagement.service.TermTakePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermTakePlanServiceImpl implements TermTakePlanService{
    @Autowired
    TermTakePlanRepository termTakePlanRepository;


    @Override
    public List getKkxy() {
        return termTakePlanRepository.getKkxy();
    }

    @Override
    public List getSyzy(String kkxy,String skxy){
        return termTakePlanRepository.getSyzy(kkxy,skxy);
    }

    @Override
    public List getKcdm(String syzy){
        return termTakePlanRepository.getkkdm(syzy);
    }

    @Override
    public List getKcmc(String syzy){
        return termTakePlanRepository.getkcmc(syzy);
    }

    @Override
    public List<TermTakePlan> findByXkkh(String xkkh){return termTakePlanRepository.findByXkkh(xkkh);}

    @Override
    public List<TermTakePlan> findByKcdm(String kcdm) {
        return termTakePlanRepository.findByKcdm(kcdm);
    }

    @Override
    public List<TermTakePlan> findByKcdmAndKkxyAndSyzy(String kcdm, String kkxy, String syzy) {
        return termTakePlanRepository.findByKcdmAndKkxyAndLikeSyzy(kcdm,syzy,"1");
    }

    @Override
    public List<TermTakePlan> findByKcdmAndKkxy(String kcdm,String kkxy,String xn,String xq){
        return termTakePlanRepository.findByKcdmAndKkxyAndXnAndXq(kcdm,kkxy, xn, xq);
    }

    @Override
    public List<TermTakePlan> save(List<TermTakePlan> list){
        return termTakePlanRepository.save(list);
    }
}
