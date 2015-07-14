package com.commander.domain.model;

import com.badlogic.gdx.utils.Array;
import com.commander.config.BattleConfig;

public class ActionSpeedModel {
    private int characterId;
    private int speed;
    private int restDistance;

    public ActionSpeedModel(CharacterModel character)
    {
        characterId = character.getId();
        speed = character.getSpeed();
        restDistance = BattleConfig.ACTION_WAIT_TIME;
    }

    public ActionSpeedModel(ActionSpeedModel action, boolean isInitialized)
    {
        characterId = action.characterId;
        speed = action.speed;
        if (isInitialized) {
            restDistance = BattleConfig.ACTION_WAIT_TIME;
        } else {
            restDistance = action.restDistance;
        }
    }

    public int getCharacterId()
    {
        return characterId;
    }

    public int getRestDistance()
    {
        return restDistance;
    }

    public void reduceRestDistance(int distance)
    {
        restDistance -= distance;
    }

    public double getWaitTime()
    {
        return 1.0*restDistance/speed;
    }
}
