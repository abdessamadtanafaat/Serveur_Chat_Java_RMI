package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer();
            Registry registry = LocateRegistry.createRegistry(1099);  // Port par défaut
            registry.rebind("ChatServer", server);
            System.out.println("Chat server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

