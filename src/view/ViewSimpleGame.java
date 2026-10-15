package view;
import java.awt.BorderLayout;

import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;

import controller.AbstractController;
import model.Observable;
import model.Observer;

public class ViewSimpleGame implements Observer{
    private JFrame fenetre;
    private JLabel label;
    private AbstractController controller;

    public ViewSimpleGame (AbstractController controller, Observable obs){
        
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
    }
    public void createUserInterface(){
        
        label = new JLabel("Turn: 0", SwingConstants.CENTER);
        fenetre.add(label, BorderLayout.CENTER);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void Actualize(int currentTurn){
        label.setText("Turn: "+currentTurn);
    }

    public void show(){
        fenetre.setVisible(true);
    }
    
}
