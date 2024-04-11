package org.multimodule.spring_basic;

import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBasicApplicationTests {

    //이렇게 SpringBootTest 에서는 사용해서 테스트 해도 됨-> 왜냐면 다른 곳에 가져다 쓸 일이 없으니까
    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
//        orderService.createOrder(!!!!!!);
    }

}
