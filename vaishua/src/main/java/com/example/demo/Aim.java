package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Aim {
	@Value("${sname:vaishnavi}")
	private String name;
	@Value("simple")
	private String code;
	String vaish="priya" ;
	@RequestMapping("/vaishu")
	@ResponseBody
	public String priya() {
		return "hi" +"<br>"+ name +"<br>"+ code +vaish;
	}

}
