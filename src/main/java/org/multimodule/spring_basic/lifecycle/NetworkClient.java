package org.multimodule.spring_basic.lifecycle;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient{

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출...뭐하는지 url = " + url);
//        connect();
//        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect : " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + " message = " + message);
    }


    //서비스 종료시 호출
    @PreDestroy
    public void disconnect(){
        System.out.println("disconnect : " + url);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메시지");
//    }

//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
}
