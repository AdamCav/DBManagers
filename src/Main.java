import com.google.gson.Gson;

public class Main {
    double testvalue=1;
    public Main(){
        Player player = new Player();
        GameState gameState = new GameState();
        LogWindow log = new LogWindow();
        DecisionWindow decisions = new DecisionWindow();
        new ManagementWindow(player,gameState,log,decisions);
       // new ManagementWindowTest();
    }

    public static void main(String[] args) {
        new Main();
    }
}
