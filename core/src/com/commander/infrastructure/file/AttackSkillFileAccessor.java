package com.commander.infrastructure.file;

import com.commander.config.FileConfig;
import com.commander.infrastructure.entity.AttackSkillEntity;
import com.commander.infrastructure.entity.BaseEntity;

public class AttackSkillFileAccessor extends CsvFileAccessor
{

    public AttackSkillFileAccessor() {
        super(FileConfig.ATTACK_SKILL_FILE_PATH);
    }

    @Override
    protected BaseEntity getBaseEntity(String[] record) {
        AttackSkillEntity entity = new AttackSkillEntity();
        entity.id = Integer.parseInt(record[0]);
        entity.limit = Integer.parseInt(record[1]);
        entity.range = Integer.parseInt(record[2]);
        entity.attack = Double.parseDouble(record[3]);
        entity.hit = Double.parseDouble(record[4]);
        entity.magicAttack = Double.parseDouble(record[5]);
        return entity;
    }

}
