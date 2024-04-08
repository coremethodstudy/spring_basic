package org.multimodule.spring_basic.singleton;

public class StatefulService {
    private int price; //상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //여기가 문제
    }

    public int getPrice(){
        return price;
    }

    //무상태로 설계해보기
    //지역 변수로 바꿔서 해보자
    public int order1(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

}
