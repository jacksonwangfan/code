package com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.Adapter;

import com.sun.istack.internal.NotNull;
import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.Handler.AnnotationHandler;
import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.HandlerAdapter;
import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.没有依赖Servlet模拟一下Servlet的Api.HttpServletRequest;
import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.没有依赖Servlet模拟一下Servlet的Api.HttpServletResponse;

public class AnnotationHandlerAdapter implements HandlerAdapter {
    @Override
    public Boolean supports(@NotNull Object handler) {
        return handler instanceof AnnotationHandlerAdapter;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,Object  handler) {
        //适配
        ((AnnotationHandler) handler).annotationHandler();
    }


}
