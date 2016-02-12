import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.sforce.soap.enterprise.LoginResult;
import com.sforce.soap.enterprise.SessionHeader;
import com.sforce.soap.enterprise.SforceServiceLocator;
import com.sforce.soap.enterprise.SoapBindingStub;
import com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServiceBindingStub;
import com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServiceServiceLocator;


public class MyWebService {
public static void main(String[] args){
 System.out.println("start of program");
 try 
     {  //Get a stub for calling enterprise WSDL's login method in order to get SessionID
      SoapBindingStub bind= (SoapBindingStub)new SforceServiceLocator().getSoap();
      LoginResult lr=bind.login("avinash.barola@metacube.com", "9782700490afo3GKfhFClkBKYoHAhtCTiQbs");

      //Create a sessionHeader object and set its sessioId property to sessionId 
      //received in loginResult object                        
      SessionHeader sh=new SessionHeader();
      sh.setSessionId(lr.getSessionId());

      //Create a service locator object for your custom web service
      MyFirstWebServiceServiceLocator locator=new MyFirstWebServiceServiceLocator();

      //Get URL for your custom web service
      URL url=new URL(locator.getMyFirstWebServiceAddress());

      //Create a stub for your custom web service with URL for your service and locator as parameters
      MyFirstWebServiceBindingStub stub=new MyFirstWebServiceBindingStub(url, locator);

      //Set the header property of stub with name "SessionHeader" and value as sh-sessionHeader 
      //object created above 
      stub.setHeader(locator.getMyFirstWebServiceAddress(), "SessionHeader", sh);

      //now make call to custom service-in our case its "Hello(String name)"
      System.out.println(stub.queryForContact("Select Name From Contact"));
      String inputStr = "11-11-2012";
      DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
      Date inputDate = dateFormat.parse(inputStr);
      System.out.println(inputDate);
System.out.println(stub.createNewStudent("WebServiceStudent1", "a0D28000002FNYK", "Female",inputDate));
     }

  catch (Exception e) 
  {e.printStackTrace(); }  
}}