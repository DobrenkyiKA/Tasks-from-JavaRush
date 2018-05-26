package com.javarush.task.task30.task3008;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    public static void sendBroadcastMessage(Message message) {
        for (String name : connectionMap.keySet()) {
            try {
                connectionMap.get(name).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(String.format("Не получилось отправить сообщение для %s", name));
            }
        }
    }

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.writeMessage("Введите порт сервера");
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())){
            consoleHelper.writeMessage("Сервер запущен");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private final Socket socket;

        public void run() {
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress().toString());
            try (Connection connection = new Connection(socket)){
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Соединение с удаленным сервером закрыто");

            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произощла ошибка при обмене данными с удаленным сервером");

            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произощла ошибка при обмене данными с удаленным сервером");

            }

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            boolean bool = true;
            String name = "";
            while (bool) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                name = message.getData();
                if (message.getType() == MessageType.USER_NAME && message.getData() != "") {
                        if (!connectionMap.containsKey(message.getData())) {
                            connectionMap.put(name, connection);
                            bool = false;
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                    }
                }
            }
            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (userName != name) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                StringBuilder stringBuilder = new StringBuilder();
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    stringBuilder.append(userName + ": " + message.getData());
                    sendBroadcastMessage(new Message(MessageType.TEXT, stringBuilder.toString()));
                } else {
                    ConsoleHelper consoleHelper = new ConsoleHelper();
                    consoleHelper.writeMessage("Ошибка, получен не текст");
                }
            }
        }

        public Handler (Socket socket) {
            this.socket = socket;
        }
    }
}
