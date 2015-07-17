package com.commander.domain.model;

import com.commander.infrastructure.entity.BrainEntity;

public class BrainModel
{
    public int braveScore;
    public int dead;
    public int defeat;
    public int injured;
    public int nearAi;
    public int nearPlayer;
    public int nearHeeler;

    public BrainModel(BrainEntity entity)
    {
        braveScore = entity.braveScore;
        dead = entity.dead;
        defeat = entity.defeat;
        injured = entity.injured;
        nearAi = entity.nearAi;
        nearPlayer = entity.nearPlayer;
        nearHeeler = entity.nearHeeler;
    }
}
