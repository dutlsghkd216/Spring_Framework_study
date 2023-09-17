package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DependencyTests {
	
	@Autowired
	private Coding coding;
	
	@Autowired
	private Restaurant restaurant;
	
//	@Test
//	public void checkDependencyInjection() {
//		log.info("-------------------------------");
//		log.info(coding);
//		log.info("computer:"+coding.getComputer());
//		log.info("-------------------------------");
//	}
	
	@Test
	public void checkDependencyInjection() {
		log.info("-------------------------------");
		log.info(restaurant);
		log.info("chef:"+restaurant.getChef());
		log.info("-------------------------------");
	}
}
