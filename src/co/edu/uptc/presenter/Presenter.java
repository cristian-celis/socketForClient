package co.edu.uptc.presenter;

import co.edu.uptc.model.ManagerModel;
import co.edu.uptc.view.ManagerView;

import java.awt.*;

public class Presenter implements Contract.Presenter{

    private ManagerModel model;
    private ManagerView view;
    public Presenter(){
        model = new ManagerModel(this);
        view = new ManagerView(this);
    }
    @Override
    public void paintRectangle(Rectangle rectangle, int color) {
        view.paintRectangle(rectangle, color);
    }

    @Override
    public void receive() {
        model.receive();
    }

    @Override
    public void setInfoFrame(int x, int y, int width, int height, int color) {
        view.setInfoFrame(x, y, width, height, color);
    }
}
