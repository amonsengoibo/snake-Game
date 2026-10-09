public class ControllerSimpleGame extends AbstractController {
    
    public ControllerSimpleGame(){
        game = new SimpleGame(4);
        game.init();
        ViewCommand vCommand = new ViewCommand(this, game);
        ViewSimpleGame vSimpleGame = new ViewSimpleGame(this, game);
        
    }
}
