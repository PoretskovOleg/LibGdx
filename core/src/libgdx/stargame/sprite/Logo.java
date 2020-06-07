package libgdx.stargame.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import libgdx.stargame.base.Sprite;
import libgdx.stargame.math.Rect;

public class Logo extends Sprite {

    private static final float SPEED_LEN = 0.01f;

    private Vector2 targetPosition;
    private Vector2 speed;
    private Vector2 tempPosition;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        targetPosition = new Vector2();
        speed = new Vector2();
        tempPosition = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.3f);
        setLeft(worldBounds.getLeft());
        setBottom(worldBounds.getBottom());
    }

    @Override
    public void draw(SpriteBatch batch) {
        update();
        super.draw(batch);
    }

    private void update() {
        tempPosition.set(targetPosition);
        if(tempPosition.sub(pos).len() < SPEED_LEN) {
            pos.set(targetPosition);
            speed.setZero();
        } else {
            this.pos.add(speed);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        targetPosition.set(touch);
        speed.set(touch.sub(pos)).setLength(SPEED_LEN);
        return false;
    }
}
