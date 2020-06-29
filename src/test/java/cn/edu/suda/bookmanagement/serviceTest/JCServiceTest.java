package cn.edu.suda.bookmanagement.serviceTest;

import cn.edu.suda.bookmanagement.BookmanagementApplication;
import cn.edu.suda.bookmanagement.service.JCService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = BookmanagementApplication.class)
public class JCServiceTest {
    @Autowired
    JCService jcService;

    @Test
    public void findAllTest(){
        jcService.findAll();
    }
}
