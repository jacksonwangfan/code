package com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.Adapter;

import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.Handler.SimpleServletHandler;
import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.HandlerAdapter;
import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.没有依赖Servlet模拟一下Servlet的Api.HttpServletRequest;
import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.没有依赖Servlet模拟一下Servlet的Api.HttpServletResponse;

public class SimpleServletHandlerAdapter implements HandlerAdapter {
    @Override
    public Boolean supports(Object handler) {
        return null;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,Object handler) {
        //适配
        ((SimpleServletHandler) handler).simpleServletHandler();
    }
}
