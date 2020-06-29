package cn.edu.suda.bookmanagement.handler;

import cn.edu.suda.bookmanagement.bean.CellProperty;
import cn.edu.suda.bookmanagement.entity.JC;
import cn.edu.suda.bookmanagement.entity.User;
import cn.edu.suda.bookmanagement.service.JCService;
import cn.edu.suda.bookmanagement.util.BeanUtil;
import cn.edu.suda.bookmanagement.util.ExcelExportProcess;
import cn.edu.suda.bookmanagement.util.MessageEncoder;
import cn.edu.suda.bookmanagement.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/restapi/jc")
public class JCController extends  Handler{
    @Autowired
    private JCService jcService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map list(HttpServletRequest request,String q) {
        Map<String,Object> map = new HashMap<>();

        int page = StringUtil.str2Int(request.getParameter("page"),0);
        int limit= StringUtil.str2Int(request.getParameter("limit"),10);
        if(StringUtils.isBlank(q)) {
            Page<JC> list = jcService.findBySfxsAndSfzf("1", "0", new PageRequest(page - 1, limit, Sort.Direction.DESC, "sxh"));
            map.put("data",list.getContent());
            map.put("count",jcService.count());
        }else{
            List<JC> list = jcService.findByJcmcAndSxh(q,new PageRequest(page - 1, limit, Sort.Direction.DESC, "sxh"));
           List<JC> list2= list.stream()
                    .limit((page)*limit)
                    .skip((page-1)*limit)
                    .collect(toList());
            map.put("data",list2);
            map.put("count",list.size());
        }
        map.put("code",0);
        map.put("msg","");


        return map;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request, @Valid JC jc) {
        User user = (User)request.getSession().getAttribute("user");
        JC jcexsit = jcService.findByJcmcAndJczzAndSfxsAndSfzf(jc.getJcmc(),jc.getJczz(),"1","0");
        if(jcexsit!=null){
            //如果存在只要更新
            jcexsit.setJcmc(jc.getJcmc());
            jcexsit.setJczz(jc.getJczz());
            jcexsit.setBbh(jc.getBbh());
            jcexsit.setCbs(jc.getCbs());
            jcexsit.setPrice(jc.getPrice());
            jcexsit.setBzsh(jc.getBzsh());
            jcexsit.setGys(jc.getGys());
            jcexsit.setCbj(jc.getCbj());
            jcexsit.setMrzk(jc.getMrzk());
            jcService.save(jc);
        }else {
            jc.setYkcsl("0");
            jc.setSfxs("1");
            jc.setSfzf("0");
            jc.setShzt("未审核");
            jc.setSrr(user.getUsername());
            jc.setSrrq(new Date().toString());
            jcService.save(jc);
        }
        return  request(super.createRequestPageTempletResponse("/jcindex"));
    }

    @RequestMapping(value = "/delete/{sxh}", method = RequestMethod.POST)
    public void delete(HttpServletRequest request, @PathVariable String sxh) {
       //逻辑删除
        JC jc = jcService.findBySxh(sxh);
        jc.setSfxs("0");
        jc.setSfzf("1");
        jcService.save(jc);
    }

    @RequestMapping(value = "/alladd", method = RequestMethod.GET)
    public List<JC> alladd(HttpServletRequest request, String kkxy) {
        return jcService.findAllxybook(kkxy,"1","0");
    }


    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response,String q)throws Exception {
        List<Map<String, Object>> values = new ArrayList<>();
        List<JC> list =new ArrayList<>();
        if(StringUtils.isBlank(q)) {
            list = jcService.findAll();
        }else{
            list = jcService.findByJcmcAndSxh(q,new PageRequest(0, 10, Sort.Direction.DESC, "sxh"));
        }
        for (JC p : list) {
            values.add(BeanUtil.transBean2Map(p));
        }

        List<CellProperty> cellProperties = new ArrayList<>();
        cellProperties.add(new CellProperty("顺序号", "sxh"));
        cellProperties.add(new CellProperty("名称", "jcmc"));
        cellProperties.add(new CellProperty("作者", "jczz"));
        cellProperties.add(new CellProperty("版本号", "bbh"));
        cellProperties.add(new CellProperty("出版社", "cbs"));
        cellProperties.add(new CellProperty("价格", "price"));
        cellProperties.add(new CellProperty("标准书号", "bzsh"));
        cellProperties.add(new CellProperty("学院", "gys"));
        cellProperties.add(new CellProperty("成本价", "cbj"));
        cellProperties.add(new CellProperty("默认折扣", "mrzk"));
        cellProperties.add(new CellProperty("审核状态", "shzt"));
        cellProperties.add(new CellProperty("录入时间", "srrq"));
        cellProperties.add(new CellProperty("出版年月", "cbny"));

        String filename = MessageEncoder.encode("教材信息");
        response.setHeader("content-disposition", "attachment;filename=" + filename + ".xls");
        ExcelExportProcess excelProcess = new ExcelExportProcess(values, cellProperties, response.getOutputStream());
        excelProcess.process();
    }
}
