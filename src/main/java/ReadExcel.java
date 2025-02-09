import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ReadExcel {

    private static final String FILE_PATH = "src\\test\\java\\sheets\\new.xlsx";
    private static final String SHEET_NAME = "Sheet1";
    private static final String DELIMITER = "-";
    private static final int ROW_INDEX = 0;
    private static final int CELL_INDEX = 0;

    public static void main(String[] args) {
        try {
            File file = new File(FILE_PATH);
            if (!isFileExists(file)) return;

            try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {
                String cellValue = readCellValue(workbook);
                String[] splitWords = cellValue.split(DELIMITER);
                long wordCount = countWords(splitWords);
                System.out.println("Number of words: " + wordCount);
                String wordToSearch = "hockey";
                boolean isWordPresent = checkWordExists(splitWords, wordToSearch);

                printWordSearchResult(wordToSearch, isWordPresent);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }

    }

    private static boolean isFileExists(File file) {
        if (!file.exists()) {
            System.err.println("File not found at: " + file.getPath());
            return false;
        }
        return true;
    }

    private static void printWordSearchResult(String wordToSearch, boolean isWordPresent) {
        System.out.println("Word to be searched: " + wordToSearch);
        System.out.println("Is there word present? - " + (isWordPresent ? "Yes" : "No"));
    }

    private static long countWords(String[] splitWords) {
        return Arrays.stream(splitWords).count();
    }

    private static String readCellValue(XSSFWorkbook workbook) {
        XSSFCell cell = workbook.getSheet(ReadExcel.SHEET_NAME)
                .getRow(ReadExcel.ROW_INDEX)
                .getCell(ReadExcel.CELL_INDEX);
        return cell.getStringCellValue();
    }

    private static boolean checkWordExists(String[] splitWords, String targetWord) {
        return Arrays.stream(splitWords).anyMatch(word -> word.equalsIgnoreCase(targetWord));
    }
}