package model;

public class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	public void play(String audioType, String fileName) {
		// Player interno suporta apenas mp3
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file. Name: " + fileName);
		}
		// Usar adaptador para reproduzir outros formatos
		else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		} else {
			System.out.println("Invalid media. " + audioType + " format not supported");
		}
	}
}
