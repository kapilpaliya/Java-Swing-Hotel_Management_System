
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

public class Admin extends JFrame implements ActionListener {
    // Variable Declaration
    JLabel employee, room, driver, IMAGE;    JButton Employee, Room, Driver, Logout, Back;
    ImageIcon Logo = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
            IMAGES = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif")),
            EMPLOYEE = new ImageIcon(ClassLoader.getSystemResource("icon/Employee.png")),
            ROOM = new ImageIcon(ClassLoader.getSystemResource("icon/Room.png")),
            DRIVER = new ImageIcon(ClassLoader.getSystemResource("icon/Driver.png"));
    Image b_Image = IMAGES.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT),
            b_Employee = EMPLOYEE.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT),
            b_Room = ROOM.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT),
            b_Driver = DRIVER.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT);
    Font font = new Font("Arial",Font.BOLD,20);
    Admin(){
        // Create Frame.
        setBounds(300,100,800,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(3,45,48));
        setResizable(false);
        setTitle("Welcome Admin");
        setIconImage(Logo.getImage());
        setLayout(null);
        setBackground(Color.white);
        revalidate();


        // Add Image In Right Image Type Is Symbol.
        IMAGE = new JLabel(new ImageIcon(b_Image));
        IMAGE.setBounds(400,20,400,400);
        add(IMAGE);


        // Add Employee Image In Left Image Type Is Symbol.
        employee = new JLabel(new ImageIcon(b_Employee));
        employee.setBounds(30,20,140,140);
        add(employee);

        // Add Employee Button.
        Employee = new JButton("Add Employee");
        Employee.setBounds(190,90,150,40);
        Employee.addActionListener(this);
        Employee.setForeground(Color.white);
        Employee.setBackground(null);
        Employee.setBorder(BorderFactory.createLineBorder(Color.white));
        Employee.setForeground(Color.white);
        Employee.setFont(font);
        add(Employee);


        // Add Room Image In Left Image Type Is Symbol.
        room = new JLabel(new ImageIcon(b_Room));
        room.setBounds(30,180,140,140);
        add(room);

        // Add Room Button.
        Room = new JButton("Add Room");
        Room.setBounds(190,250,150,40);
        Room.addActionListener(this);
        Room.setForeground(Color.white);
        Room.setBackground(null);
        Room.setBorder(BorderFactory.createLineBorder(Color.white));
        Room.setForeground(Color.white);
        Room.setFont(font);
        add(Room);


        // Add Driver Image In Left Image Type Is Symbol.
        driver = new JLabel(new ImageIcon(b_Driver));
        driver.setBounds(30,360,140,140);
        add(driver);

        // Add Driver Button.
        Driver = new JButton("Add Driver");
        Driver.setBounds(190,430,150,40);
        Driver.addActionListener(this);
        Driver.setForeground(Color.white);
        Driver.setBackground(null);
        Driver.setBorder(BorderFactory.createLineBorder(Color.white));
        Driver.setForeground(Color.white);
        Driver.setFont(font);
        add(Driver);


        // Add Logout Button.
        Logout = new JButton("Logout");
        Logout.setBounds(480,430,120,30);
        Logout.setForeground(Color.white);
        Logout.setBackground(Color.red);
        Logout.setBorder(BorderFactory.createLineBorder(Color.white));
        Logout.addActionListener(this);
        Logout.setForeground(Color.white);
        Logout.setFont(font);
        add(Logout);


        // Add Back Button.
        Back = new JButton("Back");
        Back.setBounds(630,430,120,30);
        Back.setForeground(Color.white);
        Back.setBackground(Color.blue);
        Back.setBorder(BorderFactory.createLineBorder(Color.white));
        Back.addActionListener(this);
        Back.setForeground(Color.white);
        Back.setFont(font);
        add(Back);


        setVisible(true);
    }


     //Override The ActionListener Methode.
    public void actionPerformed(ActionEvent e) {
        // Declaration Of Back Button.
        if(e.getSource()==Back){
            dispose();
            new Home();
        }


        // Declaration Of Logout Button.
        if(e.getSource()==Logout){
            dispose();
            new Login();
        }


        // Declaration Of Employee Button.
        if(e.getSource()==Employee){
            dispose();
            new AddEmployee();
        }


        // Declaration Of Room Button.
        if(e.getSource()==Room){
            dispose();
            new AddRoom();
        }


        // Declaration Of Driver Button.
        if(e.getSource()==Driver){
            dispose();
            new AddDriver();
        }

    }

}
