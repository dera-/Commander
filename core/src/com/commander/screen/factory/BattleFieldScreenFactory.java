package com.commander.screen.factory;

import com.badlogic.gdx.math.Vector2;
import com.commander.domain.factory.SkillEntityFactory;
import com.commander.domain.model.CharacterModel;
import com.commander.domain.model.MapModel;
import com.commander.domain.service.BattleFieldService;
import com.commander.infrastructure.CharacterEntityAccessor;
import com.commander.infrastructure.MapChipEntityAccessor;
import com.commander.infrastructure.entity.CharacterEntity;
import com.commander.infrastructure.entity.MapChipEntity;
import com.commander.infrastructure.entity.SkillEntity;
import com.commander.infrastructure.file.StageCharactersFileReader;
import com.commander.infrastructure.file.StageMapFileReader;
import com.commander.screen.battlefield.BattleFieldScreen;
import com.commander.view.object.CharacterDotView;
import com.commander.view.object.MapChipView;

public class BattleFieldScreenFactory
{
    public static BattleFieldScreen getScreen(int id)
    {
        MapChipEntity[][] mapChips = getMapChips((new StageMapFileReader()).getMapStrings(id));
        String[] charaData = (new StageCharactersFileReader()).getCharactersStrings(id);
        TemporaryCharaData[] characters = new TemporaryCharaData[charaData.length];
        for (int index = 0; index < characters.length; index++) {
            characters[index] = new TemporaryCharaData(index+1, charaData[index]);
        }
        BattleFieldService service = new BattleFieldService(getMapModel(mapChips), getCharacterModels(characters));
        BattleFieldView view = new BattleFieldView(getMapChipViews(mapChips), getCharacterDotViews(characters));
    }

    private static MapModel getMapModel(MapChipEntity[][] mapchips)
    {
        return new MapModel(mapchips);
    }

    private static CharacterModel[] getCharacterModels(TemporaryCharaData[] data)
    {
        CharacterModel[] characters = new CharacterModel[data.length];
        for (int index = 0; index < data.length; index++) {
            SkillEntity[] skillEntities = SkillEntityFactory.getSkilEntities(data[index].charaEntity.id);
            characters[index] = new CharacterModel(data[index].id, data[index].charaType, data[index].charaEntity, skillEntities, data[index].place);
        }
        return characters;
    }

    private static MapChipView[] getMapChipViews(MapChipEntity[][] mapchips)
    {
        int size = mapchips.length * mapchips[0].length;
        MapChipView[] views = new MapChipView[size];
        for (int y = 0; y < mapchips.length; y++) {
            for (int x =0; x < mapchips[y].length ; x++) {
                views[mapchips[y].length*y + x] = new MapChipView(mapchips[y][x], x, y);
            }
        }
        return views;
    }

    private static CharacterDotView[] getCharacterDotViews(TemporaryCharaData[] data)
    {
        CharacterDotView[] views = new CharacterDotView[data.length];
        for (int i = 0; i < views.length; i++) {
            views[i] = new CharacterDotView(data[i].charaEntity, (int)data[i].place.x, (int)data[i].place.y);
        }
        return views;
    }

    private static MapChipEntity[][] getMapChips(String[] lines)
    {
        MapChipEntity[][] entities = new MapChipEntity[lines.length][lines[0].length()];
        for (int y = lines.length-1; y >= 0; y--) {
            char[] data = lines[y].toCharArray();
            for (int x = 0; x < data.length; x++) {
                entities[lines.length-y-1][x] = (new MapChipEntityAccessor()).getByChipType(Character.toString(data[x]));
            }
        }
        return entities;
    }
}

class TemporaryCharaData
{
    int id;
    int charaType;
    CharacterEntity charaEntity;
    Vector2 place;

    public TemporaryCharaData(int id, String line)
    {
        this.id = id;
        String[] data = line.split(",");
        charaType = Integer.parseInt(data[0]);
        charaEntity = (new CharacterEntityAccessor()).get(Integer.parseInt(data[1]));
        place = new Vector2(Float.parseFloat(data[2]), Float.parseFloat(data[3]));
    }
}
