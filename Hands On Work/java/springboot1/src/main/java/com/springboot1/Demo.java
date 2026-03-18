package com.springboot1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller + @ResponseBody
public class Demo {
	@RequestMapping("/")
	public String show() {
		return "Hi There Hello";
	}
}
