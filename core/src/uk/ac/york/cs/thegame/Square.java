package uk.ac.york.cs.thegame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

// https://gamefromscratch.com/libgdx-tutorial-9-scene2d-part-1/

public class Square extends Actor {

    Texture texture = new Texture("square.png");

    private float actorX = 0;
    private float actorY = 0;

    public Square(float x, float y) {

        this.setBounds(actorX, actorY, texture.getWidth(), texture.getHeight());

        // input listener, listens to the keyboard control
        this.addListener(new InputListener() {
            @Override
            public boolean keyTyped(InputEvent ev, char character) {

                var instance = (Square) ev.getTarget();
                System.out.println(character);

                switch (character) {
                    case 'w':
                        instance.translate(0, 4);
                        break;
                    case 's':
                        instance.translate(0, -4);
                        break;
                    case 'a':
                        instance.translate(-4, 0);
                        break;
                    case 'd':
                        instance.translate(4, 0);
                        break;
                }

                return false;
            }
        });

        this.actorX = x;
        this.actorY = y;

    }

    public void translate(float x, float y) {
        this.actorX += x;
        this.actorY += y;
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, actorX, actorY);
    }


}
