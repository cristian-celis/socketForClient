package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class ClientPanel extends JPanel {

    private ManagerView view;
    private Rectangle rectangle;

    public ClientPanel(ManagerView view){
        this.setBackground(new Color(215,219,221));
        this.view = view;
        initComponents();
    }

    private void initComponents(){
        rectangle = new Rectangle(0, 0, 25, 25);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.draw(rectangle);
    }

    public void paintRectangle(Rectangle rectangle){
        this.repaint();
        this.rectangle = rectangle;
    }
}
