package libgdx.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import libgdx.stargame.base.BaseScreen;
import libgdx.stargame.math.Rect;
import libgdx.stargame.sprite.Background;
import libgdx.stargame.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture backgroundPicture;
    private Texture logoPicture;
    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        backgroundPicture = new Texture("sky.jpg");
        logoPicture = new Texture("badlogic.jpg");
        background = new Background(backgroundPicture);
        logo = new Logo(logoPicture);
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        backgroundPicture.dispose();
        logoPicture.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return false;
    }
}
