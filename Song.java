import java.util.*;

class Song implements Comparable<Song> {
    private String title;
    private String artist;
    private String dateOfPublish;
    private int playCount;

    public Song(String title, String artist, String dateOfPublish) {
        this.title = title;
        this.artist = artist;
        this.dateOfPublish = dateOfPublish;
        this.playCount = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getDateOfPublish() {
        return dateOfPublish;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void incrementPlayCount() {
        playCount++;
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
        return "Title: " + title + ", Artist: " + artist + ", Date: " + dateOfPublish + ", Plays: " + playCount;
    }
}



