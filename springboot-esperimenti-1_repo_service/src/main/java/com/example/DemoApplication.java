package com.example;

import java.sql.Date;
import java.util.Arrays;

import com.example.controllers.MyController;
import com.example.domains.Task;
import com.example.domains.TaskBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class DemoApplication {
	// Riferimento al controller con la DEPENDECY INJECTION
	// static è necessaria solo perchè l'esempio è stato svolto nel main che è statico
	// @Autowired
	// static  MyController  myController;
	// public DemoApplication(MyController myController){
	// 	this.myController=myController;
	// }
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		// riferimento al controller attraverso l'Application Context
		// Spring usa il nome della classe e converte la prima lettera in minuscolo . https://www.baeldung.com/spring-bean-names 
		MyController myController= (MyController)ctx.getBean("myController") ;
		
		// Allocazione e riferimento al controller in modo tradizionale con l'operatore new
		// la annotation @Service associata alla classe MyController non è necessaria
		// il framework non si occupa del ciclo di vita dell'oggetto di tipo MyController--> è una classe "tradizionale"
		//		MyController myController= new MyController();
		

		System.out.println(myController.hello());
		// System.out.println("Let's inspect the beans provided by Spring Boot:");

		// String[] beanNames = ctx.getBeanDefinitionNames();
		// Arrays.sort(beanNames);
		// for (String beanName : beanNames) {
		// 	System.out.println(beanName);
		// }
		

		

	}
	@Autowired
	Task task;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return  args -> {
		//	Task task = new TaskBuilder(5).setDescription("Hello").setSummary("Test").setDueDate(Date.valueOf("2021-12-02")).build();
			task.setDescription("Hello");
			task.setSummary("Test");
			task.setDueDate(Date.valueOf("2021-12-02"));
			System.out.println(task);
		};
	}

}
