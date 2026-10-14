import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;

public class ViewCommand implements Observer {
    private JFrame fenetre;
    private JSlider speed;
    private JLabel label;
    private Map<String, JButton> buttons = new LinkedHashMap<>();
    private AbstractController controller;
    private Etat etat;

    public ViewCommand(AbstractController controller, Observable obs){
        
        // instanciation du controlleur
        this.controller = controller;

        this.etat = new EtatStart(this);

        System.out.println("Constructeur de ViewCommandi");
        fenetre = new JFrame();
        fenetre.setTitle("Commande");
        fenetre.setLayout(new GridLayout(2, 1));
        fenetre.setSize(500, 300);

        fenetre.revalidate(); // Re-calcule la disposition des composants
        fenetre.repaint();    // Redessine l'interface
        buttons.put("restart", new JButton());
        buttons.put("play", new JButton());
        buttons.put("step", new JButton());
        buttons.put("pause", new JButton());
        
        //Position de la fenêtre sur l'écran par rapport à centre de l'écran
        DispositionFenetreEcran();
        
        // Création de l'interface
        createUserInterface();

        CaptureEvenement();
        //Ajout de l'observateur courant 
        obs.addObserver(this);
        
        //Afficher
        show();

        start();
    }

    public void setEtat(Etat etat){
        this.etat = etat;
    }

    public void createUserInterface(){
        
        JPanel panneauHaut = new JPanel(new GridLayout(1, 4));
        JPanel panneauBas = new JPanel(new GridLayout(1, 2));
        //int i = 0;
        for(Map.Entry<String,JButton> entry : buttons.entrySet()){
            
            ImageIcon icon = new ImageIcon("./ressources/icons/icon_"+entry.getKey()+".png");
            //System.out.println(icon);
            entry.getValue().setIcon(icon);
            panneauHaut.add(entry.getValue());
            //System.out.println("Tour de boucle "+i);
            //i++;
            
        }

        JPanel panneauGaucheBas = new JPanel(new GridLayout(2,1));
        JLabel speedLabel = new JLabel("Number of turns per second", JLabel.CENTER);
        speed = new JSlider(JSlider.HORIZONTAL, 1, 10, 2);
        speed.setMajorTickSpacing(1);
        speed.setMinorTickSpacing(1);
        speed.setPaintTicks(true);
        speed.setPaintLabels(true);
        label = new JLabel("Turn : 0",JLabel.CENTER);
        panneauGaucheBas.add(speedLabel);
        panneauGaucheBas.add(speed);
        panneauBas.add(panneauGaucheBas);
        panneauBas.add(label);
        
        fenetre.add(panneauHaut);
        fenetre.add(panneauBas);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void DispositionFenetreEcran(){
        Dimension windowSize = fenetre.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width /2 + 1000;
        int dy = centerPoint.y - windowSize.height / 2 - 350;
        fenetre.setLocation(dx,dy);
    }
    public void CaptureEvenement(){
        for(Map.Entry<String,JButton> entry : buttons.entrySet()){
            final String key = entry.getKey();
            JButton button = entry.getValue();
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evenement) {
                    switch(key){
                        case "restart":
                            start();
                            controller.restart();
                            break;
                        case "play":
                            play();
                            controller.play();
                            break;
                        case "step":
                            step();
                            controller.step();
                            break;
                        case "pause":
                            pause();
                            controller.pause();
                            break;
                    }
                }
            });
        }
        speed.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evenement) {
                JSlider source = (JSlider) evenement.getSource();
        
                // On vérifie si l'utilisateur a fini de glisser le curseur
                if (!source.getValueIsAdjusting()) {
                    double valeur = (double) source.getValue();
                    controller.setSpeed(valeur);
                }
                
            }
        });
        
    }
    public void Actualize(int turn){
        label.setText("Turn :"+turn);
    }
    public void show(){
        fenetre.setVisible(true);
    }

    /* ----> Méthodes du pattern Etat */
    public void start(){
        buttons.get("restart").setEnabled(false);
        buttons.get("pause").setEnabled(false);
        buttons.get("step").setEnabled(true);
        buttons.get("play").setEnabled(true);

        etat.start();
    }
    public void play(){
        
        buttons.get("restart").setEnabled(true);
        buttons.get("pause").setEnabled(true);
        buttons.get("step").setEnabled(false);
        buttons.get("play").setEnabled(false);  
        
        etat.play();
    }
    public void pause(){
        
        buttons.get("restart").setEnabled(true);
        buttons.get("pause").setEnabled(false);
        buttons.get("step").setEnabled(true);
        buttons.get("play").setEnabled(true);   
        
        etat.pause();
    }
    public void step(){
        
        buttons.get("restart").setEnabled(true);
        buttons.get("pause").setEnabled(false);
        buttons.get("step").setEnabled(true);
        buttons.get("play").setEnabled(true);   
        
        etat.step();
    }
    /* <---- Méthodes du pattern Etat */

    public String toString(){
        return "ViewCommand dans l'état " + etat.getClass();
    }
}
