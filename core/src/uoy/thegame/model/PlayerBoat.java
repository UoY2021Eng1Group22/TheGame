package uoy.thegame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class PlayerBoat extends Boat {

    private boolean controllable;

    public PlayerBoat(int x, int y, BoatType type, Texture texture) {
        super(x, y, type, texture);
        this.controllable = false;

        this.addListener(new InputListener() {

            public boolean keyTyped(InputEvent ev, char character) {
                var instance = (PlayerBoat) ev.getTarget();

                Gdx.app.log("Control",
                        String.format("user key typed: %c", character)
                );

                if (instance.isControllable()) {
                    switch (character) {
                        case 'w':
                            instance.translate(Direction.Up);
                            break;
                        case 's':
                            instance.translate(Direction.Down);
                            break;
                        case 'a':
                            instance.translate(Direction.Left);
                            break;
                        case 'd':
                            instance.translate(Direction.Right);
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
