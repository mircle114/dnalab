package com.dnavault;

import javax.swing.*;
import javax.swing.JFileChooser;
import java.io.File;

public class DnaFileChooser extends JFileChooser
{
  public DnaFileChooser(JPanel displayOn)
  {
      this.setCurrentDirectory(new File(System.getProperty("user.home")));
      int result = this.showOpenDialog(displayOn);
      if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = this.getSelectedFile();
        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
      }
  }
}