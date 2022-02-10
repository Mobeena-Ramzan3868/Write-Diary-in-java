import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Search  extends JFrame implements ActionListener
{
	JFrame f;
	JPanel p,pr;
	JTextField ts;
	TextArea ta;
	JButton bsear,bex,bba;
	JComboBox c;
	Dbdata db;
	int i=0;
	String res;
	Search()
	{
		db=new Dbdata();
		f=new JFrame("DAILY DIARY");
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p=new JPanel(null);
		p.setBackground(Color.PINK);
		pr=new JPanel(null);
		pr.setBackground(Color.WHITE);
		ta=new TextArea();
		ta=new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setEditable(false);
		ta.setFont(new Font("Calibri",Font.PLAIN,20));
		ts=new JTextField("Search");
		ts.setBackground(Color.WHITE);
		ts.setEditable(false);
		ts.setFont(new Font("Calibri",Font.PLAIN,17));
		bsear=new JButton(new ImageIcon("C:\\Users\\Mobeena Ramzan\\Downloads\\search.PNG"));
		bsear.setBackground(Color.WHITE);
		bba=new JButton("Back");
		bex=new JButton("Exit");
		bex.addActionListener(this);
		bba.addActionListener(this);
		bba.setBounds(340,495,80,40);
		bex.setBackground(Color.white);
		bex.setBounds(420,495,80,40);
		bba.setBackground(Color.white);
		bsear.addActionListener(this);
		ts.setBounds(15,10,443,50);
		bsear.setBounds(460,10,50,50);
		String sea[]= {"type of Search","By Date","By Time","By Word","Show all Records"};
		c=new JComboBox(sea);
		c.setBackground(Color.WHITE);
		c.addActionListener(this);
		ts.addActionListener(this);
		c.setBounds(395,60,115,30);
		p.setBounds(5,5,525,550);
		pr.setBounds(20,100,495,390);
		ta.setBounds(3,3,490,383);
		p.add(c);
		p.add(ts);
		p.add(bsear);
		p.add(bba);
		p.add(bex);
		pr.add(ta);
		f.add(pr);
		f.add(p);
		f.setVisible(true);
		f.setSize(550,600);
	}
	/*public static void main(String[] args) 
	{
		new Search();
	}*/
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(c))
		{
			if(c.getSelectedItem()=="type of Search")
			{
				ts.setText("Search");
				ts.setEditable(false);
				i=0;
			}
			else if(c.getSelectedItem()=="By Date")
			{
				ts.setEditable(true);
				ts.setText("");
				i=1;
			}
			else if(c.getSelectedItem()=="By Time")
			{
				ts.setEditable(true);
				ts.setText("");
				i=3;
			}
			else if(c.getSelectedItem()=="By Word")
			{
				ts.setEditable(true);
				ts.setText("");
				i=2;
			}
			else if(c.getSelectedItem()=="Show all Records")
			{
				ta.setText(db.allrecords());
			}
		}
		else if(e.getSource()==bsear)
		{
			if(i==1)
			{
				res=db.searchdate(ts.getText());
				System.out.println(res);
				if(res.equals(""))
				{
					ta.setText("Date not found");
				}
				else
				{
					ta.setText(res);
				}
			}
			else if(i==2)
			{
				res=db.searchword(ts.getText());
				System.out.println(res);
				if(res.equals(""))
				{
					ta.setText("word not found");
				}
				else
				{
					ta.setText(res);
				}
			}
			else if(i==3)
			{
				res=db.searchtime(ts.getText());
				System.out.println(res);
				if(res.equals(""))
				{
					ta.setText("Time not found");
				}
				else
				{
					ta.setText(res);
				}
			}
		}
		else if(e.getSource()==bba)
		{
			f.dispose();
			new Menu();
		}
		else if(e.getSource()==bex)
		{
			f.dispose();
		}
	}
}
