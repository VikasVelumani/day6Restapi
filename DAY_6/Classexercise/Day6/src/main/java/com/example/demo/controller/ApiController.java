package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService a;
	
	@PostMapping("/")
	public Child saveinfo(@RequestBody Child x)
	{
		return a.savedetails(x);
	}
    
	@GetMapping("{field}")
	public List<Child> show(@PathVariable String field)
	{
		return a.showdet(field);
	}
	
	@GetMapping("/{offset}/{pagesize}")
	public List<Child> showbypage(@PathVariable int offset,@PathVariable int pagesize)
	{
		return a.showdetailof(offset,pagesize);
	}
	@GetMapping("/{offset}/{pagesize}/{field}")
	public List<Child> showbyfield(@PathVariable int offset,@PathVariable int pagesize,String field)
	{
		return a.showdetailsort(offset,pagesize,field);
	}
}
