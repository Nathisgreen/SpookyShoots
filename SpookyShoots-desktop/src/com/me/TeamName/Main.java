package com.me.TeamName;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "SpookyShoots";
		cfg.useGL20 = false;
		cfg.width = 1024;
		cfg.height = 768;
		cfg.fullscreen = false;
		cfg.backgroundFPS = -1;
		
		new LwjglApplication(new SpookyShoots(), cfg);
	}
}
