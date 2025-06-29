package com.zomato.org.mapper;

import com.zomato.org.FoodOrderRequest;
import com.zomato.org.entity.FoodOrder;

public class FoodOrderMapper {
    public static FoodOrder toEntity(FoodOrderRequest dto) {
        FoodOrder order = new FoodOrder();
        order.setOrderId(dto.getOrderId());
        order.setCustomerName(dto.getCustomerName());
        order.setFoodItem(dto.getFoodItem());
        order.setQuantity(dto.getQuantity());
        return order;
    }
    public static FoodOrderRequest toDto(FoodOrder order) {
        FoodOrderRequest dto = new FoodOrderRequest();
        dto.setOrderId(order.getOrderId());
        dto.setCustomerName(order.getCustomerName());
        dto.setFoodItem(order.getFoodItem());
        dto.setQuantity(order.getQuantity());
        return dto;
    }

}
