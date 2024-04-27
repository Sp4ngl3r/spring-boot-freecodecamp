package com.spangler.springfreecodecamp.controller;

import com.spangler.springfreecodecamp.model.Order;
import com.spangler.springfreecodecamp.model.OrderRecord;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class InitialController {

    @GetMapping("hello-world")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello() {
        return "Hello World";
    }

    @PostMapping("accept-post")
    public String acceptPostData(
            @RequestBody String message
    ) {
        return "Post accepted with the message of " + message;
    }

    @PostMapping("order-product")
    @ResponseStatus(HttpStatus.CREATED)
    public String orderProduct(
            @RequestBody Order order
    ) {
        return "Customer " + order.getCustomerName() + " has ordered " + order.getQuantity() +
                " products of " + order.getProductName();
    }

    @PostMapping("order-record-product")
    public String orderRecordProduct(
            @RequestBody OrderRecord orderRecord
    ) {
        return "Order Record = " + orderRecord.toString();
    }

    @GetMapping("order/{order-id}")
    public String displayOrderId(
            @PathVariable("order-id") String orderId
    ) {
        return "Order has been placed for the id of " + orderId;
    }

    @GetMapping("user")
    public String displayUsername(
            @RequestParam("first-name") String firstName,
            @RequestParam("last-name") String lastName
    ) {
        return "User Name is " + firstName + " " + lastName;
    }
}
