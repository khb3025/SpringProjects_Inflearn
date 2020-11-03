package org.springframework.samples.petclinic.sample;

import org.springframework.stereotype.Repository;

@Repository("SampleRepositoryTestBean")
public class SampleRepositoryT {

	private int sampleValue;

	public int sampleFunc() {
		this.sampleValue = 1;
		return sampleValue;

	}

}
