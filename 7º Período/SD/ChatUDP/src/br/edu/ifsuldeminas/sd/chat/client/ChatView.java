package br.edu.ifsuldeminas.sd.chat.client;

import br.edu.ifsuldeminas.sd.chat.ChatException;
import br.edu.ifsuldeminas.sd.chat.ChatFactory;
import br.edu.ifsuldeminas.sd.chat.MessageContainer;
import br.edu.ifsuldeminas.sd.chat.Sender;

import javax.swing.*;
import java.awt.*;

public class ChatView extends JFrame implements MessageContainer {

    private static final long serialVersionUID = 1L;

    // GUI Components
    private JTextField localPortField;
    private JTextField remotePortField;
    private JTextField userNameField;
    private JTextArea chatHistoryArea;
    private JTextField newMessageField;
    private JButton connectButton;
    private JButton sendButton;

    private Sender messageSender;
    private String userName;

    public ChatView() {
        super("Chat UDP");
        initComponents();
        setupLayout();
        configureActions();
    }

    private void initComponents() {
        // Initializes all UI components
        localPortField = new JTextField(5);
        remotePortField = new JTextField(5);
        userNameField = new JTextField(10);
        connectButton = new JButton("Conectar");

        chatHistoryArea = new JTextArea();
        chatHistoryArea.setEditable(false);
        chatHistoryArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        chatHistoryArea.setMargin(new Insets(10, 10, 10, 10));

        newMessageField = new JTextField();
        sendButton = new JButton("Enviar");

        // Disable message fields until a connection is established
        setFieldsForConnection(false);
    }

    private void setupLayout() {
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        add(createConnectionPanel(), BorderLayout.NORTH);
        add(new JScrollPane(chatHistoryArea), BorderLayout.CENTER);
        add(createInputPanel(), BorderLayout.SOUTH);
    }

    private JPanel createConnectionPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.add(new JLabel("Sua Porta:"));
        panel.add(localPortField);
        panel.add(new JLabel("Porta Remota:"));
        panel.add(remotePortField);
        panel.add(new JLabel("Username:"));
        panel.add(userNameField);
        panel.add(connectButton);
        return panel;
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(newMessageField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);
        return panel;
    }

    private void configureActions() {
        connectButton.addActionListener(e -> attemptConnection());
        sendButton.addActionListener(e -> sendMessage());
        newMessageField.addActionListener(e -> sendMessage()); // Allows sending with the Enter key
    }

    private void attemptConnection() {
        try {
            int localPort = Integer.parseInt(localPortField.getText().trim());
            int remotePort = Integer.parseInt(remotePortField.getText().trim());
            this.userName = userNameField.getText().trim();

            if (this.userName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome não pode ser vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.messageSender = ChatFactory.build("localhost", remotePort, localPort, this);

            setFieldsForConnection(true);
            appendToHistory("System", "Conexão estabelecida com sucesso!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Números de porta precisam ser inteiros.", "Erro de formato",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ChatException ex) {
            JOptionPane.showMessageDialog(this, "Erro iniciando chat: " + ex.getMessage(), "Erro de conexão",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sendMessage() {
        String message = newMessageField.getText();
        if (messageSender != null && !message.trim().isEmpty()) {
            try {
                String formattedMessage = String.format("%s%s%s", message, MessageContainer.FROM, this.userName);
                messageSender.send(formattedMessage);

                appendToHistory("You", message);
                newMessageField.setText("");

            } catch (ChatException ex) {
                JOptionPane.showMessageDialog(this, "Falha ao enviar mensagem: " + ex.getMessage(), "Erro de envio",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void setFieldsForConnection(boolean isConnected) {
        localPortField.setEnabled(!isConnected);
        remotePortField.setEnabled(!isConnected);
        userNameField.setEnabled(!isConnected);
        connectButton.setEnabled(!isConnected);

        newMessageField.setEnabled(isConnected);
        sendButton.setEnabled(isConnected);

        if (isConnected) {
            newMessageField.requestFocusInWindow();
        }
    }

    private void appendToHistory(String sender, String content) {
        chatHistoryArea.append(String.format("%s> %s\n", sender, content));
    }

    @Override
    public void newMessage(String incomingMessage) {
        if (incomingMessage == null || incomingMessage.trim().isEmpty())
            return;

        SwingUtilities.invokeLater(() -> {
            String[] parts = incomingMessage.split(MessageContainer.FROM);
            if (parts.length == 2) {
                String senderName = parts[1].trim();
                String content = parts[0].trim();
                appendToHistory(senderName, content);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChatView().setVisible(true));
    }
}