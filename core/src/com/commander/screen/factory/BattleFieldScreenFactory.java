package com.commander.screen.factory;

import com.badlogic.gdx.math.Vector2;
import com.commander.domain.model.CharacterModel;
import com.commander.domain.model.MapModel;
import com.commander.domain.service.BattleFieldService;
import com.commander.infrastructure.CharacterEntityAccessor;
import com.commander.infrastructure.entity.CharacterEntity;
import com.commander.infrastructure.entity.MapChipEntity;
import com.commander.infrastructure.file.StageCharactersFileReader;
import com.commander.infrastructure.file.StageMapFileReader;
import com.commander.screen.battlefield.BattleFieldScreen;

public class BattleFieldScreenFactory
{
    public static BattleFieldScreen getScreen(int id)
    {
        String[] mapData = (new StageMapFileReader()).getMapStrings(id);
        String[] charaData = (new StageCharactersFileReader()).getCharactersStrings(id);
        BattleFieldService service = new BattleFieldService(getMapModel(mapData), getCharacterModels(charaData));
        BattleFieldView = new BattleFieldView(getMapView(mapData), getCharacterViews(charaData));
    }

    private static MapModel getMapModel(MapChipEntity[][] mapchips)
    {

    }

    private static CharacterModel[] getCharacterModels(TemporaryCharaData[] data)
    {

    }

    private static MapView getMapView(MapChipEntity[][] mapchips)
    {

    }

    private static CharacterView[] getCharacterViews(TemporaryCharaData[] data)
    {

    }

    private static MapChipEntity[][] getMapChips(String[] lines)
    {
        MapChipEntity[][] entities = new MapChipEntity[lines.length][lines[0].length];
        for (int y = ) {

        }
    }
}

class TemporaryCharaData
{
    private int id;
    private int charaType;
    private CharacterEntity charaEntity;
    private Vector2 place;

    public TemporaryCharaData(int id, String line)
    {
        this.id = id;
        String[] data = line.split(",");
        charaType = Integer.parseInt(data[0]);
        charaEntity = (new CharacterEntityAccessor()).get(Integer.parseInt(data[1]));
        place = new Vector2(Float.parseFloat(data[2]), Float.parseFloat(data[3]));
    }
}
