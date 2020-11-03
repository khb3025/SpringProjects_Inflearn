package org.springframework.samples.petclinic.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("SampleServiceTestBean")
public class SampleServiceT {

	@Autowired
	@Qualifier("SampleRepositoryTestBean")
	private SampleRepositoryT sampleRepository;

	public int sampleValue() {
		return sampleRepository.sampleFunc();
	}

}
