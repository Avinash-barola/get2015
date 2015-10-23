/*
 * Main class
 */
package Session_2.Assignment_2;

public class Main {
	public static void main(String args[]) {
		Approver mentor = new Mentor();//creating object of mentor class
		Approver seniorMentor = new SeniorMentor();//creating object of seniorMentor class
		Approver hr = new HR();//creating object of HR class
		//mentor.setSuccessor(seniorMentor);//setting successor of mentor
		seniorMentor.setSuccessor(hr);//setting successor of seniorMentor
		mentor.ProcessRequest(1);
	}
}
