package co.edu.uptc.model;

import co.edu.uptc.presenter.Contract;

import javax.swing.*;

public class ManagerModel implements Contract.Model {

    private Contract.Presenter presenter;
    private Client client;

    public ManagerModel(Contract.Presenter presenter){
        this.presenter = presenter;
        initConnection();
    }

    @Override
    public void receive(){
        client.receive();
    }

    public Client getClient(){
        return client;
    }
    public void initConnection(){
        String[] args = {"client", "192.168.20.25", "9999"};
        String type = args[0];
        if (type.equalsIgnoreCase("client")){
            client = new Client(args[1], Integer.parseInt(args[2]), this);
        }else{
            JOptionPane.showMessageDialog(null, "No esta definido como cliente");
        }
    }

    public Contract.Presenter getPresenter(){
        return presenter;
    }
}
