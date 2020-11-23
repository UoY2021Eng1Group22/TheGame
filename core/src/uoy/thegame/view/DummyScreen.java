package uoy.thegame.view;

import com.badlogic.gdx.Screen;

/**
 * DummyScreen is a dummy abstract class to hide away
 * boilerplate code required to be overridden by Screen interface.
 */
abstract class DummyScreen implements Screen {

    // game viewport is not responsive nor resizable -> resize func does not have a body
    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void resume() {
    }

    // pause screen needs this
    @Override
    public void pause() {
    }

    @Override
    public void hide() {
    }

    @Override
    abstract public void show();

    @Override
    abstract public void render(float delta);

    // remember to dispose stage.
    @Override
    abstract public void dispose();

}
