package co.edu.uptc.model;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.SocketException;

public class Client {
    private Connection connection;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private ManagerModel model;
    public Client(String host, int port, ManagerModel model){
        this.model = model;
        innit(host, port);
    }

    public void innit(String host, int port){
        connection = new Connection();
        connection.setType("client");
        connection.setPort(port);
        connection.setHost(host);
        connection.connect();
    }

    public void receive(){
        try {
            dataInputStream = new DataInputStream(connection.socket.getInputStream());
            String info;
            while(true){
                info = dataInputStream.readUTF();
                System.out.println("Llego: " + info);
                sendToView(info);
            }
        }catch (SocketException e){
            System.out.println("Se desconecto -> " + e.getCause());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void sendToView(String info){
        String[] coordenates = info.split(",");
        Rectangle rectangle = new Rectangle(Integer.parseInt(coordenates[0]), Integer.parseInt(coordenates[1]), 25,25);
        model.getPresenter().paintRectangle(rectangle);
    }
}
