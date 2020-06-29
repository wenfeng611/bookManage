package cn.edu.suda.bookmanagement.service.impl;

import cn.edu.suda.bookmanagement.entity.CourseJC;
import cn.edu.suda.bookmanagement.repository.CourseJCRepository;
import cn.edu.suda.bookmanagement.service.CourseJCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseJCServiceImpl implements CourseJCService{
    @Autowired
    CourseJCRepository courseJCRepository;

    @Override
    public List<CourseJC> findAll() {
        return courseJCRepository.findAll();
    }

    @Override
    public Page<CourseJC> findAll(Pageable pageable) {
        return courseJCRepository.findAll(pageable);
    }

    @Override
    public Long count(){
        return courseJCRepository.count();
    }

    @Override
    public CourseJC findBySxh(String sxh){
        return courseJCRepository.findBySxh(sxh);
    }

    @Override
    public List<CourseJC> findByKcdm(String kcdm) {
        return courseJCRepository.findByKcdm(kcdm);
    }
}
