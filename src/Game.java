

public abstract class Game implements Runnable{
    
    private Thread thread;
    private int currentTurn; // qui permettra de compter le nombre de tours courant du jeu.
    private int maxTurn; // dont la valeur est prédéfinie au moment de la création du jeu via le constructeur de Game.
    private boolean isRunning; // qui permet de savoir si le jeu a été mis en pause ou pas.

    public Game(int maxTurn){
        System.out.println("Appel au constructeur de Game");
        this.maxTurn = maxTurn;
    }

    public void launch(){
        isRunning = true;
        thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }
    
    /*Méthode qui initialise le jeu en remettant le compteur du nombre
    de tours currentTurn à zéro, met isRunning à la valeur true et appelle la méthode
    abstraite void initializeGame(), non implémentée pour l’instant. Elle sera implémentée
    par les classes concrètes qui héritent de Game.
     */
    void init(){
        System.out.println("Initialisation du jeu");
        currentTurn = 0;
        isRunning = true;
        initializeGame();
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
        System.out.println("Tour n° "+currentTurn);
        currentTurn++;
        //if(!isGameOver()) 
        if(currentTurn < maxTurn){
            takeTurn();
        }  
        else{
            isRunning = false;
            gameOver();
        }
            
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
        ViewSimpleGame view = new ViewSimpleGame();
        ViewCommand viewcommand = new ViewCommand();
        System.out.println("Début du jeu");
        view.show();
        viewcommand.show();
        while(isRunning){
            step();
            view.Actualize(currentTurn);
            viewcommand.actualize(currentTurn);
            try {
                Thread.sleep(2000);
            }catch(InterruptedException i){

            }
        }
    }
    public abstract void  initializeGame();
    public abstract void takeTurn();
    public abstract boolean isGameOver(); // vérifie si le nombre maximum de tours est atteint
    public abstract void gameOver(); //affichage d'un message de fin de jeu 
}