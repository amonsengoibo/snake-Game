public class SimpleGame extends Game {
    public SimpleGame(int maxTurn){
        super(maxTurn);
        System.out.println("Appel au constructeur de SimpleGame");
    }

    // vérifie si le nombre maximum de tours est atteint
    public boolean isGameOver(){
        return false;
    }

    public void  initializeGame(){
        System.out.println("initialisation de SimpleGame");
    }

    public void takeTurn(){
        System.out.println("Tour "+currentTurn+" du jeu en cours");
    }

    //affichage d'un message de fin de jeu 
    public void gameOver(){
        System.out.println("Game Over");
    }
}
