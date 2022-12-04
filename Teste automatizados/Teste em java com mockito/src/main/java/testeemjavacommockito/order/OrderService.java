package testeemjavacommockito.order;

import testeemjavacommockito.paymant.PaymentService;
import testeemjavacommockito.user.UserService;

public class OrderService {

	private UserService userService;
	private PaymentService paymentService;

	public OrderService(UserService userService, PaymentService paymentService) {
		this.userService = userService;
		this.paymentService = paymentService;
	}

	public void create(Order order) {
		boolean isUserMinor = userService.isUserMinor(order.getUserId());

		if (isUserMinor) {
			throw new IllegalStateException("O usu�rio n�o pode ser menor de idade");
		}

		paymentService.pay();
	}
}
