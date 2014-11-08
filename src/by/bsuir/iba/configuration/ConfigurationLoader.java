package by.bsuir.iba.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Class {@code ConfigurationLoader} is responsible for loading configuration of a system
 * from {@code *.properties} file and fill corresponding fields of {@code Configuration}
 * class object
 *
 * @author Pavel Vashkel
 * @see Configuration
 */
public class ConfigurationLoader {
    private Properties properties = new Properties();
    private Path path;
    private Configuration configuration = Configuration.getInstance();

    /**
     * Method setting path to configuration file
     *
     * @param path is a string with path to the file
     */
    public void setPath(String path) {
        this.path = Paths.get(path);
    }

    /**
     * Method loads configuration from *.properties file and fill in
     * corresponding fields in a object of {@code Configuration} class
     */
    public void load() {
        try {
            InputStream inputStream = new FileInputStream(path.toString());
            properties.load(inputStream);
            configuration.setRoads(
                    Integer.parseInt(properties.getProperty("ROADS")));
            configuration.setRightTurns(
                    getIntArray(properties.getProperty("RIGHT_TURN_LINES"))
            );
            configuration.setLeftTurns(
                    getIntArray(properties.getProperty("LEFT_TURN_LINES"))
            );
            configuration.setStraight(
                    getIntArray(properties.getProperty("STRAIGHT_LINES"))
            );
            configuration.setOutputLines(
                    getIntArray(properties.getProperty("OUTPUT_LINES"))
            );
            configuration.setPedestrianCrossings(
                    getIntArray(properties.getProperty("PEDESTRIAN"))
            );
            configuration.setConflictMatrix(
                    getInt2DArray(properties.getProperty("CONFLICT_MATRIX"))
            );
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method convert String into array of ints by splitint with comma(",")
     *
     * @param str is a String which should be converted to array of ints
     * @return array of ints
     */
    public int[] getIntArray(String str) {
        String[] arrStr = str.split(",");
        int[] arrInt = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arrInt[i] = Integer.parseInt(arrStr[i]);
        }
        return arrInt;
    }

    /**
     * Method convert String into 2D array of ints by splitting with space(" ")
     *
     * @param str is a String which should be converted to 2D array of ints
     * @return 2D array of ints
     */
    public int[][] getInt2DArray(String str) {
        String[] arrStr = str.split(" ");
        int arrLength = arrStr.length;
        int size = (int) Math.sqrt(arrLength);
        int[][] arrInt = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arrInt[i][j] = Integer.parseInt(arrStr[j + i * size]);
            }
        }
        return arrInt;
    }

}