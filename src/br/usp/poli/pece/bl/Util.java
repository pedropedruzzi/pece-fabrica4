package br.usp.poli.pece.bl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Util {
	
	private static final String DATE = "dd/MM/yyyy"; 

	public static DateFormat getDateFormat() {
		return new SimpleDateFormat(DATE);
	}
	
	public static String fieldValue(Object value) {
		if (value == null) return "";
		else return value.toString();
	}
}
