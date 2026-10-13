public class EtatPlay implements Etat {
    
    private ViewCommand viewCommand;

    public EtatPlay(ViewCommand viewCommand){
        System.out.println("Le viewCommand est à l'état Play");
        this.viewCommand = viewCommand;
    }

    public void start(){
        viewCommand.setEtat(new EtatStart(viewCommand));
    }

    public void play(){
        System.out.println("Commande interdit");
    }

    public void pause(){
        viewCommand.setEtat(new EtatPause(viewCommand));
    }
    
    public void step(){
        System.out.println("Commande interdit");
    }
}

