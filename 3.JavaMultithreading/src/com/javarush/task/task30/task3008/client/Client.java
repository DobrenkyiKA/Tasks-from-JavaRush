package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Ошибка во время ожидания");
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ощибка во время работы клиента");
        }
        String message;
        while (clientConnected && !(message = ConsoleHelper.readString()).equals("exit")) {
            if (shouldSendTextFromConsole()) {
                sendTextMessage(message);
            }
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите номер порта:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Произошло исключение IOException");
            clientConnected = false;
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {

        public void run() {
            try {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException  | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                MessageType messageType = Client.this.connection.receive().getType();
                if (messageType == MessageType.NAME_REQUEST) {
                    Client.this.connection.send(new Message (MessageType.USER_NAME, getUserName()));
                } else if (messageType == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = Client.this.connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else throw new IOException("Unexpected MessageType");
            }
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединился к чату");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }
    }
}
