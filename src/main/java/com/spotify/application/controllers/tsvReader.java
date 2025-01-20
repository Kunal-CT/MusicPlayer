package com.spotify.application.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class tsvReader implements fileHandler {

    @Override
    public void get() {
        System.out.println("Reading from TSV file");
        Scanner sc = null;
        try {
            sc = new Scanner(new File("/Users/kunal.singh/Downloads/demo/src/main/java/tsvDemo.tsv"));
            sc.useDelimiter("\t");
            while (sc.hasNext()) {
                System.out.print(sc.next() + " ");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void post( String[][] data) {
        System.out.println("Writing to TSV file");
        FileWriter writer = null;
        try {

            writer = new FileWriter(new File("/Users/kunal.singh/Downloads/demo/src/main/java/tsvDemo.tsv"));

            for (String[] datum : data) {
                for (int j = 0; j < datum.length; j++) {

                    writer.write(datum[j]);
                    if (j < datum.length - 1) {
                        writer.write("\t");
                    }
                }
                writer.write("\n");
            }

            System.out.println("Data written successfully to TSV file");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to TSV file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while writing to TSV file: " + e.getMessage());
            }
        }
    }
}
