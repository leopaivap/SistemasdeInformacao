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
			boolean isTCP) throws ChatException {

		ChatFactory.remoteHost = remoteHost;
		ChatFactory.remotePort = remotePort;
		ChatFactory.localPort = localPort;
		ChatFactory.container = container;
		ChatFactory.isTCP = isTCP;

		try {
			if (ChatFactory.isTCP) {
				new TCPReceiver(ChatFactory.localPort, ChatFactory.container);
				return new TCPSender(InetAddress.getByName(ChatFactory.remoteHost), ChatFactory.remotePort);
			} else {

				new UDPReceiver(ChatFactory.localPort, DEFAULT_RECEIVER_BUFFER_SIZE, ChatFactory.container);
				return new UDPSender(InetAddress.getByName(ChatFactory.remoteHost), ChatFactory.remotePort);

			}
		} catch (UnknownHostException unknownHostException) {
			throw new ChatException("The receiver is unknown", unknownHostException);
		}
	}
}