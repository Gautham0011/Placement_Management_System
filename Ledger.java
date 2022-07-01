import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Ledger extends JFrame implements ActionListener
{
    
    private JLabel ledgerheading;
    private JTextArea output;
    private JButton display,back;
    public BufferedReader stud;
    public BufferedReader jour; 
    public BufferedWriter pw;
    public File temp;
    Container con=null;

    Ledger()
    {

        super("Ledger Record");
        con = getContentPane();
        con.setLayout(new FlowLayout());
        Color  lightBlue = new Color(0,255,255);
        con.setBackground(lightBlue);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        Font font = new Font("Verdana", Font.BOLD, 16);
        Color blue = new Color(30,144,255);
        ledgerheading=new JLabel("The record history:");
        ledgerheading.setBounds(200, 2, 700,150);
        ledgerheading.setFont(font);
        ledgerheading.setForeground(Color.BLACK);

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

        con.add(ledgerheading);
        con.add(output);
		//con.add(scroll);
        con.add(display);
        con.add(back);

    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==display)
        {
			try
            {
                String b;
                int initial=0;
                stud = new BufferedReader(new FileReader("student.txt"));
				jour = new BufferedReader(new FileReader("journal.txt"));
				ledger(stud.readLine(),jour.readLine(),initial);
                stud.close();
                jour.close();  
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
    public void ledger (String s1, String s2,int initial) throws FileNotFoundException, IOException
	{
        String b;
        if(initial == 0)
        {
            temp = new File("temp.txt");
            Boolean createNewFile = temp.createNewFile();
            pw = new BufferedWriter(new FileWriter(temp));
            b = "NAME\t|USN\t|SEM\t|BRANCH\t|CGPA\t|NOB\t|COMPANY\t|CTC\t|COMMENTS";
            pw.write(b); 
            pw.write("\n");
            initial=1;
        }

		//consequential matching and merging
		String[] ss = s1.split("\\|"); 
		String name_s=ss[0];
        String usn_s=ss[1];
		String sem_s= ss[2];
		String branch_s=ss[3];
		String cgpa_s=ss[4];
		String nob_s=ss[5];
        String company_s=ss[6];
        String ctc_s=ss[7];
        String comments_s=ss[8];

		String[] jj = s2.split("\\|"); 
        String usn_j=jj[0];
		String sem_j= jj[1];
		String cgpa_j=jj[2];
		String nob_j=jj[3];
        String company_j=jj[4];
        String ctc_j=jj[5];
        String comments_j=jj[6];
		int item1=0,item2=0;

		item1=Integer.parseInt(usn_s);
		item2=Integer.parseInt(usn_j);
		if(ss[1].equals("999") && jj[0].equals("999")) //ss=null && jj=null
		{
            pw.close();
            File file1= new File("temp.txt");
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            output.read(br1, null);
            br1.close();
            output.requestFocus(); 
            return;       
        }	
		else if(!ss[0].equals("999") && !jj[0].equals("999")) //ss!=null && jj!=null
		{
			if (item1 == item2)
			{
				b=name_s + "\t" + usn_s + "\t" + sem_j + "\t" + branch_s + "\t" + cgpa_j + "\t" + nob_j + "\t" + company_j + "\t" + ctc_j +"\t" + comments_j;
                pw.write(b);
                pw.write("\n");
                ledger(s1,jour.readLine(),initial);
			}                                                        
                                                            
			else if(item1 < item2)
			{
				b="END OF RECORD";
                pw.write(b);
                pw.write("\n");
                ledger(stud.readLine(),s2,initial);
			}
			else
			 {
                pw.write("Invalid Record Entry\n");
                ledger(s1,jour.readLine(),initial);
			 }
		}
		else //ss==null || jj==null
		{
			 if(jj[0].equals("999"))      
			{ 
				s1=stud.readLine();
				ss = s1.split("\\|"); 
				name_s=ss[0];
                usn_s=ss[1];
				sem_s= ss[2];
				branch_s=ss[3];
				cgpa_s=ss[4];                   
				nob_s=ss[5];
                company_s=ss[6];
                ctc_s=ss[7];
                comments_s=ss[8];
				while(!ss[0].equals("999"))
				{
					b=name_s + "\t" + usn_s + "\t" + sem_s + "\t" + branch_s + "\t" + cgpa_s + "\t" + nob_s +"\t" + company_s + "\t" + ctc_s +"\t" + comments_s;
                    pw.write(b);
                    pw.write("\n");
                    s1=stud.readLine();
					ss = s1.split("\\|"); 
					name_s=ss[0];
                    usn_s=ss[1];
					sem_s= ss[2];
					branch_s=ss[3];
					cgpa_s=ss[4];
					nob_s=ss[5];
                    company_s=ss[6];
                    ctc_s=ss[7];
                    comments_s=ss[8];

					
				}
                pw.write("END OF RECORD\n");
				ledger(s1,s2,initial); 
			} 
          
		}
	}	

    public static void main(String args[])
    {
        Ledger led=new Ledger();
		led.setSize(2300,790);
		led.setVisible(true);
    }   




    
}
