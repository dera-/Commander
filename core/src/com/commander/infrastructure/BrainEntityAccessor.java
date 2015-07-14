package com.commander.infrastructure;

import com.commander.infrastructure.file.BrainFileAccessor;

public class BrainEntityAccessor extends EntityAccessor
{
    public BrainEntityAccessor()
    {
        super(new BrainFileAccessor());
    }

    public BrainEntity get(int id)
    {
        return (BrainEntity) super.get(id);
    }

}
