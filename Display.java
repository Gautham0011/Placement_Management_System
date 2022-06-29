import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Display extends JFrame implements ActionListener
{
    
    private JLabel displayheading;
    private JTextArea output;
    private JButton display,back;
    
    Container con=null;

    Display()
    {

        super("Display Record");
        con = getContentPane();
        con.setLayout(null);
        Color  lightBlue = new Color(0,255,255);
        con.setBackground(lightBlue);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        Color blue = new Color(30,144,255);
        Font font = new Font("Verdana", Font.BOLD, 16);

        displayheading=new JLabel("The records are:");
        displayheading.setBounds(200, 2, 700,150);
        displayheading.setFont(font);
        displayheading.setForeground(Color.BLACK);

        output=new JTextArea();
        output.setBounds(20, 150, 1200,400);
        output.setFont(font);
        output.setForeground(Color.BLACK);
        output.setEditable(false);

        display = new JButton("Display");
		display.setBounds(400,600,150,40);
		display.addActionListener(this);
        display.setFont(font);
        Color pul = new Color(0,0,255);
        Border bored = BorderFactory.createLineBorder(pul,5);
        display.setBorder(bored);
        display.setForeground(Color.WHITE);
        display.setBackground(blue);

        back = new JButton("Go Back");
		back.setBounds(600,600,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setBorder(bored);
        back.setForeground(Color.WHITE);
        back.setBackground(blue);

        con.add(displayheading);
		con.add(output);
        con.add(display);
        con.add(back);

    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==display)
        {
			try
            {
                String name = "", usn ="", sem = "", branch = "", cgpa= "", nob="", company="",ctc="",comments="", r;

                File temp = new File("temp.txt");
				Boolean createNewFile1 = temp.createNewFile();
                BufferedWriter pw = new BufferedWriter(new FileWriter("temp.txt"));
                String b = "NAME\t|USN\t|SEM\t|BRANCH\t|CGPA\t|NOB\t|COMPANY\t|CTC\t|COMMENTS";
                pw.write(b); 
                pw.write("\n");

                BufferedReader br = new BufferedReader(new FileReader("student.txt"));
                while((r= br.readLine()) !=null)
		        {
		        	String[] result = r.split("\\|");
		        	name=result[0];
		        	usn=result[1];
		        	sem= result[2];
		        	branch=result[3];
		        	cgpa=result[4];
		        	nob=result[5];
                    company=result[6];
                    ctc=result[7];
                    comments=result[8];
                    if(name.equals("999"))
                        break;
                    String bb = name  + "\t|" + usn + "\t|" + sem + "\t|" + branch + "\t|" + cgpa + "\t|" + nob + "\t|" + company + "\t|" + ctc + "\t|" + comments;
                    pw.write(bb);
                    pw.write("\n");
		        }
                br.close();
                pw.close();
                File file = new File("temp.txt");
                BufferedReader br1 = new BufferedReader(new FileReader(file));
                output.read(br1,null);
                br1.close(); 
                output.requestFocus();
                file.delete();  
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        if(ae.getSource()==back)
        {
            try
            {
                this.dispose();
                Home h=new Home();
                h.setSize(2300,790);
                h.setVisible(true);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[])
    {
        Display dis=new Display();
		dis.setSize(2300,790);
		dis.setVisible(true);
    }   
}
