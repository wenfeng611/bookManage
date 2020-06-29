package cn.edu.suda.bookmanagement.repository;

import cn.edu.suda.bookmanagement.entity.TermBookPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TermBookPlanRepository extends JpaRepository<TermBookPlan,String> {
    List<TermBookPlan> findByXkkhAndIsdel(String xkkh,boolean del);

    TermBookPlan findByXkkhAndJcsxhAndIsdel(String xkkh,String jcsxh,boolean del);

    List<TermBookPlan> findByXkkhAndXnAndXqAndIsdel(String xkkh,String xn,String xq,boolean del);
}
