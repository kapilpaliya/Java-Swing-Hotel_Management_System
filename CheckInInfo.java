
// Class And Package Import Statements.
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CheckInInfo extends JFrame implements ActionListener{
    // Variable Declaration.
    JLabel customerId, name, room, heading, checkIn, amount, totalAmount, Image1; JComboBox<String> IdNumber;
    JTextField Name, Room, CheckIn, Amount, TotalAmount;  JButton cancel, update, search;
    Font font = new Font("Arial",Font.BOLD,18);  String roomText,dipositeText;

    ImageIcon IMAGE = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
    Image image = IMAGE.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
    CheckInInfo(){
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
        heading = new JLabel("Customer Check-In Details!");
        heading.setFont(new Font("Arail",Font.BOLD,25));
        heading.setBounds(200,30,320,30);
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

        Room = new JTextField();
        Room.setBorder(BorderFactory.createLineBorder(Color.white));
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

        Name = new JTextField();
        Name.setBorder(BorderFactory.createLineBorder(Color.white));
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

        CheckIn = new JTextField();
        CheckIn.setBorder(BorderFactory.createLineBorder(Color.white));
        CheckIn.setBackground(new Color(16,108,115));
        CheckIn.setBounds(160,313,190,25);
        CheckIn.setForeground(Color.white);
        CheckIn.setFont(font);
        add(CheckIn);


        // Add Pay Amount Label And Input Filed.
        totalAmount = new JLabel("Amount Pay :");
        totalAmount.setBounds(20, 363, 130, 25);
        totalAmount.setForeground(Color.green);
        totalAmount.setBackground(null);
        totalAmount.setFont(font);
        add(totalAmount);

        TotalAmount = new JTextField();
        TotalAmount.setBorder(BorderFactory.createLineBorder(Color.white));
        TotalAmount.setBackground(new Color(16,108,115));
        TotalAmount.setBounds(160,363,190,25);
        TotalAmount.setForeground(Color.white);
        TotalAmount.setFont(font);
        add(TotalAmount);


        // Add Pending Amount Label And Input Filed.
        amount = new JLabel("Pending Amo. :");
        amount.setBounds(20, 413, 135, 25);
        amount.setForeground(Color.green);
        amount.setBackground(null);
        amount.setFont(font);
        add(amount);

        Amount = new JTextField();
        Amount.setBorder(BorderFactory.createLineBorder(Color.white));
        Amount.setBackground(new Color(16,108,115));
        Amount.setBounds(160,413,190,25);
        Amount.setForeground(Color.white);
        Amount.setFont(font);
        add(Amount);


        // Add Update Button.
        update = new JButton("Update");
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
                    TotalAmount.setText(rs.getString("diposite"));
                    roomText = rs.getString("room");
                    dipositeText = rs.getString("diposite");
                }

                ResultSet rs2 = JDBC.setConnection().prepareStatement("select price from room where roomNumber ='"+roomText+"'").executeQuery();
                if(rs2.next()){
                    Amount.setText(String.valueOf(Integer.parseInt(rs2.getString("price")) - Integer.parseInt(dipositeText)));
                }
            }catch(Exception z){
                z.printStackTrace();
            }
        }


        // Declaration Of Update Button.
        if(e.getSource()==update){
            try{
                String a2 = Room.getText();
                String a3 = Name.getText();
                String a4 = CheckIn.getText();
                String a6 = TotalAmount.getText();
                String Query = "update customer set room = '"+a2+"', name = '"+a3+"', date = '"+a4+"', diposite = '"+a6+"' where idNumber = '"+IdNumber.getSelectedItem()+"'   ";
                int x = JDBC.setConnection().prepareStatement(Query).executeUpdate();
                if(x>0){
                    Room.setText(null);
                    Name.setText(null);
                    CheckIn.setText(null);
                    Amount.setText(null);
                    TotalAmount.setText(null);
                    JOptionPane.showMessageDialog(this,"Successfully Updated!");
                }
            }catch(Exception z){
                z.printStackTrace();
            }
        }

    }

}
