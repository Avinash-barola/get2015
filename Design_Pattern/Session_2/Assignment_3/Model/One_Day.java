package Session_2.Assignment_3.Model;

import Session_2.Assignment_3.Cricket;

public class One_Day extends Cricket{
	public static Cricket getOneDayInstance() {//returning object of One Day class
		return new One_Day();
	}
	@Override
	protected void over() {
		System.out.println("This is One Day Match and number of overs are 50::");
	}

}
