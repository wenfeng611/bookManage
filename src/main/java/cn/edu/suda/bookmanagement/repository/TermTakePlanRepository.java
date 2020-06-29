package cn.edu.suda.bookmanagement.repository;

import cn.edu.suda.bookmanagement.entity.TermTakePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TermTakePlanRepository extends JpaRepository<TermTakePlan, String>{

    @Query("select distinct t.kkxy from TermTakePlan t")
    List getKkxy();

    @Query("select distinct t.syzy from TermTakePlan t where t.kkxy=?1 and t.skxy=?2")
    List getSyzy(String kkxy,String skxy);

    @Query(value = "select distinct t.kcdm from TermTakePlan t where t.syzy like %:syzy%")
    List getkkdm(@Param("syzy")String syzy);

    @Query(value = "select distinct t.kcmc from TermTakePlan t where t.syzy like %:syzy%")
    List getkcmc(@Param("syzy")String syzy);

    List<TermTakePlan> findByXkkh(String xkkh);

    List<TermTakePlan> findByKcdm(String kcdm);

    @Query("select t from TermTakePlan t where t.kcdm=?1  and t.syzy like %?2% and t.sh=?3")
    List<TermTakePlan> findByKcdmAndKkxyAndLikeSyzy(String kcdm,String syzy,String sh);

    List<TermTakePlan> findByKcdmAndKkxyAndXnAndXq(String kcdm,String kkxy,String xn,String xq);
}
