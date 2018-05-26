package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] strings = message.split(": ");
            if (strings.length == 2) {
                SimpleDateFormat simpleDateFormat = null;
                switch (strings[1]) {
                    case "дата" :  simpleDateFormat = new SimpleDateFormat("d.MM.YYYY"); break;
                    case "день" :  simpleDateFormat = new SimpleDateFormat("d"); break;
                    case "месяц" :  simpleDateFormat = new SimpleDateFormat("MMMM"); break;
                    case "год" :  simpleDateFormat = new SimpleDateFormat("YYYY"); break;
                    case "время" :  simpleDateFormat = new SimpleDateFormat("H:mm:ss"); break;
                    case "час" :  simpleDateFormat = new SimpleDateFormat("H"); break;
                    case "минуты" :  simpleDateFormat = new SimpleDateFormat("m"); break;
                    case "секунды" :  simpleDateFormat = new SimpleDateFormat("s"); break;
                }
                if (simpleDateFormat != null) {
                    Calendar calendar = Calendar.getInstance();
                    sendTextMessage("Информация для " + strings[0] + ": " + simpleDateFormat.format(calendar.getTime()));
                }
            }
        }
    }
}
