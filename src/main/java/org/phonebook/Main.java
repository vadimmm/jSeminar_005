package org.phonebook;


import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

//Создать телефонный справочник с возможностью импорта и экспорта данных в нескольких форматах.
//  под форматами понимаем структуру файлов, например:
//  - в файле на одной строке хранится одна часть записи, пустая строка - разделитель
public class Main {
    public static void main(String[] args) {
        Logging.LOGGER.log(Level.INFO,"*".repeat(33));
        Logging.LOGGER.log(Level.INFO,"Программа запущена");
        
        Menu.mainMenu();

        Logging.LOGGER.log(Level.INFO,"Программа завершила работу");
    }

}