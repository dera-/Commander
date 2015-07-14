package com.commander;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.commander.domain.repository.ScreenRepository;
import com.commander.domain.valueobject.ScreenEnum;

public class Commander extends Game
{
    Screen nowScreen = null;

    @Override
    public void create ()
    {
        ScreenRepository.changeScreen(ScreenEnum.GAME_START);
    }

    @Override
    public void render()
    {
        super.render();
        if (nowScreen != ScreenRepository.getNowScreen()) {
            nowScreen = ScreenRepository.getNowScreen();
            super.setScreen(nowScreen);
        }
    }
}
