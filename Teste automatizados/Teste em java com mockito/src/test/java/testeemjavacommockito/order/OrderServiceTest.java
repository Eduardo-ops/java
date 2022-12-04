package testeemjavacommockito.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import testeemjavacommockito.paymant.PaymentService;
import testeemjavacommockito.user.UserService;

public class OrderServiceTest {
	private UserService userService = Mockito.mock(UserService.class);
	private PaymentService paymentService = Mockito.mock(PaymentService.class);
	private OrderService orderService = new OrderService(userService, paymentService);

	@Test
	public void ShouldThrowsAnExceptionWhenUserIsMinor() {
		Order order = new Order(1L);

		IllegalStateException e = assertThrows(IllegalStateException.class, () -> orderService.create(order));

		assertEquals("O usuário não pode ser menor de idade", e.getMessage());
	}
}
