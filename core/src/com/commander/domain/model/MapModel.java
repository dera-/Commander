package com.commander.domain.model;

import com.badlogic.gdx.math.Vector2;
import com.commander.infrastructure.entity.MapChipEntity;

public class MapModel
{
    private static final double MAX_COST = 10000;
    private MapChipEntity[][] map;

    public MapModel()
    {

    }

    public boolean isMovablePlace(Vector2 place)
    {
        if (
            place.x < 0
            && place.y < 0
            && map.length <= place.y
            && map[0].length <= place.x
        ) {
            return false;
        }
        return map[(int)place.y][(int)place.x].isMovable;
    }

    public double getCost(Vector2 place)
    {
        if (!isMovablePlace(place)) {
            return MAX_COST;
        }
        return map[(int)place.y][(int)place.x].move;
    }
}
