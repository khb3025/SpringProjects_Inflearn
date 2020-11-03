package org.springframework.samples.petclinic.proxyExample;

public class Cash implements Payment{

	@Override
	public void pay(int amount) {
		System.out.println(amount + "결재");
	}

}
