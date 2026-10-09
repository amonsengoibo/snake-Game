import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ViewCommand implements Observer {
    JFrame fenetre;
    JSlider numberTurnPerSecond;
    JLabel label;
    Map<String, JButton> buttons = new LinkedHashMap<>();
    public ViewCommand(Observable obs){
        System.out.println("Constructeur de ViewCommandi");
        fenetre = new JFrame();
        fenetre.setTitle("Commande");
        fenetre.setLayout(new GridLayout(2, 1));
        fenetre.setSize(700, 400);
        
        //Position de la fenêtre sur l'écran par rapport à centre de l'écran
        Dimension windowSize = fenetre.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width /2 + 1000;
        int dy = centerPoint.y - windowSize.height / 2 - 350;
        fenetre.setLocation(dx,dy);

        fenetre.revalidate(); // Re-calcule la disposition des composants
        fenetre.repaint();    // Redessine l'interface
        buttons.put("restart", new JButton());
        buttons.put("play", new JButton());
        buttons.put("step", new JButton());
        buttons.put("pause", new JButton());
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
        JLabel numberTurnPerSecondLabel = new JLabel("Number of turns per second", JLabel.CENTER);
        numberTurnPerSecond = new JSlider(JSlider.HORIZONTAL, 1, 10, 2);
        numberTurnPerSecond.setMajorTickSpacing(1);
        numberTurnPerSecond.setMinorTickSpacing(1);
        numberTurnPerSecond.setPaintTicks(true);
        numberTurnPerSecond.setPaintLabels(true);
        label = new JLabel("Turn : 0",JLabel.CENTER);
        panneauGaucheBas.add(numberTurnPerSecondLabel);
        panneauGaucheBas.add(numberTurnPerSecond);
        panneauBas.add(panneauGaucheBas);
        panneauBas.add(label);
        
        fenetre.add(panneauHaut);
        fenetre.add(panneauBas);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Ajout de l'observateur courant 
        obs.addObserver(this);
    }
    public void Actualize(int turn){
        label.setText("Turn :"+turn);
    }
    public void show(){
        fenetre.setVisible(true);
    }
}
