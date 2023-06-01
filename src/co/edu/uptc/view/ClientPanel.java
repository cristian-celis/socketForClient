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
        graphics2D.setColor(new Color(color));
        System.out.println("color -> " + color);
        graphics2D.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    private int color;

    public void paintRectangle(Rectangle rectangle, int color){
        this.repaint();
        this.color = color;
        this.rectangle = rectangle;
    }
}
