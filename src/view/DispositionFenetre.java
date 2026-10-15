package view;

import javax.swing.*;
import java.awt.*;

public class DispositionFenetre {
    JFrame fenetre;
    public DispositionFenetre(JFrame fenetre){
        this.fenetre = fenetre;
    }
    /* True : Droite et False : Gauche */
    public void DispositionFenetreEcran(int ecartX, int ecartY, boolean emplacement){
        Dimension windowSize = fenetre.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx =(emplacement) ? centerPoint.x - windowSize.width /2 - ecartX : centerPoint.x - windowSize.width /2 + ecartX;
        int dy = centerPoint.y - windowSize.height / 2 - ecartY;
        fenetre.setLocation(dx,dy);
    }
}
