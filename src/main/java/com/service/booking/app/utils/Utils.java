package com.service.booking.app.utils;

public class Utils {

	public Utils() {
		
	}
	
	public static String keepNumbersOnly(String inputString) {
        StringBuilder result = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
