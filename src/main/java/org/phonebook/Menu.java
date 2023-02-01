package org.phonebook;

import java.util.Scanner;
import java.util.logging.Level;

public class Menu {
    public static void mainMenu(){
        Scanner in = new Scanner(System.in);
        System.out.println("1 - Отобразить справочник");
        System.out.println("2 - Выгрузить данные");
        System.out.println("3 - Загрузить данные");
        System.out.println(". ".repeat(15)+".");
        System.out.print("Выберите действие: ");
        Logging.LOGGER.log(Level.INFO,"Ожидание ввода данных от пользователя");
        int input = in.nextInt();
        Logging.LOGGER.log(Level.SEVERE,"Пользователь ввёл данные '" + input + "'.");
        Filemanager run = new Filemanager();
        Addressbook phones = new Addressbook();
        phones.Addressbook();

        switch (input) {
            case 1:
                Logging.LOGGER.log(Level.INFO,"Отрабатывает вариант '" + input + "' в меню.");
                phones.showAddressBook();
                Logging.LOGGER.log(Level.SEVERE,"Успешно отработан '" + input + "' вариант меню.");
                break;
            case 2:
                Logging.LOGGER.log(Level.INFO,"Отрабатывает вариант '" + input + "' в меню.");
                phones.Addressbook();
                run.fileExport(phones.pb);
                Logging.LOGGER.log(Level.SEVERE,"Успешно отработан '" + input + "' вариант меню.");
                break;
            case 3:
                Logging.LOGGER.log(Level.INFO,"Отрабатывает вариант '" + input + "' в меню.");
                phones.Addressbook();
                run.fileImport(phones.pb);
                phones.showAddressBook();
                Logging.LOGGER.log(Level.SEVERE,"Успешно отработан '" + input + "' вариант меню.");
                break;
        }
    }

//    public void subMenu(){
//
//    }
}
