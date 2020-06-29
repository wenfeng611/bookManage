package cn.edu.suda.bookmanagement.service;

import cn.edu.suda.bookmanagement.entity.JC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JCService {
    List<JC> findAll();
    Page<JC> findAll(Pageable page);
    JC save(JC jc);
    void deleteBySxh(String sxh);
    JC findBySxh(String sxh);
    JC findByJcmcAndJczzAndSfxsAndSfzf(String jcmc,String jczz,String sfxs,String sfzf);
    Page<JC> findBySfxsAndSfzf(String sfxs,String sfzf,Pageable page);
    List<JC> findByJcmcAndSxh(String q,Pageable page);


    Long count();
    List<JC> findByGys(String Gys);
    Page<JC> findByGys(String Gys,Pageable page);
    List<JC> findByShzt(String shzt);
    Page<JC> findByShzt(String shzt,Pageable page);
    List<JC> findAllxybook(String kkxy,String sfxs,String sfzf);
}
