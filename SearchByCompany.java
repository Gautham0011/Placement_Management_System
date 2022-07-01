import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class SearchByCompany extends JFrame implements ActionListener
{
    
    private JLabel companyL;
    private JComboBox companyT; 
    private JTextArea output;
    private JButton search,back;
    
    Container con=null;
    String usn="";
    String[] companies= {"Amazon","Flipcart","Ebay","SAP_LABS","Capgemini","Cognizant","Infosys","Wipro"};
    
    SearchByCompany()
    {
        super("\"Search By Company");
        con = getContentPane();
        con.setLayout(null);
        Color  lightBlue = new Color(0,255,255);
        con.setBackground(lightBlue);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        Font font = new Font("Verdana", Font.BOLD, 16);
        Color blue = new Color(30,144,255);
        companyL=new JLabel("Enter Company of record to be searched");
        companyL.setBounds(300, 50, 700,150);
        companyL.setFont(font);
        companyL.setForeground(Color.BLACK);
        
        companyT=new JComboBox(companies);
		companyT.setBounds(725,100,250,50);
        companyT.setFont(font);
        companyT.setForeground(Color.BLACK);

        output=new JTextArea();
        output.setBounds(20,200,1200,350);
        output.setFont(font);
        output.setForeground(Color.BLACK);
        output.setEditable(false);
       
        search = new JButton("Search");
		search.setBounds(400,600,150,40);
		search.addActionListener(this);
        search.setFont(font);
        Color pul = new Color(0,0,255);
        Border bored = BorderFactory.createLineBorder(pul,5);
        search.setBorder(bored);
        search.setForeground(Color.WHITE);
        search.setBackground(blue);

        back = new JButton("Go Back");
		back.setBounds(600,600,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setBorder(bored);
        back.setForeground(Color.WHITE);
        back.setBackground(blue);

        con.add(companyL);
		con.add(companyT);
        con.add(output);
        con.add(search);
        con.add(back);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==search)
        {
        	String company1 = (String) companyT.getSelectedItem();
            //String company1 = companyT.getText();
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
                    if(company.equals(company1)) {
                    String bb = name  + "\t|" + usn + "\t|" + sem + "\t|" + branch + "\t|" + cgpa + "\t|" + nob + "\t|" + company + "\t|" + ctc + "\t|" + comments;
                    pw.write(bb);
                    pw.write("\n");
                    }
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
                Search1 h=new Search1();
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
        Search1 ser=new Search1();
		ser.setSize(2300,790);
		ser.setVisible(true);
    }
}

