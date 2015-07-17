package com.commander.domain.model;

import com.badlogic.gdx.math.Vector2;
import com.commander.domain.factory.BrainModelFactory;
import com.commander.domain.valueobject.CharacterType;
import com.commander.infrastructure.entity.CharacterEntity;
import com.commander.infrastructure.entity.SkillEntity;

public class CharacterModel
{
    private int id;
    private int charaType;
    private int maxHp;
    private int attack;
    private int defense;
    private int hit;
    private int avoid;
    private int luck;
    private int magicAttack;
    private int magicDefense;
    private int speed;
    private int move;
    private SkillEntity[] skills;

    private int currentHp;
    private Vector2 currentPlace;
    private Vector2[] movingRoute;
    private BrainModel brain;
    private static final Vector2[] NO_ROOT = new Vector2[0];

    public CharacterModel(int id, int charaType, CharacterEntity entity, SkillEntity[] skillEntitys, Vector2 place)
    {
        this.id = id;
        this.charaType = charaType;
        maxHp = entity.hp;
        currentHp = entity.hp;
        attack = entity.attack;
        defense = entity.defense;
        hit = entity.hit;
        avoid = entity.avoid;
        luck = entity.luck;
        magicAttack = entity.magicAttack;
        magicDefense = entity.magicDefense;
        speed = entity.speed;
        move = entity.move;
        skills = skillEntitys;
        brain = BrainModelFactory.getBrainModel(entity.brainId);
        currentPlace = new Vector2(place.x, place.y);
        movingRoute = NO_ROOT;
    }

    public boolean isAlive()
    {
        return currentHp > 0;
    }

    public void damage(int d)
    {
        currentHp -= d;
        if (currentHp < 0) {
            currentHp = 0;
        }
        if (currentHp > maxHp) {
            currentHp = maxHp;
        }
    }

    public Vector2 getCurrentPlace()
    {
        return currentPlace;
    }

    public void reachTargetPlace()
    {
        currentPlace = movingRoute[movingRoute.length-1];
        movingRoute = NO_ROOT;
    }

    public Vector2[] getMovingRoute()
    {
        return movingRoute;
    }

    public void setMovingRoute(Vector2[] route)
    {
        movingRoute = route;
    }

    public int getId()
    {
        return id;
    }

    public int getMove()
    {
        return move;
    }

    public int getSpeed()
    {
        return speed;
    }
}
