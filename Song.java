import java.time.LocalDate;
import java.util.*;

class Song implements Comparable<Song> {
    private String title;
    private String artist;
//    private String dateOfPublish;
    private int playCount;
    private LocalDate date;

//    public Song(String title, String artist, String dateOfPublish) {
//        this.title = title;
//        this.artist = artist;
//        this.dateOfPublish = dateOfPublish;
//        this.playCount = 0;
////        if( !date == NULL)
//        this.date = LocalDate.now();
//    }

    public Song(String title, String artist, LocalDate date){
        this.title = title;
        this.artist = artist;
        this.playCount = 0;
        this.date = date ;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

//    public String getDateOfPublish() {
//        return dateOfPublish;
//    }

    public LocalDate getDate(){
        return date;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void incrementPlayCount() {
        playCount++;
    }

    public void dateChange( LocalDate date){
        this.date = date;
    }

    @Override
    public int compareTo(Song other) {
        if (this.playCount != other.playCount) {
            return Integer.compare(other.playCount, this.playCount);
        }
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Date: " + date + ", Plays: " + playCount;
    }
}



