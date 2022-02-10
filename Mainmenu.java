import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Mainmenu extends JFrame implements ActionListener,MouseListener
{
	JFrame fm;
	JPanel p1,pt,pp;
	TextArea t;
	JTextField ts;
	JButton bsear,ba,bme;
	Dbdata d;
	Mainmenu()
	{
		d=new Dbdata();
		fm=new JFrame("DAILY DIARY");
		fm.setLayout(null);
		fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1=new JPanel(null);
		p1.setBackground(Color.PINK);
		pp=new JPanel(null);
		pp.setBackground(Color.LIGHT_GRAY);
		ts=new JTextField("Search");
		Font font=new Font("Calibri",Font.BOLD,25);
		ts.setBackground(Color.WHITE);
		ts.setEditable(false);
		ts.setFont(new Font("Calibri",Font.PLAIN,17));
		pt=new JPanel(null);
		pt.setBackground(Color.white);
		t=new TextArea();
		bsear=new JButton(new ImageIcon("C:\\Users\\Mobeena Ramzan\\Downloads\\search.PNG"));
		bsear.setBackground(Color.WHITE);
		ba=new JButton("+");
		ba.setBackground(Color.WHITE);
		ba.setFont(font);
		bme=new JButton(new ImageIcon("C:\\Users\\Mobeena Ramzan\\Downloads\\menu.PNG"));
		bme.setBackground(Color.WHITE);
		bsear.addActionListener(this);
		ba.addActionListener(this);
		bme.addActionListener(this);
		bme.setBounds(3,5,50,50);
		ts.setBounds(56,5,403,50);
		bsear.setBounds(460,5,50,50);
		ba.setBounds(450,470,60,60);
		p1.setBounds(5,5,850,850);
		t.setBackground(Color.white);
		t=new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		t.setEditable(false);
		t.setBounds(0,0,456,389);
		t.setFont(new Font("Arial",Font.PLAIN,15));
		t.setText(d.allrecords());
		pt.setBounds(54,70,455,390);
		pp.setBounds(0,1,54,460);
		pp.addMouseListener(this);
		p1.add(ts);
		p1.add(bsear);
		p1.add(ba);
		//p1.add(bme);
		p1.add(pt);
		pt.add(t);
		p1.add(pp);
		pp.add(bme);
		fm.add(p1);
		fm.setVisible(true);
		fm.setSize(550,600);
	}
	public void actionPerformed(ActionEvent e) 
	{	
		if(e.getSource()==bsear)
		{
			fm.dispose();
			new Search();
		}
		else if(e.getSource()==ba)
		{
			fm.dispose();
			new Writediary();
		}
		else if(e.getSource()==bme)
		{
			fm.dispose();
			new Menu();
		}
	}
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource()==pp)
		{
			fm.dispose();
			new Menu();
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
