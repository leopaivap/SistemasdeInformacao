package br.edu.ifsuldeminas.sd.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ChatFactory {
	private static int DEFAULT_RECEIVER_BUFFER_SIZE = 1000;
	private static String serverName;
	private static int serverPort;
	private static int localPort;
	private static MessageContainer container;

	public static Sender build(String serverName, int serverPort, int localPort, MessageContainer container)
			throws ChatException {
		ChatFactory.serverName = serverName;
		ChatFactory.serverPort = serverPort;
		ChatFactory.localPort = localPort;
		ChatFactory.container = container;
		try {
			new UDPReceiver(ChatFactory.localPort, DEFAULT_RECEIVER_BUFFER_SIZE, ChatFactory.container);
			return new UDPSender(InetAddress.getByName(ChatFactory.serverName), ChatFactory.serverPort);
		} catch (UnknownHostException unknownHostException) {
			throw new ChatException("Servidor n ̃ao conhecido.", unknownHostException);
		}
	}
}