package com.ceiba.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.model.entity.ResponseJson;
import com.ceiba.model.service.IOperacionService;

@RestController
@RequestMapping(value = "operacion")
public class operacionController {

	@Autowired
	private IOperacionService operationService;

	@GetMapping(value = "hola")
	public String getHola() {
		return "hola";
	}

	@PostMapping(path = "/calcularCuadratica", produces = "application/json")
	public ResponseJson getCuadratica(@QueryParam("a") Double a, @QueryParam("b") Double b,
			@QueryParam("c") Double c) {

		StringBuilder err = new StringBuilder();
		
		String msg = null;
		
		List<Double> respuestaList =  operationService.calcularCuadratica(a, b, c);
		
		if (respuestaList != null) {
			msg = "VALOR X1 + : "+respuestaList.get(0).doubleValue() + "  "
					+ " VALOR X2 - : "+respuestaList.get(1).doubleValue();
		} else {
			msg = "Error al calcular operación. Verificar datos ";
			err.append(msg);
		}
		ResponseJson response;
		if (!err.toString().isEmpty()) {
			response = new ResponseJson(false, err.toString());
		} else {
			response = new ResponseJson(true, "OK");
			response.setData(msg);
		}
		return response;
	}
	
	@PostMapping(path = "/calcularFibonacci", produces = "application/json")
	public ResponseJson calcularFibonacci(@QueryParam("tamano") Integer tamano) {

		StringBuilder err = new StringBuilder();
		
		String msg = null;
		
		List<Integer> respuestaList =  operationService.calcularFibonacci(tamano);
		
		if (respuestaList != null) {
			msg = "Serie : "+respuestaList.toString();
		} else {
			msg = "Error al calcular serie. Verificar datos ";
			err.append(msg);
		}
		ResponseJson response;
		if (!err.toString().isEmpty()) {
			response = new ResponseJson(false, err.toString());
		} else {
			response = new ResponseJson(true, "OK");
			response.setData(msg);
		}
		return response;
	}

}
