package com.commander.view.object;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.commander.config.FileConfig;
import com.commander.config.GameConfig;
import com.commander.infrastructure.entity.MapChipEntity;
import com.commander.infrastructure.file.image.TextureRepository;
import com.commander.view.GameView;

public class MapChipView extends GameView
{
    private Sprite chipSprite;
    private MapChipEntity entity;

    public MapChipView(MapChipEntity chip, int x, int y)
    {
        super(GameConfig.MAP_CHIP_WIDTH*x, GameConfig.MAP_CHIP_HEIGHT*y, GameConfig.MAP_CHIP_WIDTH, GameConfig.MAP_CHIP_HEIGHT);
        chipSprite = new Sprite(
            TextureRepository.generateTexture(
                FileConfig.IMAGE_DIR_PATH + chip.imageKey,
                chip.imageKey
            )
        );
        this.entity = chip;
    }

    @Override
    public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer)
    {
        batch.begin();
        chipSprite.setPosition(leftX, lowerY);
        chipSprite.setSize(width, height);
        chipSprite.draw(batch);
        batch.end();
    }
}
