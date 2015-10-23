package Session_2.Assignment_2;

public class Mentor extends Approver {

	@Override
	public void ProcessRequest(int leave) {
		if(leave == 1) {
			System.out.println("Leave Approved By Mentor:::");
		}
		else if(successor != null){
			successor.ProcessRequest(leave);
		}
	}
}
