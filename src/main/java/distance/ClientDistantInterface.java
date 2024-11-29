package distance;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientDistantInterface extends Remote {
    void receiveMessage(String message) throws RemoteException;  // Recevoir un message
    String getNameDistant() throws RemoteException;              // Obtenir le nom du client
    String getIdDistant() throws RemoteException;                // Obtenir l'ID du client
}