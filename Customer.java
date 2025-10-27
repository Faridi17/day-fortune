import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Customer {
    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("Day Fortune");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().setBackground(Color.WHITE);

        // Grid
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(30, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        // Header
        JLabel title = new JLabel("Day Fortune", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setForeground(new Color(16, 24, 40));

        // Button
        JButton button = new JButton("Ramal Nasibku");
        button.setPreferredSize(new Dimension(200, 50));
        button.setBackground(new Color(94, 114, 228));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel luckLabel = new JLabel("", SwingConstants.CENTER);
        luckLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        luckLabel.setForeground(new Color(33, 33, 33));

        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.gridx = 0;
        gbcLabel.gridy = GridBagConstraints.RELATIVE;
        gbcLabel.insets = new Insets(5, 0, 0, 0); // jarak 5px dari tombol
        gbcLabel.anchor = GridBagConstraints.CENTER;

        // Frame
        frame.add(title, gbc);
        frame.add(button, gbc);
        frame.add(luckLabel, gbcLabel);
        frame.setVisible(true);


        // ActionListener Button
        button.addActionListener(e -> {
            new Thread(() -> {
                try (Socket clientSocket = new Socket("localhost", 49750);
                     BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String serverResponse = inFromServer.readLine();
                    SwingUtilities.invokeLater(() -> luckLabel.setText(serverResponse));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }).start();
        });



    }
}