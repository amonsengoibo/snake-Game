public abstract class AbstractController {
    
    protected Game game;
    
    public AbstractController(){
        
    }
    
    // arrêt et réinitialisation
    public void restart(){
        game.pause();    
        game.init();
    }

    // passage manuel d’une étape
    public void step(){
        game.step();
    }

    // passage automatique des étapes
    public void play(){
        game.play();
        game.run();
    }

    // interruption du passage automatique des étapes
    public void pause(){
        game.pause();
    }

    // réglage de la vitesse du jeu
    public void setSpeed(double speed){
        long s = Math.round(speed * 1000.0);
        game.setSpeed(s);
    }
}
