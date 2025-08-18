package br.edu.ifsuldeminas.mch.sd.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private static String KEY_TO_EXIT = "q";
	private static int ONE_SECOND = 1000;
	private static int bufferSize = 100;

	public static void main(String[] args) {
		String groupAddress = "228.6.7.8";
		int port = 3000;
		DatagramSocket datagramSocket = null;
		Scanner reader = new Scanner(System.in);
		String stringMessage = "";
		try {
			InetAddress group = InetAddress.getByName(groupAddress);

			datagramSocket = new DatagramSocket();
			while (!stringMessage.equals(KEY_TO_EXIT)) {
				System.out.printf("Give me your message (%s to quit): ", KEY_TO_EXIT);
				stringMessage = reader.nextLine();
				if (!stringMessage.equals("q")) {
					byte[] message = stringMessage.getBytes();
					DatagramPacket datagramPacketToSend = new DatagramPacket(message, message.length, group, port);
					datagramSocket.send(datagramPacketToSend);
					System.out.printf("Sending message: %s\n", stringMessage);
					datagramSocket.setSoTimeout(ONE_SECOND);
					byte[] replyBuffer = new byte[bufferSize];
// Recebe enquanto houver mensagens
					boolean couldHaveMoreMessages = true;
					while (couldHaveMoreMessages) {
						DatagramPacket messageReply = new DatagramPacket(replyBuffer, replyBuffer.length);
						try {
							datagramSocket.receive(messageReply);
							System.out.printf("Received: %s\n", new String(messageReply.getData()));
						} catch (SocketTimeoutException e) {
							couldHaveMoreMessages = false;
						}
					}
				} else {
					closeOpenedResources(datagramSocket, reader);
					System.out.printf("Client exiting with %s ...\n", KEY_TO_EXIT);
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void closeOpenedResources(DatagramSocket datagramSocket, Scanner reader) {
		if (datagramSocket != null)
			datagramSocket.close();
		if (reader != null)
			reader.close();
	}
}