import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
@SuppressWarnings(&quot;serial&quot;)
public class LoginFrame extends JFrame
{
Container c=null;
JLabel lblUnm,lblPwd;
JTextField txtUnm;
JPasswordField txtPwd;
static String strPwd;
DBhandler objDB=new DBhandler();
public LoginFrame()
{
c=getContentPane();
ImageIcon icn=new ImageIcon(&quot;loginfarme.jpg&quot;);
JLabel bg=new JLabel(icn);
bg.setSize(Toolkit.getDefaultToolkit().getScreenSize());
c.add(bg);
///////////////////////// USER-NAME /////////////////////////////////
lblUnm=new JLabel(&quot;USER NAME&quot;);
lblUnm.setBounds(50, 200, 300,30);
lblUnm.setFont(new Font(&quot;Latin&quot;, Font.ITALIC, 30));
lblUnm.setForeground(Color.WHITE);
bg.add(lblUnm);
txtUnm=new JTextField();
txtUnm.setBounds(350, 200, 150, 30);
txtUnm.setFont(new Font(&quot;lucia&quot;, Font.BOLD, 20));
bg.add(txtUnm);
//////////////////////// PASSWORD //////////////////////////////////
lblPwd=new JLabel(&quot;PASSWORD&quot;);
lblPwd.setBounds(50, 260, 300, 30);
lblPwd.setFont(new Font(&quot;Latin&quot;, Font.ITALIC, 30));
lblPwd.setForeground(Color.WHITE);
bg.add(lblPwd);
txtPwd=new JPasswordField();
txtPwd.setBounds(350, 260, 150, 30);
txtPwd.setFont(new Font(&quot;lucia&quot;, Font.BOLD, 20));

bg.add(txtPwd);
//////////////////// LOGIN BUTTON //////////////////////////////////
ImageIcon icn1=new ImageIcon(&quot;login.png&quot;);
JButton login=new JButton(icn1);
login.setBounds(200, 320, 122, 50);
bg.add(login);
login.addActionListener(new ActionListener()
{

public void actionPerformed(ActionEvent arg0)
{
String strUnm;
strUnm=txtUnm.getText();
strPwd=String.valueOf(txtPwd.getPassword());
boolean res=objDB.isValidUser(strUnm, strPwd);
if(res==true)
{
dispose();
@SuppressWarnings(&quot;unused&quot;)
StartFrame wfrm=new StartFrame();
}
else
{

JOptionPane.showMessageDialog(null,&quot;INVALID USERNAME OR PASSWORD&quot;);

}
}

});

///////////////////////////////////////////////////////////////////////////

setVisible(true);
setTitle(&quot;Food Panda&quot;);
setSize(Toolkit.getDefaultToolkit().getScreenSize());
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);