package com.spotify.application.controllers;

import com.spotify.application.SongInformation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import jakarta.annotation.PreDestroy;
import java.util.concurrent.Executors;


@RestController
public class SongsController {
    private List<SongInformation> songList = new ArrayList<>();
    private SongInformation songInformation;
    private final ExecutorService executorService = Executors.newCachedThreadPool();


    @PostMapping("/add-songs")
    public  void addSong(@RequestBody SongInformation songInformation) {
        // Add song logic
        songList.add(songInformation);
        System.out.println("Song addition success");
    }

    @GetMapping("/get-songs")
    public String getSong() {
        // Get song logic
        String song = songList.get(0).getSongArtist();
        return "Song 123 .... Retrieval successful" + songList.get(0);
    }

    @GetMapping("/csv-playlist")
    public void csvPlaylist() {
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

    @PreDestroy
    public void shutdownExecutor() {
        executorService.shutdown();
    }


    @PostMapping("/add-playlist")
    public void addCsv(@RequestBody SongInformation songInformation) {
        String fileType = songInformation.getFileType();
        String[][] data = {
                {songInformation.getSongName(), songInformation.getSongArtist(), songInformation.getFileType()}
        };
        Runnable task = () -> {
            if (fileType.equalsIgnoreCase("csv")) {
                csvReader Csv = new csvReader();
                Csv.post(data);
            } else if (fileType.equalsIgnoreCase("tsv")) {
                tsvReader Tsv = new tsvReader();
                Tsv.post(data);
            } else {
                System.out.println("Invalid file type");
            }
        };
        executorService.submit(task);
    }
}
