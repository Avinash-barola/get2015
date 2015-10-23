package Session_2.Assignment_3.Model;

import Session_2.Assignment_3.Cricket;

public class _20_20 extends Cricket{
	public static Cricket get_20_20Instance() {//method to returning object of 
		return new _20_20();
	}
	@Override//overriding over method of Cricket class
	protected void over() {
		System.out.println("This is 20-20 Match and number of overs are 20::");
	}

}
