package view;
import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

import controller.ControllerSimpleGame;
import model.Observable;
import model.Observer;

public class ViewSimpleGame implements Observer{
    private JFrame fenetre;
    private JLabel label;
    private ControllerSimpleGame controller;

    public ViewSimpleGame (ControllerSimpleGame controller, Observable obs){
        
        // instanciation du controlleur
        this.controller = controller;
        
        
        
        fenetre = new JFrame();
        fenetre.setTitle("Game");
        fenetre.setLayout(new BorderLayout());
        fenetre.setSize(500, 500);

        createUserInterface();
        
        //Ajout de l'observateur courant 
        obs.addObserver(this);
        show();
        DispositionFenetre d = new DispositionFenetre(fenetre);
        d.DispositionFenetreEcran(1000, 350, true);
    }
    public void createUserInterface(){
        
        label = new JLabel("Turn: 0", SwingConstants.CENTER);
        fenetre.add(label, BorderLayout.CENTER);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void update(Observable obs, int currentTurn){
        label.setText("Turn: "+currentTurn);
    }

    public void show(){
        fenetre.setVisible(true);
    }
    
}
