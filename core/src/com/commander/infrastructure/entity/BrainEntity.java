package com.commander.infrastructure.entity;

public class BrainEntity extends BaseEntity
{
    public int defeat;  //撃破した時の評価値
    public int dead;    //撃破された時の評価値
    public int injured;  //被ダメージ計算をするかどうか
    public int nearHeeler;  //近くに回復できるキャラがいる場合の評価値
    public int nearAi;    //近くに味方がいる場合の評価値
    public int nearPlayer;  //プレイヤーキャラに近づいた場合の評価値
    public int braveScore;  //戦闘を仕掛けた時に得られる得点
}
