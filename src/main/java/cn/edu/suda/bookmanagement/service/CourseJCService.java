package cn.edu.suda.bookmanagement.service;

import cn.edu.suda.bookmanagement.entity.CourseJC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseJCService {
    List<CourseJC> findAll();

    Page<CourseJC> findAll(Pageable pageable);

    Long count();

    CourseJC findBySxh(String sxh);

    List<CourseJC> findByKcdm(String kcdm);
}
