package cn.edu.suda.bookmanagement.handler;

import cn.edu.suda.bookmanagement.util.UKView;
import org.springframework.web.servlet.ModelAndView;

public class Handler {

    public ModelAndView request(UKView data) {
        return new ModelAndView(data.getTemplet()!=null ? data.getTemplet(): data.getPage() , "data", data) ;
    }

    public UKView createRequestPageTempletResponse(String page) {
        return new UKView(page);
    }
}
