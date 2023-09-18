
// Class And Package Import Statements.
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
public class newCustomer extends JFrame implements ActionListener{
    // Variable Declaration.
    JLabel id, number, name, gender, heading, country, room, date, Date, deposite, IMAGE; JButton Add, Back;
    JTextField Number, Name, Deposite  ; JComboBox<String> ID, Country, Room ; ButtonGroup radioButtonGroup;
    JRadioButton male, female, other;
    ImageIcon IMAGES = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
    Image b_Image = IMAGES.getImage().getScaledInstance(320,320,Image.SCALE_DEFAULT);
    Font font = new Font("Arial",Font.BOLD,16);
    newCustomer(){
        // Create Frame.
        setBounds(568,135,720,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(3,45,48));
        setResizable(false);
        setTitle("Login Face");
        setLayout(null);
        revalidate();
        setUndecorated(true);


        // Add Heading In Top Of Frame.
        heading = new JLabel("Add Customer Details");
        heading.setFont(new Font("Arial",Font.BOLD,25));
        heading.setBounds(270, 5, 260, 40);
        heading.setForeground(Color.white);
        heading.setBackground(null);
        add(heading);


        // Add Image In Right Image Type Is Symbol.
        IMAGE = new JLabel(new ImageIcon(b_Image));
        IMAGE.setBounds(400,140,320,320);
        add(IMAGE);


        // Add JOB Title Label And Input filed.
        id = new JLabel("ID :");
        id.setBounds(30, 70, 120, 30);
        id.setForeground(Color.white);
        id.setBackground(null);
        id.setFont(font);
        add(id);

        ID = new JComboBox<String>(new String[]{"Passport", "Aadhaar Card", "Voter ID", "Driving License"});
        ID.setBorder(null);
        ID.setBounds(170,70,200,30);
        ID.setForeground(Color.black);
        ID.setBackground(new Color(16,108,115));
        ID.setFont(font);
        add(ID);


        // Add Username Label And Input filed.
        number = new JLabel("Number :");
        number.setBounds(30, 120, 120, 30);
        number.setForeground(Color.white);
        number.setBackground(null);
        number.setFont(font);
        add(number);

        Number = new JTextField();
        Number.setBorder(BorderFactory.createLineBorder(Color.white));
        Number.setBounds(170,120,200,30);
        Number.setForeground(Color.black);
        Number.setBackground(new Color(16,108,115));
        Number.setFont(font);
        add(Number);


        // Add Username Label And Input filed.
        name = new JLabel("Username :");
        name.setBounds(30, 170, 170, 30);
        name.setForeground(Color.white);
        name.setBackground(null);
        name.setFont(font);
        add(name);

        Name = new JTextField();
        Name.setBorder(BorderFactory.createLineBorder(Color.white));
        Name.setBounds(170,170,200,30);
        Name.setForeground(Color.black);
        Name.setBackground(new Color(16,108,115));
        Name.setFont(font);
        add(Name);


        // Add Gender Label And Input filed.
        gender = new JLabel("Gender :");
        gender.setBounds(30, 220, 120, 30);
        gender.setForeground(Color.white);
        gender.setBackground(null);
        gender.setFont(font);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(170,220,60,30);
        male.setForeground(Color.cyan);
        male.setSelected(true);
        male.setBackground(null);
        male.setBorder(null);
        male.setFont(font);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(230,220,80,30);
        female.setForeground(Color.cyan);
        female.setBackground(null);
        female.setBorder(null);
        female.setFont(font);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(310,220,80,30);
        other.setForeground(Color.cyan);
        other.setBackground(null);
        other.setBorder(null);
        other.setFont(font);
        add(other);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(male);
        radioButtonGroup.add(female);
        radioButtonGroup.add(other);



        // Add JOB Title Label And Input filed.
        country = new JLabel("Country :");
        country.setBounds(30, 270, 120, 30);
        country.setForeground(Color.white);
        country.setBackground(null);
        country.setFont(font);
        add(country);

        Country = new JComboBox<String>(new String[]{"Bangladesh", "Brazil", "Chaina", "France", "India",
                                                "Indonesia", "Iran", "Japan", "Mexico",  "Pakistan",
                                                "Russia", "Thailand", "United Kingdom", "United States"});
        Country.setBorder(null);
        Country.setBounds(170,270,200,30);
        Country.setForeground(Color.black);
        Country.setBackground(new Color(16,108,115));
        Country.setFont(font);
        add(Country);


        // Add JOB Title Label And Input filed.
        room = new JLabel("Room Number :");
        room.setBounds(30, 320, 120, 30);
        room.setForeground(Color.white);
        room.setBackground(null);
        room.setFont(font);
        add(room);

        Room = new JComboBox<String>();
        Room.setBorder(null);
        try{
            ResultSet rs = JDBC.setConnection().prepareStatement("select roomNumber from room where availability ='Available'").executeQuery();
            while(rs.next()){
                Room.addItem(rs.getString("roomNumber"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Room.setBounds(170,320,200,30);
        Room.setForeground(Color.black);
        Room.setBackground(new Color(16,108,115));
        Room.setFont(font);
        add(Room);


        // Add JOB Title Label And Input filed.
        date = new JLabel("Date :");
        date.setBounds(30, 370, 120, 30);
        date.setForeground(Color.white);
        date.setBackground(null);
        date.setFont(font);
        add(date);

        // Add JOB Title Label And Input filed.
        Date = new JLabel(" "+new Date());
        Date.setBounds(170,370,300,30);
        Date.setForeground(Color.green);
        Date.setBackground(null);
        Date.setFont(font);
        add(Date);


        // Add Username Label And Input filed.
        deposite = new JLabel("Deposite :");
        deposite.setBounds(30, 420, 120, 30);
        deposite.setForeground(Color.white);
        deposite.setBackground(null);
        deposite.setFont(font);
        add(deposite);

        Deposite = new JTextField();
        Deposite.setBorder(BorderFactory.createLineBorder(Color.white));
        Deposite.setBounds(170,420,200,30);
        Deposite.setForeground(Color.black);
        Deposite.setBackground(new Color(16,108,115));
        Deposite.setFont(font);
        add(Deposite);



        // Add EmployeeAdd Button In Frame.
        Add = new JButton("Add");
        Add.setBounds(70,480,120,30);
        Add.setBackground(Color.black);
        Add.setForeground(Color.white);
        Add.addActionListener(this);
        Add.setBorder(null);
        Add.setFont(font);
        add(Add);


        // Add Back Button In Frame.
        Back = new JButton("Back");
        Back.setBounds(210,480,120,30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        Back.setBorder(null);
        Back.setFont(font);
        add(Back);

        setVisible(true);
    }


    // Override The ActionListener Methods.
    @Override
    public void actionPerformed(ActionEvent e){

//         Declaration Of Add Button.
        if(e.getSource()==Add){
            String idText = (String)ID.getSelectedItem();
            String numberText = Number.getText();
            String nameText = Name.getText();
            String genderText = null;
            if(male.isSelected()) genderText=male.getText();
            else if( female.isSelected()) genderText=female.getText();
            else if (other.isSelected()) genderText = other.getText();
            String countryText = (String)Country.getSelectedItem();
            String roomText = (String)Room.getSelectedItem();
            String dateText = Date.getText();
            String depositeText = Deposite.getText();

            String Query = "insert into customer values('"+idText+"', '"+numberText+"', '"+nameText+"', '"+genderText+"', '"+countryText+"','"+roomText+"', '"+dateText+"', '"+depositeText+"')";
            String Query2 = "update room set availability = 'Occupied' where roomNumber='"+roomText+"'";
            if(numberText.equals("")||nameText.equals("")||depositeText.equals("")){
                JOptionPane.showMessageDialog(this,"Data Field Is Empty!","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    int x = JDBC.setConnection().prepareStatement(Query).executeUpdate();
                    int y = JDBC.setConnection().prepareStatement(Query2).executeUpdate();
                    if(x>0&&y>0){
                        Number.setText(null);
                        Name.setText(null);
                        Deposite.setText(null);
                        male.setSelected(true);
                        ID.setSelectedIndex(0);
                        Country.setSelectedIndex(0);
                        Room.setSelectedIndex(0);
                        JOptionPane.showMessageDialog(this,"Data Successfully Uploaded!");
                    }
                }
                catch(Exception z){
                    z.printStackTrace();
                }
            }
        }


        // Declaration Of Back Button.
        if (e.getSource() == Back) {
            dispose();
        }

    }
}
