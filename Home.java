
// Class And Package Import Statements.
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener{
    JLabel reception, admin, background;    JButton Reception, Admin;
    Font font = new Font("Arial",Font.BOLD,20);
    ImageIcon Logo = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
            rs = new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png")),
            ad = new ImageIcon(ClassLoader.getSystemResource("icon/Admin.png")),
            bg = new ImageIcon(ClassLoader.getSystemResource("icon/background.gif"));
    Image b_Background = bg.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT),
            b_Admin = ad.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT),
            b_Reception = rs.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);


    Home(){
        // Create Frame.
        setBounds(300,100,900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(3,45,48));
        setResizable(false);
        setTitle("Hotel Management System");
        setIconImage(Logo.getImage());
        setLayout(null);
        setBackground(Color.white);
        revalidate();


        // Add Receptionist Image In Center Image Type Is Symbol.
        reception = new JLabel(new ImageIcon(b_Reception));
        reception.setBounds(225,195,150,150);
        add(reception);


        // Add Admin Image In Center Image Type Is Symbol.
        admin = new JLabel(new ImageIcon(b_Admin));
        admin.setBounds(525,200,150,150);
        add(admin);


        // Add Cancel Button.
        Reception = new JButton("Receptionist");
        Reception.setBounds(225,350,150,40);
        Reception.setForeground(Color.white);
        Reception.addActionListener(this);
        Reception.setBackground(new Color(3,45,48));
        Reception.setBorder(BorderFactory.createLineBorder(Color.white));
        Reception.setForeground(Color.white);
        Reception.setFont(font);
        add(Reception);


        // Add Login Button.
        Admin = new JButton("Admin");
        Admin.setBounds(525,350,150,40);
        Admin.setForeground(Color.white);
        Admin.setBackground(new Color(3,45,48));
        Admin.setBorder(BorderFactory.createLineBorder(Color.white));
        Admin.addActionListener(this);
        Admin.setForeground(Color.white);
        Admin.setFont(font);
        add(Admin);


        // Add Image In Left Image Type Is Symbol.
        background = new JLabel(new ImageIcon(b_Background));
        background.setBounds(0,0,900,600);
        add(background);

        setVisible(true);
    }


    // Override The ActionListener Methode.
    public void actionPerformed(ActionEvent e){

        // Admin Button Declaration.
        if(e.getSource()==Admin){
            new AdminLogin();
            this.dispose();
        }


        // Reception Button Declaration.
        if (e.getSource() == Reception) {
            new Receptionist();
            this.dispose();
        }

    }

}
