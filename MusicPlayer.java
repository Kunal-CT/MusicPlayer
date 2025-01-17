import java.time.LocalDate;
import java.util.TreeSet;

class MusicPlayer {
    private TreeSet<Song> songs;

    public MusicPlayer() {
        songs = new TreeSet<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void changeDate(LocalDate date, String title){
        for( Song song: songs){
            if(song.getTitle().equalsIgnoreCase(title)){
                song.dateChange(date);
            }
        }
    }

    public void playSong(String title, String artist) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title) && song.getArtist().equalsIgnoreCase(artist)) {
                songs.remove(song);
                song.incrementPlayCount();
                songs.add(song);
                System.out.println("Playing: " + song + "\n");
                return;
            }
        }
        System.out.println("Song not found.");
    }

    public void playSong( String title, String artist, LocalDate date){
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title) && song.getArtist().equalsIgnoreCase(artist) && song.getDate().isEqual(date)) {
                songs.remove(song);
                song.incrementPlayCount();
                songs.add(song);
                System.out.println("Playing: " + song + "\n");
                return;
            }
        }
        System.out.println("Song not found.");
    }


    public void nPopularSongOverall(int n) {
        if (!songs.isEmpty()) {
            int i = 1 ;
            for( Song song : songs ) {
                if (i < n + 1) {
                    System.out.println(i + "th popular song overall is : ");
                    System.out.println(song);
                    i++;
                }
            }
            System.out.println("\n");
        } else {
            System.out.println("No songs available." + "\n");
        }
    }

    public void nPopularSongOverall(int n, String artist) {
        if (!songs.isEmpty()) {
            int i = 1 ;
            for( Song song : songs ) {
                if (i < n + 1 && song.getTitle().equals(artist)) {
                    System.out.println(i + "th popular song overall is : ");
                    System.out.println(song);
                    i++;
                }
            }
            System.out.println("\n");
        } else {
            System.out.println("No songs available." + "\n");
        }
    }
    public void nPopularSongOnDate(int n, LocalDate date) {
        if (!songs.isEmpty()) {
            int i = 1 ;
            for( Song song : songs ) {
                if (i < n + 1 && song.getDate().isEqual(date)) {
                    System.out.println(i + "th popular song overall is : ");
                    System.out.println(song);
                    i++;
                }
            }
            System.out.println("\n");
        } else {
            System.out.println("No songs available." + "\n");
        }
    }

    public void nPopularSongBeforeDate(int n, LocalDate date) {
        if (!songs.isEmpty()) {
            int i = 1 ;
            for( Song song : songs ) {
                if (i < n + 1 && song.getDate().isBefore(date)) {
                    System.out.println(i + "th popular song overall is : ");
                    System.out.println(song);
                    i++;
                }
            }
            System.out.println("\n");
        } else {
            System.out.println("No songs available." + "\n");
        }
    }

    public void songByDate(LocalDate date) {
        boolean found = false;
        for (Song song : songs) {
            if (song.getDate().isBefore(date)) {
                System.out.println(song);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No songs found for the specified date." + "\n");
        }
    }

    public void displayAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs available." + "\n");
        } else {
            System.out.println("All Songs:" ) ;
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }
}

//import java.util.HashMap;
//import java.util.*;
//import java.util.PriorityQueue;
//
//public class MusicPlayer {
//
//    public static void main( String[] args){
//        Songs song = new Songs("Test", 1);
//        Map<String, PriorityQueue<Songs>> mapSong = new HashMap<String, PriorityQueue<Songs>>();
//
//    }
//
//    public String addSong(Map<String, PriorityQueue<Songs>> mapSong, String singer, Songs song){
//        mapSong.computeIfAbsent(singer, k -> new PriorityQueue<>()).offer(song);
//        return song + " added successfully under " + singer;
//    }
//
//    public void songs(Map<String, PriorityQueue<Songs>> mapSong, String singer){
//        if(mapSong.containsKey(singer)){
//            PriorityQueue<Songs> songs = mapSong.get(singer);
//            System.out.println("Singer found successfully");
//            while( !songs.isEmpty()){
//                System.out.println(songs.poll());
//            }
//
//        }else{
//            System.out.println("No such singer exists");
//        }
//    }
//
//
//
//}

//    public void songsByDate(String date) {
//        boolean found = false;
//        for (Song song : songs) {
//            if (song.getDateOfPublish().equals(date)) {
//                System.out.println(song);
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("No songs found for the specified date." + "\n");
//        }
//    }

//    public void mostPopularSongByArtist(String artist) {
//        Song mostPopular = null;
//        for (Song song : songs) {
//            if (song.getArtist().equalsIgnoreCase(artist)) {
//                mostPopular = song;
//                break;
//            }
//        }
//        if (mostPopular != null) {
//            System.out.println("Most popular song by " + artist + ": " + mostPopular + "\n");
//        } else {
//            System.out.println("No songs found by " + artist + "\n");
//        }
//    }
//
//    public void mostPopularSongOverall() {
//        if (!songs.isEmpty()) {
//            System.out.println("Most popular song overall: " + songs.first() + "\n");
//        } else {
//            System.out.println("No songs available." + "\n");
//        }
//    }
