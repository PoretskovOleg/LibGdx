package libgdx.stargame.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import libgdx.stargame.base.ScaledButton;
import libgdx.stargame.math.Rect;
import libgdx.stargame.screen.GameScreen;

public class ButtonPlay extends ScaledButton {

    private final Game game;

    private static final float MARGIN = 0.05f;

    public ButtonPlay(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btPlay"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.25f);
        setBottom(worldBounds.getBottom() + MARGIN);
        setLeft(worldBounds.getLeft() + MARGIN);
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen());
    }
}