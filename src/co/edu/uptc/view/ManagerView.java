package co.edu.uptc.view;

import co.edu.uptc.presenter.Contract;
import co.edu.uptc.presenter.Presenter;

import javax.swing.*;
import java.awt.*;

public class ManagerView extends JFrame implements Contract.View{
    private ClientPanel clientPanel;
    private Contract.Presenter presenter;

    public ManagerView(Contract.Presenter presenter){
        this.presenter = presenter;
        this.setTitle("Client");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(700, 700);
        initComponents();
        this.setVisible(true);
    }

    @Override
    public void setInfoFrame(int x, int y, int width, int height, int color){
        this.setSize(width, height);
        this.setLocation(x, y);
        this.setBackground(new Color(color));
    }

    private void initComponents(){
        setLayout(new BorderLayout());
        clientPanel = new ClientPanel(this);
        clientPanel.setPreferredSize(new Dimension(700,700));
        this.add(clientPanel, BorderLayout.CENTER);
        presenter.receive();
    }

    @Override
    public void paintRectangle(Rectangle rectangle, int color) {
        clientPanel.paintRectangle(rectangle, color);
    }
}
