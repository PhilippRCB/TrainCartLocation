package com.example.traincartlocation;

import java.io.File;

public class FileFinder {

    private final String directory = "./Data/TrainData/";
    private String fileName = "";
    public FileFinder (String ril100){
        fileName = directory + findFile(ril100 + "_");
    }

    public String getFileName() {
        return fileName;
    }

    private String findFile(String ril100) {
        File[] dataFiles = new File(directory).listFiles();
        if (dataFiles == null) return "no File";
        for (File file : dataFiles) {
            String fileName = file.getName();
            if (fileName.toLowerCase().contains(ril100.toLowerCase()))
                return fileName;
        }
        return "no Match";
    }
}
