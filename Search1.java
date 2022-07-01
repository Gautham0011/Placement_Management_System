import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;


public class Search1 extends JFrame implements ActionListener{
	
	JLabel welcome,searchheading;
	JButton searchbyusn,searchbycompany,searchbybranch,back; 
	
	Search1(){
		
		super("Search");
		Container con = getContentPane();
		con.setLayout(null);
		Color  lightBlue = new Color(138,43,226);
        con.setBackground(lightBlue);    
        con.setVisible(true);
		
		searchheading = new JLabel("CAMPUS PLACEMENTS");
        searchheading.setBounds(520,0, 400,150);
		con.add(searchheading);

		Font fonth = new Font("Verdana", Font.BOLD, 24);
		searchheading.setFont(fonth);
		searchheading.setForeground(Color.WHITE);

		welcome = new JLabel("CHOOSE CRITERIA TO SEARCH STUDENTS");
		welcome.setBounds(480,30, 400,150);
		con.add(welcome);

		Font fontw = new Font("Verdana", Font.BOLD, 16);
        welcome.setFont(fontw);
        welcome.setForeground(Color.WHITE);
		
		Color blue = new Color(148,0,211);
		Color pul = new Color(75,0,130);
		Border bored = BorderFactory.createLineBorder(pul,5);
		searchbyusn = new JButton("Search By USN");
		searchbyusn.addActionListener(this);
		searchbyusn.setBounds(180,275,230, 50);
		Font font1 = new Font("Verdana", Font.BOLD, 16);
		searchbyusn.setFont(font1);
		searchbyusn.setBorder(bored);
		searchbyusn.setForeground(Color.WHITE);
		searchbyusn.setBackground(blue);

		searchbycompany = new JButton("Search By Company");
		searchbycompany.addActionListener(this);
		searchbycompany.setBounds(500,275, 200, 50);
		Font font2 = new Font("Verdana", Font.BOLD, 16);
        searchbycompany.setFont(font2);
        searchbycompany.setBorder(bored);
        searchbycompany.setForeground(Color.WHITE);
        searchbycompany.setBackground(blue);
        
		searchbybranch = new JButton("Search By Branch");
		searchbybranch.addActionListener(this);
		searchbybranch.setBounds(830,275, 175, 50);
		Font font3 = new Font("Verdana", Font.BOLD, 16);
        searchbybranch.setFont(font3);
        searchbybranch.setBorder(bored);
        searchbybranch.setForeground(Color.WHITE);
        searchbybranch.setBackground(blue);
        
        Font font = new Font("Verdana", Font.BOLD, 16);
        back = new JButton("Go Back");
		back.setBounds(525,600,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setBorder(bored);
        back.setForeground(Color.WHITE);
        back.setBackground(blue);
        
        con.add(searchbyusn);
        con.add(searchbycompany);
        con.add(searchbybranch);
        con.add(back);
        
        JLabel background;
		con.setSize(1200,700);
		con.setLayout(null);
       	ImageIcon img=new ImageIcon("C:\\Users\\MCHOME\\Downloads\\fsminipresent\\fsminipresent\\search1.jpg");
       	background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1200,700);
        add(background);
        
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==searchbyusn)
		{
			this.dispose();
			SearchByUSN in=new SearchByUSN();
			in.setSize(2300,790);
			in.setVisible(true);
		}

		if(ae.getSource()==searchbycompany)
		{
			this.dispose();
			SearchByCompany del=new SearchByCompany();
			del.setSize(2300,790);
			del.setVisible(true);
		}

		if(ae.getSource()==searchbybranch)
		{
			this.dispose();
			SearchByBranch dis=new SearchByBranch();
			dis.setSize(2300,790);
			dis.setVisible(true);
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

}
