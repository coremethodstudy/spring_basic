package org.multimodule.spring_basic.singleton;

public class SingletonService {
    //static으로 객체 1개 성성하기
    //new 로 객체 생성 막기
    //get으로 객체 가져오기

    //1. static 영역에 객체를 딱 1개만 생성해둔다
    private static final SingletonService instance = new SingletonService();

    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다
    public static SingletonService getInstance(){
//        logic();
        return instance;
    }
    //이렇게 하면 자바가 컴파일될 때 static 영역에 생성됨

    //3. 생성자를 private으로 선언해서 외부 new 키원드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    //이렇게 하면 진짜 완벽한 싱글톤임 짱임
}
