package view;

public class EtatPause implements Etat {
    
    private ViewCommand viewCommand;

    public EtatPause(ViewCommand viewCommand){
        System.out.println("Le viewCommand est à l'état Pause");
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

