package testeemjavacommockito.order;

import testeemjavacommockito.user.User;

public class Order {

	private Long userId;

	public Order(Long id) {
		this.userId = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
