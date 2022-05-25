package com.ceiba.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OperacionServiceImp implements IOperacionService {

	@Override
	public List<Double> calcularCuadratica(double a, double b, double c) {
		// TODO Auto-generated method stub

		double x1, x2, potencia, raiz = 0;

		potencia = Math.pow(b, 2) - (4 * a * c);

		x1 = (-b - Math.sqrt(potencia) / 2 * a);
		x2 = (-b + Math.sqrt(potencia) / 2 * a);

		List<Double> respuestaList = new ArrayList<>();
		respuestaList.add(x1);
		respuestaList.add(x2);

		return respuestaList;
	}

	@Override
	public List<Integer> calcularFibonacci(int tamano) {

		List<Integer> fibonacciList = new ArrayList<>();
		
		for (int i = 0; i < tamano; i++) {
			fibonacciList.add(fibonacci(i));
	    }
		
		return fibonacciList;
	}

	int fibonacci(int n) {
		if (n > 1) {
			return fibonacci(n - 1) + fibonacci(n - 2); // función recursiva
		} else if (n == 1) { // caso base
			return 1;
		} else if (n == 0) { // caso base
			return 0;
		} else { // error
			System.out.println("Debes ingresar un tamaño mayor o igual a 1");
			return -1;
		}
	}

}
