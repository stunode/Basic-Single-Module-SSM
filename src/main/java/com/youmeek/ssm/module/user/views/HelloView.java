package com.youmeek.ssm.module.user.views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

//放到容器中,增加@Component
@Component
public class HelloView implements View{
    @Override
    public String getContentType() {
        return"text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().print("hello view, time: " + new Date());
    }


//    @Override
//    public String getContentType() {
//        return "text/html";
//    }
//
//    @Override
//	public void render(Map<String, ?> model, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		response.getWriter().print("hello view, time: " + new Date());
//	}
}
