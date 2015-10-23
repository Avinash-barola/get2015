package Session_2.Assignment_3.Model;

import Session_2.Assignment_3.Cricket;

public class Test extends Cricket{
	public static Cricket getTestInstance() {//returning object of test class
		return new Test();
	}
	@Override
	protected void over() {
		System.out.println("This is Test Match::");
	}

}
