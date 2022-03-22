package com.dnavault;

import javax.swing.*;
import java.awt.Insets;
import java.util.List;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import java.awt.Component;


public class CreateProjectPanel extends JPanel implements ActionListener
{
  // CONSTANTS
  private final String BTN_CREATE_PROJECT_NAME = "btnCreateProject";

  private Color originalBackground;
  protected JProgressBar progressBar;
  

  // Components
  private JTextField jtfModelVersion;
  private JTextField jtfGroupId;
  private JTextField jtfArtifactId;
  private JTextField jtfVersion;
  private JButton jbCreateProject;
  
  public CreateProjectPanel()
  {
      setMavenProjectPropertiesPanel();
      //Common.setComponentToFixedDimension(this,new Dimension(300,200)); 
      setVisible(true);
  }

  private void setMavenProjectPropertiesPanel()
  {                  
      setBorder(DnaBorderFactory.createTitledBorder("Create project",true,3));
      setLayout(new GridBagLayout());

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.weightx = 0;
      gbc.weighty = 0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.SOUTH;

      Dimension fixedSize =  new Dimension(150,23);
    
      JLabel jlModelVersion = new JLabel("modelVersion:");
      add(jlModelVersion,gbc);       

      gbc.gridx = 1;
      jtfModelVersion = new JTextField("4.0.0");
      jtfModelVersion.addFocusListener(new FocusListener() 
      {
            public void focusGained(FocusEvent e) 
            {
              jtfModelVersion.setBackground(Color.WHITE);
            }

            public void focusLost(FocusEvent e) 
            {
                
            }
      });
      add(jtfModelVersion,gbc);
      Common.setComponentToFixedDimension(jtfModelVersion,fixedSize); 

      gbc.gridx = 0;
      gbc.gridy = 1;
      JLabel jlGroupId = new JLabel("groupId:");
      add(jlGroupId,gbc);

      gbc.gridx = 1;
      jtfGroupId = new JTextField();
      jtfGroupId.addFocusListener(new FocusListener() 
      {
            public void focusGained(FocusEvent e) 
            {
              jtfGroupId.setBackground(Color.WHITE);
            }

            public void focusLost(FocusEvent e) 
            {
                
            }
      });
      add(jtfGroupId,gbc);
      Common.setComponentToFixedDimension(jtfGroupId,fixedSize);
      
      gbc.gridx = 0;
      gbc.gridy = 2;
      JLabel jlArtifactId = new JLabel("artifactId:");
      add(jlArtifactId,gbc);

      gbc.gridx = 1;
      jtfArtifactId = new JTextField();
      jtfArtifactId.addFocusListener(new FocusListener() 
      {
            public void focusGained(FocusEvent e) 
            {
                jtfArtifactId.setBackground(Color.WHITE);
            }

            public void focusLost(FocusEvent e) 
            {
                
            }
      });
      add(jtfArtifactId,gbc);
      Common.setComponentToFixedDimension(jtfArtifactId,fixedSize);
      
      gbc.gridx = 0;
      gbc.gridy = 3;
      JLabel jlVersion = new JLabel("version:");
      add(jlVersion,gbc);
      
      gbc.gridx = 1;
      jtfVersion = new JTextField("1.0-SNAPSHOT");
      jtfVersion.addFocusListener(new FocusListener() 
      {
            public void focusGained(FocusEvent e) 
            {
              jtfVersion.setBackground(Color.WHITE);
            }

            public void focusLost(FocusEvent e) 
            {
                
            }
      });
      add(jtfVersion,gbc);
      Common.setComponentToFixedDimension(jtfVersion,fixedSize);

      gbc.gridx = 0;
      gbc.gridy = 4;
      jbCreateProject = new JButton("Create");
      jbCreateProject.setName(BTN_CREATE_PROJECT_NAME);
      add(jbCreateProject,gbc);
      jbCreateProject.addActionListener(this);

      gbc.gridx = 1;
      gbc.gridy = 5;
 
      progressBar = new JProgressBar(0, 100);
      progressBar.setVisible(false);
      add(progressBar,gbc);
    
      setVisible(true);
  }

   @Override
    public void actionPerformed(ActionEvent e) 
    {
      String ctrlName = ((JButton)e.getSource()).getName();

      // If the Create button triggered the event
      if(ctrlName.equals(BTN_CREATE_PROJECT_NAME))
      {
        String errorValidationMessage = getCreateProjectValidationErrorMessage(); 
       
        if(errorValidationMessage != "")
        {
          System.out.println(errorValidationMessage);
          return;
        }

        // Otherwise all is valid on the form
        createProject();
        
      }
    }

    private void createProject()
    {
          List cmd = new ArrayList();
          cmd.add("/bin/bash");
          cmd.add("buildproject.sh");
          cmd.add(jtfGroupId.getText());
          cmd.add(jtfArtifactId.getText());
          DnaExecCommand.runCommand(cmd);
          progressBar.setVisible(true);
          progressBar.setValue(0);
          progressBar.setStringPainted(true);
          
    }
  
    private String getCreateProjectValidationErrorMessage()
    {
      String errMsg ="";
      JTextField jtfWithError = new JTextField();
      
      if(jtfModelVersion.getText().equals(""))
      {
        jtfWithError = jtfModelVersion;
        errMsg = "Missing Model Version";
      }
      else if(jtfGroupId.getText().equals(""))
      {  
        jtfWithError = jtfGroupId;
        errMsg = "Missing Group Id";
      }
      else if(jtfArtifactId.getText().equals(""))
      {
        jtfWithError = jtfArtifactId;
        errMsg = "Missing Artifact Id";
      }
      else if(jtfVersion.getText().equals(""))
      {
        jtfWithError = jtfVersion;
        errMsg = "Missing Version";
      }

      if(jtfWithError != null)
      {
        jtfWithError.setBackground(new Color(255, 0, 0, 50));
      }
      return errMsg;
    }
}
