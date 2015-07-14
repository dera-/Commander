package com.commander.infrastructure.file;

import com.commander.config.FileConfig;
import com.commander.infrastructure.entity.BaseEntity;
import com.commander.infrastructure.entity.BrainEntity;

public class BrainFileAccessor extends CsvFileAccessor {

    public BrainFileAccessor() {
        super(FileConfig.BRAIN_FILE_PATH);
    }

    @Override
    protected BaseEntity getBaseEntity(String[] record) {
        BrainEntity entity = new BrainEntity();
        entity.id = Integer.parseInt(record[0]);
        entity.defeat = Integer.parseInt(record[1]);  //撃破した時の評価値
        entity.dead = Integer.parseInt(record[2]);    //撃破された時の評価値
        entity.injured = Integer.parseInt(record[3]); //被ダメージ計算をするかどうか
        entity.nearHeeler = Integer.parseInt(record[4]);  //近くに回復できるキャラがいる場合の評価値
        entity.nearAI = Integer.parseInt(record[5]);    //近くに味方がいる場合の評価値
        entity.nearPlayer = Integer.parseInt(record[6]);  //プレイヤーキャラに近づいた場合の評価値
        entity.braveScore = Integer.parseInt(record[7]);  //戦闘を仕掛けた時に得られる得点
        return entity;
    }
}
