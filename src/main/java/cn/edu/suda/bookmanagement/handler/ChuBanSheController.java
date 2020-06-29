package cn.edu.suda.bookmanagement.handler;

import cn.edu.suda.bookmanagement.entity.ChuBanShe;
import cn.edu.suda.bookmanagement.service.ChuBanSheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restapi/chubanshe")
public class ChuBanSheController {
    @Autowired
    ChuBanSheService chuBanSheService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List list(HttpServletRequest request) {
        List<Map> mapList = new ArrayList<>();
        List<ChuBanShe> list =  chuBanSheService.findAll();
        for (ChuBanShe chuBanShe : list) {
            Map<String, String> map = new HashMap<>();
            map.put("id", chuBanShe.getCbsmc());
            map.put("text", chuBanShe.getCbsmc());
            mapList.add(map);
        }
        return mapList;

    }
}
