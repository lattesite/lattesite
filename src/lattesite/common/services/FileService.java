package lattesite.common.services;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

/** File system operations used during site generation. */
public class FileService {

    private final LogService logService;

    public FileService(LogService logService) {
        this.logService = logService;
    }

    /**
     * Writes a file on disk with the given string using UTF-8.
     *
     * @param file     - The file destination on disk
     * @param contents - The string data
     * @throws Exception - If any problems occur
     */
    public void writeFile(String file, String contents) throws Exception {
        this.logService.log("Writing file \"" + file + "\".");
        try {
            FileUtils.writeStringToFile(new File(file), contents, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new Exception(exception);
        }
    }

    /**
     * Copies all files and subdirectories from one directory to another.
     *
     * @param from the source directory path
     * @param to   the destination directory path
     */
    public void copyDirectory(String from, String to) throws Exception {
        this.logService.log("Copying contents from \"" + from + "\" to \"" + to + "\".");
        try {
            FileUtils.copyDirectory(new File(from), new File(to));
        } catch (IOException exception) {
            throw new Exception(exception);
        }
    }

    /**
     * Deletes a directory and all its contents; does nothing if the directory does not exist.
     *
     * @param folder the path of the directory to delete
     */
    public void deleteDirectory(String folder) throws Exception {
        this.logService.log("Deleting folder \"" + folder + "\"...");
        Path path = Paths.get(folder);
        if (!Files.exists(path)) {
            return;
        }

        // Use NIO traversal (faster) + Commons FileUtils for fallback deletion
        Files.walk(path)
                .sorted(Comparator.reverseOrder())
                .parallel()
                .forEach(p -> {
                    try {
                        Files.deleteIfExists(p);
                    } catch (IOException e) {
                        // Commons fallback
                        FileUtils.deleteQuietly(p.toFile());
                    }
                });
        this.logService.log("Deletion done.");
    }

    /** @return {@code true} if the file or directory at the given path exists */
    public boolean exists(String file) {
        return new File(file).exists();
    }

    /**
     * Reads the contents of a file as a UTF-8 string.
     *
     * @param file the path to the file
     * @return the file contents as a string
     */
    public static String readFileAsString(String file) throws Exception {
        return readFileAsString(new File(file));
    }

    /**
     * Reads the contents of a file as a UTF-8 string.
     *
     * @param file the file to read
     * @return the file contents as a string
     */
    public static String readFileAsString(File file) throws Exception {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8.name());
    }

}
