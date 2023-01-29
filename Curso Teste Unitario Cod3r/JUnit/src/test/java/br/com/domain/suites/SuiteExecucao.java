package br.com.domain.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.domain.services.CalculadoraTest;
import br.com.domain.services.CalculoValorLocacaoTest;
import br.com.domain.services.LocacaoServiceTest;
import br.com.domain.services.OrdemTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	CalculadoraTest.class, 
	CalculoValorLocacaoTest.class, 
	LocacaoServiceTest.class, 
	OrdemTest.class
})
public class SuiteExecucao {
	// Comentários apenas para declaração obrigatória da classe.

	/*
	 * Before e After são muito indicado em um suite de execução quando se tem a
	 * necessidade de realização uma configuração inicial, antes da execução dos
	 * métodos, um exemplo, realizar conexão com banco de dados.
	 */
	@BeforeClass
	public static void beforeSetup() {
		System.out.println("Before class");
	}

	@AfterClass
	public static void afterSetup() {
		System.out.println("After class");
	}
}
