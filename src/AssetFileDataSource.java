package com.computer.trading.client.ui.model;



import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.computer.trading.client.controller.AssetController;
import com.computer.trading.client.util.Configuration;
import com.computer.trading.common.Constants;
import com.computer.trading.common.beans.Asset;

public class AssetFileDataSource implements AssetInfoDataSource {
   

    /**
     * Storage for the asset objects, name is the unique key per asset.
     */
    private HashMap<String, Asset> data;

    private AssetController  controller;
    /**
     * If any of the data has changed, this will be set to true.
     */
    private boolean dataChanged = false;

    public AssetFileDataSource() {
        data = new HashMap<>();
        controller = new AssetController(Configuration.getInstance(Constants.CLIENT_CONFIG_PATH));

        List<Asset> assets = controller.getAllAssets();
        for(Asset a: assets) {
        	data.put(a.getName(), a);
        }
        
    }

    @Override
    public void addAsset(Asset p) {
        if (p == null)
            throw new IllegalArgumentException("Asset cannot be null");

        // map[name] = p
        data.put(p.getName(), p);
        dataChanged = true;
    }

    @Override
    public Asset getAsset(String name) {
        // look the asset up by their name, if they exist, return the asset,
        // otherwise return null
        return data.getOrDefault(name, null);
    }

    @Override
    public int getSize() {
        // return the number of entries or keys in our hash map
        return data.size();
    }

    @Override
    public void deleteAsset(String name) {
        // remove the asset from the map with this name (or key)
        data.remove(name);
        dataChanged = true;
    }

    @Override
    public void close() {
        // has the data changed? do we need to update the file?
        if (!dataChanged)
            return;

        /**
         * open up the stream for writing the objects to
         * if this file already exists, it will be overwritten
         */
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(Constants.ASSET_PATH))) {
            // save the hash map to the file
            // it's recursive in this case, so it saves all the keys as well as the values (Asset)
            stream.writeObject(data);

            // make sure it's all written
            // this doesn't matter so much for files, since there's an implicit flush() before closing
            // but for network sockets it absolutely does matter, see the readme.
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> nameSet() {
     
        return data.keySet();
    }      
}
