package org.springframework.samples.petclinic.proxyExample;

public class Store {
	private Payment payment;

	public Store(Payment payment) {
		this.payment = payment;
	}

	public void buySomething(int amount){
		payment.pay(amount);
	}
}
