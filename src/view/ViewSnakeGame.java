package view;

import java.awt.*;


import javax.swing.*;
import controller.ControllerSnakeGame;
import model.Observable;
import model.Observer;
import model.SnakeGame;

public class ViewSnakeGame implements Observer {
    
    private JFrame fenetre;
    private PanelSnakeGame panelSG;
    ControllerSnakeGame controller;

    public ViewSnakeGame(ControllerSnakeGame controller, Observable obs, PanelSnakeGame panelSG, int sizeX, int sizeY){
        this.controller = controller;
        this.panelSG = panelSG;
        obs.addObserver(this);
        this.fenetre = new JFrame();
        fenetre.setTitle("SnakeGame");
        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int sizeStep = 45; // Taille d'une case en pixels
        int mapWidth = sizeX * sizeStep;
        int mapHeight = sizeY * sizeStep;

        // On garantit une largeur/hauteur minimale pour éviter que la barre de titre compresse le plateau
        int minWidth = Math.max(mapWidth, 350); 
        int minHeight = Math.max(mapHeight, 350);
        this.panelSG.setPreferredSize(new Dimension(minWidth, minHeight));
        // Ajout de panelSG à la fenetre
        fenetre.add(panelSG);

        this.fenetre.pack(); 
        this.fenetre.setLocationRelativeTo(null);
        
        DispositionFenetre d = new DispositionFenetre(fenetre);
        d.DispositionFenetreEcran(1000, 350, true);

        fenetre.setVisible(true);
    }

    public void update(Observable obs, int currentTurn){
        if(obs instanceof SnakeGame){
            SnakeGame game = (SnakeGame) obs;
            panelSG.updateInfoGame(
                game.getFeatures_snakes(), 
                game.getFeatures_items()
            );
            panelSG.repaint();
        }
        
    }
    
}
