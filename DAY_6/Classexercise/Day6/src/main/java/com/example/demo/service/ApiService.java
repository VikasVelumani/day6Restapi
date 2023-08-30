package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepo;

@Service
public class ApiService {
	  @Autowired
      ChildRepo c;
      
      public Child savedetails(Child m)
      {
    	  return c.save(m);
      }
      public List<Child> showdet(String h)
      {
    	  return c.findAll(Sort.by(Sort.DEFAULT_DIRECTION,h));
      }
      public List<Child> showdetailof(int p,int q)
      {
    	  Page<Child> z = c.findAll(PageRequest.of(p, q));
    	  return z.getContent();
      }
      public List<Child> showdetailsort(int d,int e,String f)
      {
    	  Page<Child> i = c.findAll(PageRequest.of(d, e,Sort.by(Direction.ASC,f)));
    	  return i.getContent();
      }
}
