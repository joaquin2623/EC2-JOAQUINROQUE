package com.example.HospitalIdat.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.HospitalIdat.dto.RecepcionistaDTORequest;
import com.example.HospitalIdat.dto.RecepcionistaDTOResponse;
import com.example.HospitalIdat.servicios.RecepcionistaService;


@Controller
@RequestMapping( path = "/Recepcionista/v1")
public class RecepcionistaController {
	@Autowired
	private RecepcionistaService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<RecepcionistaDTOResponse>>  listar() {
		
		return new ResponseEntity<List<RecepcionistaDTOResponse>>(service.listarRecepcionista(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody RecepcionistaDTORequest Recepcionista) {
		service.guardarRecepcionista(Recepcionista);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		RecepcionistaDTOResponse p =service.obtenerRecepcionistaId(id);
		if(p != null) {
			service.eliminarRecepcionista(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody RecepcionistaDTORequest productos) {
		RecepcionistaDTOResponse p =service.obtenerRecepcionistaId(productos.getId());
		if(p != null) {
			service.actualizarRecepcionista(productos);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<RecepcionistaDTOResponse> obtenerId(@PathVariable Integer id) {
		RecepcionistaDTOResponse p =service.obtenerRecepcionistaId(id);
		if(p != null) {
			return  new ResponseEntity<RecepcionistaDTOResponse>(service.obtenerRecepcionistaId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<RecepcionistaDTOResponse>(HttpStatus.NOT_FOUND);
	}
}

	
	


