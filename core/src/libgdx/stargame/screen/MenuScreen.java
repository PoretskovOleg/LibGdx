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

    @Override
    public void show() {
        super.show();
        background = new Texture("sky.jpg");
        object = new Texture("badlogic.jpg");
        posObject = new Vector2(0, 0);
        speedObject = new Vector2(0, 0);
        targetPosition = new Vector2(0, 0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (targetPosition.sub(posObject).len2() <= speedObject.len2()) {
            targetPosition.add(posObject);
            posObject.set(targetPosition);
        } else {
            targetPosition.add(posObject);
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
        speedObject = targetPosition.cpy().sub(posObject).nor();
        return false;
    }
}
