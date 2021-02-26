package Util;

import java.util.regex.Pattern;


/**
 * Classe de ProjectUtils
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class ProjectUtils {
    
    
    
    /* REGEX PATTERNS*/
        //Pattern for integer value
    private final static Pattern integerPattern = Pattern.compile("^[1-9]\\d*$");
        //Pattern for float 
    private final static Pattern numericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    
    
    /**
     * Check if given String is valid and returns its value as int else return -1
     * 
     * @param s
     * @return
     */
    public static int stringIsAnInteger(String s){
        return integerPattern.matcher(s).matches() ? Integer.parseInt(s) : Integer.MAX_VALUE;
    }

    

    /**
     * Check if given String is valid and returns its value as float else return -1
     * @param num
     * @return Double
     */
    public static Double isNumeric(String num){
        return numericPattern.matcher(num).matches() ? Double.parseDouble(num) : Double.MAX_VALUE;
    }
    
}
