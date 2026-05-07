package com.library.util;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Reusable file-handling utility for reading, writing, updating,
 * and deleting records in pipe-delimited .txt files.
 */
public final class FileUtil {

    private FileUtil() {
        // utility class – prevent instantiation
    }

    /**
     * Read all non-blank lines from a text file.
     */
    public static List<String> readAllLines(String filePath) {
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return lines;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Append a single line to the end of a file. Creates file if absent.
     */
    public static void appendLine(String filePath, String line) {
        ensureFileExists(filePath);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Overwrite a file with the given list of lines.
     */
    public static void writeAllLines(String filePath, List<String> lines) {
        ensureFileExists(filePath);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, false))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update a record whose first pipe-delimited field matches the given id.
     */
    public static void updateLine(String filePath, String id, String newLine) {
        List<String> lines = readAllLines(filePath);
        List<String> updated = new ArrayList<>();
        for (String line : lines) {
            String lineId = line.split("\\|")[0].trim();
            if (lineId.equals(id)) {
                updated.add(newLine);
            } else {
                updated.add(line);
            }
        }
        writeAllLines(filePath, updated);
    }

    /**
     * Delete a record whose first pipe-delimited field matches the given id.
     */
    public static void deleteLine(String filePath, String id) {
        List<String> lines = readAllLines(filePath);
        List<String> remaining = new ArrayList<>();
        for (String line : lines) {
            String lineId = line.split("\\|")[0].trim();
            if (!lineId.equals(id)) {
                remaining.add(line);
            }
        }
        writeAllLines(filePath, remaining);
    }

    /**
     * Generate the next numeric ID based on existing records.
     */
    public static String generateNextId(String filePath) {
        List<String> lines = readAllLines(filePath);
        int maxId = 0;
        for (String line : lines) {
            try {
                int lineId = Integer.parseInt(line.split("\\|")[0].trim());
                if (lineId > maxId) maxId = lineId;
            } catch (NumberFormatException ignored) { }
        }
        return String.valueOf(maxId + 1);
    }

    /**
     * Ensure the file (and parent directories) exist.
     */
    public static void ensureFileExists(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
