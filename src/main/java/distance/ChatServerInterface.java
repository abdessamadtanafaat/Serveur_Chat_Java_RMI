package distance;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServerInterface extends Remote {
    void sendToAll(String senderName, String message) throws RemoteException;  // Envoyer à tous
    void sendToOne(String senderName, String receiverName, String message) throws RemoteException;  // Envoyer un message privé
    void signIn(ClientDistantInterface client) throws RemoteException;        // S'inscrire
    void signOut(ClientDistantInterface client, String message) throws RemoteException; // Se désinscrire
}
