import java.awt.BorderLayout;

import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;

public class ViewSimpleGame {
    JFrame fenetre;
    JLabel label;
    public ViewSimpleGame (){
        fenetre = new JFrame();
        fenetre.setLayout(new BorderLayout());
        fenetre.setSize(500, 500);
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
