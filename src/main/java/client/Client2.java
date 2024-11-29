package client;


import distance.ChatServerInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try {
            // Connexion au registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            ChatServerInterface server = (ChatServerInterface) registry.lookup("ChatServer");

            // Demander au client son nom et son ID
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez votre nom : ");
            String name = scanner.nextLine();
            System.out.print("Entrez votre ID : ");
            String id = scanner.nextLine();

            // Crée une instance de ClientDistant (objet réel)
            ClientDistant client = new ClientDistant(id, name);

            // Exporte cet objet en tant qu'objet distant
            UnicastRemoteObject.exportObject(client, 0); // Le '0' signifie l'exportation de l'objet

            // Appelle signIn pour enregistrer le client auprès du serveur
            server.signIn(client);

            System.out.println("Bienvenue " + name + "! Vous êtes maintenant connecté au chat.");
            System.out.println("Tapez un message pour l'envoyer à tout le monde. Tapez 'exit' pour quitter.");

            // Boucle pour envoyer des messages
            while (true) {
                System.out.print("Vous: ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    // Appel de signOut pour désenregistrer le client
                    server.signOut(client, "Au revoir !");

                    // Délier l'objet distant du registre RMI après déconnexion
                    UnicastRemoteObject.unexportObject(client, true); // Supprime l'objet du registre RMI
                    System.out.println("Vous avez quitté le chat.");
                    break;
                }

                // Envoyer un message à tous les clients connectés
                server.sendToAll(name, message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
