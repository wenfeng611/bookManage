package cn.edu.suda.bookmanagement.serviceTest;

import cn.edu.suda.bookmanagement.BookmanagementApplication;
import cn.edu.suda.bookmanagement.repository.TeachTaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = BookmanagementApplication.class)
public class TeachTaskRepositoryTest {
    @Autowired
    TeachTaskRepository teachTaskRepository;

    @Test
    public void testgetXnAndGetKkxy(){
       List listxn = teachTaskRepository.getXn();
       List listkkxy =  teachTaskRepository.getKkxy();
    }

    @Test
    public void testfindByXnAndXqAndLbAndKkxyAndSh(){

        List listkkxy =  teachTaskRepository.findByXnAndXqAndLbAndKkxy("2017-2018","1","普通课程","医学部");
        System.out.print(listkkxy);
    }
}
