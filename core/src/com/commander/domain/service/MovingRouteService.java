package com.commander.domain.service;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.commander.domain.model.CharacterModel;
import com.commander.domain.model.MapModel;
import com.commander.domain.model.RouteModel;

public class MovingRouteService
{
    private static Vector2[] nexPlaces;

    static {
        nexPlaces = new Vector2[4];
        nexPlaces[0] = new Vector2(-1, 0);
        nexPlaces[1] = new Vector2(1, 0);
        nexPlaces[2] = new Vector2(0, -1);
        nexPlaces[3] = new Vector2(0, 1);
    }

    public static Array<RouteModel> getMovingRoutes(CharacterModel chara, MapModel map)
    {
        Array<RouteModel> routes = new Array<RouteModel>();
        Array<RouteModel> queue = new Array<RouteModel>();
        int move = chara.getMove();
        RouteModel firstRoute = new RouteModel(chara.getCurrentPlace(), 0);
        queue.addAll(getNextRoutes(firstRoute, map, move));
        while (queue.size > 0) {
            RouteModel nextRoute = queue.pop();
            for (RouteModel route : routes) {
                if (nextRoute.isSameRoute(route)) {
                    continue;
                }
            }
            routes.add(nextRoute);
            queue.addAll(getNextRoutes(nextRoute, map, move));
        }
        return routes;
    }

    private static Array<RouteModel> getNextRoutes(RouteModel beforeRoute, MapModel map, int move)
    {
        Array<RouteModel> next = new Array<RouteModel>();
        double currentCost = beforeRoute.getCost();
        for (Vector2 place : nexPlaces) {
            double cost = currentCost + map.getCost(place);
            if (move < cost) {
                continue;
            }
            next.add(new RouteModel(beforeRoute, place, cost));
        }
        return next;
    }
}
