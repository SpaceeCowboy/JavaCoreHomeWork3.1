import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StringBuilder logger = new StringBuilder();

        List<File> folders = Arrays.asList(
                new File("D:/Games", "src"),
                new File("D:/Games", "res"),
                new File("D:/Games", "savegames"),
                new File("D:/Games", "temp"),
                new File("D:/Games/src", "main"),
                new File("D:/Games/src", "test"),
                new File("D:/Games/res", "drawables"),
                new File("D:/Games/res", "vectors"),
                new File("D:/Games/res", "icons")
        );

        List<File> files = Arrays.asList(
                new File("D:/Games/src/main", "Main.java"),
                new File("D:/Games/src/main", "Utils.java"),
                new File("D:/Games/temp", "temp.txt")
        );

        folders.stream().forEach(folder -> {
            if (folder.mkdir()) {
                logger.append("Каталог " + folder.getName() + " успешно создан" + "\n");
                System.out.println("Каталог " + folder.getName() + " успешно создан");
            } else {
                logger.append("Произошла ошибка при создании каталога " + folder.getName() + "\n");
                System.out.println("Произошла ошибка при создании каталога " + folder.getName());
            }
        });

        files.stream().forEach(file -> {
            try {
                if (file.createNewFile()) {
                    logger.append("Файл " + file.getName() + " успешно создан" + "\n");
                    System.out.println("Файл " + file.getName() + " успешно создан");
                }
            } catch (IOException ex) {
                logger.append(ex.getMessage() + "\n");
                System.out.println(ex.getMessage());
            }
        });

        try (FileOutputStream record = new FileOutputStream("D:/Games/temp/temp.txt")) {
            byte[] bytes = logger.toString().getBytes();
            record.write(bytes, 0, bytes.length);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
