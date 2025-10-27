import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Seer {
    public static void main(String[] args) throws IOException {
        
        try (ServerSocket welcomeSocket = new ServerSocket(49750)) {
            System.out.println("Server berjalan di port 49750...");

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                Random rand = new Random();
                int randomNumber = rand.nextInt(7);

                String[] luck = {"Ketiban sial", "Dapat Rezeki", "Jatuh ke goat", "Dikirimin makanan", "Menang Undian", "Biasa aj", "Kehujanan"};

                outToClient.writeBytes(luck[randomNumber] + "\n");
            }
        }
    }
}
