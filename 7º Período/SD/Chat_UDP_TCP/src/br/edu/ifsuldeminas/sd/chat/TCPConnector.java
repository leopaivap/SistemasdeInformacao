package br.edu.ifsuldeminas.sd.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPConnector implements Sender, Receiver {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private MessageContainer container;
    private boolean isRunning = false;

    public TCPConnector(String remoteHost, int remotePort, int localPort, MessageContainer container)
            throws ChatException {
        this.container = container;
        new Thread(() -> connectAndReceive(remoteHost, remotePort, localPort)).start();
    }

    private void connectAndReceive(String remoteHost, int remotePort, int localPort) {
        try {
            this.socket = new Socket(remoteHost, remotePort);
            container.newMessage("System> Conectado a " + remoteHost + " via TCP.");
        } catch (IOException e) {
            container.newMessage("System> Não foi possível conectar. Aguardando conexão na porta " + localPort + "...");
            try (ServerSocket serverSocket = new ServerSocket(localPort)) {
                this.socket = serverSocket.accept();
                container.newMessage("System> Conexão recebida de " + socket.getInetAddress().getHostAddress());
            } catch (IOException ioException) {
                container.newMessage("System> Erro crítico ao aguardar conexão: " + ioException.getMessage());
                return;
            }
        }

        try {
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.isRunning = true;

            String messageFromPeer;
            while (isRunning && (messageFromPeer = in.readLine()) != null) {
                container.newMessage(messageFromPeer);
            }
        } catch (IOException e) {
            if (isRunning) {
                container.newMessage("System> A conexão foi perdida.");
            }
        } finally {
            close();
        }
    }

    @Override
    public void send(String message) throws ChatException {
        if (out != null && !out.checkError()) {
            out.println(message);
        } else {
            throw new ChatException("A conexão não está ativa para envio.", null);
        }
    }

    @Override
    public void run() {
    }

    private void close() {
        this.isRunning = false;
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {

        }
    }
}