package com.gft.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Generated;
import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_DOWN;

@SpringBootApplication
@RestController
public class DemoProjectApplication {

	@Generated(value="org.springframework.boot")
	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
	}

	@GetMapping("/")
	public String root() {
		return "Hola mundo";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	/*
	@GetMapping("add")
	public int canAdd (@RequestParam int a, @RequestParam int b) {
		return a + b;
	}
	*/

	@GetMapping("/add")
	public Object add(
			@RequestParam(value="a", defaultValue = "0") Float a,
			@RequestParam(value="b", defaultValue = "0") Float b
	) {
		Float sum = a+b;
		Float decimals = sum - sum.intValue();
		if(decimals!=0) {
			return sum;
		}
		return Integer.valueOf(sum.intValue());
	}

	@GetMapping("/multiply")
	public Object multiply(
			@RequestParam(value="a", defaultValue = "0") Float a,
			@RequestParam(value="b", defaultValue = "0") Float b
	) {
		Float product = a * b;
		Float decimals = product - product.intValue();
		if(decimals!=0) {
			return product;
		}
		return Integer.valueOf(product.intValue());
	}

	@GetMapping("/subtract")
	public Object subtract(
			@RequestParam(value="a", defaultValue = "0") Float a,
			@RequestParam(value="b", defaultValue = "0") Float b
	) {
		Float sub = a - b;
		Float decimals = sub - sub.intValue();
		if(decimals!=0) {
			return sub;
		}
		return Integer.valueOf(sub.intValue());
	}

	@GetMapping("/divide")
	public BigDecimal divide(
			@RequestParam(value="a", defaultValue = "0") BigDecimal a,
			@RequestParam(value="b", defaultValue = "0") BigDecimal b
	) {
		return a.divide(b, 2, HALF_DOWN);
	}
// Falta a??adir la sqrt
}
