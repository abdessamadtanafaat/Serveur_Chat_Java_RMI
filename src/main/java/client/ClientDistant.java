package client;


import distance.ClientDistantInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientDistant implements ClientDistantInterface {
    private LocalClient localClient;

    public ClientDistant(String id, String name) throws RemoteException {
        // Crée une instance locale
        this.localClient = new LocalClient(id, name);
    }

    @Override
    public void receiveMessage(String message) throws RemoteException {
        // Utilise la méthode de LocalClient pour afficher un message
        localClient.displayMessage(message);
    }

    @Override
    public String getNameDistant() throws RemoteException {
        return localClient.getName();
    }

    @Override
    public String getIdDistant() throws RemoteException {
        return localClient.getId();
    }
}
