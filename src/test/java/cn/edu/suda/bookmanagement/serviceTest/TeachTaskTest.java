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
public class TeachTaskTest {
    @Autowired
    TeachTaskRepository teachTaskRepository;

    @Test
    public void testFindByKcdm(){
        List list = teachTaskRepository.findByKcdm("0081010");
        System.out.print(list);
    }
}
