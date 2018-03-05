package com.safewind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			 date = format.parse("2018-3-12");
		}catch (Exception e){
			e.printStackTrace();
		}
		Date dateNow = new Date();
		long time = (dateNow.getTime()-date.getTime())/(1000*3600*24);
		System.out.println(format.format(dateNow)+" "+format.format(date));
		System.out.println(time);*/
	}
}
