package com.commander.infrastructure.file;

import com.commander.config.FileConfig;
import com.commander.infrastructure.entity.BaseEntity;
import com.commander.infrastructure.entity.RecoverSkillEntity;

public class RecoverSkillFileAccessor extends CsvFileAccessor {

    public RecoverSkillFileAccessor() {
        super(FileConfig.RECOVER_SKILL_FILE_PATH);
    }

    @Override
    protected BaseEntity getBaseEntity(String[] record) {
        RecoverSkillEntity entity = new RecoverSkillEntity();
        entity.id = Integer.parseInt(record[0]);
        entity.imageKey = record[1];
        entity.limit = Integer.parseInt(record[2]);
        entity.range = Integer.parseInt(record[3]);
        entity.recover = Integer.parseInt(record[4]);
        entity.recoverRange = Integer.parseInt(record[5]);
        return entity;
    }

}
