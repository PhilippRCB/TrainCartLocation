package com.example.traincartlocation;

import java.io.File;

public class FileFinder {
    private String fileName = "";
    private final File xmlFile;
    public FileFinder (String ril100){
        fileName = findFile(ril100 + "_");
        xmlFile = new File(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    private String findFile(String ril100) {
        File[] dataFiles = new File("./Data/TrainData/").listFiles();
        if (dataFiles == null) return "no File";
        for (File file : dataFiles) {
            String fileName = file.getName();
            if (fileName.toLowerCase().contains(ril100.toLowerCase()))
                return fileName;
        }
        return "no Match";
    }

    public File getXmlFile() {
        return xmlFile;
    }
}
