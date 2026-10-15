package model;

import java.util.ArrayList;

import utils.FeaturesSnake;
import utils.FeaturesItem;

public class SnakeGame extends Game{
    
    private InputMap inputMap;
    private ArrayList<FeaturesSnake> featuresSnakes;
    private ArrayList<FeaturesItem> featuresItems;

    public SnakeGame(int maxTurn, String layoutFileName){
        super(maxTurn);

        this.inputMap = new InputMap(layoutFileName);
        

    }

    public void  initializeGame(){
        this.featuresItems = inputMap.getStart_items() ;
        this.featuresSnakes = inputMap.getStart_snakes();

        notifyObservers();
    }
    
    public void takeTurn(){

    }

    // vérifie si le nombre maximum de tours est atteint
    public boolean isGameOver(){
        return false;
    }

    //affichage d'un message de fin de jeu 
    public void gameOver(){

    }
    public int getSizeX(){
        return inputMap.getSizeX();
    }
    public int getSizeY(){
        return inputMap.getSizeY();
    }
    public boolean[][] get_walls(){
        return inputMap.get_walls();
    }
    public ArrayList<FeaturesSnake> getStart_snakes(){
        return inputMap.getStart_snakes();
    }
    public ArrayList<FeaturesItem> getStart_items(){
        return inputMap.getStart_items();
    }
    public ArrayList<FeaturesSnake> getFeatures_snakes(){
        return featuresSnakes;
    }
    public ArrayList<FeaturesItem> getFeatures_items(){
        return featuresItems;
    }
    
}
