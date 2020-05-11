package libgdx.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import libgdx.stargame.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture background;
    private Texture object;
    private Vector2 posObject;
    private Vector2 speedObject;
    private Vector2 targetPosition;
    private Vector2 tempPosition;

    @Override
    public void show() {
        super.show();
        background = new Texture("sky.jpg");
        object = new Texture("badlogic.jpg");
        posObject = new Vector2();
        speedObject = new Vector2();
        targetPosition = new Vector2();
        tempPosition = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        tempPosition.set(posObject);
        if (tempPosition.sub(targetPosition).len2() <= speedObject.len2()) {
            posObject.set(targetPosition);
            speedObject.setZero();
        } else {
            posObject.add(speedObject);
        }
        batch.begin();
        batch.draw(background, 0, 0, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(object, posObject.x, posObject.y);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        background.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        targetPosition.set(screenX, Gdx.graphics.getHeight() - screenY);
        speedObject.set(targetPosition.cpy().sub(posObject)).nor();
        return false;
    }
}
