package javaapplication7;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;


public class JListDemo extends JFrame {
      int i = 0;
    public JListDemo() {
        File[] fileList = getFileList("C:\\Users\\ธนพล\\Desktop\\Digital theoram");
        setSize(new Dimension(1000, 1000));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        final JLabel label = new JLabel("slect");
        String[] data = new String[fileList.length];
        System.out.println(fileList.length);
        for(File file : fileList) {
          
               data[i] = (file.getName());
                System.out.println(data[i]);
               i=i+1;
              
            }
       

        final JList dataList = new JList(data);

        dataList.addListSelectionListener(new ListSelectionListener() {


            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  label.setText(dataList.getSelectedValue().toString());
                  ExibePDF a;
                    a = new ExibePDF();
                    a.main("C:\\Users\\ธนพล\\Desktop\\Digital theoram\\"+dataList.getSelectedValue().toString());
                }
            }
        });
        add(dataList);
        add(label);

        setVisible(true);

    }
    public static File[] getFileList(String dirPath) {
            File dir = new File(dirPath);   

            File[] fileList = dir.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith(".pdf");
                }
            });
            return fileList;
        }
    public static void main(String args[]) {
        new JListDemo();
       
    }

}