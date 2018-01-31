package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.say();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    //pretend we start rmi server as SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            Remote stub = null;
            Remote stub1 = null;
            final String UNIC_BINDING_NAME = "cata";
            final String UNIC_BINDING_NAME1 = "goga";
            try {
                registry = LocateRegistry.createRegistry(2099);
                Cat cat = new Cat("Alis");//напишите тут ваш код
                Dog dog = new Dog("Pes");//напишите тут ваш код
                final Cat service = cat;
                final Dog service1 = dog;
                stub = UnicastRemoteObject.exportObject(service, 2099);
                stub1 = UnicastRemoteObject.exportObject(service1, 2099);
                registry.bind(UNIC_BINDING_NAME, stub);
                registry.bind(UNIC_BINDING_NAME1, stub1);
            } catch (RemoteException e) {
                e.printStackTrace(System.err);
            } catch (AlreadyBoundException e) {
                e.printStackTrace(System.err);
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        //start rmi server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        //start client
        CLIENT_THREAD.start();
    }
}