package co.edu.uptc.model;

import co.edu.uptc.pojo.InformationForImage;
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
        try{
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        int count = 0;
                        dataInputStream = new DataInputStream(connection.socket.getInputStream());
                        String info;
                        while (true) {
                            info = dataInputStream.readUTF();
                            System.out.println("Llego: " + info);
                            //jsonToRectangle(info);
                            jsonToImg(info, count);
                            count++;
                        }
                    } catch (SocketException e) {
                        System.out.println("Se desconecto -> " + e.getCause());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            thread.start();
        }catch (Exception e){
        }

    }

    private String totalInfo = "";

    private void jsonToImg(String info, int count){
        String amountTotalInfo = "";
        if (count == 0){
            String[] divideInfo = info.split("=");
            amountTotalInfo = divideInfo[0];
            System.out.println("tamaño divideInfo 1: " + divideInfo[1].length());
            totalInfo = divideInfo[1];
        }else{
            totalInfo += info;
        }
        System.out.println("totalInfo lenght: " + totalInfo.length() + ", amountTotalInfor: " + amountTotalInfo);
        if (totalInfo.length() == Integer.parseInt(amountTotalInfo)){
            System.out.println("totalInfo: " + totalInfo);
            System.out.println("Coincidio");
            InformationForImage bytes = new Gson().fromJson(totalInfo, InformationForImage.class);
            try{
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes.getImgBytes()));
                File file = new File("imagenGenerada.png");
                ImageIO.write(image, "png", file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void jsonToRectangle(String info) {
        System.out.println("Img");
        String[] coordenates = info.split(",");
        Rectangle rectangle = new Rectangle(Integer.parseInt(coordenates[0]), Integer.parseInt(coordenates[1]), 25, 25);
        model.getPresenter().paintRectangle(rectangle);
    }
}
