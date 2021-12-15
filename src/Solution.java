import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Application application = new Application();
        while(true) application.handleCommands();
    }
}
