package libgdx.stargame;

import com.badlogic.gdx.Game;

import libgdx.stargame.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen());
	}
}
