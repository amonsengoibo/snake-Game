import java.util.ArrayList;
import java.util.List;

public abstract class Game implements Runnable, Observable{
    
    private Thread thread;
    protected int currentTurn; // qui permettra de compter le nombre de tours courant du jeu.
    private int maxTurn; // dont la valeur est prédéfinie au moment de la création du jeu via le constructeur de Game.
    private boolean isRunning; // qui permet de savoir si le jeu a été mis en pause ou pas.
    private long speed;
    private List<Observer> observers = new ArrayList<>();

    public Game(int maxTurn){

        System.out.println("Appel au constructeur de Game");
        this.maxTurn = maxTurn;
        this.speed = 2000;

    }

    public void launch(){
        isRunning = true;
        thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }
    
    /*
        Méthode qui initialise le jeu en remettant le compteur du nombre
        de tours currentTurn à zéro, met isRunning à la valeur true et appelle la méthode
        abstraite void initializeGame(), non implémentée pour l’instant. Elle sera implémentée
        par les classes concrètes qui héritent de Game.
     */
    void init(){
        System.out.println("Initialisation du jeu");
        currentTurn = 0;
        isRunning = true;
        initializeGame();
        notifyObservers();
    }

    /*
        Méthode qui incrémente le compteur de tours du jeu et effectue
        un seul tour du jeu en appelant la méthode abstraite void takeTurn() si le jeu n’est
        pas terminé. Pour savoir si le jeu est terminé, on appelera la méthode abstraite boolean
        isGameOver() et on vérifiera si le nombre maximum de tours est atteint. Si le jeu est
        terminé, elle doit mettre le booléen isRunning à la valeur false puis faire appel à la
        méthode abstraite void gameOver() et qui permettra d’afficher un message de fin du
        jeu.
    */
   
    public void step(){
        
        
        //if(!isGameOver()) 
        if(currentTurn < maxTurn){
            currentTurn++;
            takeTurn();
        }  
        else{
            isRunning = false;
            gameOver();
        }
        notifyObservers();
            
    }
    /*
        Méthode qui met en pause le jeu en mettant le flag booléen isRunning à false.
    */
    public void pause(){
        isRunning = false;
        
        System.out.println("Le jeu est mis en pause");
    }

    /*
        Méthode qui lance le jeu en pas à pas avec la méthode step() tant que le flag booléen isRunning reste à true.
    */
    public void run(){
        
        System.out.println("Début du jeu :");
        // !!! A Ajouter isGameOVer() par la suite dans la condition de boucle !!!
        while(isRunning){
            step();
            
            try {
                Thread.sleep(speed);
            }catch(InterruptedException i){

            }
            notifyObservers();
        }
    }
    public void play(){
        isRunning = true;
        launch();
        notifyObservers();
    }
    public void setSpeed(long speed){
        this.speed = speed;
    }
    public void addObserver(Observer obs){
        observers.add(obs);
    }
    public void deleteObserver(Observer obs){
        observers.remove(obs);
    }
    public void notifyObservers(){
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).Actualize(currentTurn);
        }
    }

    
    public abstract void  initializeGame();
    
    public abstract void takeTurn();

    // vérifie si le nombre maximum de tours est atteint
    public abstract boolean isGameOver(); 

    //affichage d'un message de fin de jeu 
    public abstract void gameOver(); 
}