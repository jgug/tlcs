package by.bsuir.iba.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This class loads configuration info from
 * *.cfg file and fill into {@code Configuration} object
 *
 * @author Pavel Vashkel
 * @see by.bsuir.iba.configuration.Configuration
 */

@Deprecated
public class ConfigurationLoader {
    private Configuration configuration = new Configuration();
    private Path path;
    private List<String> lines = new ArrayList<>();
    private int roads;

    /**
     * Method sets path to config file
     *
     * @param path is a string with path to config file
     */
    public void setPath(String path) {
        this.path = Paths.get(path);
    }

    /**
     * Method retrieve configuration lines from configuration file and
     * store them into ArrayList of Strings
     */
    public void load() {
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = lines.size() - 1; i >= 0; i--) {
            if (lines.get(i).startsWith("#")) {
                lines.remove(i);
            }
        }
    }

    /**
     * Method extracts digit from string
     *
     * @param str is a string of which digits must be extracted
     * @return {@code String} value of digits containing in a input string
     */
    public String getDigit(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > 47 && c < 58) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Method extracts digit from string
     *
     * @param str is a string of which digits must be extracted
     * @return {@code int[]} array of digits containing in a input string
     */
    public int[] getDigits(String str) {
        String[] arrStr = str.split(" ");
        int[] arrInt = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arrInt[i] = Integer.parseInt(arrStr[i]);
        }
        return arrInt;
    }

    /**
     * Method extracts two dimensional array from list of strings
     *
     * @param lstr is a {@code ArrayList<Strings>} of which digits must be extracted
     * @return {@code int[][]} array of digits containing in a input string
     */
    public int[][] getMatrix(List<String> lstr) {
        int[][] arr = new int[lstr.size()][lstr.size()];
        for (int i = 0; i < lstr.size(); i++) {
            String[] arrStr = lstr.get(i).split(" ");
            for (int j = 0; j < lstr.size(); j++) {
                arr[i][j] = Integer.parseInt(arrStr[j]);
            }
        }
        return arr;
    }

    /**
     * Method parse ArrayList of Strings from
     * config file and sets appropriate values
     * to fields of Configuration class object
     *
     * @see by.bsuir.iba.configuration.Configuration
     */
    public void parse() {
        roads = Integer.parseInt((getDigit(lines.get(0))));
        configuration.setRoads(roads);
        configuration.setRightTurns(getDigits(lines.get(1)));
        configuration.setLeftTurns(getDigits(lines.get(2)));
        configuration.setStraight(getDigits(lines.get(3)));
        configuration.setOutputLines(getDigits(lines.get(4)));
        configuration.setPedestrianCrossings(getDigits(lines.get(5)));
        lines = lines.subList(6, lines.size());
        configuration.setConflictMatrix(getMatrix(lines));
    }
}
