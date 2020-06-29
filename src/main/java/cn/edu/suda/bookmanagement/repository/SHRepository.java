package cn.edu.suda.bookmanagement.repository;

import cn.edu.suda.bookmanagement.entity.SH;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SHRepository extends JpaRepository<SH, String> {
    Optional<SH> findByXnAndXqAndLbAndXyAndIstj(String xn, String xq, String lb, String xy, boolean tijiao);

}
