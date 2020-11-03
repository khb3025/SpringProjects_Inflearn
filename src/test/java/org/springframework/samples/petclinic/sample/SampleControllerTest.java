
package org.springframework.samples.petclinic.sample;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerController;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.proxyExample.CashPerforMeasuringProxy;
import org.springframework.samples.petclinic.proxyExample.Store;
import org.springframework.samples.petclinic.visit.VisitRepository;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class SampleControllerTest {



	@Autowired
	SampleServiceT sampleServiceT;

	@Autowired
	ApplicationContext applicationContext;


	@Test
	public void aopProxyPatternTest(){
		Store store = new Store(new CashPerforMeasuringProxy());
		store.buySomething(1000);
	}


	@Test
	public void assertEqualsTest() {
		assertEquals(sampleServiceT.sampleValue(), 1);
	}

	@Test
	public void assertNotEqualsTest() {
		assertNotEquals(sampleServiceT.sampleValue(), 1);
	}

	@Test
	public void groupAssertTest() {
		assertAll(() -> assertEquals(1, sampleServiceT.sampleValue()),
				() -> assertNotEquals(2, sampleServiceT.sampleValue()));

	}

	@Test
	public void getBean() {
		OwnerController bean = applicationContext.getBean(OwnerController.class);
		assertNotNull(bean);

	}

	@Test
	void dependentAssertions() {
		assertAll("properties", () -> {
			String firstName = "Joe";
			assertNotNull(firstName);

			// Executed only if the previous assertion is valid.
			assertAll("first name", () -> assertTrue(firstName.startsWith("J")),
					() -> assertTrue(firstName.endsWith("e")));
		}, () -> {
			// Grouped assertion, so processed independently
			// of results of first name assertions.
			String lastName = "David";
			assertNotNull(lastName);

			// Executed only if the previous assertion is valid.
			assertAll("last name", () -> assertTrue(lastName.startsWith("D")),
					() -> assertTrue(lastName.endsWith("e")));
		});
	}

	@Test
	void exceptionTesting() {
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			int i = 1 / 0;
		});
		assertEquals("/ by zero", exception.getMessage());
	}

	@Test
	void timeoutNotExceeded() {
		// The following assertion succeeds.

		assertTimeout(Duration.ofSeconds(5), () -> {
			Thread.sleep(10000);
		});
	}

	@Test
	void timeoutNotExceeded2() {
		// The following assertion succeeds.

		assertTimeout(Duration.ofSeconds(5), () -> {
			Thread.sleep(2000);
		});
	}

	@Test
	void timeoutNotExceededWithResult() {
		// The following assertion succeeds, and returns the supplied object.
		String actualResult = assertTimeout(Duration.ofMinutes(2), () -> {
			return "a result";
		});
		assertEquals("a result", actualResult);
	}

	@Test
	void timeoutExceededWithPreemptiveTermination() {
		// The following assertion fails with an error message similar to:
		// execution timed out after 10 ms
		assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
			// Simulate task that takes more than 10 ms.
			Thread.sleep(2000);
		});
	}

	@Test
	void timeoutExceededWithPreemptiveTermination2() {
		// The following assertion fails with an error message similar to:
		// execution timed out after 10 ms
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			// Simulate task that takes more than 10 ms.
			Thread.sleep(500);
		});
	}

	@Test
	void assertNullTest() {
		// The following assertion fails with an error message similar to:
		// execution timed out after 10 ms
		String str = null;
		assertNull(str);
	}

	@Test
	void assertEqualsNullTest() {
		// The following assertion fails with an error message similar to:
		// execution timed out after 10 ms
		String str = "aaa";
		assertEquals(null, str);
	}

	@Test
	void assertNotNullTest() {
		// The following assertion fails with an error message similar to:
		// execution timed out after 10 ms
		String str = null;
		assertNotNull(str);
	}

	@Test
	void assertWithHamcrestMatcher() {
		assertThat(4 - 1, is(equalTo(3)));
	}

}
