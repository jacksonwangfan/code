package com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式;


import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.没有依赖Servlet模拟一下Servlet的Api.HttpServletRequest;
import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.没有依赖Servlet模拟一下Servlet的Api.HttpServletResponse;

public interface HandlerAdapter {
     Boolean supports(Object handler);

    void handle(HttpServletRequest request, HttpServletResponse response,Object handler);
}
