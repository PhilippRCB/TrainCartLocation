package com.example.traincartlocation;

import java.io.File;

public class FileFinder {

    private String fileName = "";
    public FileFinder (String ril100){
        fileName = findFile(ril100 + "_");
    }

    public String getFileName() {
        return fileName;
    }

    private String findFile(String ril100) {
        String directory = "./Data/TrainData/";
        File[] dataFiles = new File(directory).listFiles();
        if (dataFiles == null) return "no File";
        for (File file : dataFiles) {
            String fileName = directory + file.getName();
            if (fileName.toLowerCase().contains(ril100.toLowerCase()))
                return fileName;
        }
        return "no Match";
    }
}
