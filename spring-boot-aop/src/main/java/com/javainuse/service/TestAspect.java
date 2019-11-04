
package com.javainuse.service;

import org.springframework.stereotype.Component;

@Component
public class TestAspect {

	public void sayHi(String str) {
		System.out.println("saying hi");

	}

	public void sayBye() {
		System.out.println("saying sayBye");
	}

}
