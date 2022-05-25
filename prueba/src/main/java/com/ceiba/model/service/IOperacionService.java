package com.ceiba.model.service;

import java.util.List;

public interface IOperacionService {
	
	public List<Double> calcularCuadratica(double a, double b, double c);
	
	public List<Integer> calcularFibonacci(int tamano);
}
