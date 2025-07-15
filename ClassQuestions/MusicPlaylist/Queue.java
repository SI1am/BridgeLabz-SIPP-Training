package ClassQuestions.MusicPlaylist;

public class Queue {
    String song;
    Queue prev;
    Queue next;
    public Queue(String song) {
    this.song = song;
    this.prev = null;
    this.next = null;
}

}
