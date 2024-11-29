package server;

import distance.ChatServerInterface;
import distance.ClientDistantInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends UnicastRemoteObject implements ChatServerInterface {
    private final List<ClientDistantInterface> clients = new ArrayList<>();

    public ChatServer() throws RemoteException {
        super();
    }

    @Override
    public void signIn(ClientDistantInterface client) throws RemoteException {
        clients.add(client);
        System.out.println(client.getNameDistant() + " has joined the chat.");
        sendToAll("Server", client.getNameDistant() + " has joined the chat.");
    }

    @Override
    public void signOut(ClientDistantInterface client, String message) throws RemoteException {
        clients.remove(client);
        // Notifier tous les autres clients de la déconnexion
        sendToAll("Server", client.getNameDistant() + " has left the chat: " + message);

        System.out.println(client.getNameDistant() + " has left the chat.");
    }


    @Override
    public void sendToAll(String senderName, String message) throws RemoteException {
        for (ClientDistantInterface client : clients) {
            client.receiveMessage(senderName + ": " + message);
        }
    }


    @Override
    public void sendToOne(String senderName, String receiverName, String message) throws RemoteException {
        for (ClientDistantInterface client : clients) {
            if (client.getNameDistant().equals(receiverName)) {
                client.receiveMessage("[Private] " + senderName + ": " + message);
                return;
            }
        }
        System.out.println("User " + receiverName + " not found.");
    }
}
