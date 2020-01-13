package com.example.InsertarDatos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.InsertarDatos.model.Persona;

@Controller
@RequestMapping("/recibir")
public class RecibirDatosController {
// localhost:8080/recibir/devolverDatoGet?nombreGet=Jesus Alcocer
	private static final Log LOGGER=LogFactory.getLog(RecibirDatosController.class);
@GetMapping("/devolverDatoGet")
public ModelAndView devolverDatoGet(
@RequestParam(name = "nombreGet", required = false, defaultValue =
"NULL") String nombre) {
ModelAndView mav = new ModelAndView("devolverDatoGet");
mav.addObject("nombreGet_mav", nombre);
return mav;
}
// Con la segunda forma mandamos el parametro directamente
// localhost:8080/recibir/devolverDatoGetDirectamente/Jesus Alcocer
@GetMapping("/devolverDatoGetDirectamente/{nombreGet}")
public ModelAndView devolverDatoGetDirectamente(@PathVariable("nombreGet") String
nombre) {
ModelAndView mav = new ModelAndView("devolverDatoGet");
mav.addObject("nombreGet_mav", nombre);
return mav;
}

//ENVIO MEDIANTE POST//VAMOS A LLAMAR A UN FORMULARIO
//localhost:8080/recibir/formulario
@GetMapping("/formulario")
public String showForm(Model model){

	LOGGER.info("Info_Trace");
	LOGGER.warn("Warning Trace");
	LOGGER.error("Error Trace");
	LOGGER.debug("Debug Trace");
	model.addAttribute("person",new Persona());
	return "formulario";

}
//Con este metodo recibimos los parametros del formulario
//el parametro sera @PostMapping
@PostMapping("/addperson")
public ModelAndView addPerson(@ModelAttribute("person")Persona person){
ModelAndView mav=new ModelAndView("result");
LOGGER.info("Metodo : ' addperson ' --Parametros :'"+person+"'");
mav.addObject("person",person);
return mav;
}

//R E D I R E C C I O N E S
//PRIMERA FORMA (La comentamos para que no se pise con la otra)
/*@GetMapping("/")
public String redirect(){
return "redirect:/recibir/formulario";
}*/
//Segunda Forma utilizando un objeto REdirectView
@GetMapping("/")
public RedirectView redirect(){
return new RedirectView("/recibir/formulario");
}

}
