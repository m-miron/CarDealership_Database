package com.yu.dealership;

import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
//    String contractFilename;
//    public ContractFileManager (String contractFilename) {
//        this.contractFilename = contractFilename;
//    }
    public static String contractFileName = "ContractsList";
    public void saveContract (Contract c) {
        //Write to file

        //TODO: Implement logic for saving a new dealership.
        try (FileWriter fileWriter = new FileWriter(contractFileName, false)) {
                //c.getPersistentString() is what we write to file (if-else?)
                fileWriter.write(c.getPersistentString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
