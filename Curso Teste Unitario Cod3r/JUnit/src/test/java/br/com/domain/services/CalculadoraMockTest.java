package br.com.domain.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import junit.framework.Assert;

public class CalculadoraMockTest {

	@Mock
	private CalculadoraService calcMock;

	@Spy
	private CalculadoraService calcSpy;

	@Mock
	private EmailService email;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void teste() {
		CalculadoraService calc = Mockito.mock(CalculadoraService.class);

		ArgumentCaptor<Integer> argCapt = ArgumentCaptor.forClass(Integer.class);
		Mockito.when(calc.somar(argCapt.capture(), argCapt.capture())).thenReturn(5);
		
		Assert.assertEquals(5, calc.somar(1, 100000));
		
		System.out.println(argCapt.getAllValues());
	}
}

