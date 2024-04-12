package org.multimodule.spring_basic.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.multimodule.spring_basic.common.MyLogger;
import org.multimodule.spring_basic.logdemo.LogDemoService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final ObjectProvider<MyLogger> myLoggerObjectProvider;
    private final LogDemoService logDemoService;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();
        MyLogger myLogger = myLoggerObjectProvider.getObject();

        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");

        logDemoService.logic("testID");
        return "ok";
    }
    //ObjectProvider.getObject() 로 Controller와 Service 에서 각각 한번씩 따로 호출해도 HTTP 요청이 같으면 같은 스프링 빈이 반환됨


}
