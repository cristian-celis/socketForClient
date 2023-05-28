package co.edu.uptc.presenter;

import java.awt.*;

public interface Contract {
    interface Presenter{
        void paintRectangle(Rectangle rectangle);
    }
    interface Model{
    }
    interface View{
        void paintRectangle(Rectangle rectangle);
    }
}
