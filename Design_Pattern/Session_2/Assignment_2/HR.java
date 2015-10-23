package Session_2.Assignment_2;

public class HR extends Approver{
	@Override
	public void ProcessRequest(int leave) {		
		if(leave > 2 && leave <=5) {
			System.out.println("Leave Approved By HR:::");
		}
		else if(successor==null) {
			System.out.println("Meetings Requires For Leave:::");
		}
	}
}
