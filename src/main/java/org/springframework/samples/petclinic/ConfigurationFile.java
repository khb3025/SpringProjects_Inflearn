
package org.springframework.samples.petclinic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sample.SampleRepositoryT;
import org.springframework.samples.petclinic.sample.SampleServiceT;
import org.springframework.util.StopWatch;

@Configuration
public class ConfigurationFile {

	@Bean
	public SampleRepositoryT return_sampleRepository() {
		return new SampleRepositoryT();

	};


	/*
	 * @Bean("SampleServiceT2") public SampleServiceT return_sampleController(){ return
	 * new SampleServiceT();
	 *
	 * };
	 */

}
