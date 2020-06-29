package cn.edu.suda.bookmanagement.serviceTest;

import cn.edu.suda.bookmanagement.BookmanagementApplication;
import cn.edu.suda.bookmanagement.repository.TermTakePlanRepository;
import cn.edu.suda.bookmanagement.service.TeachTaskService;
import cn.edu.suda.bookmanagement.service.TermTakePlanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = BookmanagementApplication.class)
public class TermTakePlanServiceTest {
    @Autowired
    TermTakePlanService termTakePlanService;

    @Autowired
    TermTakePlanRepository termTakePlanRepository;

    @Autowired
    TeachTaskService teachTaskService;

    @Test
    public void testFindKkxy(){
      List list = termTakePlanService.getKkxy();
      System.out.println(list);
      List<String> zylist = termTakePlanService.getSyzy("计算机科学与技术学院","计算机科学与技术学院");
      System.out.print(zylist);
      List newList = new ArrayList();
      zylist.forEach(zy->{
          //用，分割 全部放到新的数组里
          String[] arra = zy.split(",");
          for(int i=0;i<arra.length;i++){
              newList.add(arra[i]);
          }
      });
      System.out.println(newList);
      Set<String> set =new HashSet<>();
      set.addAll(newList);
    }

    @Test
    public void testGetKcdm(){
        //拿到专业对应的课程代码
       List list = termTakePlanRepository.getkkdm("软件工程");
       System.out.print(list);
       //teachtask中通过kcdm拿到xkkh
        teachTaskService.getAllKcByKcdm(list);
    }
}
