package co.edu.uptc.presenter;

import java.awt.*;

public interface Contract {
    interface Presenter{
        void paintRectangle(Rectangle rectangle, int color);
        void receive();
        void setInfoFrame(int x, int y, int width, int height, int color);
    }
    interface Model{
        void receive();
    }
    interface View{
        void setInfoFrame(int x, int y, int width, int height, int color);
        void paintRectangle(Rectangle rectangle, int color);
    }
}
