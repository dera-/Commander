package com.commander.view.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.commander.view.AnimationView;

public class BattleFieldView extends AnimationView
{



    public BattleFieldView(int x, int y, int w, int h)
    {
        super();
    }

    @Override
    public void animation(float time)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer)
    {

    }

    public void movingCamera(OrthographicCamera camera, int x, int y)
    {
        camera.position.x = x;
        camera.position.y = y;
    }

    public

}
