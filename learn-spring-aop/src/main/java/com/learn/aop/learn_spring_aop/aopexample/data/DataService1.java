package com.learn.aop.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
	public int[] retriveData() {
		return new int[] { 11, 12, 33, 44, 55 };
	}
}
