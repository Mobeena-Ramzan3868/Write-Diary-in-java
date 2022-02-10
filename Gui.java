import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Gui extends JFrame implements ActionListener, MouseListener
{
	JFrame fd;
	JPanel ps;
	JLabel lu,lp,ext;
	JTextField tu;
	JPasswordField tp;
	JButton bs;
	Gui()
	{
		fd=new JFrame("Daily Diary");
		fd.setLayout(null);
		fd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ps=new JPanel(null);
		ps.setBackground(Color.PINK);
		Font fon=new Font("Calibri",Font.BOLD,30);
		lu=new JLabel("User");
		lu.setFont(fon);
		lp=new JLabel("Password");
		lp.setFont(fon);
		tu=new JTextField("mobeena ramzan");
		tu.setFont(new Font("Arial",Font.PLAIN,15));
		tp=new JPasswordField();
		tp.setFont(new Font("Arial",Font.PLAIN,15));
		Font fo=new Font("Arial",Font.PLAIN,20);
		bs=new JButton("Sign in");
		bs.setFont(fo);
		ext=new JLabel("EXIT");
		tu.addActionListener(this);
		tp.addActionListener(this);
		bs.addActionListener(this);
		ext.addMouseListener(this);
		lu.setBounds(30,87,100,50);
		tu.setBounds(165,80,200,50);
		lp.setBounds(30,150,200,50);
		tp.setBounds(165,140,200,50);
		bs.setBounds(150,235,130,45);
		ps.setBounds(5,5,495,390);
		ext.setBounds(205,265,50,50);
		ext.setForeground(Color.gray);
		ps.add(lu);
		ps.add(lp);
		ps.add(tu);
		ps.add(tp);
		ps.add(bs);
		ps.add(ext);
		fd.add(ps);
		fd.setVisible(true);
		fd.setSize(520,440);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==bs)
		{
			if(tu.getText().equalsIgnoreCase("Mobeena Ramzan"))
			{
				if(tp.getText().equals("mobi"))
				{
					fd.dispose();
					new Mainmenu();
				}
				else
				{
					JLabel wp=new JLabel("*wrong Password");
					wp.setForeground(Color.red);
					wp.setBounds(365,145,110,50);
					ps.add(wp);
				}
			}
			else
			{
				JLabel wu=new JLabel("*wrong User Id");
				wu.setForeground(Color.red);
				wu.setBounds(365,85,90,50);
				ps.add(wu);
			}
		}	
	}
	public static void main(String[] args)
	{
		new Gui();
	}
	public void mouseClicked(MouseEvent e) 
	{
		if(e.getSource()==ext)
		{
			fd.dispose();
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
