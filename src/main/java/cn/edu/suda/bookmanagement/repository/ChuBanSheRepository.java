package cn.edu.suda.bookmanagement.repository;

import cn.edu.suda.bookmanagement.entity.ChuBanShe;
import cn.edu.suda.bookmanagement.entity.JC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChuBanSheRepository extends JpaRepository<ChuBanShe, String> {
    Page<ChuBanShe> findAll(Pageable page);
}
