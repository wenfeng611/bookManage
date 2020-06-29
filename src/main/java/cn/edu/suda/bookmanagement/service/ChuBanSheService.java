package cn.edu.suda.bookmanagement.service;

import cn.edu.suda.bookmanagement.entity.ChuBanShe;
import cn.edu.suda.bookmanagement.entity.JC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ChuBanSheService {
    Page<ChuBanShe> findAll(Pageable page);
    List<ChuBanShe> findAll();
}
