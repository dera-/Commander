package com.commander.infrastructure;

import com.commander.config.GameConfig;
import com.commander.infrastructure.entity.BaseEntity;
import com.commander.infrastructure.file.CsvFileAccessor;


public abstract class EntityAccessor
{
    protected CsvFileAccessor csvFileAccessor;

    public EntityAccessor(CsvFileAccessor csv)
    {
        csvFileAccessor = csv;
    }

    public BaseEntity get(int id)
    {
        if (GameConfig.USE_DATABASE) {
            //TODO データベースから値を取得する場合
            return null;
        } else {
            return csvFileAccessor.getRecordById(Integer.toString(id));
        }
    }
}
