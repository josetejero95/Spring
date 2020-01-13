package com.example.InsertarDatos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.InsertarDatos.service.ExampleService;



@Controller// indicamos que es un bean
@RequestMapping("/example")//indicamos la ruta principal
public class ExampleController {

	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;//Tenemos que declarar la interfaz
	@GetMapping("/examplestringLista")
	public String exampleStringLista(Model model){
	model.addAttribute("people",exampleService.getListPeople());
	return ("insertarLista");
	}
	@GetMapping("/exampleMAVlista")//indicamos la ruta principal
	public ModelAndView exampleMAVlista(){
	ModelAndView mav=new ModelAndView("insertarLista");
	mav.addObject("people",exampleService.getListPeople());
	return mav;
	}
	
	
	
	
}
