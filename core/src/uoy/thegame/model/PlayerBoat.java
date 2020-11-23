package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class PlayerBoat extends Boat {

    private boolean controllable;

    public PlayerBoat(int x, int y, BoatType type, Texture texture) {
        super(x, y, type, texture);
        // means the object won't move until the player presses a button
        // see the show() method on the PlayScreen class for usage
        this.controllable = false;

        // logic for receiving inputs from the player
        this.addListener(new InputListener() {

            public boolean keyTyped(InputEvent ev, char character) {
                var instance = (PlayerBoat) ev.getTarget();

                Gdx.app.log("Control",
                        String.format("user key typed: %c", character)
                );

                if (instance.isControllable()) {
                    switch (character) {
                        case 'w':
                            instance.translateBoat(Direction.Up);
                            break;
                        case 's':
                            instance.translateBoat(Direction.Down);
                            break;
                        case 'a':
                            instance.translateBoat(Direction.Left);
                            break;
                        case 'd':
                            instance.translateBoat(Direction.Right);
                            break;
                    }
                }
                return false;
            }

        });

    }

    public boolean isControllable() {
        return controllable;
    }

    public void setControllable(boolean controllable) {
        this.controllable = controllable;
    }

}
