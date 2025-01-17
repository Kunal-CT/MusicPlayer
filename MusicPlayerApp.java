public class MusicPlayerApp {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.addSong(new Song("YO Mama", "Yo Yo oi", "2023-01-01"));
        player.addSong(new Song("bu hu hu", "Yo Yo oi", "2023-02-01"));
        player.addSong(new Song("hahahahahha", "acha", "2023-03-01"));
        
        player.playSong("YO Mama", "Yo Yo oi");
        player.playSong("YO Mama", "Yo Yo oi");
        player.playSong("bu hu hu", "Yo Yo oi");

        player.mostPopularSongByArtist("Yo Yo oi");
        player.mostPopularSongOverall();
        player.songsByDate("2023-01-01");
        player.nPopularSongOverall(2);
        player.displayAllSongs();
    }
}