package geektime.spring.complexcontrollerdemo.controller;

import geektime.spring.complexcontrollerdemo.model.Coffee;
import geektime.spring.complexcontrollerdemo.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-05 15:21
 */
@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping(path = "/", params = "!name")
    @ResponseBody
    public List<Coffee> getAll() {
        return coffeeService.getAllCoffee();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Coffee getById(@PathVariable Long id) {
        Coffee coffee = coffeeService.getCoffee(id);
        return coffee;
    }

    @GetMapping(path = "/", name = "name")
    @ResponseBody
    public Coffee getByNanme(@RequestParam String name) {
        Coffee coffee = coffeeService.getCoffee(name);
        return coffee;
    }
}
