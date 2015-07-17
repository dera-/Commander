package com.commander.infrastructure.file;

import com.commander.config.FileConfig;
import com.commander.infrastructure.entity.BaseEntity;
import com.commander.infrastructure.entity.CharacterEntity;

public class CharacterFileAccessor extends CsvFileAccessor
{

    public CharacterFileAccessor()
    {
        super(FileConfig.CHARACTER_FILE_PATH);
    }

    @Override
    protected BaseEntity getBaseEntity(String[] record)
    {
        CharacterEntity entity = new CharacterEntity();
        entity.id = Integer.parseInt(record[0]);
        entity.name = record[1];
        entity.imageKey = record[2];
        entity.hp = Integer.parseInt(record[3]);
        entity.attack = Integer.parseInt(record[4]);
        entity.defense = Integer.parseInt(record[5]);
        entity.hit = Integer.parseInt(record[6]);
        entity.avoid = Integer.parseInt(record[7]);
        entity.luck = Integer.parseInt(record[8]);
        entity.magicAttack = Integer.parseInt(record[9]);
        entity.magicDefense = Integer.parseInt(record[10]);
        entity.speed = Integer.parseInt(record[11]);
        entity.move = Integer.parseInt(record[12]);
        entity.brainId = Integer.parseInt(record[13]);
        return entity;
    }

}
