package com.commander.infrastructure.file;

import com.commander.config.FileConfig;

public class StageMapFileReader extends FileReader
{
    public String[] getMapStrings(int stageNum) {
        return getStrings(FileConfig.STAGE_DIR_PATH + FileConfig.MAP_FILE_PREFIX + stageNum + ".txt");
    }
}
