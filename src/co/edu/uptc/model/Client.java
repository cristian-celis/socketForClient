package co.edu.uptc.model;

import co.edu.uptc.pojo.*;
import com.google.gson.Gson;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.SocketException;

public class Client {
    private Connection connection;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private ManagerModel model;

    public Client(String host, int port, ManagerModel model) {
        this.model = model;
        innit(host, port);
    }

    public void innit(String host, int port) {
        connection = new Connection();
        connection.setType("client");
        connection.setPort(port);
        connection.setHost(host);
        connection.connect();
    }

    public void receive() {
        try {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        dataInputStream = new DataInputStream(connection.socket.getInputStream());
                        String info;
                        while (true) {
                            info = dataInputStream.readUTF();
                            System.out.println("Llego: " + info);
                            jsonToRectangle(info);
                        }
                    } catch (SocketException e) {
                        System.out.println("Se desconecto -> " + e.getCause());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            thread.start();
        } catch (Exception e) {
        }

    }

    private void jsonToRectangle(String info) {
        Information information = new Gson().fromJson(info, Information.class);

        figureInformation figureInformation = information.getFigureInformation();
        int color = figureInformation.getColor();

        panelInformation panelInformation = information.getPanelInformation();
        int panelColor = panelInformation.getColor();

        frameInformation frameInformation = information.getFrameInformation();

        int x = frameInformation.getX();
        int y = frameInformation.getY();
        int width = frameInformation.getWidth();
        int height = frameInformation.getHeight();


        int intRectangle = information.getFigureInformation().rectangle;
        model.getPresenter().setInfoFrame(x, y, width, height, panelColor);
        model.getPresenter().paintRectangle(getRectangle(intRectangle), color);
    }

    private Rectangle getRectangle(int numero) {
        String binaryNum = Integer.toBinaryString(numero);
        while (binaryNum.length() < 32) {
            binaryNum = "0" + binaryNum;
        }
        String[] num = binaryNum.split("");
        boolean ready = false;
        String[] x = new String[10];
        String[] y = new String[10];
        String[] width = new String[6];
        String[] height = new String[6];
        String[] temporal = height;
        int lastPosition = num.length - 1;
        int count = 1;
        while (!ready && lastPosition >= 0) {


            for (int i = 0; i < temporal.length; i++) {
                temporal[i] = num[lastPosition];
                lastPosition--;
            }
            switch (count) {
                case 1 -> {
                    height = temporal;
                    temporal = width;
                }
                case 2 -> {
                    width = temporal;
                    temporal = y;
                }
                case 3 -> {
                    y = temporal;
                    temporal = x;
                }
                case 4 -> {
                    x = temporal;
                    ready = true;
                }
            }
            count++;
        }

        int numX = Integer.parseInt(new StringBuilder(String.join("", x)).reverse().toString(), 2);
        int numY = Integer.parseInt(new StringBuilder(String.join("", y)).reverse().toString(), 2);
        int numWidth = Integer.parseInt(new StringBuilder(String.join("", width)).reverse().toString(), 2);
        int numHeigth = Integer.parseInt(new StringBuilder(String.join("", height)).reverse().toString(), 2);
        return new Rectangle(numX, numY, numWidth, numHeigth);
    }
}
