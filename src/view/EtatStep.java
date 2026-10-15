package view;

public class EtatStep implements Etat {
    
    private ViewCommand viewCommand;

    public EtatStep(ViewCommand viewCommand){
        System.out.println("Le viewCommand est à l'état Step");
        this.viewCommand = viewCommand;
    }

    public void start(){
        viewCommand.setEtat(new EtatStart(viewCommand));
    }

    public void play(){
        viewCommand.setEtat(new EtatPlay(viewCommand));
    }

    public void pause(){
        System.out.println("Commande interdit");
    }
    
    public void step(){
        viewCommand.setEtat(new EtatStep(viewCommand));
    }
}
