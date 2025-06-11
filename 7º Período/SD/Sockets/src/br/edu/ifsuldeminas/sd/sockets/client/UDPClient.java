package br.edu.ifsuldeminas.sd.sockets.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {
	private static final int TIME_OUT = 5000;
	private static int SERVER_PORT = 3000;
	private static int BUFFER_SIZE = 200;

	private static String KEY_TO_EXIT = "q";

	public static void main(String[] args) {
		DatagramSocket datagramSocket = null;
		Scanner reader = new Scanner(System.in);
		String stringMessage = "";
		while (!stringMessage.equals(KEY_TO_EXIT)) {
			System.out.printf("Escreva uma mensagem (%s para sair): ", KEY_TO_EXIT);
			stringMessage = reader.nextLine();
			boolean operationIsComplete = false;
			if (!stringMessage.equals("q")) {
				try {
					datagramSocket = new DatagramSocket();
					byte[] message = stringMessage.getBytes();
					InetAddress serverAddress = InetAddress.getLocalHost();
					DatagramPacket datagramPacketToSend = new DatagramPacket(message, message.length, serverAddress,
							SERVER_PORT);
					datagramSocket.setSoTimeout(TIME_OUT);
					datagramSocket.send(datagramPacketToSend);
					byte[] responseBuffer = new byte[BUFFER_SIZE];
					DatagramPacket datagramPacketForResponse = new DatagramPacket(responseBuffer,
							responseBuffer.length);
					datagramSocket.receive(datagramPacketForResponse);
					System.out.printf("Resposta do servidor: %s\n", new String(datagramPacketForResponse.getData()));
					operationIsComplete = true;
				} catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
					arrayIndexOutOfBoundsException.printStackTrace();
				} catch (SocketException socketException) {
					socketException.printStackTrace();
				} catch (UnknownHostException unknownHostException) {
					unknownHostException.printStackTrace();
				} catch (SocketTimeoutException socketTimeoutException) {
					System.out.printf("Sem resposta do servidor de eco UDP.\n");
					operationIsComplete = true;
				} catch (IOException ioException) {
					ioException.printStackTrace();
				} finally {
					if (!operationIsComplete) {
						closeOpenedResources(datagramSocket, reader);

						System.out.printf("Programa abortou devido a erros");
					}
				}
			} else {
				closeOpenedResources(datagramSocket, reader);
				System.out.printf("Cliente saindo com %s ...\n", KEY_TO_EXIT);
			}
		}
	}

	private static void closeOpenedResources(DatagramSocket datagramSocket, Scanner reader) {
		if (datagramSocket != null)
			datagramSocket.close();
		if (reader != null)
			reader.close();
	}
}