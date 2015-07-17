package com.commander.infrastructure;

import com.commander.infrastructure.entity.BaseEntity;
import com.commander.infrastructure.entity.MapChipEntity;
import com.commander.infrastructure.file.MapChipFileAccessor;

public class MapChipEntityAccessor extends EntityAccessor
{

    public MapChipEntityAccessor()
    {
        super(new MapChipFileAccessor());
    }

    public MapChipEntity get(int id)
    {
        return (MapChipEntity)super.get(id);
    }

    public MapChipEntity getByChipType(String type)
    {
        BaseEntity[] records = super.csvFileAccessor.getRecords("chip_type", type);
        return records.length == 0 ? null : (MapChipEntity)records[0];
    }

}
