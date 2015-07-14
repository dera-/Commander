package com.commander.infrastructure;

import com.commander.infrastructure.entity.AttackSkillEntity;
import com.commander.infrastructure.file.AttackSkillFileAccessor;
import com.commander.infrastructure.file.CsvFileAccessor;

public class AttackSkillEntityAccessor extends EntityAccessor
{
    public AttackSkillEntityAccessor()
    {
        super(new AttackSkillFileAccessor());
    }

    public AttackSkillEntity get(int id)
    {
        return (AttackSkillEntity) super.get(id);
    }
}
