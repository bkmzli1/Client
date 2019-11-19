package ru.bkmz.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class Client implements Runnable {
    static private Socket socket;
    static private ObjectOutputStream outputStream;
    static private ObjectInputStream inputStream;


    @Override
    public void run() {
        MainActivity.tv.setText("начето подключение");
        try {
            try {

                while (true) {
                    socket = new Socket(InetAddress.getByName("192.168.0.159"), 800);
                    outputStream = new ObjectOutputStream(socket.getOutputStream());
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    MainActivity.tv.setText("out:" + inputStream.readObject());

                }
            } catch (SocketException e) {
                e.printStackTrace();
                MainActivity.tv.setText("ошибка подключения");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void sendData(Object object) {
        try {
            MainActivity.tv.setText("отправяется");
            outputStream.flush();
            outputStream.writeObject(object);
            MainActivity.tv.setText("отправлено");
        } catch (Exception e) {
        }
    }
}