package com.commander.view;

public abstract class AnimationView extends GameView
{
    protected float accumulatedTime;
    public abstract void animation(float time);
}
