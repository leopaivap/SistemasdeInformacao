package br.edu.ifsuldeminas.sd.chat;

public interface MessageContainer {
	String FROM = "::de::";

	void newMessage(String message);
}