package com.commander.domain.service;

import com.commander.domain.model.CharacterModel;
import com.commander.domain.model.MapModel;
import com.commander.domain.repository.CharacterModelRepository;

public class BattleFieldService
{
    private MapModel map;
    private CharacterModel[] characters;

    public BattleFieldService(MapModel map, CharacterModel[] characters)
    {
        this.map = map;
        this.characters = characters;
        CharacterModelRepository.initialize();
        CharacterModelRepository.setCharacters(characters);
        CharacterModelRepository.setActionSpeeds();
    }
}
