package br.edu.ifsuldeminas.mch.sd.rmi.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;

public class Calculator implements Operations {
	
	private List<String> lastOperations = new ArrayList<String>();
	
	public Number sum(Number x, Number y) {
		Number result = x.doubleValue() + y.doubleValue();
		log(x, "+", y, result);
		return result;
	}
	
	public Number sub(Number x, Number y) {
		Number result = x.doubleValue() - y.doubleValue();
		log(x, "-", y, result);
		return result;
	}
	
	public Number mul(Number x, Number y) {
		Number result = x.doubleValue() * y.doubleValue();
		log(x, "*", y, result);
		return result;
	}
	
	public Number div(Number x, Number y) {
		Number result = Double.NaN;
		if (y.doubleValue() != 0)
			result = x.doubleValue() / y.doubleValue();
		log(x, "/", y, result);
		return result;
	}
	
	public Number raiz(Number x, Number y) {
		Number result = Double.NaN;
		result = Math. pow(x.doubleValue(),(1/y.doubleValue()));
		log(x, "Raiz", y, result);
		return result;
	}
	
	public Number pot(Number x, Number y) {
		Number result = Double.NaN;
		result = Math. pow(x.doubleValue(), y.doubleValue());
		log(x, "^", y, result);
		return result;
	}
	
	public Number por(Number x, Number y) {
		Number result = Double.NaN;
		result = (x.doubleValue() / 100) * y.doubleValue();
		log(x, "Por", y, result);
		return result;
	}
	
	public Number mod(Number x, Number y) {
		Number result = Double.NaN;
		result = x.doubleValue() % y.doubleValue();
		log(x, "%", y, result);
		return result;
	}
	
	public Number fat(Number x) {
		int result = 1;
	      for( int i = 1; i <= x.doubleValue(); i++ ) {
	    	  result *= i;
	      }
	     log("!", x, result);
		return result;
	}
	
	public String dec(Number x) {
		String result = Integer.toBinaryString((int) x.doubleValue());
		log(x, result);
		return result;
	}
	
	public String hex(Number x) {
		String result = Integer.toHexString((int) x.doubleValue());
		log(x, result);
		return result;
	}
	
	public List<String> lastOperations(int howMany) {
		if (lastOperations.size() < howMany)
			return lastOperations();
		return new ArrayList<String>(lastOperations.subList(
				lastOperations.size() - howMany, lastOperations.size()));
	}
	
	public List<String> lastOperations() {
		return lastOperations;
	}
	
	private void log(Number operatorOne, String operation, Number operatorTwo,
			Number result) {

		String formattedOperation = String.format("%s %s %s = %s",
				operatorOne.toString(), operation, operatorTwo.toString(),
				result.toString());
		lastOperations.add(formattedOperation);
		System.out.printf("%s at %s\n", formattedOperation, new Date());
	}
	
	private void log(String operation, Number operatorOne,
			Number result) {

		String formattedOperation = String.format("%s %s = %s",
				operation, operatorOne.toString(),
				result.toString());
		lastOperations.add(formattedOperation);
		System.out.printf("%s at %s\n", formattedOperation, new Date());
	}
	
	private void log( Number operatorOne, String result) {

		String formattedOperation = String.format("%s = %s",
				operatorOne.toString(),
				result.toString());
		lastOperations.add(formattedOperation);
		System.out.printf("%s at %s\n", formattedOperation, new Date());
	}
}