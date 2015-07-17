package com.commander.domain.factory;

import com.commander.domain.model.BrainModel;
import com.commander.infrastructure.BrainEntityAccessor;

public class BrainModelFactory
{
    public static BrainModel getBrainModel(int brainId)
    {
        return new BrainModel((new BrainEntityAccessor()).get(brainId));
    }
}
