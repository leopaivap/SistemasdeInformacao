package br.edu.ifsuldeminas.sd.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ChatFactory {
	private static final int DEFAULT_RECEIVER_BUFFER_SIZE = 1000;

	private static String remoteHost;
	private static int remotePort;
	private static int localPort;
	private static MessageContainer container;
	private static boolean isTCP;

	public static Sender build(String remoteHost, int remotePort, int localPort, MessageContainer container,
			boolean isTCP)
			throws ChatException {

		ChatFactory.remoteHost = remoteHost;
		ChatFactory.remotePort = remotePort;
		ChatFactory.localPort = localPort;
		ChatFactory.container = container;
		ChatFactory.isTCP = isTCP;

		if (ChatFactory.isTCP) {
			return new TCPConnector(ChatFactory.remoteHost, ChatFactory.remotePort, ChatFactory.localPort,
					ChatFactory.container);
		} else {
			try {
				new UDPReceiver(ChatFactory.localPort, DEFAULT_RECEIVER_BUFFER_SIZE, ChatFactory.container);
				return new UDPSender(InetAddress.getByName(ChatFactory.remoteHost), ChatFactory.remotePort);
			} catch (UnknownHostException unknownHostException) {
				throw new ChatException("Servidor não conhecido.", unknownHostException);
			}
		}
	}
}