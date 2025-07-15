package ClassQuestions.MusicPlaylist;
abstract class Navigation {
    abstract void current(String song);
    abstract void back();
    abstract void forward();
    abstract String getCurrentSong();
    
}
