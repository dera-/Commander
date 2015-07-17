package com.commander.domain.factory;

import com.badlogic.gdx.utils.Array;
import com.commander.infrastructure.AttackSkillEntityAccessor;
import com.commander.infrastructure.CharacterSkillEntityAccessor;
import com.commander.infrastructure.DefenseSkillEntityAccessor;
import com.commander.infrastructure.RecoverSkillEntityAccessor;
import com.commander.infrastructure.entity.CharacterSkillEntity;
import com.commander.infrastructure.entity.SkillEntity;

public class SkillEntityFactory
{
    public static SkillEntity[] getSkilEntities(int characterId)
    {
        Array<SkillEntity> skills = new Array<SkillEntity>();
        CharacterSkillEntity[] entities = (new CharacterSkillEntityAccessor()).getByCharacterId(characterId);
        for (CharacterSkillEntity entity : entities) {
            SkillEntity skill = null;
            if (entity.skillType.equals("attack")) {
                skill = (new AttackSkillEntityAccessor()).get(entity.skillId);
            } else if (entity.skillType.equals("defense")) {
                skill = (new DefenseSkillEntityAccessor()).get(entity.skillId);
            } else if (entity.skillType.equals("recover")) {
                skill = (new RecoverSkillEntityAccessor()).get(entity.skillId);
            }
            if (skill != null) {
                skills.add(skill);
            }
        }
        return skills.toArray();
    }
}
