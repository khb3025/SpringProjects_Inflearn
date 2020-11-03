package org.springframework.samples.petclinic.proxyExample;

import org.springframework.util.StopWatch;

public class CashPerforMeasuringProxy implements Payment{
	Cash cash = new Cash();

	@Override
	public void pay(int amount) {
		StopWatch sw = new StopWatch();
		sw.start();
		cash.pay(amount);
		sw.stop();
		System.out.println(sw.prettyPrint());
	}
}
