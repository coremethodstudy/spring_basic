package org.multimodule.spring_basic.command.domain.item;

import jakarta.persistence.Entity;

@Entity
public class Car extends Item{
    public Car(Long id, String itemName, int itemPrice) {
        super(id, itemName, itemPrice);
    }

    public Car() {

    }
}
