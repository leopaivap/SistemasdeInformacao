package br.edu.ifsuldeminas.mch.sd.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Peer {
	private static byte[] incomingBuffer = null;
	private static int bufferSize = 100;
	private static MulticastSocket multicastSocket = null;

	public static void main(String[] args) {
		String groupAddress = "228.6.7.8";
		int port = 3000;
		incomingBuffer = new byte[bufferSize];
		try {
			InetAddress group = InetAddress.getByName(groupAddress);
			multicastSocket = new MulticastSocket(port);
// Se junta ao grupo "228.6.7.8"
			multicastSocket.joinGroup(group);
			DatagramPacket received = null;
			while (true) {
				System.out.printf("Waiting on: %d\n", port);
				received = receive();
				System.out.printf("From: %s on %d\nMessage: %s.\n", received.getAddress().toString(),
						received.getPort(), new String(received.getData()));
				DatagramPacket reply = new DatagramPacket(received.getData(), bufferSize, received.getAddress(),
						received.getPort());
				multicastSocket.send(reply);
				System.out.printf("Replying %s:%d\n", received.getAddress().getHostAddress(), received.getPort());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static DatagramPacket receive() throws IOException {
		DatagramPacket received = new DatagramPacket(incomingBuffer, incomingBuffer.length);
		multicastSocket.receive(received);
		return received;
	}
}