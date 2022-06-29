import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Delete extends JFrame implements ActionListener
{
    private JLabel usnL;
    private JTextField usnT;
    private JButton delete,back;
    
    Container con=null;
    String usn="";

    Delete()
    {
        super("Delete Record");
        con = getContentPane();
        con.setLayout(null);
        Color  lightBlue = new Color(0,255,255);
        con.setBackground(lightBlue);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        Font font = new Font("Verdana", Font.BOLD, 16);

        Color blue = new Color(30,144,255);
        usnL=new JLabel("Enter USN of record to be deleted");
        usnL.setBounds(400, 50, 700,150);
        usnL.setFont(font);
        usnL.setForeground(Color.BLACK);

        usnT=new JTextField(200);
		usnT.setBounds(725,100,250,50);
        usnT.setFont(font);
        usnT.setForeground(Color.BLACK);

        delete = new JButton("Delete");
		delete.setBounds(400,600,150,40);
		delete.addActionListener(this);
        delete.setFont(font);
        Color pul = new Color(0,0,255);
        Border bored = BorderFactory.createLineBorder(pul,5);
        delete.setBorder(bored);
        delete.setForeground(Color.WHITE);
        delete.setBackground(blue);

        back = new JButton("Go Back");
		back.setBounds(600,600,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setBorder(bored);
        back.setForeground(Color.WHITE);
        back.setBackground(blue);


        con.add(usnL);
		con.add(usnT);
        con.add(delete);
        con.add(back);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==delete)
        {
			try{
                String usn = usnT.getText();
                String usn1="",r;
                int count=0;
                File file = new File("student.txt");  //student
                BufferedReader br = new BufferedReader(new FileReader(file));

                File file1 = new File("journal.txt");  //journal
                BufferedReader br1 = new BufferedReader(new FileReader(file1));

                File temp = new File("temp.txt");  //student temp
                Boolean createNewFile = temp.createNewFile();
                BufferedWriter pw = new BufferedWriter(new FileWriter(temp));

                File temp1 = new File("temp1.txt");  //journal temp
                Boolean createNewFile1 = temp.createNewFile();
                BufferedWriter pw1 = new BufferedWriter(new FileWriter(temp1));
                while((r= br.readLine()) !=null)
                {	
                    String[] result = r.split("\\|");
                    usn1=result[1];
                    if(usn1.equals(usn)) 
                    {
                        count=1;
                        continue;
                    }
                    else
                    {
                        pw.write(r);
                        pw.write("\n");
                    } 
                }

                while((r= br1.readLine()) !=null)
                {	
                    String[] result = r.split("\\|");
                    usn1=result[0];
                    if(usn1.equals(usn)) 
                    {
                        continue;
                    }
                    else
                    {
                        pw1.write(r);
                        pw1.write("\n");
                    } 
                }

                if(count == 0)
                    showMessageDialog(null, "Invalid USN");
                else
                    showMessageDialog(null, "Record Deleted!");

                pw.flush();
                pw.close();
                br.close();	
                pw1.close();
                br1.close();
        
                file.delete();
                temp.renameTo(file);
                file1.delete();
                temp1.renameTo(file1);
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            this.dispose();
            Home h=new Home();
            h.setSize(2300,790);
            h.setVisible(true);
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
        Delete del=new Delete();
		del.setSize(2300,790);
		del.setVisible(true);
    }   
}
