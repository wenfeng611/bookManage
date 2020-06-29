package cn.edu.suda.bookmanagement.service.impl;

import cn.edu.suda.bookmanagement.entity.JC;
import cn.edu.suda.bookmanagement.repository.JCRepository;
import cn.edu.suda.bookmanagement.service.JCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JCServiceImpl implements JCService{
    @Autowired
    JCRepository jCRepository;

    @Override
    public List<JC> findAll() {
        return jCRepository.findAll();
    }

    @Override
    public Page<JC> findAll(Pageable page) {
        return jCRepository.findAll(page);
    }

    @Override
    public Page<JC> findBySfxsAndSfzf(String sfxs,String sfzf,Pageable page){
        return jCRepository.findBySfxsAndSfzf(sfxs,sfzf, page);
    }

    @Override
    public JC save(JC jc) {
        return jCRepository.save(jc);
    }

    @Override
    public void deleteBySxh(String sxh) {
        jCRepository.deleteBySxh(sxh);
    }


    @Override
    public JC findBySxh(String sxh) {
        return jCRepository.findBySxh(sxh);
    }

    @Override
    public JC findByJcmcAndJczzAndSfxsAndSfzf(String jcmc,String jczz,String sfxs,String sfzf){
        return jCRepository.findByJcmcAndJczzAndSfxsAndSfzf(jcmc,jczz,sfxs,sfzf);
    }

    @Override
    public List<JC> findByJcmcAndSxh(String q,Pageable page){
        return jCRepository.findByJcmcAndSxh(q,q);
    }

    @Override
    public List<JC> findByGys(String Gys) {
        return jCRepository.findByGys(Gys);
    }
    @Override
    public Long count(){
        return jCRepository.countBySfxsAndSfzf("1","0");
    }

    @Override
    public Page<JC> findByGys(String Gys, Pageable page) {
        return jCRepository.findByGys(Gys,page);
    }

    @Override
    public List<JC> findByShzt(String shzt) {
        return jCRepository.findByShzt(shzt);
    }

    @Override
    public Page<JC> findByShzt(String shzt, Pageable page) {
        return jCRepository.findByShzt(shzt,page);
    }

    @Override
    public List<JC> findAllxybook(String kkxy,String sfxs,String sfzf){
        return jCRepository.findByGysAndSfxsAndSfzf(kkxy,sfxs,sfzf);
    }
}
