package controller;

import java.util.ArrayList;

import model.SnakeGame;

import view.PanelSnakeGame;
import view.ViewCommand;
import view.ViewSnakeGame;

public class ControllerSnakeGame extends AbstractController{
    
    public ControllerSnakeGame(String layoutFileName){
        SnakeGame snakeGame = new SnakeGame(10, layoutFileName);
        this.game = snakeGame;
        
        PanelSnakeGame panelSG = new PanelSnakeGame(
            snakeGame.getSizeX(), 
            snakeGame.getSizeY(), 
            snakeGame.get_walls(), 
            snakeGame.getStart_snakes(), 
            snakeGame.getStart_items());
        ViewCommand vCommands = new ViewCommand(this, game);
        ViewSnakeGame vSnakeGame = new ViewSnakeGame(
            this, 
            game, 
            panelSG, 
            snakeGame.getSizeX(), 
            snakeGame.getSizeY()
        );
        game.init();
    }
    
}
