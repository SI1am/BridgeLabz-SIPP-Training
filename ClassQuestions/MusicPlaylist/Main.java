package ClassQuestions.MusicPlaylist;


public class Main {
    public static void main(String[] args) {
        Spotify musicPlaylist = new Spotify("play");
        musicPlaylist.current("Savariya sarkar");
        musicPlaylist.current("Chhery chhery lady");
        musicPlaylist.current("Pretty Little baby");
        musicPlaylist.current("Meradesh");
        musicPlaylist.back();
        System.out.println("Current song:" + musicPlaylist.getCurrentSong());
        musicPlaylist.forward();
        System.out.println("Current song:" + musicPlaylist.getCurrentSong());
        musicPlaylist.showPlaylist();

    }
    
}
