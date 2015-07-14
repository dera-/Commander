package com.commander.infrastructure;

import com.commander.infrastructure.entity.DefenseSkillEntity;
import com.commander.infrastructure.file.DefenseSkillFileAccessor;

public class DefenseSkillEntityAccessor extends EntityAccessor
{

    public DefenseSkillEntityAccessor()
    {
        super(new DefenseSkillFileAccessor());
    }

    public DefenseSkillEntity get(int id)
    {
        return (DefenseSkillEntity)super.get(id);
    }

}
