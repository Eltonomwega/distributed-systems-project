import java.rmi.RemoteException;

// Implementing the remote interface 
public class ImplExample implements HelloMe {  
   
  // Implementing the interface method 
  public void printMsg() {  
     System.out.println("This is an example RMI program");  
  }

  @Override
  public String sayHello() throws RemoteException {
    // TODO Auto-generated method stub
    return null;
  }  
} 