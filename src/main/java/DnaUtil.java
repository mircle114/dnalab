package com.dnavault;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.*;
import java.text.DecimalFormat;
import java.util.function.Function;
import java.util.function.Predicate;



class DnaUtil
{

    private final static Integer MIN = 1;
    private final static Integer MAX = 258;
    private final static Integer REALMAX = 255;
    private final static IntStream LIMITRANGE = IntStream.range (MIN, MAX);
    private static LinkedHashMap <String,Double> dnaMap = new LinkedHashMap<>();
    private static Integer counter = 0;
    private final static int LIMIT_PRINT = 900;
    private final static int NOT_FOUND = -1;
    private final static Float LOT_SIZE = REALMAX.floatValue() * REALMAX.floatValue();
    private static PrintStream out = System.out;
    
    private static List<String> listDnaResults = new ArrayList<>(); 
    private static List<String> listDupsCombo = new ArrayList<>();
    private static List<DnaStrand> listDnaStrands = new ArrayList<>();
    private static List<String> listEnd = new ArrayList<>();


    public DnaUtil()
    {
        if(dnaMap.size() == 0)
        {
            System.out.println("Loading combos");
            getCombinations();
            System.out.println("Completed");
        }
    }


    // Encodes the data to DNA charset      
    /*public String encode(Integer[] strand, DnaStrand.CalcType calcType)
    {
        String result = "";
        DnaStrand dnaStrandFound = getDnaStrand(strand);
      
        if(!dnaStrandFound.equals(null))
        {
            if(calcType.equals(DnaStrand.CalcType.COMPOSITE))
            {   
                result = dnaStrandFound.getCompositeT().toString();
            }   
            else if(calcType.equals(DnaStrand.CalcType.PERCT))
            {
                result = dnaStrandFound.getPercT().toString();
            }
            else if(calcType.equals(DnaStrand.CalcType.HYPOT))
            {
                result = dnaStrandFound.getHypoT().toString();
            }
            else if(calcType.equals(DnaStrand.CalcType.SUM_PERCT))
            {
                result = dnaStrandFound.getSumTPercT().toString();
            }
            else if(calcType.equals(DnaStrand.CalcType.SUM_HYPOT))
            {
                result = dnaStrandFound.getSumTHypoT().toString();
            }
            else if(calcType.equals(DnaStrand.CalcType.SUM_ALLT))
            {
                result = dnaStrandFound.getSumAllT().toString();
            }
        }
        return result;
    }
  
    // Decodes the DNA charset
    public static String decode(Double ncoded)
    {
        Predicate<DnaStrand> bySumTPercT = dnaStrand -> dnaStrand.getSumTPercT().equals(ncoded);
        Predicate<DnaStrand> bySumTHypoT = dnaStrand -> dnaStrand.getSumTHypoT().equals(ncoded);
   
        List<DnaStrand> dnaListSumTMatch = getListOfStrands().stream()
        .filter(bySumTHypoT)
        //.filter(bySumTPercT.and(bySumTHypoT))
        //.filter(bySumTPercT.or(bySumTHypoT))
        .collect(Collectors.toList());
        return Integer.toString(dnaListSumTMatch.size());
    }
    */
    
    // This method is used to run Match test for strand distinctiveness 
    // allows us to compare match/resuts based on experimental calcs
    public static void runDnaMatchTest()
    {
        List<String> listResults = new ArrayList<>();
                    
        for(DnaStrand dnaStr : listDnaStrands)
        {
            // Index of strand in map
            int strandIdx = dnaStr.getStrandIndex();
            // PercT
            Double percT = dnaStr.getPercT();
            String[] percTs = Common.getStringArrayOfDigits(percT);
            // HypoT 
            Double hypoT = dnaStr.getHypoT();
            String[] hypoTs = Common.getStringArrayOfDigits(hypoT);
            // SumT
            Double sumT = dnaStr.getSumAllT();
            // Sum of all the digits in the array
            Double sumDigits = Common.getSumOfAllDigits(percT,false);
            // Composite
            double composit = dnaStr.getCompositeT();
            
            // Add to our result list to run some tests on
            listResults.add(percT.toString());
        }
        
         // Collect the list as map by groupingBy() method
        Map<String,Long> result1Map 
            = listResults.stream().collect(
                Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()));
        //out.println(result1Map); 
          
        Map<String, Long> result1MapForCount = result1Map.entrySet()
        .stream().filter(map -> map.getValue() == 1)
        .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        out.println(result1MapForCount);
    /*    
                    
        List<Double> resultTestList = new ArrayList<>();  
        
        for(Map.Entry <String, Long> entry: result1Map.entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            
            Double doubleKey = Double.valueOf(key);
            Double doubleVal = Double.valueOf(entry.getValue());
            Double resulTing = (doubleVal / doubleKey) * 100;
            resultTestList.add(resulTing);
            
           //out.printf("Key: %s :: Value: %s \n",key,value);
        }
        
        Map<Double,Long> testerMap = resultTestList.stream()
        .collect(Collectors
        .groupingBy(Function.identity(),Collectors.counting()));
        
        Map<Double, Long> newTesterMap2 = testerMap.entrySet()
        .stream()
        .filter(map -> map.getValue() == 2)
        .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        
        
        // Collect the list as map by groupingBy() method
        Map<String,Long> resultDivMap
            = listResults.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            */
    }
    
    // Get the DnaStrand object that matches this zone->strand
    public static DnaStrand getDnaStrand(Integer[] inStrand)
    {
        Integer zone = inStrand[0];
        Integer strand = inStrand[1];
        
        Predicate<DnaStrand> byZone = dnaStrand -> dnaStrand.getZone().equals(zone);
        Predicate<DnaStrand> byStrand = dnaStrand -> dnaStrand.getStrand().equals(strand);
        
        List<DnaStrand> lstDnaStrand = getListOfStrands().stream().filter(byZone.and(byStrand)).collect(Collectors.toList());
        DnaStrand dna = lstDnaStrand.size() == 1 ? lstDnaStrand.get(0) : null;
        
        return dna;
    }
    
    // Get our collection of DnaStrand objects
    private static List<DnaStrand> getListOfStrands()
    {
        return listDnaStrands;
    }
    
    /* arr[] ---> Input Array
     data[] ---> Temporary array to store current combination
     start & end ---> Starting and Ending indexes in arr[]
     index ---> Current index in data[]
     r ---> Size of a combination to be printed */
    private static void combinationUtil (Integer arr[], Integer data[], int start,
    		       int end, int index, int r)
    {
        // Current combination is ready to be printed
        if (index == r)
        {
            counter++;
            Integer[] combo = data.clone();
            // Build up our Dna strands
            DnaStrand dnaStrand = new DnaStrand(combo,counter);
            listDnaStrands.add(dnaStrand);
            getCombos().put(Arrays.toString(combo),dnaStrand.getPercT());
            // Recursion is complete for this combo
            return;
        } // End if combo ready to print 
        
        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int iCurrIndex = start;
         (iCurrIndex <= end && end - iCurrIndex + 1 >= r - index);
         iCurrIndex++)
          {
            data[index] = arr[iCurrIndex];
            combinationUtil (arr, data, start, end - 1, index+1, r);
          }
    }
   
    /* getter for list of combos collected */
    public static LinkedHashMap<String,Double> getCombos()
    {
        return dnaMap;
    }
    
    // The main function that creates all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    private static void loadCombinations (Integer arr[], int n, int r, int outputLimit)
    {
        // Print all combination using temporary array 'data[]'
        combinationUtil (arr, new Integer[r], 0, n - 1, 0, r);
    }
    
    // Gets the index within List<int[]> of a given sample 
    private static int getTranslationIndex (Integer[] strand)
    {
        String inStrand = Arrays.toString(strand);
        
        LinkedHashMap <String,Double> combos = getCombos();
        List keys = new ArrayList (combos.keySet());
        for (int i = 0; i < keys.size (); i++)
          {
        String key = keys.get (i).toString ();
        if (key.equals (inStrand))
          {
            System.out.println (key);
            return i;
          }
          }
        return NOT_FOUND;
    }
    
    //*Driver function to check for above function
    private static LinkedHashMap<String,Double> getCombinations()
    {
        Stream<Integer> boxedtest = LIMITRANGE.boxed();
        Integer[] result = boxedtest.toArray(Integer[]::new);
        int r = 2;
        int n = result.length;
        loadCombinations (result, n-1, r, LIMIT_PRINT);
        
      
        
        return getCombos();
    }
}
