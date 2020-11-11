package uk.ac.york.cs.thegame.desktop;

// switched from Lwjgl2 to Lwjgl3 (performance)

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import uk.ac.york.cs.thegame.TheGame;

public class DesktopLauncher {
	public static void main(String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("the-game");
		config.setWindowedMode(640, 480);
		new Lwjgl3Application(new TheGame(), config);
	}
}
