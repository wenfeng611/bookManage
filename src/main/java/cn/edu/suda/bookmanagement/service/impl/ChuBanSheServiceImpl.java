package cn.edu.suda.bookmanagement.service.impl;

import cn.edu.suda.bookmanagement.entity.ChuBanShe;
import cn.edu.suda.bookmanagement.entity.JC;
import cn.edu.suda.bookmanagement.repository.ChuBanSheRepository;
import cn.edu.suda.bookmanagement.service.ChuBanSheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuBanSheServiceImpl implements ChuBanSheService {

    @Autowired
    ChuBanSheRepository chuBanSheRepository;

    @Override
    public Page<ChuBanShe> findAll(Pageable page) {
        return chuBanSheRepository.findAll(page);
    }

    @Override
    public List<ChuBanShe> findAll() {
        return chuBanSheRepository.findAll();
    }

}
