package ClassQuestions.MusicPlaylist;

public class Spotify extends Navigation {
    private String play;
    private Queue current;

    public Spotify(String play){
        current = new Queue(play);
    }

    @Override
    public void current(String song) {
        Queue newNode = new Queue(song);
        current.next = null; 
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
        System.out.println("Visited: " + song);
    }

     @Override
    public void back() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Moved Back to: " + current.song);
        } else {
            System.out.println("No back queue.");
        }
    }

     @Override
    public void forward() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Moved Next to: " + current.song);
        } else {
            System.out.println("No next queue.");
        }
    }

      @Override
    public String getCurrentSong() {
        return current.song;
    }

    public void showPlaylist() {
    Queue temp = current;
    // Move to the start of the playlist
    while (temp.prev != null) {
        temp = temp.prev;
    }

    System.out.println("\n Your Playlist:");
    while (temp != null) {
        System.out.println("- " + temp.song);
        temp = temp.next;
    }
    }


}
