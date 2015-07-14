package com.commander.infrastructure;

import com.commander.infrastructure.entity.RecoverSkillEntity;
import com.commander.infrastructure.file.RecoverSkillFileAccessor;

public class RecoverSkillEntityAccessor extends EntityAccessor
{

    public RecoverSkillEntityAccessor()
    {
        super(new RecoverSkillFileAccessor());
    }

    public RecoverSkillEntity get(int id)
    {
        return (RecoverSkillEntity)super.get(id);
    }

}
