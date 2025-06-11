package br.edu.ifsuldeminas.sd.sockets.server;

public class MainServer {
	public static int SERVER_PORT = 3000;
	public static int SERVER_BUFFER_SIZE = 200;

	public static void main(String[] args) {
		try {
			UDPEchoServer.start(SERVER_PORT, SERVER_BUFFER_SIZE);
		} catch (UDPEchoServerException udpEchoServerException) {
			System.err.println(udpEchoServerException.getMessage());
			udpEchoServerException.printStackTrace();
		}
	}
}