import java.time.LocalDate;

public class MusicPlayerApp {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        LocalDate date = LocalDate.of(2023,1,1);
        LocalDate date1 = LocalDate.of(2023,2,1);
        LocalDate date2 = LocalDate.of(2022,3,1);
        player.addSong(new Song("YO Mama", "Yo Yo oi", date));
        player.addSong(new Song("bu hu hu", "Yo Yo oi", date1));
        player.addSong(new Song("hahahahahha", "acha", date2));
        
        player.playSong("YO Mama", "Yo Yo oi");
        player.playSong("YO Mama", "Yo Yo oi");
        player.playSong("bu hu hu", "Yo Yo oi");

//        player.mostPopularSongByArtist("Yo Yo oi");
//        player.mostPopularSongOverall();
        LocalDate date3 = LocalDate.of(2021,11,7);
        player.nPopularSongBeforeDate(1,date3);
        player.nPopularSongOverall(2);
        player.displayAllSongs();

        csvReader playlist = new csvReader();
        tsvReader playlist1 = new tsvReader();
        playlist.read();
        playlist1.read();
    }

    public void readPlaylist( FileReader f){
        f.read();
    }
}