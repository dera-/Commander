package com.commander.infrastructure.file.image;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.commander.infrastructure.file.FileUtil;

public class TextureRepository
{
    private static ObjectMap<String,Texture> textureMap = new ObjectMap<String,Texture>();
    private static ObjectMap<String,TextureRegion[]> textureRegionMap = new ObjectMap<String,TextureRegion[]>();

    public static void setTexture(String name, Texture texture)
    {
        textureMap.put(name, texture);
    }

    public static Texture getTexture(String name)
    {
        return textureMap.get(name);
    }

    public static Texture generateTexture(String path, String name)
    {
        if (textureMap.containsKey(name)) {
            return textureMap.get(name);
        }
        Texture texture = new Texture(FileUtil.getFileHandle(path));
        setTexture(name, texture);
        return texture;
    }

    public static void setTextureRegions(String name, TextureRegion[] regions)
    {
        textureRegionMap.put(name, regions);
    }

    public static TextureRegion[] getTextureRegion(String name)
    {
        return textureRegionMap.get(name);
    }

    public static TextureRegion[] generateTextureRegions(String path, String name, int w, int h)
    {
        if (textureRegionMap.containsKey(name)) {
            return getTextureRegion(name);
        }
        Texture texture = new Texture(FileUtil.getFileHandle(path));
        Array<TextureRegion> list = new Array<TextureRegion>();
        TextureRegion[][] regions = new TextureRegion(texture).split(w, h);
        for (int i=0; i<regions.length; i++) {
            for (int j=0; j<regions[i].length; j++) {
                list.add(regions[i][j]);
            }
        }
        TextureRegion[] region = list.toArray(TextureRegion.class);
        setTextureRegions(name, region);
        return region;
    }

    public static TextureRegion[] getTextureRegions(String[] paths, String[] keys, int num)
    {
        TextureRegion[] regions = new TextureRegion[num];
        for (int i=0; i<num; i++) {
            regions[i] = new TextureRegion(generateTexture(paths[i], keys[i]));
        }
        return regions;
    }
}
