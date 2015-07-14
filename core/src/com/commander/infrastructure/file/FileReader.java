package com.commander.infrastructure.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.badlogic.gdx.utils.Array;

public class FileReader
{
    public String[] getStrings(String filePath)
    {
        Array<String> strings = new Array<String>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(FileUtil.getFileHandle(filePath).read()));
            String line;
            while ((line = reader.readLine()) !=null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileUtil.closeReader(reader);
        }
        return strings.toArray();
    }
}
