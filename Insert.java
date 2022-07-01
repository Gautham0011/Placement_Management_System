import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Insert extends JFrame implements ActionListener 
{
    private  JLabel insertHeading,nameL,usnL,semL,branchL,cgpaL,nobL,companyL,ctcL,commentsL;
    private  JTextField nameT,usnT,cgpaT,nobT,ctcT,commentsT;
	JComboBox companyT,branchT,semT;;
    private  JButton insert,back;
    String[] companies= {"Amazon","Flipcart","Ebay","SAP_LABS","Capgemini","Cognizant","Infosys","Wipro"};
    String[] branches= {"CSE","ISE","EEE","ECE","MEC","TEC","AIML"};
    String[] sems= {"01","02","03","04","05","06","07","08"};
    //JComboBox combobox=new JComboBox(companies);

    Container con=null;
    String name="", usn1="", sem="", branch="", cgpa="", nob="",company="",ctc="",comments="";

    Insert()
    {
        super("Insert Record");
        con = getContentPane();
        con.setLayout(null);
		Color  lightBlue = new Color(0,255,255);
        con.setBackground(lightBlue);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        insertHeading = new JLabel("INSERT STUDENT DETAILS");
        insertHeading.setBounds(550,-50, 400,150);

        con.add(insertHeading);
        //con.add(combobox);
		Color blue = new Color(30,144,255);
        Font font = new Font("Verdana", Font.BOLD, 16);
        insertHeading.setFont(font);
        insertHeading.setForeground(Color.BLACK);

        nameL=new JLabel("Enter Name:");
        nameL.setBounds(350,70,150,40);
        nameL.setFont(font);
        nameL.setForeground(Color.BLACK);
        nameT=new JTextField(200);
		nameT.setBounds(725,70,250,30);
        nameT.setFont(font);
        nameT.setForeground(Color.BLACK);

        usnL=new JLabel("Enter USN:");
		usnL.setBounds(350,130,150,40);
        usnL.setFont(font);
        usnL.setForeground(Color.BLACK);
		usnT=new JTextField(200);
		usnT.setBounds(725,130,250,30);
        usnT.setFont(font);
        usnT.setForeground(Color.BLACK);
        
        semL=new JLabel("Enter Semester:");
		semL.setBounds(350,190,150,40);
        semL.setFont(font);
        semL.setForeground(Color.BLACK);
		semT=new JComboBox(sems);
		semT.setBounds(725,190,250,30);
        semT.setFont(font);
        semT.setForeground(Color.BLACK);

        branchL=new JLabel("Enter Branch:");
		branchL.setBounds(350,250,150,40);
        branchL.setFont(font);
        branchL.setForeground(Color.BLACK);
        branchT=new JComboBox(branches);
		branchT.setBounds(725,250,250,30);
        branchT.setFont(font);
        branchT.setForeground(Color.BLACK);

        cgpaL=new JLabel("Enter CGPA:");
		cgpaL.setBounds(350,310,150,40);
        cgpaL.setFont(font);
        cgpaL.setForeground(Color.BLACK);
		cgpaT=new JTextField(200);
		cgpaT.setBounds(725,310,250,30);
        cgpaT.setFont(font);
        cgpaT.setForeground(Color.BLACK);

        nobL=new JLabel("Enter Number of backlogs:");
		nobL.setBounds(350,370,300,40);
        nobL.setFont(font);
        nobL.setForeground(Color.BLACK);
		nobT=new JTextField(200);
		nobT.setBounds(725,370,250,30);
        nobT.setFont(font);
        nobT.setForeground(Color.BLACK);

		companyL=new JLabel("Enter Aspiring Company:");
		companyL.setBounds(350,430,300,40);
        companyL.setFont(font);
        companyL.setForeground(Color.BLACK);
		companyT=new JComboBox(companies);
		companyT.setBounds(725,430,250,30);
        companyT.setFont(font);
        companyT.setForeground(Color.BLACK);
        companyT.addActionListener(this);

		/*ctcL=new JLabel("Enter Aspiring CTC:");
		ctcL.setBounds(350,490,300,40);
        ctcL.setFont(font);
        ctcL.setForeground(Color.BLACK);
		ctcT=new JTextField(200);
		ctcT.setBounds(725,490,250,30);
        ctcT.setFont(font);
        ctcT.setForeground(Color.BLACK);
        ctcT.setText(ctc);*/

		commentsL=new JLabel("Enter Comments:");
		commentsL.setBounds(350,490,300,40);
        commentsL.setFont(font);
        commentsL.setForeground(Color.BLACK);
		commentsT=new JTextField(200);
		commentsT.setBounds(725,490,250,30);
        commentsT.setFont(font);
        commentsT.setForeground(Color.BLACK);

        insert=new JButton("Insert");
		insert.setBounds(400,550,150,40);
		insert.addActionListener(this);
        insert.setFont(font);
        Color pul = new Color(0,0,255);
        Border bored = BorderFactory.createLineBorder(pul,5);
        insert.setBorder(bored);
        insert.setForeground(Color.WHITE);
        insert.setBackground(blue);

		back = new JButton("Go Back");
		back.setBounds(750,550,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setBorder(bored);
        back.setForeground(Color.WHITE);
        back.setBackground(blue);

        con.add(nameL);
		con.add(nameT);
        con.add(usnL);
		con.add(usnT);
		con.add(semL);
		con.add(semT);
		con.add(branchL);
		con.add(branchT);
        con.add(cgpaL);
		con.add(cgpaT);
        con.add(nobL);
		con.add(nobT);
		con.add(companyL);
		con.add(companyT);
		//con.add(ctcL);
		//con.add(ctcT);
		con.add(commentsL);
		con.add(commentsT);
		con.add(insert);
		con.add(back);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==insert)
        {
			try
			{
				String p = "999" + "|" + "999" + "|" +"999" + "|" +"999" + "|" +"999" + "|" +"999" + "|"+"999" + "|"+"999" + "|"+"999" + "|" ;
				File data = new File("student.txt");
				File data1 = new File("journal.txt");
				if(data.createNewFile() && data1.createNewFile())   
				{
					Boolean createNewFile = data.createNewFile();
					Boolean createNewFile1 = data1.createNewFile();
					// System.out.println("student "+createNewFile);
					// System.out.println("journal "+createNewFile1);
					BufferedWriter pw = new BufferedWriter(new FileWriter(data));
					BufferedWriter pw1 = new BufferedWriter(new FileWriter(data1));
					pw.write(p);
					pw.write("\n");
					pw.close();
					pw1.write(p);
					pw1.write("\n");
					pw1.close();
				}

				String name = nameT.getText();
           		String usn1 = usnT.getText();
           		String sem = (String) semT.getSelectedItem();
           		String branch = (String) branchT.getSelectedItem();
           		String cgpa = cgpaT.getText();
           		String nob = nobT.getText();
				String company = (String) companyT.getSelectedItem();
				String ctc = ctcofcompany(company);
				//ctcT.setText(ctc);
				String comments = commentsT.getText();

                int check=0,usn2=0,usn3=0;
				String usn="",r,sort,sort1="";
		        File file = new File("student.txt");
		     	BufferedReader br=new BufferedReader(new FileReader(file));
			    while((r= br.readLine()) !=null)
		        {
		        	String[] result = r.split("\\|");
		        	usn=result[1];
		        	if(usn.equals(usn1))
		        	{	check=1;
		        		showMessageDialog(null, "A record already exists with usn: "+result[1]);
						break;
		        	}
		        }
		        br.close();
		        //if record already exists
		         if(check==1)
		         {
					showMessageDialog(null, "Record Updated!");
				 }
		        	String b = usn1 + "|" + sem + "|"  + cgpa + "|" + nob + "|" + company + "|" +ctc + "|" + comments + "|";
		        	int len = b.length();
					File file2 = new File ("journal.txt");
		        	BufferedReader br2 = new BufferedReader(new FileReader(file2));
		        	usn3=Integer.parseInt(usn1);
		        	//sorting before insertion
					File temp1 = new File("temp.txt");
					Boolean createNewFile1 = temp1.createNewFile();
					BufferedWriter pw2 = new BufferedWriter(new FileWriter(temp1));
		        	String result1[]={};
					String sem1,cgpa1,nob1,company1,ctc1,comments1;
		        	while((sort = br2.readLine()) != null)
		        	{
		        		result1 = sort.split("\\|");
		        		usn2=Integer.parseInt(result1[0]);
		        		sem1 = result1[1];   
		        		cgpa1=result1[2];
		        		nob1=result1[3];
						company1=result1[4];
						ctc1=result1[5];
						comments1=result1[6];
		        		sort1 = usn2 + "|" + sem1 + "|" + cgpa1 + "|" + nob1 + "|" + company1 + "|" +ctc1 + "|" + comments1 + "|";
		        		if(usn3<usn2)
		        		{
		        			pw2.write(b);
							pw2.write("\n");
		        			break;                                            
		        		}
		        		else if(usn3 == usn2)        
		        		{
		        			pw2.write(sort1); 
							pw2.write("\n");
		        			pw2.write(b); 
							pw2.write("\n");
		        			break;
		        		}
		        		pw2.write(sort1); 
						pw2.write("\n");
		        	}    
		        	if(sort!=null )
		        	{
		        		if(result1[0].equals("999"))
		        		{
		        			pw2.write(sort1);
							pw2.write("\n");
		        		}
		        		else
		        		{
		        			if(usn3>usn2)
		        			{
		        				pw2.write(b);
								pw2.write("\n");
		        				pw2.write(p);  
								pw2.write("\n");   
		        			}
		        			else if (usn3 == usn2)
		        			{
		        				while(!(result1[1].equals("999")))
		        				{
		        					sort = br2.readLine();
		        					result1 = sort.split("\\|");
		        					usn2=Integer.parseInt(result1[0]);
		        					sem1 = result1[1];
		        					cgpa1=result1[2];
		        					nob1=result1[3];
									company1=result1[4];
									ctc1=result1[5];
									comments1=result1[6];
		        					sort1 = usn2 + "|" + sem1 + "|" + cgpa1 + "|" + nob1 + "|" + company + "|" +ctc + "|" + comments + "|";
		        					pw2.write(sort1);
									pw2.write("\n");
		        				}
		        			}
		        			else
		        			{
		        				while(!result1[1].equals("999"))
		        				{
		        					pw2.write(sort1);
									pw2.write("\n");
		        					sort = br2.readLine();
		        					result1 = sort.split("\\|");
		        					usn2=Integer.parseInt(result1[0]);
		        					sem1 = result1[1];
		        					cgpa1=result1[2];
		        					nob1=result1[3];
									company1=result1[4];
									ctc1=result1[5];
									comments1=result1[6];
		        					sort1 = usn2 + "|" + sem1 + "|" + cgpa1 + "|" + nob1 + "|" + company + "|" +ctc + "|" + comments + "|";
		        				}
		        			}
		        			pw2.write(p);
							pw2.write("\n");
		        		}
		        	}
		        	pw2.flush();   
		        	pw2.close();
		        	br2.close();
		        	file2.delete();
		        	temp1.renameTo(file2);
					modify(name,usn1,sem,branch,cgpa,nob,company,ctc,comments);
		        //}
		        //if record does not exist
		        if(check == 0)
		        {
		        	File file1 = new File("student.txt");
		        	BufferedReader br1 = new BufferedReader(new FileReader(file1));
		        	b = name + "|" + usn1 + "|" + sem + "|" + branch + "|" + cgpa + "|" + nob + "|" + company + "|" +ctc + "|" + comments + "|";
		        	len = b.length();
		        	usn3=Integer.parseInt(usn1);

		        	//sorting before insertion
					File temp = new File("temp.txt");
					Boolean createNewFile = temp.createNewFile();
					BufferedWriter pw1 = new BufferedWriter(new FileWriter(temp));
		        	String result[]={};
		        	while((sort = br1.readLine()) != null)
		        	{
		        		result = sort.split("\\|");
		        		usn2=Integer.parseInt(result[1]);
		        		if(usn3<usn2)
		        		{
		        			pw1.write(b);
							pw1.write("\n");
		        			break;
		        		}
		        		pw1.write(sort); 
						pw1.write("\n");
		        	}    

		        	if(sort!=null )
		        	{
		        		if(result[1].equals("999"))
		        		{
		        			pw1.write(sort);
							pw1.write("\n");
		        		}
		        		else
		        		{ 
		        			while(!result[1].equals("999"))
		        			{
		        				pw1.write(sort);
								pw1.write("\n");
		        				sort = br1.readLine();
		        				result = sort.split("\\|");
		        			}
		        			pw1.write(p);
							pw1.write("\n");
		        		}
		        	}
					showMessageDialog(null, "Record Added!");
		        	pw1.flush();   
		        	pw1.close();
		        	br1.close();

		        	file1.delete();
		        	temp.renameTo(file1);
                }

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


    private String ctcofcompany(String company2) {
    	
    	if(company2=="Amazon") {
    		return "24,00,000";
    	}
    	else if(company2=="Flipcart") {
    		return "19,00,000";
    	}
    	else if(company2=="Ebay") {
    		return "15,00,000";
    	}
    	else if(company2=="SAP_LABS") {
    		return "18,00,000";
    	}
    	else if(company2=="Capgemini") {
    		return "7,00,000";
    	}
    	else if(company2=="Cognizant") {
    		return "6,00,000";
    	}
    	else if(company2=="Infosys") {
    		return "5,00,000";
    	}
    	else if(company2=="Wipro") {
    		return "4,00,000";
    	}
		return null;
	}

	public void modify(String name0, String usn0,String sem0,String branch0, String cgpa0,String nob0, String company0, String ctc0, String comments0) throws FileNotFoundException,IOException,NullPointerException
	{	
		String usn="",r;

		File file = new File("student.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		File temp = new File("temp.txt");
		Boolean createNewFile = temp.createNewFile();
		BufferedWriter pw = new BufferedWriter(new FileWriter(temp));

		while((r= br.readLine()) !=null)
		{	
			String[] result = r.split("\\|");
			usn=result[1];

			if(usn.equals(usn0))
			{
				String b = name0+"|"+usn0+"|"+sem0+"|"+branch0+"|"+cgpa0+"|"+nob0+"|"+company0+"|"+ctc0+"|"+comments0+"|";
				int len = b.length();
				pw.write(b);
				pw.write("\n");
			}
			else
			{
				pw.write(r);
				pw.write("\n");
			}
		}
		pw.flush();
		pw.close();
		br.close();	

		file.delete();
		temp.renameTo(file);
	}



    public static void main(String args[])
    {
        Insert in = new Insert();
        in.setSize(2300,790);
        in.setVisible(true);
    }   
}   


