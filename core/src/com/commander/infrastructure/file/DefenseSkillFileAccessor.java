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
        entity.imageKey = record[1];
        entity.limit = Integer.parseInt(record[2]);
        entity.defence = Double.parseDouble(record[3]);
        entity.avoid = Double.parseDouble(record[4]);
        entity.magicDefense = Double.parseDouble(record[5]);
        return entity;
    }

}
