package com.commander.infrastructure;

import com.commander.config.GameConfig;
import com.commander.infrastructure.entity.BaseEntity;
import com.commander.infrastructure.entity.CharacterSkillEntity;
import com.commander.infrastructure.file.CharacterSkillFileAccessor;

public class CharacterSkillEntityAccessor extends EntityAccessor
{
    public CharacterSkillEntityAccessor()
    {
        super(new CharacterSkillFileAccessor());
    }

    public CharacterSkillEntity get(int id)
    {
        return (CharacterSkillEntity) super.get(id);
    }

    public CharacterSkillEntity[] getByCharacterId(int characterId)
    {
        if (GameConfig.USE_DATABASE) {
            return null;
        } else {
            BaseEntity[] entities = csvFileAccessor.getRecords("character_id", Integer.toString(characterId));
            CharacterSkillEntity[] characterSkillEntities = new CharacterSkillEntity[entities.length];
            for (int i = 0; i < characterSkillEntities.length; i++) {
                characterSkillEntities[i] = (CharacterSkillEntity)entities[i];
            }
            return characterSkillEntities;
        }
    }

}
