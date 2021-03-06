package uoy.thegame.desktop;

// switched from Lwjgl2 to Lwjgl3 (performance)

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import uoy.thegame.TheGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        // setting up the low-level game library

        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

        config.setTitle("the-game");
        config.setWindowedMode(1159, 408);
        config.setResizable(false); // viewport is not responsive

        // start the game
        new Lwjgl3Application(new TheGame(), config);
    }
}
