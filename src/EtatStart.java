public class EtatStart implements Etat {
    
    private ViewCommand viewCommand;

    public EtatStart(ViewCommand viewCommand){
        System.out.println("Le viewCommand est à l'état Start");
        this.viewCommand = viewCommand;
    }

    public void start(){
        System.out.println("Commande désactivés");
    }

    public void play(){
        viewCommand.setEtat(new EtatPlay(viewCommand));
    }

    public void pause(){
        System.out.println("Commande désactivé");
    }

    public void step(){
        viewCommand.setEtat(new EtatStep(viewCommand));
    }
}
