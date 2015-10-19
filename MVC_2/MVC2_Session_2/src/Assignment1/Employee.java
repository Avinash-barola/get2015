
package Assignment1;
public class Employee{
	@Enhancement(id = 1, synopsis = "Avinash")
	public static void employeeDetail(int id,String synopsis,String engineer,String date){
		System.out.println("WelCome->"+id+"->"+synopsis+"->"+engineer+"->"+date);
	}
	@Enhancement(id = 1, synopsis = "Avinash", engineer="software", date="10/14/2015")
	public static void employeeDetails(int id,String synopsis,String engineer,String date){
		System.out.println("WelCome->"+id+"->"+synopsis+"->"+engineer+"->"+date);
	}
	public static void employeeDetail(){
		System.out.println("Sorry No Annotation");
	}
}

