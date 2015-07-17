package com.commander.infrastructure.file;

import com.commander.config.FileConfig;
import com.commander.infrastructure.entity.BaseEntity;
import com.commander.infrastructure.entity.MapChipEntity;

public class MapChipFileAccessor extends CsvFileAccessor
{

    public MapChipFileAccessor()
    {
        super(FileConfig.MAPCHIP_FILE_PATH);
    }

    @Override
    protected BaseEntity getBaseEntity(String[] record)
    {
        MapChipEntity entity = new MapChipEntity();
        entity.id = Integer.parseInt(record[0]);
        entity.name = record[1];
        entity.imageKey = record[2];
        entity.chipType = record[3].charAt(0);
        entity.isMovable = record[4].equalsIgnoreCase("1") ? true : false;
        entity.move = Double.parseDouble(record[5]);
        entity.recover = Double.parseDouble(record[6]);
        entity.attack = Double.parseDouble(record[7]);
        entity.defence = Double.parseDouble(record[8]);
        entity.hit = Double.parseDouble(record[9]);
        entity.avoid = Double.parseDouble(record[10]);
        entity.magicAttack = Double.parseDouble(record[11]);
        entity.magicDefense = Double.parseDouble(record[12]);
        return entity;
    }

}
