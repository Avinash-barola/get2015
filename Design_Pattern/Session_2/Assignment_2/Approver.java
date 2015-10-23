/*
 * Abstract class Approver
 */
package Session_2.Assignment_2;

abstract class Approver {
	protected Approver successor;
    public void setSuccessor(Approver successor)
    {
      this.successor = successor;
    }
    public abstract void ProcessRequest(int leave);
}
