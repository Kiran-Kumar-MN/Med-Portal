package com.xworkz.medi.util;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomPasswordGenerator {
public RandomPasswordGenerator() {
System.out.println("Created "+this.getClass().getSimpleName());
}

String capLetters="QWERTYUIOPASDFGHJKLZXCVBNM";
String smLetters="qwertyuiopasdfghjklzxcvbnm";
String specialChar="!@#$%^&*";
String numbers = "1234567890";

public String generateRandomPassword() {
	StringBuilder builder = new StringBuilder();
	builder.append(RandomStringUtils.random(2, capLetters)).append(RandomStringUtils.random(2, smLetters)).append(RandomStringUtils.random(2, specialChar)).append(RandomStringUtils.random(2, numbers));
	
	return new String(builder);
}
}
