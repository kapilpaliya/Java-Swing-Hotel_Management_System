
// Class And Package Import Statements.
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Receptionist  extends  JFrame implements ActionListener{
    // Variable Declaration.
    JLabel IMAGE2, IMAGE; JPanel p1,p2;
    JButton customer, room, department, employeeInfo, customerInfo, managerInfo, checkOut, updateCheckIn, updateRoom, pickUp, searchRoom, logOut, back;
    ImageIcon Logo = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
            IMAGES = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif")),
            IMAGES2 = new ImageIcon(ClassLoader.getSystemResource("icon/IMAGE2.gif"));
    Image b_Image = IMAGES.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT),
            b_Image2 = IMAGES2.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
    Font font = new Font("Arial",Font.BOLD,16);
    Receptionist(){
        // Create Frame.
        setBounds(300,100,1000,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(65,105,225));
        setResizable(false);
        setTitle("Login Face");
        setIconImage(Logo.getImage());
        setLayout(null);
        revalidate();


        // Add Left Panel Container In Frame To Store Component.
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(5,5,250,600);
        p1.setBackground(new Color(3,45,48));
        add(p1);


        // Add Right Panel Container In Frame To Store Component.
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(260,5,720,600);
        p2.setBackground(new Color(3,45,48));
        add(p2);


        // Add Customer Button.
        customer = new JButton("New Customer Form");
        customer.setBounds(25,10,200,25);
        customer.setForeground(Color.white);
        customer.setBackground(null);
        customer.setBorder(BorderFactory.createLineBorder(Color.white));
        customer.setForeground(Color.white);
        customer.addActionListener(this);
        customer.setFont(font);
        p1.add(customer);


        // Add Room Button.
        room = new JButton("Room");
        room.setBounds(25,45,200,25);
        room.setForeground(Color.white);
        room.setBackground(null);
        room.setBorder(BorderFactory.createLineBorder(Color.white));
        room.setForeground(Color.white);
        room.addActionListener(this);
        room.setFont(font);
        p1.add(room);


        // Add Department Button.
        department = new JButton("Department");
        department.setBounds(25,80,200,25);
        department.setForeground(Color.white);
        department.setBackground(null);
        department.setBorder(BorderFactory.createLineBorder(Color.white));
        department.setForeground(Color.white);
        department.addActionListener(this);
        department.setFont(font);
        p1.add(department);


        // Add Employee Info Button.
        employeeInfo = new JButton("All Employee Info");
        employeeInfo.setBounds(25,115,200,25);
        employeeInfo.setForeground(Color.white);
        employeeInfo.setBackground(null);
        employeeInfo.setBorder(BorderFactory.createLineBorder(Color.white));
        employeeInfo.setForeground(Color.white);
        employeeInfo.addActionListener(this);
        employeeInfo.setFont(font);
        p1.add(employeeInfo);


        // Add Customer Info Button.
        customerInfo = new JButton("Customer Info");
        customerInfo.setBounds(25,150,200,25);
        customerInfo.setForeground(Color.white);
        customerInfo.setBackground(null);
        customerInfo.setBorder(BorderFactory.createLineBorder(Color.white));
        customerInfo.setForeground(Color.white);
        customerInfo.addActionListener(this);
        customerInfo.setFont(font);
        p1.add(customerInfo);


        // Add Manager Info Button.
        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(25,185,200,25);
        managerInfo.setForeground(Color.white);
        managerInfo.setBackground(null);
        managerInfo.setBorder(BorderFactory.createLineBorder(Color.white));
        managerInfo.setForeground(Color.white);
        managerInfo.addActionListener(this);
        managerInfo.setFont(font);
        p1.add(managerInfo);


        // Add Check OUt Button.
        checkOut = new JButton("Check Out");
        checkOut.setBounds(25,220,200,20);
        checkOut.setForeground(Color.white);
        checkOut.setBackground(null);
        checkOut.setBorder(BorderFactory.createLineBorder(Color.white));
        checkOut.setForeground(Color.white);
        checkOut.addActionListener(this);
        checkOut.setFont(font);
        p1.add(checkOut);


        // Add Update Check-in Info Button.
        updateCheckIn = new JButton("Update Check-in Details");
        updateCheckIn.setBounds(25,255,200,25);
        updateCheckIn.setForeground(Color.white);
        updateCheckIn.setBackground(null);
        updateCheckIn.setBorder(BorderFactory.createLineBorder(Color.white));
        updateCheckIn.setForeground(Color.white);
        updateCheckIn.addActionListener(this);
        updateCheckIn.setFont(font);
        p1.add(updateCheckIn);


        // Add Update Room Button.
        updateRoom = new JButton("Update Room Status");
        updateRoom.setBounds(25,290,200,25);
        updateRoom.setForeground(Color.white);
        updateRoom.setBackground(null);
        updateRoom.setBorder(BorderFactory.createLineBorder(Color.white));
        updateRoom.setForeground(Color.white);
        updateRoom.addActionListener(this);
        updateRoom.setFont(font);
        p1.add(updateRoom);


        // Add Pick Up Service Button.
        pickUp = new JButton("Pick Up Service");
        pickUp.setBounds(25,325,200,25);
        pickUp.setForeground(Color.white);
        pickUp.setBackground(null);
        pickUp.setBorder(BorderFactory.createLineBorder(Color.white));
        pickUp.setForeground(Color.white);
        pickUp.addActionListener(this);
        pickUp.setFont(font);
        p1.add(pickUp);


        // Add Search Room Button.
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(25,360,200,25);
        searchRoom.setForeground(Color.white);
        searchRoom.setBackground(null);
        searchRoom.setBorder(BorderFactory.createLineBorder(Color.white));
        searchRoom.setForeground(Color.white);
        searchRoom.addActionListener(this);
        searchRoom.setFont(font);
        p1.add(searchRoom);


        // Add Logout Button.
        logOut = new JButton("Logout");
        logOut.setBounds(35,395,80,25);
        logOut.setForeground(Color.white);
        logOut.setBackground(Color.red);
        logOut.setBorder(BorderFactory.createLineBorder(Color.white));
        logOut.setForeground(Color.white);
        logOut.addActionListener(this);
        logOut.setFont(font);
        p1.add(logOut);


        // Add Back Button.
        back = new JButton("Back");
        back.setBounds(135,395,80,25);
        back.setForeground(Color.white);
        back.setBackground(Color.blue);
        back.setBorder(BorderFactory.createLineBorder(Color.white));
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setFont(font);
        p1.add(back);


        // Add Image In Bottom Image Type Is Symbol.
        IMAGE = new JLabel(new ImageIcon(b_Image));
        IMAGE.setBounds(25,420,200,200);
        p1.add(IMAGE);


        // Add Image In Right Image Type Is Symbol.
        IMAGE2 = new JLabel(new ImageIcon(b_Image2));
        IMAGE2.setBounds(110,50,500,500);
        p2.add(IMAGE2);


        setVisible(true);

    }


    // Override The ActionListener Method.
    @Override
    public void actionPerformed(ActionEvent e){
        // Declaration Of Customer Button.
        if(e.getSource()==customer){
            new newCustomer();
        }


        // Declaration Of Room Button.
        if(e.getSource()==room){
            new Room();
        }


        // Declaration Of department Button.
        if(e.getSource()==department){
            new Department();
        }


        // Declaration Of employeeInfo Button.
        if(e.getSource()==employeeInfo){
            new Employee();
        }


        // Declaration Of CustomerInfo Button.
        if(e.getSource()==customerInfo){
            new CustomerInfo();
        }


        // Declaration Of managerInfo Button.
        if(e.getSource()==managerInfo){
            new ManagerInfo();
        }


        // Declaration Of checkOut Button.
        if(e.getSource()==checkOut){
            new CheckOutInfo();
        }


        // Declaration Of updateCheckIn Button.
        if(e.getSource()==updateCheckIn){
            new CheckInInfo();
        }


        // Declaration Of updateRoom Button.
        if(e.getSource()==updateRoom){
            new UpdateRoom();
        }


        // Declaration Of pickUp Button.
        if(e.getSource()==pickUp){
            new PickUpService();
        }


        // Declaration Of SearchRoom Button.
        if(e.getSource()==searchRoom){
            new SearchRoom();
        }


        // Declaration Of logOut Button.
        if(e.getSource()==logOut){
            new Login();
            dispose();
        }


        // Declaration Of back Button.
        if(e.getSource()==back){
            dispose();
            new Home();
        }
    }
}
