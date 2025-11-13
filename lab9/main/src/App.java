import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class App {

    private static final String SURNAME = "Коростелев";
    private static final String NAME = "Сергей";

    public static void main(String[] args) {
        try {
            Path surnameDir = Paths.get(SURNAME);
            Files.createDirectories(surnameDir); 
            System.out.println("a. Создана директория: " + surnameDir);

            Path nameFile = surnameDir.resolve(NAME);
            Files.createFile(nameFile);
            System.out.println("b. Создан файл: " + nameFile);

            Path dir3 = surnameDir.resolve("dir1/dir2/dir3");
            Files.createDirectories(dir3);
            Path copiedFile = dir3.resolve(NAME);
            Files.copy(nameFile, copiedFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("c. Созданы директории dir1/dir2/dir3 и скопирован файл: " + copiedFile);

            Path dir2 = surnameDir.resolve("dir1/dir2");
            Path file1 = dir2.resolve("file1");
            Files.createFile(file1);
            System.out.println("d. Создан файл: " + file1);

            Path file2 = dir2.resolve("file2");
            Files.createFile(file2);
            System.out.println("e. Создан файл: " + file2);

            System.out.println("\nf. Рекурсивный обход директории " + surnameDir + ":");
            Files.walkFileTree(surnameDir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    System.out.println("F " + surnameDir.relativize(file));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    System.out.println("D " + surnameDir.relativize(dir));
                    return FileVisitResult.CONTINUE;
                }
            });

            Path dir1 = surnameDir.resolve("dir1");
            deleteDirectoryRecursively(dir1);
            System.out.println("g. Удалена директория: " + dir1);

            System.out.println("\n Все пункты задания выполнены!");

        } catch (IOException e) {
            System.err.println("Ошибка при выполнении операций с файлами: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void deleteDirectoryRecursively(Path directory) throws IOException {
        if (!Files.exists(directory)) {
            return;
        }

        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}