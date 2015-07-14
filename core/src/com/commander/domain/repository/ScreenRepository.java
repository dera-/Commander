package com.commander.domain.repository;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Array;
import com.commander.domain.valueobject.ScreenEnum;

public class ScreenRepository
{
    private static Array<Screen> screenStack = new Array<Screen>();
    public static Screen getNowScreen()
    {
        return screenStack.peek();
    }

    public static void changeScreen(ScreenEnum screenEnum)
    {
        switch(screenEnum) {
            default: return;
        }
    }
}
