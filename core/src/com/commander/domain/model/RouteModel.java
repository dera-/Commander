package com.commander.domain.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class RouteModel
{
    private Vector2[] route;
    private double cost;

    public RouteModel(Vector2 place, int cost)
    {
        this.route = new Vector2[1];
        this.route[0] = place;
        this.cost = cost;
    }

    public RouteModel(RouteModel beforeRoute, Vector2 nextPlace, double cost)
    {
        this.route = new Vector2[beforeRoute.route.length+1];
        for (int i=0; i<beforeRoute.route.length; i++) {
            this.route[i] = beforeRoute.route[i];
        }
        this.route[beforeRoute.route.length] = nextPlace;
        this.cost = cost;
    }

    public boolean isSameRoute(RouteModel targetRouteModel)
    {
        Vector2[] targetRoute = targetRouteModel.route;
        if (targetRoute.length != route.length) {
            return false;
        }
        for (int i = 0; i<targetRoute.length; i++) {
            if (targetRoute[i].x != route[i].x || targetRoute[i].y != route[i].y) {
                return false;
            }
        }
        return true;
    }

    public double getCost()
    {
        return cost;
    }

    public Vector2 reachedPlace()
    {
        return route[route.length-1];
    }

}
