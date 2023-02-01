package org.phonebook;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;

public class Filemanager {
    static String FILE_PATH = "./src/main/java/org/phonebook/";
    String FILE_NAME_EXPORT = "export.csv";
    String FILE_PATH_FULL = FILE_PATH+FILE_NAME_EXPORT;
    public void fileExport(ArrayList<Phonebook> pb){
        Logging.LOGGER.log(Level.SEVERE,"Запущен экспорт записной книги");
        try(FileWriter writer = new FileWriter(FILE_PATH + FILE_NAME_EXPORT, false))
        {
            // запись всей строки
            for(Phonebook i: pb){
                String text = i.getName() + ";" + i.getPhone() + ";" + i.getCity();
                writer.write(text);
                Logging.LOGGER.log(Level.SEVERE,"Строка с данными '" + text + "' успешно экспортирована" );
//                Logging.LOGGER.log(Level.WARNING,"Строка с данными '" + text + "' успешно экспортирована" );
//                Logging.LOGGER.log(Level.INFO,"Строка с данными '" + text + "' успешно экспортирована" );
//                Logging.LOGGER.log(Level.CONFIG,"Строка с данными '" + text + "' успешно экспортирована" );
//                Logging.LOGGER.log(Level.FINE,"Строка с данными '" + text + "' успешно экспортирована" );
//                Logging.LOGGER.log(Level.FINER,"Строка с данными '" + text + "' успешно экспортирована" );
//                Logging.LOGGER.log(Level.FINEST,"Строка с данными '" + text + "' успешно экспортирована" );
//                Logging.LOGGER.log(Level.ALL,"Строка с данными '" + text + "' успешно экспортирована" );
                // запись по символам
                writer.append('\n');
//                writer.append('E');
            }
            writer.flush();
            Logging.LOGGER.log(Level.SEVERE,"Файл экспорта записан");
        }
        catch(IOException ex){
            Logging.LOGGER.log(Level.WARNING,"Произошла ошибка при экспорте");
            System.out.println(ex.getMessage());
        }
    }

    public void fileImport(ArrayList<Phonebook> pb){
        Logging.LOGGER.log(Level.INFO,"Запущен импорт записной книги");
        try {
            File file = new File(FILE_PATH_FULL);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            Logging.LOGGER.log(Level.SEVERE,"Проверка наличия строки с данными в файле, найдено значение '" + line + "'" );
            while (line != null) {
                String[] tmp = line.split(";");
                pb.add(new Phonebook(tmp[0], tmp[1], tmp[2]));
                Logging.LOGGER.log(Level.SEVERE,"Строка с данными '" + line + "' успешно обработана" );
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            Logging.LOGGER.log(Level.WARNING,"Произошла ошибка, файл импорта не найден");
            e.printStackTrace();
        } catch (IOException e) {
            Logging.LOGGER.log(Level.WARNING,"Произошла ошибка при импорте");
            e.printStackTrace();
        }
    }
}
