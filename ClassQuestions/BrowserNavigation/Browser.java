public class Browser extends Navigation{
    private String url;
    private History current;

    public Browser(String home){
        current = new History(home);
    }

    @Override
    public void visit(String url) {
        History newNode = new History(url);
        current.forward = null; 
        newNode.prev = current;
        current.forward = newNode;
        current = newNode;
        System.out.println("Visited: " + url);
    }

     @Override
    public void back() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Moved Back to: " + current.url);
        } else {
            System.out.println("No back history.");
        }
    }

     @Override
    public void forward() {
        if (current.forward != null) {
            current = current.forward;
            System.out.println("Moved Forward to: " + current.url);
        } else {
            System.out.println("No forward history.");
        }
    }

      @Override
    public String getCurrentPage() {
        return current.url;
    }

    
}
