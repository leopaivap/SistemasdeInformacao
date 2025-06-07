package br.edu.ifsuldeminas.sd.chat.client;

import br.edu.ifsuldeminas.sd.chat.MessageContainer;

public class SysOutContainer implements MessageContainer {
	public void newMessage(String message) {
		if (message == null || message.equals(""))
			return;
		String[] messageParts = message.split(MessageContainer.FROM);

		System.out.println(String.format("%s> %s", messageParts[1], messageParts[0]));
	}
}