package com.commander.domain.service;

import com.badlogic.gdx.utils.Array;
import com.commander.domain.model.ActionSpeedModel;
import com.commander.domain.model.CharacterModel;

public class CharacterSortingService
{
    public static Array<ActionSpeedModel> getSortedCharacters(Array<CharacterModel> characters)
    {
        Array<ActionSpeedModel> sortedCharacters = new Array<ActionSpeedModel>();
        for (CharacterModel chara : characters) {
            addCharacter(sortedCharacters, new ActionSpeedModel(chara));
        }
        return sortedCharacters;
    }

    public static void updateSortedCharacters(Array<ActionSpeedModel> sortedCharacters)
    {
        ActionSpeedModel action = sortedCharacters.removeIndex(0);
        for (ActionSpeedModel model : sortedCharacters) {
            model.reduceRestDistance(action.getRestDistance());
        }
        addCharacter(sortedCharacters, new ActionSpeedModel(action, true));
    }

    public static void deleteCharacter(Array<ActionSpeedModel> sortedCharacters, CharacterModel chara)
    {
        for (ActionSpeedModel model : sortedCharacters) {
            if (model.getCharacterId() == chara.getId()) {
                sortedCharacters.removeValue(model, true);
                return;
            }
        }
    }

    private static void addCharacter(Array<ActionSpeedModel> sortedCharacters, ActionSpeedModel newModel)
    {
        for (int index = 0; index < sortedCharacters.size; index++) {
            ActionSpeedModel model = sortedCharacters.get(index);
            if (newModel.getWaitTime() < model.getWaitTime()) {
                sortedCharacters.set(index, newModel);
                return;
            }
        }
        sortedCharacters.add(newModel);
    }

    public static Array<ActionSpeedModel> getNextOtherActions(Array<ActionSpeedModel> sortedCharacters)
    {
        Array<ActionSpeedModel> clone = getCloneSortedCharacters(sortedCharacters);
        Array<ActionSpeedModel> otherActions = new Array<ActionSpeedModel>();
        int targetCharaId = clone.get(0).getCharacterId();
        updateSortedCharacters(clone);
        while (targetCharaId != clone.get(0).getCharacterId()) {
            otherActions.add(clone.get(0));
            updateSortedCharacters(clone);
        }
        return otherActions;
    }

    private static Array<ActionSpeedModel> getCloneSortedCharacters(Array<ActionSpeedModel> sortedCharacters)
    {
        Array<ActionSpeedModel> clone = new Array<ActionSpeedModel>();
        for (ActionSpeedModel action : sortedCharacters) {
            clone.add(new ActionSpeedModel(action, false));
        }
        return clone;
    }
}
