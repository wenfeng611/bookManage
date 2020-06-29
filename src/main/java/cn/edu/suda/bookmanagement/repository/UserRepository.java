package cn.edu.suda.bookmanagement.repository;

import cn.edu.suda.bookmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String username,String password);
    User findByUsername(String username);
}
