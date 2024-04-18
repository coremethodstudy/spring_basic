package org.multimodule.spring_basic.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient1 implements InitializingBean, DisposableBean {

    private String url;


    public NetworkClient1() {
        System.out.println("객체 생성 ---------------------------");
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    public void disconnect() {
        System.out.println("close : " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("빈 초기화 ---------------------------");
        System.out.println(this.getClass());
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }

}
