package com.commander.view.object;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.commander.view.AnimationView;

public class SkillView extends AnimationView
{
    private static final float ANIMATION_INTERVAL = 0.3f;
    private float animationIntervalTime = 0;
    public SkillView(int x, int y) {
        super(x, y, w, h);
    }

    @Override
    public void animation(float time) {
        animationIntervalTime += time;
        if (animationIntervalTime < ANIMATION_INTERVAL) {
            return;
        }
        animationIntervalTime = 0;

    }

    @Override
    public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        // TODO Auto-generated method stub

    }

}
