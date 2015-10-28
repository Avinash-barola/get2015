package com.metacube.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class FahrenheitToCelsius {
	@WebMethod
	//Method to convert Temperature
	public double convertIntoCelsius(double temp) {
		return ((temp - 32)*5)/9 ;
	}
}
