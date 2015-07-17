package com.commander.domain.repository;

import com.badlogic.gdx.utils.Array;
import com.commander.domain.model.ActionSpeedModel;
import com.commander.domain.model.CharacterModel;
import com.commander.domain.service.CharacterSortingService;

public class CharacterModelRepository
{
    private static Array<CharacterModel> currentCharacters;
    private static Array<ActionSpeedModel> actionSpeeds;

    public static void initialize()
    {
        currentCharacters.clear();
        actionSpeeds.clear();
    }

    public static void setCharacters(CharacterModel[] characters)
    {
        currentCharacters.addAll(characters);
    }

    public static void setActionSpeeds()
    {
        actionSpeeds = CharacterSortingService.getSortedCharacters(currentCharacters);
    }

    public static void updateActionSpeeds()
    {
        CharacterSortingService.updateSortedCharacters(actionSpeeds);
    }

    public static CharacterModel getActiveCharacter()
    {
        return getCharacterModel(actionSpeeds.get(0).getCharacterId());
    }

    public static CharacterModel getCharacterModel(int id)
    {
        for (CharacterModel chara : currentCharacters) {
            if (id == chara.getId()) {
                return chara;
            }
        }
        return null;
    }

    public static void deleteCurrentCharacter(int id)
    {
        CharacterModel targetChara = getCharacterModel(id);
        CharacterSortingService.deleteCharacter(actionSpeeds, targetChara);
        currentCharacters.removeValue(targetChara, true);
    }

}
