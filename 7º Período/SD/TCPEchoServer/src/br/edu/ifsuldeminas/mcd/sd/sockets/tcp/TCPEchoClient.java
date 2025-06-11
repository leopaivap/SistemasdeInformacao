package br.edu.ifsuldeminas.mcd.sd.sockets.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TCPEchoClient {
	public static String KEY_TO_EXIT = "q";

	public static void main(String[] args) {
		String serverName = "localhost";
		int serverPort = 3000;

		Scanner reader = new Scanner(System.in);
		Socket socket = null;
		String message = "";
		try {
			while (!message.equals(KEY_TO_EXIT)) {
				System.out.printf("Digite uma mensagem (%s para sair): ", KEY_TO_EXIT);
				message = reader.nextLine();
				// Cria um socket e conecta ao servidor na porta especificada
				socket = new Socket(serverName, serverPort);
				DataInputStream inputFlow = new DataInputStream(socket.getInputStream());
				DataOutputStream outputFlow = new DataOutputStream(socket.getOutputStream());
				// Envia a mensagem ao servidor (padrao UTF)
				outputFlow.writeUTF(message);
				// Le a resposta do servidor
				String reply = inputFlow.readUTF();
				System.out.printf("Resposta> %s \n", reply);
				socket.close();
			}
			reader.close();
		} catch (NoSuchElementException noSuchElementException) {
			noSuchElementException.printStackTrace();
		} catch (UnknownHostException unknownHostException) {
			unknownHostException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			if (reader != null)
				reader.close();
			try {
				if (socket != null)
					socket.close();
			} catch (IOException ioExceptionOnClose) {
				ioExceptionOnClose.printStackTrace();
			}
		}

	}
}