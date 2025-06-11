package br.edu.ifsuldeminas.mcd.sd.sockets.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {
	public static void main(String[] args) {
		int serverPort = 3000;
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			// Cria um socket de servidor para esperar por conexao dos clientes
			serverSocket = new ServerSocket(serverPort);
			System.out.printf("Servidor rodando...\n");
			while (true) {
				// Espera e aceita conexao dos clientes
				socket = serverSocket.accept();
				System.out.printf("Cliente %s conectando na porta %d ", socket.getInetAddress().getHostAddress(),
						socket.getPort());
				DataInputStream inputFlow = new DataInputStream(socket.getInputStream());
				DataOutputStream outputFlow = new DataOutputStream(socket.getOutputStream());
				// Le a mensagem do cliente
				String message = inputFlow.readUTF();
				System.out.printf("Mensagem> %s \n", message);

				// Responde ao cliente
				outputFlow.writeUTF(message);
				socket.close();
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			try {
				if (serverSocket != null)
					serverSocket.close();
				if (socket != null)
					socket.close();
			} catch (IOException ioExceptionOnClose) {
				ioExceptionOnClose.printStackTrace();
			}
		}
	}
}