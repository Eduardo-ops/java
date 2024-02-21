

import org.junit.Test;

import br.com.domain.entities.Usuario;
import junit.framework.Assert;

public class AseertTest {

	@Test
	public void methodTest() {

		Assert.assertTrue(true);
		Assert.assertFalse(false);

		Assert.assertEquals(1, 1);
		Assert.assertEquals("Erro ao comparar os dois inteiros", 1, 1);
		Assert.assertEquals(0.69789, 0.697, 0.001);
		Assert.assertEquals(Math.PI, 3.14, 0.01);

		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());

		Assert.assertEquals("Show", "Show");
		// Assert.assertNotEquals("Show", "Cachoeira");
		Assert.assertTrue("Show".equalsIgnoreCase("ShoW"));
		Assert.assertTrue("Show".startsWith("Sh"));

		Usuario usuario1 = new Usuario("Jose");
		Usuario usuario2 = new Usuario("Jose");
		Usuario usuario3 = usuario2;
		Usuario usuario4 = new Usuario("Meire");

		Assert.assertEquals(usuario1, usuario2);
		Assert.assertSame(usuario2, usuario3);
		Assert.assertNotSame(usuario1, usuario3);
		Assert.assertNotNull(usuario4);
	}
}
