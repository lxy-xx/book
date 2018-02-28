package com.safewind;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by lxy_x on 2018/2/27.
 */
@Component
@ConfigurationProperties(prefix = "book")
public class Book {

    private String name;
    private float cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }


}
