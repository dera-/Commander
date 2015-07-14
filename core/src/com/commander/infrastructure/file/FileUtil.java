package com.commander.infrastructure.file;

import java.io.IOException;
import java.io.Reader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.commander.config.FileConfig;
import com.commander.config.ServerConfig;

public class FileUtil
{
    public static FileHandle getFileHandle(String filePath)
    {
        if (FileConfig.USE_INNER_FILE) {
            return Gdx.files.internal(filePath);
        } else {
            return Gdx.files.external(ServerConfig.FILE_SERVER_URL + filePath);
        }
    }

    public static void closeReader(Reader reader)
    {
        if (reader == null) return;
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

