package org.multimodule.spring_basic.lifecycle;

public class NetworkClient2 {

    private String url;


    public NetworkClient2() {
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


    public void init() {
        System.out.println("빈 초기화 ---------------------------");
        System.out.println(this.getClass());
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }


    public void destroy() {
        disconnect();
    }

}
