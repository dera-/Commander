package com.commander.infrastructure;

import com.commander.infrastructure.entity.CharacterEntity;
import com.commander.infrastructure.file.CharacterFileAccessor;

public class CharacterEntityAccessor extends EntityAccessor
{

    public CharacterEntityAccessor()
    {
        super(new CharacterFileAccessor());
    }

    public CharacterEntity get(int id)
    {
        return (CharacterEntity)super.get(id);
    }

}
