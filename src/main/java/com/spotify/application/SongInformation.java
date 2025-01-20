package com.spotify.application;


import lombok.*;

@Data
public class SongInformation {
    private String songName;
    private String songArtist;
    private String fileType;

    public String getSongArtist() {
        System.out.println("Song Artist: " + songArtist);
        return songArtist;
    }

    public String getSongName() {
        System.out.println("Song Name: " + songName);
        return songName;
    }

    public String getFileType() {
        System.out.println("File Type: " + fileType);
        return fileType;
    }
//    public SongInformation(String songName, String songArtist) {
//        this.songName = songName;
//        this.songArtist = songArtist;
//    }

}
