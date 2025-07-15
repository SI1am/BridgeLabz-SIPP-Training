public class Main {
    public static void main(String[] args) {
        Browser browser = new Browser("www.google.com");

        browser.visit("www.walmart.com");
        browser.visit("www.github.com");
        browser.visit("www.chat.openai.com");
        System.out.println("Current Page 1: " + browser.getCurrentPage());
        browser.back();
        // System.out.println("Current Page:2 " + browser.getCurrentPage());
        browser.back();
        // System.out.println("Current Page:3 " + browser.getCurrentPage());
        browser.forward();
        System.out.println("Current Page: 4" + browser.getCurrentPage());
    }
}
