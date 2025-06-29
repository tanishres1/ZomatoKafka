package com.zomato.org;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrderRequest {
    private String orderId;
    private String customerName;
    private String foodItem;
    private int quantity;
}
