import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloMe extends Remote {
    String sayHello() throws RemoteException;
}