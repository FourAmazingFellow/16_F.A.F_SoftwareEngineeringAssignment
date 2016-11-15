package org.FAF.helloWorld;

import org.junit.Assert;
import org.junit.Test;


public class HelloWorldTest {
	
	@Test
	public void testSayHello() {
		HelloWorld helloWorld = new HelloWorld();
		Assert.assertEquals("HelloWorld.sayHello() has Error", "HelloWorld", helloWorld.sayHello());
	}
}
