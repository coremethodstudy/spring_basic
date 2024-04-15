package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.item.Car;
import org.multimodule.spring_basic.command.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface CarItemRepository extends JpaRepository<Car, Long> {
}
