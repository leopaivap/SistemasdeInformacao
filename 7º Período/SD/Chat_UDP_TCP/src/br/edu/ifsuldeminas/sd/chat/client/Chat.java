package br.edu.ifsuldeminas.sd.chat.client;

import java.util.Scanner;
import br.edu.ifsuldeminas.sd.chat.ChatException;
import br.edu.ifsuldeminas.sd.chat.ChatFactory;
import br.edu.ifsuldeminas.sd.chat.MessageContainer;
import br.edu.ifsuldeminas.sd.chat.Sender;

public class Chat {
	public static String KEY_TO_EXIT = "q";

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		System.out.print("Porta local: ");
		int localPort = Integer.parseInt(reader.nextLine());

		System.out.print("IP Remoto: ");
		String remoteIp = reader.nextLine();

		System.out.print("Porta remota: ");
		int remotePort = Integer.parseInt(reader.nextLine());

		System.out.print("Nome: ");
		String from = reader.nextLine();

		System.out.print("Usar TCP? (s/n): ");
		String choice = reader.nextLine();
		boolean useTCP = choice.equalsIgnoreCase("s");

		try {
			Sender sender = ChatFactory.build(remoteIp, remotePort, localPort, new SysOutContainer(), useTCP);
			System.out.println("--------------------------------------------------");
			System.out.printf("Chat iniciado em %s! Conectado a %s:%d\n", (useTCP ? "TCP" : "UDP"), remoteIp,
					remotePort);
			System.out.println("Digite suas mensagens. Para sair, digite 'q'.");
			System.out.println("--------------------------------------------------");

			String message = "";
			while (true) {
				message = reader.nextLine();

				if (message.equalsIgnoreCase(KEY_TO_EXIT)) {
					break;
				}

				if (!message.trim().isEmpty()) {
					String formattedMessage = String.format("%s%s%s", message, MessageContainer.FROM, from);
					sender.send(formattedMessage);
				}
			}
		} catch (ChatException chatException) {
			System.err.printf("Houve algum erro no chat. Mensagem do erro: %s\n",
					chatException.getCause() != null ? chatException.getCause().getMessage()
							: chatException.getMessage());
		} finally {
			System.out.println("Encerrando o chat.");
			reader.close();
			System.exit(0);
		}
	}
}