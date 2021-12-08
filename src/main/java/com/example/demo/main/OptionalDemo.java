package com.example.demo.main;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		String name = null;
		//name = "not null";
	    Optional<String> optName = Optional.ofNullable(name);
	    System.out.println(optName.orElse("Name is null."));
	}

}
