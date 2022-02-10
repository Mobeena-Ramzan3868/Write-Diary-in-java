import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Writediary implements ActionListener
{
	JFrame f;
	TextArea t;
	JLabel ld,lt;
	JButton bsave,bback,bexit;
	Dbdata db;
	Writediary()
	{
		db=new Dbdata();
		f=new JFrame("DAILY DIARY");
		f.setLayout(null);
		f.setForeground(Color.yellow);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pp=new JPanel(null);
		SimpleDateFormat form=new SimpleDateFormat("dd/MM/yyyy|hh:mm:ss ");
		Date date=new Date();
		String a=form.format(date);
		int z=a.indexOf("|");
		String dat=a.substring(0,z);
		String tim=a.substring(z+1,a.length());
		ld=new JLabel(dat);
		ld.setFont(new Font("Calibri",Font.BOLD,30));
		lt=new JLabel("Time: "+tim);
		lt.setFont(new Font("Calibri",Font.BOLD,14));
		bsave=new JButton("Save");
		bsave.setBounds(140,490,80,40);
		bback=new JButton("Back");
		bback.setBounds(240,490,80,40);
		bexit=new JButton("Exit");
		bexit.setBounds(340,490,80,40);
		ld.setBounds(5,5,200,50);
		lt.setBounds(5,30,200,50);
		t=new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		t.setBounds(20, 75, 500, 400);
		//t.addMouseListener(this);
		bsave.addActionListener(this);
		bback.addActionListener(this);
		pp.setBounds(20,2,170,70);
		pp.setBackground(Color.white);
		pp.add(ld);
		pp.add(lt);
		f.add(bexit);
		f.add(bsave);
		f.add(bback);
		f.add(pp);
		f.add(t);
		f.setVisible(true);
		f.setSize(550,600);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==bsave)
		{
			if(t.getText().equals(""))
			{
				JOptionPane.showInputDialog(null,"First plz enter data to save");
			}
			else
			{
				db.insert(ld.getText(), lt.getText(), t.getText());
				t.setText("");
			}
			//String res=db.allrecords();
			//System.out.println(res);
		}
		else if(e.getSource()==bback)
		{
			if(t.getText().equals(""))
			{
				System.out.println("nothing to save");
			}
			else
			{
				db.insert(ld.getText(), lt.getText(), t.getText());
			}
			f.dispose();
			new Mainmenu();
		}
		else if(e.getSource()==bexit)
		{
			f.dispose();
		}
	}
}
