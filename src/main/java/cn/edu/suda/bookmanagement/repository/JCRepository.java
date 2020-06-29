package cn.edu.suda.bookmanagement.repository;

import cn.edu.suda.bookmanagement.entity.JC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JCRepository extends JpaRepository<JC, String> {
    List<JC> findAll();
    Page<JC> findAll(Pageable page);

    Page<JC> findBySfxsAndSfzf(String Sfxs,String Sfzf,Pageable page);

    @Query(value = "select t from JC t where t.jcmc like %:jcmc% or t.sxh=:sxh or t.gys like %:jcmc%")
    List<JC> findByJcmcAndSxh(@Param("jcmc")String jcmc, @Param("sxh")String sxh);

    JC findBySxh(String sxh);
    JC findByJcmcAndJczzAndSfxsAndSfzf(String jcmc,String jczz,String sfxs,String sfzf);

    void deleteBySxh(String sxh);
    List<JC> findByGysAndSfxsAndSfzf(String Gys,String sfxs,String sfzf);
    List<JC> findByGys(String Gys);
    Page<JC> findByGys(String Gys,Pageable page);
    List<JC> findByShzt(String shzt);
    Page<JC> findByShzt(String shzt,Pageable page);
    Long countBySfxsAndSfzf(String sfxs,String sfzf);
}
