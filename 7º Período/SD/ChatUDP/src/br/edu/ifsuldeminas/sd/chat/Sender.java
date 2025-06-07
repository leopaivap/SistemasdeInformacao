package br.edu.ifsuldeminas.sd.chat;

public interface Sender {
	void send(String message) throws ChatException;
}