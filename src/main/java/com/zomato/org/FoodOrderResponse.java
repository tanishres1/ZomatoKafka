package com.zomato.org;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodOrderResponse {

    private String message;
    private String orderId;
}
