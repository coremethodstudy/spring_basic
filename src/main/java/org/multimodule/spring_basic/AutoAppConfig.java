package org.multimodule.spring_basic;

import org.multimodule.spring_basic.command.application.DiscountPolicy;
import org.multimodule.spring_basic.command.application.FixDiscountPolicy;
import org.multimodule.spring_basic.command.application.RateDiscountPolicy;
import org.multimodule.spring_basic.repository.CarItemRepository;
import org.multimodule.spring_basic.repository.ElectronicProductRepository;
import org.multimodule.spring_basic.repository.HomeApplianceRepository;
import org.multimodule.spring_basic.repository.ItemRepository;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
        Configuration.class)
)
public class AutoAppConfig {

    @Bean
    @Primary
    public DiscountPolicy rateDiscountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public DiscountPolicy fixDiscountPolicy() {
        return new FixDiscountPolicy();
    }

    @Bean
    public List<ItemRepository> itemRepositoryList() {
        List<ItemRepository> itemRepositoryList = new ArrayList<>();
        itemRepositoryList.add(new CarItemRepository());
        itemRepositoryList.add(new HomeApplianceRepository());
        itemRepositoryList.add(new ElectronicProductRepository());
        return itemRepositoryList;
    }

}
