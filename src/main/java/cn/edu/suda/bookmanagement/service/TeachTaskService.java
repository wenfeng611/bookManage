package cn.edu.suda.bookmanagement.service;

import cn.edu.suda.bookmanagement.dto.TeachTaskSearchBean;
import cn.edu.suda.bookmanagement.entity.TeachTask;

import java.util.List;

public interface TeachTaskService {
    List getAllKcByKcdm(List kcdm);
    List<TeachTask> findByKcdm(List kcdm);

    List<TeachTask> findByXnAndXqAndLbAndKkxyAndSh(String xn,String xq,String lb,String kkxy,String sh);

    List<TeachTask> findByXnAndXqAndLbAndKkxy(String xn,String xq,String lb,String kkxy);

    List<TeachTask> save(List<TeachTask> list);
}
