package com.commander.infrastructure.file;

import com.commander.config.FileConfig;

public class StageCharactersFileReader extends FileReader
{
    public String[] getCharactersStrings(int stageNum) {
        return getStrings(FileConfig.STAGE_DIR_PATH + FileConfig.CHARACTERS_FILE_PREFIX + stageNum + ".txt");
    }
}
