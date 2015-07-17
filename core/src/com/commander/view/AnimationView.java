package com.commander.view;

import com.commander.config.GameConfig;


public abstract class AnimationView extends GameView
{
    protected float accumulatedTime;

    public AnimationView()
    {
        this(0, 0, GameConfig.GAME_WIDTH, GameConfig.GAME_HEIGHT);
    }

    public AnimationView(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }

    public abstract void animation(float time);
}
