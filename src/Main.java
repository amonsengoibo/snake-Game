public class Main {
    public static void main(String[] args) throws Exception {
        SimpleGame game = new SimpleGame(4);

        ViewCommand vCommand = new ViewCommand(game);
        ViewSimpleGame vSimpleGame = new ViewSimpleGame(game);

        vCommand.show();
        vSimpleGame.show();
        
        game.init();
        game.run();
    }
}
