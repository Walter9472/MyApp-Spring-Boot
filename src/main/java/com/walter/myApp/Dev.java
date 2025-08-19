package com.walter.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class Dev {
    // Connecting to Class Laptop
    @Autowired// Field  Injection
    @Qualifier("laptop")
    private Computer comp;

//    public Dev(Laptop laptop){
//        this.laptop = laptop;
//    }
//    @Autowired
//    public void setLaptop(Laptop laptop){
//        this.laptop = laptop;
//    }
    public void build(){

        comp.compile();

        System.out.println("Working on Awesome Projekt");
    }
}
