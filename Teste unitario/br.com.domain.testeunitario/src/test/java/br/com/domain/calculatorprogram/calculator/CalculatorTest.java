package br.com.domain.calculatorprogram.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.domain.calculatorprogram.Calculator;

class CalculatorTest {

	@Test
	public void teste1() {
		Calculator cl = new Calculator();

		double sum = cl.sum();

		Assertions.assertEquals(0, sum);
	}

	@Test
	public void teste2() {
		Calculator cl = new Calculator();

		double sum = cl.sum(15, 10);

		Assertions.assertEquals(10, sum);

	}

}
