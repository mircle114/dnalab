package com.dnavault;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.*;
import java.util.function.Function;
import java.text.DecimalFormat;
import javax.swing.JComponent;
import java.awt.Dimension;
import javax.swing.border.*;

public class Common
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

        public static char ConvertIntToChar(int intToConvert)
        {
          return (char)(intToConvert + '0');
        }

        // GUI Helpers
        public static void setComponentToFixedDimension(JComponent component, Dimension fixedDimension)
        {
            component.setSize(fixedDimension);
            component.setPreferredSize(fixedDimension);
            component.setMaximumSize(fixedDimension);
            component.setMinimumSize(fixedDimension);
        }

        public static void setComponentPadding(JComponent component,int top, int left, int bottom, int right )
    {
        Border currentBorder = component.getBorder();
        Border emptyBorder = new EmptyBorder(top,left,bottom,right);
        component.setBorder(new CompoundBorder(currentBorder,emptyBorder));
    }
	}
