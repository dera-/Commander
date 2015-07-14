package com.commander.infrastructure.file;

import com.commander.config.FileConfig;
import com.commander.infrastructure.entity.BaseEntity;
import com.commander.infrastructure.entity.CharacterSkillEntity;

public class CharacterSkillFileAccessor extends CsvFileAccessor {

    public CharacterSkillFileAccessor() {
        super(FileConfig.CHARACTER_SKILL_FILE_PATH);
    }

    @Override
    protected BaseEntity getBaseEntity(String[] record) {
        CharacterSkillEntity entity = new CharacterSkillEntity();
        entity.id = Integer.parseInt(record[0]);
        entity.characterId = Integer.parseInt(record[1]);
        entity.skillId = Integer.parseInt(record[2]);
        entity.skillType = record[3];
        return entity;
    }

}
