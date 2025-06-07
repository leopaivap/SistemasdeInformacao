package br.edu.ifsuldeminas.sd.chat.client;

import java.util.Scanner;

import br.edu.ifsuldeminas.sd.chat.ChatException;
import br.edu.ifsuldeminas.sd.chat.ChatFactory;
import br.edu.ifsuldeminas.sd.chat.MessageContainer;
import br.edu.ifsuldeminas.sd.chat.Sender;

public class Chat {
	public static String KEY_TO_EXIT = "q";
	public static int RECEIVER_BUFFER_SIZE = 1000;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.print("Porta local: ");
		int localPort = reader.nextInt();
		System.out.print("Porta remota: ");
		int serverPort = reader.nextInt();
// Para limpar o buffer
		reader.nextLine();
		System.out.print("Nome: ");
		String from = reader.nextLine();
		try {
			Sender sender = ChatFactory.build("localhost", serverPort, localPort, new SysOutContainer());
			String message = "";
			while (!message.equals(KEY_TO_EXIT)) {
				message = reader.nextLine();
				message = String.format("%s%s%s", message, MessageContainer.FROM, from);
				if (!message.equals("")) {
					if (message.equals("q"))

						System.exit(0);
					else
						sender.send(message);
				}
			}
		} catch (ChatException chatException) {
			System.err.printf(String.format("Houve algum erro no chat. Mensagem do erro: %s",
					chatException.getCause().getMessage()));
		} finally {
			reader.close();
			System.exit(0);
		}
	}
}