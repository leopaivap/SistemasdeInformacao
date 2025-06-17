package br.edu.ifsuldeminas.sd.chat.client;

import br.edu.ifsuldeminas.sd.chat.ChatException;
import br.edu.ifsuldeminas.sd.chat.ChatFactory;
import br.edu.ifsuldeminas.sd.chat.MessageContainer;
import br.edu.ifsuldeminas.sd.chat.Sender;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChatView extends JFrame implements MessageContainer {

    private static final long serialVersionUID = 1L;

    private JTextField localPortField;
    private JTextField remoteIpField;
    private JTextField remotePortField;
    private JTextField userNameField;
    private JRadioButton tcpRadioButton;
    private JRadioButton udpRadioButton;
    private ButtonGroup protocolGroup;
    private JTextArea chatHistoryArea;
    private JTextField newMessageField;
    private JButton connectButton;
    private JButton sendButton;

    private Sender messageSender;
    private String userName;

    public ChatView() {
        super("Chat UDP/TCP");
        initComponents();
        setupLayout();
        configureActions();
    }

    private void initComponents() {
        localPortField = new JTextField("5000", 5);
        remoteIpField = new JTextField("127.0.0.1", 10);
        remotePortField = new JTextField("6000", 5);
        userNameField = new JTextField("user", 10);
        tcpRadioButton = new JRadioButton("TCP");
        udpRadioButton = new JRadioButton("UDP");
        udpRadioButton.setSelected(true);
        protocolGroup = new ButtonGroup();
        protocolGroup.add(tcpRadioButton);
        protocolGroup.add(udpRadioButton);
        connectButton = new JButton("Conectar");
        chatHistoryArea = new JTextArea();
        chatHistoryArea.setEditable(false);
        chatHistoryArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        newMessageField = new JTextField();
        sendButton = new JButton("Enviar");
        sendButton.setForeground(Color.BLACK);

        setFieldsForConnection(false);
    }

    private void setupLayout() {
        setMinimumSize(new Dimension(600, 450));
        setSize(750, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        mainPanel.add(createConnectionPanel(), BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(chatHistoryArea), BorderLayout.CENTER);
        mainPanel.add(createInputPanel(), BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private JPanel createConnectionPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Configuração da Conexão"));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Sua Porta:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(localPortField, gbc);
        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("IP Remoto:"), gbc);
        gbc.gridx = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(remoteIpField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Porta Remota:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(remotePortField, gbc);
        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(userNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Protocolo:"), gbc);
        JPanel protocolPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        protocolPanel.add(tcpRadioButton);
        protocolPanel.add(udpRadioButton);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        panel.add(protocolPanel, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        connectButton.setBackground(new Color(60, 179, 113));
        connectButton.setForeground(Color.BLACK);
        panel.add(connectButton, gbc);

        return panel;
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Mensagem"));

        sendButton.setBackground(new Color(70, 130, 180));
        sendButton.setForeground(Color.BLACK);

        panel.add(newMessageField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);
        return panel;
    }

    private void configureActions() {
        connectButton.addActionListener(e -> attemptConnection());
        sendButton.addActionListener(e -> sendMessage());
        newMessageField.addActionListener(e -> sendMessage());
    }

    private void attemptConnection() {
        try {
            int localPort = Integer.parseInt(localPortField.getText().trim());
            int remotePort = Integer.parseInt(remotePortField.getText().trim());
            String remoteIp = remoteIpField.getText().trim();
            this.userName = userNameField.getText().trim();

            boolean useTCP = tcpRadioButton.isSelected();

            if (this.userName.isEmpty() || remoteIp.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome de usuário e IP remoto não podem ser vazios.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.messageSender = ChatFactory.build(remoteIp, remotePort, localPort, this, useTCP);

            setFieldsForConnection(true);
            appendToHistory("System", "Tentando conectar usando " + (useTCP ? "TCP..." : "UDP..."));

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
                appendToHistory("Você", message);
                newMessageField.setText("");
            } catch (ChatException ex) {
                appendToHistory("System", "Falha ao enviar mensagem: " + ex.getMessage());
            }
        }
    }

    private void setFieldsForConnection(boolean isConnected) {
        localPortField.setEnabled(!isConnected);
        remoteIpField.setEnabled(!isConnected);
        remotePortField.setEnabled(!isConnected);
        userNameField.setEnabled(!isConnected);
        connectButton.setEnabled(!isConnected);

        tcpRadioButton.setEnabled(!isConnected);
        udpRadioButton.setEnabled(!isConnected);

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
            if (incomingMessage.startsWith("System>")) {
                appendToHistory("System", incomingMessage.substring(8));
                return;
            }

            String[] parts = incomingMessage.split(MessageContainer.FROM);
            if (parts.length >= 2) {
                String senderName = parts[1].trim();
                String content = parts[0].trim();
                appendToHistory(senderName, content);
            } else {
                appendToHistory("Info", incomingMessage);
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Não foi possível aplicar o Look and Feel do sistema.");
        }

        SwingUtilities.invokeLater(() -> new ChatView().setVisible(true));
    }
}