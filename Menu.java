import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Menu extends JFrame implements ActionListener
{
	JFrame f;
	JPanel p;
	JButton bus,bex,bmm;
	TextArea t;
	JLabel ld,ldd;
	Menu()
	{
		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		t=new TextArea();
		t=new TextArea("",0,0,TextArea.SCROLLBARS_NONE);
		t.setBounds(165, 5, 350, 530);
		t.setFont(new Font("Calibri",Font.BOLD,20));
		t.setEditable(false);
		p=new JPanel(null);
		ld=new JLabel("DAILY");
		ld.setFont(new Font("Calibri",Font.BOLD,60));
		ld.setBounds(5,10,200,100);
		ldd=new JLabel("Diary");
		ldd.setFont(new Font("Calibri",Font.BOLD,40));
		ldd.setBounds(7,50,200,100);
		p.setBackground(Color.pink);
		bus=new JButton("About Us");
		bus.setBackground(Color.white);
		bus.setFont(new Font("Calibri",Font.BOLD,18));
		bex=new JButton("Sign Out");
		bex.setBackground(Color.white);
		bex.setFont(new Font("Calibri",Font.BOLD,18));
		bmm=new JButton("Main Menu");
		bmm.setBackground(Color.white);
		bmm.setFont(new Font("Calibri",Font.BOLD,18));
		bus.addActionListener(this);
		bex.addActionListener(this);
		bmm.addActionListener(this);
		bus.setBounds(4,221,155,70);
		bex.setBounds(4,292,155,70);
		bmm.setBounds(4,150,155,70);
		p.setBounds(5,5,160,530);
		p.add(ld);
		p.add(ldd);
		p.add(bus);
		p.add(bex);
		p.add(bmm);
		f.add(t);
		f.add(p);
		f.setVisible(true);
		f.setSize(550,600);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==bus)
		{
			t.setText("\n\n\nPROJECT BY: \n\n	Mobeena Ramzan (3868-FBAS/BSCS/F18-B) \n	Noor-ul-Huda (3847-FBAS/BSCS/F18-B)");
		}
		else if(e.getSource()==bmm)
		{
			f.dispose();
			new Mainmenu();
		}
		else if(e.getSource()==bex)
		{
			f.dispose();
			new Gui();
		}
	}
}
