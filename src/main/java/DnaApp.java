import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.*;
import java.text.DecimalFormat;
import java.util.function.Function;

public class DnaApp
{
	public static void main(String[] args) 
	{
	    // Create a instance of Combo utility    
       /* CombinationUtil cu = new CombinationUtil();
        // Run a sample test 
        Integer[] sampleIn = new Integer[]{88,30};
        String encoded = cu.getDnaStrand(sampleIn).getEncoded();
        System.out.printf("Sample in: %s | Sample out: %s \n",Arrays.toString(sampleIn),encoded);
        CombinationUtil.runDnaMatchTest();*/
        
        //GraphApp.man();
	}
	
	public static class Common
	{
	    
	    private Common(){}

        // Setting precision upto 2 decimal point
        public static DecimalFormat decimalFormat = new DecimalFormat("#.##");

        public static List<String> getElementsByIndexSelection(String[] from, Integer[] indexesToCollect)
        {
            List<String> selectedElements = IntStream
                .range(0,from.length)
                .filter(i -> Arrays.asList(indexesToCollect).contains(i))
                .mapToObj(i -> from[i])
                .collect(Collectors.toList());
            return selectedElements;
        }

        public static Double getSumOfAllDigits(Double inDouble, boolean runAsPlusMinus)
        {
            String filteredIn = inDouble.toString().replaceAll("[^0-9,]","");
            String[] filteredInStrings = filteredIn.split("");
            List<String> myTList = new ArrayList<>();
            Collections.addAll(myTList,filteredInStrings);
            // Back to a string but just numberStr
            String stringNewT = String.join("",filteredIn);
            List<Integer> listOfTNumbers = Arrays.asList(stringNewT.split(""))
            .stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
            Integer sumT = 0;
            
            if(runAsPlusMinus)
            {
                //int result = listOfTNumbers.stream().reduce();  
            }
            else
            {
                sumT = listOfTNumbers.stream().filter(i -> i > 0).mapToInt(i -> i).sum();
            }
            
            return sumT.doubleValue();
        }
        
        public static String[] getStringArrayOfDigits(Double inDouble)
        {
            String filtered = inDouble.toString().replaceAll("[^0-9,]","");
            return filtered.split("");
        }
        
        public static List<String> getListOfDigitStrings(Double in)
	    {
	        String[] numberStr = getStringArrayOfDigits(in);
	         List<String> returnList = new ArrayList<>();
            // Copy the array of string numbers to a generic list
            Collections.addAll(returnList, numberStr);
	        return returnList;
	    }
	    
	}
}


