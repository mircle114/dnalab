package com.dnavault;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.*;
import java.text.DecimalFormat;
import java.util.function.Function;

public class DnaStrand
{
    
    public static enum CalcType 
    {
        PERCT,HYPOT,COMPOSITE,SINT,SUM_PERCT,SUM_HYPOT,SUM_ALLT
    }
    
    private final static int MAXVAL = 65536;
    private final static PrintStream out = System.out;
    private final static int SCALEFACTOR = 10;

    private Integer[] cmbo;
    private int strandIndex;
    
    // Calcs
    private double percT;
    private double hypoT;
    private double compositeT;
    
    private double sinT;
    private int sinCycles;
    private int sinPoints;
    private double[] sinSines;
    private int[] sinPts;

    private double sumTPercT;
    private double sumTHypoT;
    private double sumTSinT;
    private double sumAllT;
   
    private String strandOut;
    
    private int zone;
    private int strand;
    private String encoded;
    
    public DnaStrand(Integer[] cmbo, int strandI)
    {
        this.cmbo = cmbo;
        setZone(cmbo[0]);
        setStrand(cmbo[1]);
        setStrandIndex(strandI);
        
        setPercT();
        setHypoT();
        setCompositeT();
        setSinT();
        
        setSumTPercT();
        setSumTHypoT();
        setSumAllT();
        
        setEncoded();
    }
    
    public double getSinT()
    {
       return this.sinT;
    }

    public void setSinT()
    {
        this.sinT = calcResult(CalcType.SINT);
    }

    public String getEncoded()
    {
        return this.encoded;
    }
    
    public void setEncoded()
    {
        this.encoded = this.getPercT().toString();
    }
        
    public Integer getZone()
    {
        return this.zone;
    }
    
    public void setZone(Integer zone)
    {
        this.zone = zone;
    }
    
    public Integer getStrand()
    {
        return this.strand;
    }
    
    public void setStrand(Integer strand)
    {
        this.strand = strand;
    }
    
    public int getStrandIndex()
    {
        return this.strandIndex;
    }
    
    public void setStrandIndex(int strandIdx)
    {
        this.strandIndex = strandIdx;
    }
    
    public Integer[] getCmbo()
    {
        return this.cmbo;
    }
    
    public void setCmbo(Integer[] cmboIn)
    {
        this.cmbo = cmboIn;
    }
    
    public Double getPercT()
    {
        return this.percT;
    }
    
    public void setPercT()
    {
        this.percT = calcResult(CalcType.PERCT);
    }
    
     public Double getSumTPercT()
    {
        return this.sumTPercT;
    }
    
    public void setSumTPercT()
    {
        this.sumTPercT = calcResult(CalcType.SUM_PERCT);
    }
    
    public double getHypoT()
    {
        return this.hypoT;
    }
    
    public void setHypoT()
    {
        this.hypoT = calcResult(CalcType.HYPOT);
    }
    
    public double getSumTHypoT()
    {
        return this.sumTHypoT;
    }
    
    public void setSumTHypoT()
    {
        this.sumTHypoT = calcResult(CalcType.SUM_HYPOT);
    }

    public double getCompositeT()
    {
        return this.compositeT;
    }
    
    public void setCompositeT()
    {
        this.compositeT = calcResult(CalcType.COMPOSITE);
    }
   
    public double getSumAllT()
    {
        return this.sumAllT;
    }
    
    public void setSumAllT()
    {
        this.sumAllT = calcResult(CalcType.SUM_ALLT);
    }
  
    public double calcResult(CalcType calcType)
    {
        double result = 0.00;
        double percT = getPercT();
        double hypoT = getHypoT();
        double compositeT = getCompositeT();
        
        if(calcType.equals(CalcType.HYPOT))
        {
            Integer[] cmbos = getCmbo();
            Integer cmb1 = cmbos[0];
            Integer cmb2 = cmbos[1];
            
            result = Math.sqrt((cmb1 * cmb1) + (cmb2 * cmb2));
        }
        else if(calcType.equals(CalcType.PERCT))
        {
            double strandInd = Double.valueOf(getStrandIndex());
            result =  (strandInd / MAXVAL) * 100;
        }
        else if(calcType.equals(CalcType.COMPOSITE))
        {
            String[] justDigits = Common.getStringArrayOfDigits(percT);
            Integer[] compositeTIndexes = new Integer[] {0,1,justDigits.length-1}; 
           
            List<String> listWithIndexSelections = Common.getElementsByIndexSelection(justDigits,compositeTIndexes);
            String compositeTString = String.join("",listWithIndexSelections);
            double compositeTDouble = Double.valueOf(compositeTString);
            
            double sumOfComposite = Common.getSumOfAllDigits(compositeTDouble,false);
            
            result = compositeTDouble;
        }
        else if(calcType.equals(CalcType.SINT))
        {
            // TO DO ->>> MULTIPLYOR is hardcoded to 1 (###,###) is one point
            // 
            double radians = (Math.PI / SCALEFACTOR) * 1;
            double sines = Math.sin(radians);
            //double radians = (Math.PI / SCALEFACTOR) * i;
            result = sines;
        }
        else if(calcType.equals(CalcType.SUM_PERCT))
        {
            result = Common.getSumOfAllDigits(percT,false);
        }
        else if(calcType.equals(CalcType.SUM_HYPOT))
        {
            result = Common.getSumOfAllDigits(hypoT,false);
        }
        else if(calcType.equals(CalcType.SUM_ALLT))
        {
            double sumT1 = Common.getSumOfAllDigits(percT,false);
            double sumT2 = Common.getSumOfAllDigits(hypoT,false);
            result = sumT1 + sumT2;
        }
        
        return result;
    }
}
