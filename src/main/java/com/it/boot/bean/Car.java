package com.it.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ZuYingFang
 * @time 2021-09-11 0:14
 */

/**
 * 使用Java读取到properties文件中的内容，并且把它封装到JavaBean中，以供随时使用；
 * 1、使用@Component + @ConfigurationProperties————只有在容器中的组件，才会拥有springboot提供的强大功能，这里的prefix是指定前缀
 * 2、在配置类中添加注解@EnableConfigurationProperties(Car.class)————开启Car配置绑定功能，而且把这个Car组件自动注入到容器中
 */
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {

    private String brand;

    private Integer price;

    public Car() {
    }

    public Car(String brand, Integer price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
