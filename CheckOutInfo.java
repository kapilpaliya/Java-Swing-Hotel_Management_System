

// Class And Package Import Statements.
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CheckOutInfo extends JFrame  implements ActionListener{
    // Variable Declaration.
    JLabel customerId, name, room, heading, checkIn, checkOut, Image1, Room, Name, CheckIn, CheckOut; JComboBox<String> IdNumber;
    JButton cancel, update, search;
    Font font = new Font("Arial",Font.BOLD,18);

    ImageIcon IMAGE = new ImageIcon(ClassLoader.getSystemResource("icon/check-out.png"));
    Image image = IMAGE.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
    CheckOutInfo(){
        // Create Frame.
        setBounds(568,135,720,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(3,45,48));
        setResizable(false);
        setTitle("Login Face");
        setLayout(null);
        revalidate();
        setUndecorated(true);


        // Add Heading In Frame.
        heading = new JLabel("Customer Check-Out Details!");
        heading.setFont(new Font("Arail",Font.BOLD,25));
        heading.setBounds(190,30,340,30);
        heading.setForeground(Color.cyan);
        add(heading);


        // Add Customer-Id And Number Label And Option Field.
        customerId = new JLabel("Customer ID :");
        customerId.setBounds(20,163,130,25);
        customerId.setForeground(Color.green);
        customerId.setBackground(null);
        customerId.setFont(font);
        add(customerId);

        IdNumber = new JComboBox<String>();
        IdNumber.setBackground(new Color(16,108,115));
        IdNumber.setBounds(160,163,190,25);
        IdNumber.setForeground(Color.white);
        IdNumber.setBorder(null);
        IdNumber.setFont(font);
        add(IdNumber);


        // Add Room Label And Input Filed.
        room = new JLabel("Room No. :");
        room.setBounds(20, 213, 130, 25);
        room.setForeground(Color.green);
        room.setBackground(null);
        room.setFont(font);
        add(room);

        Room = new JLabel();
        Room.setBackground(new Color(16,108,115));
        Room.setBounds(160,213,190,25);
        Room.setForeground(Color.white);
        Room.setFont(font);
        add(Room);


        // Add Username Label And Input Filed.
        name = new JLabel("Username :");
        name.setBounds(20, 263, 130, 25);
        name.setForeground(Color.green);
        name.setBackground(null);
        name.setFont(font);
        add(name);

        Name = new JLabel();
        Name.setBackground(new Color(16,108,115));
        Name.setBounds(160,263,190,25);
        Name.setForeground(Color.white);
        Name.setFont(font);
        add(Name);


        // Add Check-In Label And Input Filed.
        checkIn = new JLabel("Checked-in :");
        checkIn.setBounds(20, 313, 130, 25);
        checkIn.setForeground(Color.green);
        checkIn.setBackground(null);
        checkIn.setFont(font);
        add(checkIn);

        CheckIn = new JLabel();
        CheckIn.setBackground(new Color(16,108,115));
        CheckIn.setBounds(160,313,300,25);
        CheckIn.setForeground(Color.white);
        CheckIn.setFont(font);
        add(CheckIn);


        // Add Check-Out Label And Input Filed.
        checkOut = new JLabel("Check-Out :");
        checkOut.setBounds(20, 363, 130, 25);
        checkOut.setForeground(Color.green);
        checkOut.setBackground(null);
        checkOut.setFont(font);
        add(checkOut);

        CheckOut = new JLabel(""+new Date());
        CheckOut.setBackground(new Color(16,108,115));
        CheckOut.setBounds(160,363,300,25);
        CheckOut.setForeground(Color.white);
        CheckOut.setFont(font);
        add(CheckOut);


        // Add Update Button.
        update = new JButton("Release");
        update.setBorder(BorderFactory.createLineBorder(Color.white));
        update.setBounds(135,550,100,25);
        update.setForeground(Color.white);
        update.setForeground(Color.white);
        update.addActionListener(this);
        update.setBackground(null);
        update.setFont(font);
        add(update);


        // Add Cancel Button.
        cancel = new JButton("Cancel");
        cancel.setBorder(BorderFactory.createLineBorder(Color.white));
        cancel.setBounds(285,550,100,25);
        cancel.setForeground(Color.white);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setBackground(null);
        cancel.setFont(font);
        add(cancel);


        // Add Search Button.
        search = new JButton("Search");
        search.setBorder(BorderFactory.createLineBorder(Color.white));
        search.setBounds(435,550,100,25);
        search.setForeground(Color.white);
        search.setForeground(Color.white);
        search.addActionListener(this);
        search.setBackground(null);
        search.setFont(font);
        add(search);


        // Add Image In Right Side Of Frame.
        Image1 = new JLabel(new ImageIcon(image));
        Image1.setBounds(400,150,300,300);
        add(Image1);


        // Add Room Number In RoomNumber Label.
        try{
            ResultSet rs = JDBC.setConnection().prepareStatement("select idNumber from customer").executeQuery();
            while(rs.next()){
                IdNumber.addItem(rs.getString("idNumber"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


        setVisible(true);
    }



    // Override The ActionListener Method.
    @Override
    public void actionPerformed(ActionEvent e){


        // Declaration Of Cancel Button.
        if(e.getSource()==cancel){
            dispose();
        }


        // Declaration Of Search Button.
        if(e.getSource()==search){
            try{
                ResultSet rs = JDBC.setConnection().prepareStatement("select name,room,date,diposite from customer where idNumber ='"+IdNumber.getSelectedItem()+"'").executeQuery();
                if(rs.next()){
                    Room.setText(rs.getString("room"));
                    Name.setText(rs.getString("name"));
                    CheckIn.setText(rs.getString("date"));
                }
            }catch(Exception z){
                z.printStackTrace();
            }
        }


        // Declaration Of Update Button.
        if(e.getSource()==update){
            try{
                int x  = JDBC.setConnection().prepareStatement("delete from customer where idNumber = '"+IdNumber.getSelectedItem()+"' and room = '"+Room.getText()+"'").executeUpdate();
                int y = JDBC.setConnection().prepareStatement("update room set availability = 'Available' where roomNumber = '"+Room.getText()+"'").executeUpdate();
                if(y>0 && x>0){
                    JOptionPane.showMessageDialog(this,"Check-out Successfully!");
                }
            }
            catch(Exception z){
                z.printStackTrace();
            }
        }

    }

}
