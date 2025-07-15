abstract class Navigation {
    abstract void visit(String url);
    abstract void back();
    abstract void forward();
    abstract String getCurrentPage();
    
}
