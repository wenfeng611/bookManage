package cn.edu.suda.bookmanagement.UtilsTest;

import cn.edu.suda.bookmanagement.BookmanagementApplication;
import cn.edu.suda.bookmanagement.dto.TeachTaskTermTakePlanDTO;
import cn.edu.suda.bookmanagement.entity.TeachTask;
import cn.edu.suda.bookmanagement.repository.TeachTaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = BookmanagementApplication.class)
public class BeanUtilsTest {

    @Autowired
    TeachTaskRepository teachTaskRepository;

    @Test
    public void testBeanUtils(){
       TeachTask t =  teachTaskRepository.findById("1");
        System.out.print(t);
        TeachTaskTermTakePlanDTO tt = new TeachTaskTermTakePlanDTO();
        //把A赋值给B
        BeanUtils.copyProperties(t,tt);
        System.out.print(tt);
    }
}
