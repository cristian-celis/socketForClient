package co.edu.uptc.presenter;

import java.awt.*;

public interface Contract {
    interface Presenter{
        void paintRectangle(Rectangle rectangle);
        void receive();
    }
    interface Model{
        void receive();
    }
    interface View{
        void paintRectangle(Rectangle rectangle);
    }
}
