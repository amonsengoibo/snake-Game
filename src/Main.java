import controller.*;


public class Main {
    public static void main(String[] args) throws Exception {
        
        /* Simple Game */
        /*ControllerSimpleGame controller = new ControllerSimpleGame();*/
        
        /* Snake Game */
        ControllerSnakeGame controller = new ControllerSnakeGame(
            "../layouts/smallNoWall.lay"
        );
        
    }
}
