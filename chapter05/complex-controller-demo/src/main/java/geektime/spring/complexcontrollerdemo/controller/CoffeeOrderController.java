package geektime.spring.complexcontrollerdemo.controller;

import geektime.spring.complexcontrollerdemo.controller.request.NewOrderRequest;
import geektime.spring.complexcontrollerdemo.model.Coffee;
import geektime.spring.complexcontrollerdemo.model.CoffeeOrder;
import geektime.spring.complexcontrollerdemo.service.CoffeeOrderService;
import geektime.spring.complexcontrollerdemo.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-05 15:39
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class CoffeeOrderController {

    @Autowired
    private CoffeeOrderService orderService;
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/{id}")
    public CoffeeOrder getOrder(@PathVariable("id") Long id) {
        return orderService.get(id);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrder create(@RequestBody NewOrderRequest newOrder) {
        log.info("receive new order: {}", newOrder);
        Coffee[] coffees = coffeeService.getCoffeeByName(newOrder.getItems())
                .toArray(new Coffee[] {});
        return orderService.createOrder(newOrder.getCustomer(), coffees);
    }
}
