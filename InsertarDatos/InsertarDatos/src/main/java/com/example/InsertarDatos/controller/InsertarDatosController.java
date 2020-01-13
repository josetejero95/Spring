package com.example.InsertarDatos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.InsertarDatos.model.Persona;

@Controller
@RequestMapping("/insertar")
public class InsertarDatosController {
//Esta forma la utilizaremos cuando queremos insertar dato simple
@GetMapping("/insertardatos")
public String insertar(Model model) {
model.addAttribute("nombre", "Jesús");
return "/insertardatos";
}
//Esta forma la utilizaremos cuando queremos insertar datos simple 2ª forma
@GetMapping("/insertardatosMAV")
public ModelAndView insertarMAV() {
ModelAndView model=new ModelAndView("insertardatos");
model.addObject("nombre", "Alcocer");
return model;
}
//INSERTAR MODELO
@GetMapping("/insertarModelo")
public String insertarModelo(Model model) {
model.addAttribute("persona", new Persona("Felipe", 46));
return "/insertarmodelo";
}
@GetMapping("/insertarModeloMAV")
public ModelAndView insertarModeloMAV() {
ModelAndView model=new ModelAndView("insertarmodelo");
model.addObject("persona", new Persona("María", 26));
return model;
}

private List<Persona> getAlumnos(){
List<Persona> alumnos=new ArrayList<Persona>();
alumnos.add(new Persona("Carlos",23));
alumnos.add(new Persona("Maria",24));
alumnos.add(new Persona("Luis",18));
alumnos.add(new Persona("Fatima",25));
return alumnos;
}
@GetMapping("/insertarLista")
public String insertarLista(Model model) {
model.addAttribute("alumnos",getAlumnos());
return "/insertarLista";
}
@GetMapping("/insertarListaMAV")
public ModelAndView insertarListaMAV() {
ModelAndView model=new ModelAndView("insertarLista");
model.addObject("alumnos", getAlumnos());
return model;
}


}
