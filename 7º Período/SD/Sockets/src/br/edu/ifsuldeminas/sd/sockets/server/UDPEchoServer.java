package br.edu.ifsuldeminas.sd.sockets.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.net.SocketException;

public class UDPEchoServer {
	private static byte[] BUFFER_OVER_FLOW_MESSAGE = "Dados acima do tamanho.".getBytes();
	private static int MIN_BUFFER_SIZE = 100;
	private static DatagramSocket datagramSocket = null;
	private static byte[] incomingBuffer = null;
	private static int portNumber;
	private static int bufferSize;
	private static boolean isRunning = false;

	public static void start(int portNumber, int bufferSize) throws UDPEchoServerException {
		validateAttributes(portNumber, bufferSize);
		asignAttributes(portNumber, bufferSize);
		try {
			prepare();
			run();
		} catch (IOException ioException) {
			isRunning = false;
			throw new UDPEchoServerException("Houve algum erro ao executar o servidor de eco UDP.", ioException);
		} finally {
			closeResources();
			System.out.println("Servidor parou devido a erros.");
		}
	}

	public static void stop() {
		if (isRunning) {
			closeResources();
			isRunning = false;
			System.out.println("Servidor parado.");
		} else {
			System.out.println("Servidor j e s t parado.");
		}
	}

	private static void validateAttributes(int portNumber, int bufferSize) {
		if (portNumber <= 1024)
			throw new IllegalArgumentException("O servidor UDP n o pode usar portar reservadas.");

		if (bufferSize < MIN_BUFFER_SIZE)
			throw new IllegalArgumentException(
					String.format("O buffer de mensagem precisa ser maior que %d", MIN_BUFFER_SIZE));
	}

	private static void asignAttributes(int portNumber, int bufferSize) {
		UDPEchoServer.portNumber = portNumber;
		UDPEchoServer.bufferSize = bufferSize;
	}

	private static void prepare() throws SocketException {
		if (isRunning)
			stop();
		datagramSocket = new DatagramSocket(portNumber);
		incomingBuffer = new byte[bufferSize];
	}

	private static void run() throws IOException {
		System.out.printf("Servidor de eco rodando em ’%s:%d’ ...\n", InetAddress.getLocalHost().getHostAddress(),
				portNumber);
		isRunning = true;
		DatagramPacket received = null;
		while (true) {
			received = receive();
			if (dataIsUnderSize(received))
				reply(received);
			else {
				reply(received, BUFFER_OVER_FLOW_MESSAGE, BUFFER_OVER_FLOW_MESSAGE.length);
			}
		}
	}

	private static DatagramPacket receive() throws IOException {
		DatagramPacket received = new DatagramPacket(incomingBuffer, incomingBuffer.length);
		datagramSocket.receive(received);
		return received;
	}

	private static boolean dataIsUnderSize(DatagramPacket received) {
		return incomingBuffer.length >= received.getData().length;
	}

	private static void reply(DatagramPacket received) throws IOException {
		reply(received, received.getData(), received.getLength());
	}

	private static void reply(DatagramPacket received, byte[] message, int bufferSize) throws IOException {
		DatagramPacket reply = new DatagramPacket(message, bufferSize, received.getAddress(), received.getPort());
		datagramSocket.send(reply);
		System.out.printf("Servidor respondendo %s:%d\n", received.getAddress().getHostAddress(), received.getPort());
	}

	private static void closeResources() {
		if (datagramSocket != null)
			datagramSocket.close();
		datagramSocket = null;
	}
}