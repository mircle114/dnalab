package com.dnavault;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class DnaExecCommand 
{

  private DnaExecCommand(){}

  public static void runCommand(List cmd)
  {
       /* List cmd = new ArrayList();
          cmd.add("/bin/bash");
          cmd.add("buildproject.sh");
          cmd.add("dnavault");
        */
    
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
  }
}



