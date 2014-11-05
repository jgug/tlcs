package by.bsuir.iba.configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class loads configuration info from
 * *.cfg file and fill into {@code Configuration} object
 *
 * @author Pavel Vashkel
 * @see by.bsuir.iba.configuration.Configuration
 */

public class ConfigurationLoader {
    private Configuration configuration = new Configuration();
    private String path;
    private List<String> lines = new ArrayList<String>();

    /**
     * Method sets path to config file
     *
     * @param path is a string with path to config file
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Method loads significant lines from config file
     * excluding comments which is lines starts with #
     */
    public void load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#") && !line.isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method extracts digits from string
     *
     * @param str is a string of which digits
     *            must be extracted
     * @return {@code String} value of digits containing
     * in a input string
     * @see java.lang.String
     */
    public String getDigits(String str) {
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
     * Method parse ArrayList of Strings from
     * config file and sets appropriate values
     * to fields of Configuration class object
     * @see by.bsuir.iba.configuration.Configuration
     */
    public void parse() {
        configuration.setRoads(Integer.parseInt((getDigits(lines.get(0)))));
        configuration.setRightTurns(getDigits(lines.get(1)));
        configuration.setLeftTurns(getDigits(lines.get(2)));
        configuration.setStraight(getDigits(lines.get(3)));
        configuration.setOutputLines(getDigits(lines.get(4)));
        configuration.setPedestrianCrossings(getDigits(lines.get(5)));
        lines = lines.subList(6, lines.size());
        int size = lines.size();
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] array = lines.get(i).split("");
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(array[j]);
            }
        }
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        configuration.setConflictMatrix(arr);
    }
}
