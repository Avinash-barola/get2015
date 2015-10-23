/*
 * Abstract class Cricket
 */
package Session_2.Assignment_3;

public abstract class Cricket {
	public void play() {
		start();
		over();
		end();
	}
	 protected void start() {
		 System.out.println("Match has started:::");
	}
	 protected void end() {
		 System.out.println("Match has end:::");
	}
	 abstract protected void over();//abstract method used by child classes
}
