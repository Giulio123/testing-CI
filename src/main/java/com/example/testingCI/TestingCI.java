package com.example.testingCI;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/** TestingCI logic */
@Service

public class TestingCI {
	
	@Cacheable("sum")
	public int sum(int a, int b) {
		return a + b;
	}

}
