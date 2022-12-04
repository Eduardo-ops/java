package br.com.domain.calculatorprogram.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.domain.calculatorprogram.Calculator;

class CalculatorTest {

	@Test
	public void SumShouldReturnZeroWhenNoValueWereGiven() {
		Calculator calculator = new Calculator();

		double sum = calculator.sum();

		Assertions.assertEquals(0, sum);
	}

	@Test
	public void SumShouldReturnTheSumOfGivenValues() {
		Calculator calculator = new Calculator();

		double sum = calculator.sum(5, 10);

		Assertions.assertEquals(15, sum);

	}

	@Test
	public void SquareRootShouldThrowsAnExceptionWhenTheGivenNumberWereLassThenZero() {
		Calculator calculator = new Calculator();

		IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
				() -> calculator.squareRoot(-1));

		Assertions.assertEquals("Não existe raiz quadrada real para números negativos", e.getMessage());
	}

	@Test
	public void SquareRootShouldReturnTheSquareRootOfGivenNumber() {
		Calculator calculator = new Calculator();

		double result = calculator.squareRoot(25);

		Assertions.assertEquals(5, result);
	}

	@Test
	public void isOddShouldRturnTrueWhenTheGivenNumberIsOdd() {
		Calculator calculator = new Calculator();

		boolean result = calculator.isOdd(5);

		Assertions.assertTrue(result);
	}

	@Test
	public void isOddShouldRturnFalseWhenTheGivenNumberIsEven() {
		Calculator calculator = new Calculator();

		boolean result = calculator.isOdd(20);

		Assertions.assertFalse(result);
	}
}
