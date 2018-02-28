package com.safewind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lxy_x on 2018/2/27.
 */
@RestController
public class HelloController {

    @Value(value = "${B}")
    private String C;

    @Autowired
    private Book book;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String say() {
        return C+book.getName();
    }
}
