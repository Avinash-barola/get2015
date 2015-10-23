package Session_2.Assignment_2;

public class SeniorMentor extends Approver{
	@Override
	public void ProcessRequest(int leave) {
		if(leave == 2) {
			System.out.println("Leave Approved By Senior Mentor:::");
		}
		else if(successor != null){
			successor.ProcessRequest(leave);
		}
	}
}
