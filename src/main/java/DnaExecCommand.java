package com.dnavault;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class DnaExecCommand 
{
 public static void main(String[] args) 
  {

    List cmd = new ArrayList();
    cmd.add("/bin/bash");
    cmd.add("buildproject.sh");
    cmd.add("java-mvn-start");
  
    try
    {
      ProcessBuilderWrapper pbd = new ProcessBuilderWrapper(new File("src/main/resources/scripts"),cmd);
      
      System.out.println("Command has terminated with status: " + pbd.getStatus());
      System.out.println("Output:\n" + pbd.getInfos());
      System.out.println("Error: " + pbd.getErrors());
    }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    
    
    /* Process p;
    try 
    {
       String[] cmd = {"mvn","archetype:generate"};
       p = Runtime.getRuntime().exec(cmd); 
      p.waitFor(); 
       BufferedReader reader=new BufferedReader(new InputStreamReader(
        p.getInputStream())); 
       String line; 
       while((line = reader.readLine()) != null) 
       { 
        System.out.println(line);
       } 
    } 
    catch (IOException e) 
    {
     // TODO Auto-generated catch block
     e.printStackTrace();
    } 
    catch (InterruptedException e) 
    {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
 }*/
}
}



