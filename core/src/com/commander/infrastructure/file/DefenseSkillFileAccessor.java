package com.commander.infrastructure.file;

import com.commander.config.FileConfig;
import com.commander.infrastructure.entity.BaseEntity;
import com.commander.infrastructure.entity.DefenseSkillEntity;

public class DefenseSkillFileAccessor extends CsvFileAccessor {

    public DefenseSkillFileAccessor() {
        super(FileConfig.DEFENSE_SKILL_FILE_PATH);
    }

    @Override
    protected BaseEntity getBaseEntity(String[] record) {
        DefenseSkillEntity entity = new DefenseSkillEntity();
        entity.id = Integer.parseInt(record[0]);
        entity.limit = Integer.parseInt(record[1]);
        entity.defence = Double.parseDouble(record[2]);
        entity.avoid = Double.parseDouble(record[3]);
        entity.magicDefense = Double.parseDouble(record[4]);
        return entity;
    }

}
