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
        model.getClient().receive();
    }
    @Override
    public void paintRectangle(Rectangle rectangle) {
        view.paintRectangle(rectangle);
    }
}
