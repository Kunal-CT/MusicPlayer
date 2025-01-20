package com.spotify.application.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class csvReader implements fileHandler {
    @Override
    public void get() {
        System.out.println("Reading from CSV file");
        Scanner sc = null;
        try {
            sc = new Scanner(new File("/Users/kunal.singh/Desktop/Trial Prac/application/src/main/java/com/spotify/application/controllers/csvDemo.csv"));
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                System.out.print(sc.next());
                System.out.print("\n");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void post(String[][] data) {
        System.out.println("Writing to CSV file");
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("/Users/kunal.singh/Desktop/Trial Prac/application/src/main/java/com/spotify/application/controllers/csvDemo.csv"));
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {

                    writer.write(data[i][j]);
                    if (j < data[i].length - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }

            System.out.println("Data written successfully to CSV file");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to CSV file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while writing to CSV file: " + e.getMessage());
            }
        }
    }
}
