package com.sforce.soap.schemas._class.MyFirstWebService;

public class MyFirstWebServicePortTypeProxy implements com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServicePortType {
  private String _endpoint = null;
  private com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServicePortType myFirstWebServicePortType = null;
  
  public MyFirstWebServicePortTypeProxy() {
    _initMyFirstWebServicePortTypeProxy();
  }
  
  public MyFirstWebServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initMyFirstWebServicePortTypeProxy();
  }
  
  private void _initMyFirstWebServicePortTypeProxy() {
    try {
      myFirstWebServicePortType = (new com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServiceServiceLocator()).getMyFirstWebService();
      if (myFirstWebServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)myFirstWebServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)myFirstWebServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (myFirstWebServicePortType != null)
      ((javax.xml.rpc.Stub)myFirstWebServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sforce.soap.schemas._class.MyFirstWebService.MyFirstWebServicePortType getMyFirstWebServicePortType() {
    if (myFirstWebServicePortType == null)
      _initMyFirstWebServicePortTypeProxy();
    return myFirstWebServicePortType;
  }
  
  public java.lang.String createNewStudent(java.lang.String name, java.lang.String classId, java.lang.String sex, java.util.Date dob) throws java.rmi.RemoteException{
    if (myFirstWebServicePortType == null)
      _initMyFirstWebServicePortTypeProxy();
    return myFirstWebServicePortType.createNewStudent(name, classId, sex, dob);
  }
  
  public java.lang.String queryForContact(java.lang.String query) throws java.rmi.RemoteException{
    if (myFirstWebServicePortType == null)
      _initMyFirstWebServicePortTypeProxy();
    return myFirstWebServicePortType.queryForContact(query);
  }
  
  
}