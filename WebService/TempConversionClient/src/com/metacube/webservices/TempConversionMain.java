/*
 * Main class to call web service
 */
package com.metacube.webservices;
public class TempConversionMain {
	public static void main(String args[]){
		FahrenheitToCelsiusServiceLocator fahrenheitToCelsiusServiceLocator=new FahrenheitToCelsiusServiceLocator();//to get locater
		fahrenheitToCelsiusServiceLocator.setFahrenheitToCelsiusEndpointAddress("http://localhost:8080/TempConversion/services/FahrenheitToCelsius");//Setting address
		
		try {
			FahrenheitToCelsius fahrenheitToCelsius= fahrenheitToCelsiusServiceLocator.getFahrenheitToCelsius();
			System.out.println(fahrenheitToCelsius.convertIntoCelsius(33));//Calling Web service method
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
