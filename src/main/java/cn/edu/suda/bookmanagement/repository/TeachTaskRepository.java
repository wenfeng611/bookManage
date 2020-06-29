package cn.edu.suda.bookmanagement.repository;

import cn.edu.suda.bookmanagement.dto.TeachTaskSearchBean;
import cn.edu.suda.bookmanagement.entity.TeachTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeachTaskRepository extends JpaRepository<TeachTask, String> {

    @Query("select distinct t.xkkh from TeachTask t where t.kcdm=?1")
    List findXkkhByKcdm(String kcdm);

   // @Query("select t.kcmc,t.kcdm,t.xf,t.kcxz from TeachTask t where t.kcdm=?1")
    List<TeachTask> findByKcdm(String kcdm);

    TeachTask findById(String id);

    @Query("select distinct t.xn from TeachTask t")
    List<String> getXn();

    @Query("select distinct t.kkxy from TeachTask t")
    List<String> getKkxy();

    @Query("select distinct t.lb from TeachTask t")
    List<String> getLb();

    List<TeachTask> findByXnAndXqAndLbAndKkxyAndSh(String xn,String xq,String lb,String kkxy,String sh);

    List<TeachTask> findByXnAndXqAndLbAndKkxy(String xn,String xq,String lb,String kkxy);
}
