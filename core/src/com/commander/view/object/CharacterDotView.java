package com.commander.view.object;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.commander.config.FileConfig;
import com.commander.config.GameConfig;
import com.commander.infrastructure.entity.CharacterEntity;
import com.commander.infrastructure.file.image.TextureRepository;
import com.commander.view.AnimationView;

public class CharacterDotView extends AnimationView
{
    private static final float MAX_TIME = 1000f;
    private static final float ANIMATION_INTERVAL = 0.3f;
    private static final int NO_ANIMATION = -1;
    private static final int MOVING_DOWN = 0;
    private static final int MOVING_LEFT = 1;
    private static final int MOVING_RIGHT = 2;
    private static final int MOVING_UP = 3;
    private Animation[] charaAnime = new Animation[4];
    private TextureRegion charaTexture;
    private CharacterEntity entity;
    private int currentAnimationMode;
    private float currentTime;
    private float animationIntervalTime;
    private Vector2 realPlace;
    private Vector2 reachPlace;

    public CharacterDotView(CharacterEntity entity, int x, int y)
    {
        super(GameConfig.MAP_CHIP_WIDTH*x, GameConfig.MAP_CHIP_HEIGHT*y, GameConfig.CHARA_DOT_WIDTH, GameConfig.CHARA_DOT_HEIGHT);
        TextureRegion[] textures = TextureRepository.generateTextureRegions(
            FileConfig.IMAGE_DIR_PATH + FileConfig.CHARACTER_DOT_FILE_PREFIX + entity.imageKey + FileConfig.IMAGE_FORMAT_PNG,
            entity.imageKey,
            GameConfig.CHARA_DOT_WIDTH,
            GameConfig.CHARA_DOT_HEIGHT
        );
        this.charaTexture = textures[1];
        TextureRegion[] movingDownTextures = {textures[0], textures[2]};
        charaAnime[MOVING_DOWN] = new Animation(ANIMATION_INTERVAL, movingDownTextures);
        TextureRegion[] movingLeftTextures = {textures[3], textures[5]};
        charaAnime[MOVING_LEFT] = new Animation(ANIMATION_INTERVAL, movingLeftTextures);
        TextureRegion[] movingRightTextures = {textures[6], textures[8]};
        charaAnime[MOVING_RIGHT] = new Animation(ANIMATION_INTERVAL, movingRightTextures);
        TextureRegion[] movingUpTextures = {textures[9], textures[11]};
        charaAnime[MOVING_UP] = new Animation(ANIMATION_INTERVAL, movingUpTextures);
        this.entity = entity;
        this.currentAnimationMode = NO_ANIMATION;
        currentTime = 0f;
        realPlace = new Vector2(leftX, lowerY);
        reachPlace = new Vector2(0, 0);
    }

    @Override
    public void animation(float time)
    {
        currentTime = (currentTime + time) % MAX_TIME;
        if (currentAnimationMode == NO_ANIMATION) {
            return;
        }
        animationIntervalTime += time;
        if (animationIntervalTime < ANIMATION_INTERVAL) {
            return;
        }
        animationIntervalTime = 0;
        movingAnimation(time);
    }

    private void movingAnimation(float time)
    {
        if (reachPlace.x == 0 && reachPlace.y == 0) {
            currentAnimationMode = NO_ANIMATION;
        } else if (reachPlace.x > 0) {
            currentAnimationMode = MOVING_RIGHT;
            reachPlace.x--;
            realPlace.x += GameConfig.MAP_CHIP_WIDTH;
        } else if (reachPlace.y > 0) {
            currentAnimationMode = MOVING_UP;
            reachPlace.y--;
            realPlace.y += GameConfig.MAP_CHIP_HEIGHT;
        } else if (reachPlace.x < 0) {
            currentAnimationMode = MOVING_LEFT;
            reachPlace.x++;
            realPlace.x -= GameConfig.MAP_CHIP_WIDTH;
        } else if (reachPlace.y < 0) {
            currentAnimationMode = MOVING_DOWN;
            reachPlace.y++;
            realPlace.y -= GameConfig.MAP_CHIP_HEIGHT;
        }
    }

    @Override
    public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer)
    {
        batch.begin();
        batch.draw(getCurrentSprite(), realPlace.x, realPlace.y, width, height);
        batch.end();
    }

    private TextureRegion getCurrentSprite()
    {
        switch(currentAnimationMode){
        case MOVING_DOWN:
            return charaAnime[MOVING_DOWN].getKeyFrame(currentTime, true);
        case MOVING_LEFT:
            return charaAnime[MOVING_LEFT].getKeyFrame(currentTime, true);
        case MOVING_RIGHT:
            return charaAnime[MOVING_RIGHT].getKeyFrame(currentTime, true);
        case MOVING_UP:
            return charaAnime[MOVING_UP].getKeyFrame(currentTime, true);
        default:
            return charaTexture;
        }
    }

    public void setReachPlace(float dx, float dy)
    {
        reachPlace.add(dx, dy);
    }

}
