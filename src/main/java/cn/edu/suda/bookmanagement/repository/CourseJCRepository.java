package cn.edu.suda.bookmanagement.repository;

import cn.edu.suda.bookmanagement.entity.CourseJC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseJCRepository extends JpaRepository<CourseJC, String> {
    List<CourseJC> findAll();

    Page<CourseJC> findAll(Pageable pageable);

    CourseJC findBySxh(String sxh);

    List<CourseJC> findByKcdm(String kcdm);
}
