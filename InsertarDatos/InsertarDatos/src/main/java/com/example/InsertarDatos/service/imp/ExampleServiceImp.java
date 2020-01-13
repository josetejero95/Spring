package com.example.InsertarDatos.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.example.InsertarDatos.model.Persona;
import com.example.InsertarDatos.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImp implements ExampleService{
private static final Log LOG =
LogFactory.getLog(ExampleServiceImp.class);
@Override
public List<Persona> getListPeople() {
List<Persona> people= new ArrayList<>();
people.add(new Persona("Jesus",53));
people.add(new Persona("Guadalupe",50));
people.add(new Persona("Daniel",24));
people.add(new Persona("Fernando",17));
LOG.info("Hello from Service");
return people;
}
}
