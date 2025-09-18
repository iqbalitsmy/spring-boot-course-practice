package com.learn.aop.learn_spring_aop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.learn.aop.learn_spring_aop.aopexample.annotations.TrackTime;
import com.learn.aop.learn_spring_aop.aopexample.data.DataService1;

@Service
public class BusinessService1 {
	private DataService1 dataService1;

	public BusinessService1(DataService1 dataService1) {
		super();
		this.dataService1 = dataService1;
	}
	@TrackTime
	public int calculateMax() {
		int[] data = dataService1.retriveData();
//		throw new RuntimeException("Something is wrong");
		return Arrays.stream(data).max().orElse(0);
	} 

}
