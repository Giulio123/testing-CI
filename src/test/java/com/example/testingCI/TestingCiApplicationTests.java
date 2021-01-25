package com.example.testingCI;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class TestingCiApplicationTests {

	 private TestingCI testingCI = new TestingCI();

     @Test
     public void testSum() {
          assertEquals(5, testingCI.sum(2, 3));
     }

}
