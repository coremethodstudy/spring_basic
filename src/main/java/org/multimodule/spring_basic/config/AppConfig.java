package org.multimodule.spring_basic.config;

import org.multimodule.spring_basic.order.OrderService;
import org.multimodule.spring_basic.order.discount.DiscountPolicy;
import org.multimodule.spring_basic.order.discount.FixDiscount;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public OrderService orderService(){
        return new OrderService(discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscount();
    }


}
