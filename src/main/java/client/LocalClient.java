package client;

public class LocalClient {
    private String id;    // Identifiant unique
    private String name;  // Pseudonyme

    public LocalClient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void displayMessage(String message) {
        System.out.println("[" + name + "]: " + message);
    }
}
