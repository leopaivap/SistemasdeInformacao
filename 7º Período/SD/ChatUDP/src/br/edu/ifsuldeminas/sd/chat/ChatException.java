package br.edu.ifsuldeminas.sd.chat;

public class ChatException extends Exception {
	private static final long serialVersionUID = 1L;

	public ChatException(String message, Throwable cause) {
		super(message, cause);
	}
}