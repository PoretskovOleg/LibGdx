package libgdx.stargame.pool;


import libgdx.stargame.base.SpritesPool;
import libgdx.stargame.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
