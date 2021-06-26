package com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式;

import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.没有依赖Servlet模拟一下Servlet的Api.HttpServletRequest;
import com.wf.code.设计模式.适配器模式.SpringMVC中的适配器模式.没有依赖Servlet模拟一下Servlet的Api.HttpServletResponse;

//这里相当于调用者
public class DisparcherServlet {

    protected void doDispatch(HttpServletRequest request, HttpServletResponse response){
        //。。。。。。
        HandlerAdapter handlerAdapter = getHandlerAdapter();
        //。。。。。。
        handlerAdapter.handle(request,response,handlerAdapter);
    }

  private HandlerAdapter getHandlerAdapter(){
        return null;
  }
}
