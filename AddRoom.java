
// Class And Package Import Statements.
import javax.swing.JFrame;
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
public class AddRoom extends JFrame implements ActionListener{
    // Variable Declaration.
    JLabel roomNumber, price, availability, bedType, cleanStatus, heading, IMAGE; JComboBox Availability,BedType, CleanStatus; JTextField RoomNumber, Price;
    JButton Add, Back;
    ImageIcon Logo = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
            IMAGES = new ImageIcon(ClassLoader.getSystemResource("icon/Room.png"));
    Image b_Image = IMAGES.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
    Font font = new Font("Arial",Font.BOLD,16);

    AddRoom(){
        // Create Frame.
        setBounds(400,150,800,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(3,45,48));
        setResizable(false);
        setTitle("Login Face");
        setLayout(null);
        revalidate();


        // Add Image In Right Image Type Is Symbol.
        IMAGE = new JLabel(new ImageIcon(b_Image));
        IMAGE.setBounds(400,75,300,300);
        add(IMAGE);


        // Add Heading In Top Of Frame.
        heading = new JLabel("Add Room");
        heading.setBounds(335, 5, 130, 40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setBackground(null);
        add(heading);


        // Add RoomNumber Label And Input filed.
        roomNumber = new JLabel("Room Number :");
        roomNumber.setBounds(30, 75, 120, 30);
        roomNumber.setForeground(Color.white);
        roomNumber.setBackground(null);
        roomNumber.setFont(font);
        add(roomNumber);

        RoomNumber = new JTextField();
        RoomNumber.setBorder(BorderFactory.createLineBorder(Color.white));
        RoomNumber.setBounds(170,75,200,30);
        RoomNumber.setForeground(Color.black);
        RoomNumber.setBackground(new Color(16,108,115));
        RoomNumber.setFont(font);
        add(RoomNumber);


        // Add Availability Label And Input filed.
        availability = new JLabel("Availability :");
        availability.setBounds(30, 135, 120, 30);
        availability.setForeground(Color.white);
        availability.setBackground(null);
        availability.setFont(font);
        add(availability);

        Availability = new JComboBox(new String[]{"Available","Occupied"});
        Availability.setBorder(null);
        Availability.setBounds(170,135,200,30);
        Availability.setForeground(Color.black);
        Availability.setBackground(new Color(16,108,115));
        Availability.setFont(font);
        add(Availability);


        // Add Price Label And Input filed.
        price = new JLabel("Price :");
        price.setBounds(30, 185, 120, 30);
        price.setForeground(Color.white);
        price.setBackground(null);
        price.setFont(font);
        add(price);

        Price = new JTextField();
        Price.setBorder(BorderFactory.createLineBorder(Color.white));
        Price.setBounds(170,185,200,30);
        Price.setForeground(Color.black);
        Price.setBackground(new Color(16,108,115));
        Price.setFont(font);
        add(Price);


        // Add CleanStatus Label And Input filed.
        cleanStatus = new JLabel("Cleaning Status :");
        cleanStatus.setBounds(30, 235, 150, 30);
        cleanStatus.setForeground(Color.white);
        cleanStatus.setBackground(null);
        cleanStatus.setFont(font);
        add(cleanStatus);

        CleanStatus = new JComboBox(new String[]{"Cleaned","Dirty"});
        CleanStatus.setBorder(null);
        CleanStatus.setBounds(170,235,200,30);
        CleanStatus.setForeground(Color.black);
        CleanStatus.setBackground(new Color(16,108,115));
        CleanStatus.setFont(font);
        add(CleanStatus);


        // Add BedType Label And Input filed.
        bedType = new JLabel("Bed Type :");
        bedType.setBounds(30, 295, 150, 30);
        bedType.setForeground(Color.white);
        bedType.setBackground(null);
        bedType.setFont(font);
        add(bedType);

        BedType = new JComboBox(new String[]{"Single Bad","Double Bad"});
        BedType.setBorder(null);
        BedType.setBounds(170,295,200,30);
        BedType.setForeground(Color.black);
        BedType.setBackground(new Color(16,108,115));
        BedType.setFont(font);
        add(BedType);


        // Add RoomAdd Button In Frame.
        Add = new JButton("Add");
        Add.setBounds(50,370,120,30);
        Add.setBackground(Color.black);
        Add.setForeground(Color.white);
        Add.addActionListener(this);
        Add.setBorder(null);
        Add.setFont(font);
        add(Add);


        // Add Back Button In Frame.
        Back = new JButton("Back");
        Back.setBounds(190,370,120,30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        Back.setBorder(null);
        Back.setFont(font);
        add(Back);


        setUndecorated(true);
        setVisible(true);
    }

    // Override The ActionListener Methods.
    @Override
    public void actionPerformed(ActionEvent e){

        // Declaration Of Add Button.
        if(e.getSource()==Add){
            String roomNumberText = RoomNumber.getText();
            String availabilityText = Availability.getSelectedItem().toString();
            String priceText = Price.getText();
            String cleanStatusText = CleanStatus.getSelectedItem().toString();
            String bedTypeText = BedType.getSelectedItem().toString();
            String Query = "insert into room values('"+roomNumberText+"', '"+availabilityText+"', '"+priceText+"','"+cleanStatusText+"', '"+bedTypeText+"')";
            if(roomNumberText.equals("")||priceText.equals("")){
                JOptionPane.showMessageDialog(this,"Data Field Is Empty!","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    int x = JDBC.setConnection().prepareStatement(Query).executeUpdate();
                    if(x>0){
                        RoomNumber.setText(null);
                        Price.setText(null);
                        Availability.setSelectedIndex(0);
                        CleanStatus.setSelectedIndex(0);
                        BedType.setSelectedIndex(0);
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
            new Admin();
            dispose();
        }

    }

}
