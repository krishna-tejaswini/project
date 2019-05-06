package com.niit.sportsback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sportsback.config.DbConfig;

public class UserTest {

public static void main(String[] args) {
		AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(DbConfig.class);
		
}
}
