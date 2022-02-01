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
        PERCT,HYPOT,COMPOSITE,SUM_PERCT,SUM_HYPOT,SUM_ALLT
    }
    
    private final static int MAXVAL = 65536;
    private final static PrintStream out = System.out;
   
    private Integer[] cmbo;
    private int strandIndex;
    
    private Double percT;
    private Double hypoT;
    private String compositeT;
    
    private Double sumTPercT;
    private Double sumTHypoT;
    private Double sumAllT;
   
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
        
        setSumTPercT();
        setSumTHypoT();
        setSumAllT();
        
        setEncoded();
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
    
    public Double getHypoT()
    {
        return this.hypoT;
    }
    
    public void setHypoT()
    {
        this.hypoT = calcResult(CalcType.HYPOT);
    }
    
    public Double getSumTHypoT()
    {
        return this.sumTHypoT;
    }
    
    public void setSumTHypoT()
    {
        this.sumTHypoT = calcResult(CalcType.SUM_HYPOT);
    }

    public String getCompositeT()
    {
        return this.compositeT;
    }
    
    public void setCompositeT()
    {
        this.compositeT = calcResult(CalcType.COMPOSITE).toString();
    }
   
    public Double getSumAllT()
    {
        return this.sumAllT;
    }
    
    public void setSumAllT()
    {
        this.sumAllT = calcResult(CalcType.SUM_ALLT);
    }
  
    public Double calcResult(CalcType calcType)
    {
        Double result = 0.00;
        Double percT = getPercT();
        Double hypoT = getHypoT();
        String compositeT = getCompositeT();
        
        if(calcType.equals(CalcType.HYPOT))
        {
            Integer[] cmbos = getCmbo();
            Integer cmb1 = cmbos[0];
            Integer cmb2 = cmbos[1];
            
            result = Math.sqrt((cmb1 * cmb1) + (cmb2 * cmb2));
        }
        else if(calcType.equals(CalcType.PERCT))
        {
            Double strandInd = Double.valueOf(getStrandIndex());
            result =  (strandInd / MAXVAL) * 100;
        }
        else if(calcType.equals(CalcType.COMPOSITE))
        {
            String[] justDigits = Main.Common.getStringArrayOfDigits(percT);
            Integer[] compositeTIndexes = new Integer[] {0,1,justDigits.length-1}; 
           
            List<String> listWithIndexSelections = Main.Common.getElementsByIndexSelection(justDigits,compositeTIndexes);
            String compositeTString = String.join("",listWithIndexSelections);
            Double compositeTDouble = Double.valueOf(compositeTString);
            
            Double sumOfComposite = Main.Common.getSumOfAllDigits(compositeTDouble,false);
            
            result = compositeTDouble;
        }
        else if(calcType.equals(CalcType.SUM_PERCT))
        {
            result = Main.Common.getSumOfAllDigits(percT,false);
        }
        else if(calcType.equals(CalcType.SUM_HYPOT))
        {
            result = Main.Common.getSumOfAllDigits(hypoT,false);
        }
        else if(calcType.equals(CalcType.SUM_ALLT))
        {
            Double sumT1 = Main.Common.getSumOfAllDigits(percT,false);
            Double sumT2 = Main.Common.getSumOfAllDigits(hypoT,false);
            result = sumT1 + sumT2;
        }
        
        return result;
    }
}
