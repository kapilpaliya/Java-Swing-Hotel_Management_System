
// Class And Package Import Statements.
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AdminLogin extends JFrame implements ActionListener {
    // Variable Declaration
    JLabel name, password, IMAGE, heading;  JTextField Name;    JPasswordField Password;    JButton Cancel, Login;
    ImageIcon Logo = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
            img = new ImageIcon(ClassLoader.getSystemResource("icon/AdminLogin.png"));
    Image b_Image = img.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
    Font font = new Font("Arial",Font.BOLD,20);

    AdminLogin(){
        // Create Frame.
        setBounds(300,100,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(3,45,48));
        setResizable(false);
        setTitle("Admin Login");
        setIconImage(Logo.getImage());
        setLayout(null);
        setBackground(Color.white);
        revalidate();


        // Add Image In Left Image Type Is Symbol.
        IMAGE = new JLabel(new ImageIcon(b_Image));
        IMAGE.setBounds(400,20,400,400);
        add(IMAGE);


        // Add Heading In Center Of Frame.
        heading = new JLabel("Admin Login Authentication");
        heading.setBounds(195,10,410,40);
        heading.setFont(new Font("Arial",Font.BOLD,30));
        heading.setForeground(Color.white);
        add(heading);


        // Add Name Label And Input Field.
        name = new JLabel("Username :");
        name.setBounds(50,150,110,40);
        name.setForeground(Color.white);
        name.setFont(font);
        add(name);

        Name = new JTextField();
        Name.setBorder(BorderFactory.createLineBorder(Color.white));
        Name.setBounds(170,150,230,40);
        Name.setForeground(Color.green);
        Name.setBackground(null);
        Name.setFont(font);
        add(Name);


        // Add Password Label And Input Field.
        password = new JLabel("Password :");
        password.setBounds(50,230,110,40);
        password.setForeground(Color.white);
        password.setFont(font);
        add(password);

        Password = new JPasswordField();
        Password.setBounds(170,230,230,40);
        Password.setBorder(BorderFactory.createLineBorder(Color.white));
        Password.setForeground(Color.green);
        Password.setBackground(null);
        Password.setFont(font);
        add(Password);


        // Add Cancel Button.
        Cancel = new JButton("Cancel");
        Cancel.setBounds(80,310,120,40);
        Cancel.addActionListener(this);
        Cancel.setForeground(Color.white);
        Cancel.setBackground(null);
        Cancel.setBorder(BorderFactory.createLineBorder(Color.white));
        Cancel.setForeground(Color.white);
        Cancel.setFont(font);
        add(Cancel);


        // Add Login Button.
        Login = new JButton("Login");
        Login.setBounds(240,310,120,40);
        Login.setForeground(Color.white);
        Login.setBackground(null);
        Login.setBorder(BorderFactory.createLineBorder(Color.white));
        Login.addActionListener(this);
        Login.setForeground(Color.white);
        Login.setFont(font);
        add(Login);


        setVisible(true);
    }

    // Override The ActionListener Methode.
    public void actionPerformed(ActionEvent e) {

        // Declaration Of Login Button.
        if (e.getSource() == Login) {
            try{
                String  id  = Name.getText();
                String pass = Password.getText();
                if(id.equals("")||pass.equals("")){
                    JOptionPane.showMessageDialog(this, "Input Field Is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    ResultSet rs = JDBC.setConnection().prepareStatement("select * from employee where name = '" + id + "' and phone = '" + pass + "' and job = 'Manager'").executeQuery();
                    if(rs.next()){
                        new Admin();
                        dispose();
                    }
                    else{
                        Name.setText(null);
                        Password.setText(null);
                        JOptionPane.showMessageDialog(this, "Name And Password Not Match!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            catch(Exception z){
                z.printStackTrace();
            }
        }


        // Declaration Of Cancel Button.
        if (e.getSource() == Cancel) {
            new Home();
            this.dispose();
        }

    }

}
