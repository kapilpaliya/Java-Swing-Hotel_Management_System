
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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class UpdateRoom extends JFrame implements ActionListener {
    JLabel customerId, name, room, heading, available, clean, Image1; JComboBox<String> IdNumber, Clean, Available;
    JTextField Name, Room;  JButton cancel, update, search;
    Font font = new Font("Arial",Font.BOLD,18); String roomText;
    ImageIcon IMAGE = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
    Image image = IMAGE.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
    UpdateRoom(){
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
        customerId.setBounds(20,187,130,25);
        customerId.setForeground(Color.green);
        customerId.setBackground(null);
        customerId.setFont(font);
        add(customerId);

        IdNumber = new JComboBox<String>();
        IdNumber.setBackground(new Color(16,108,115));
        IdNumber.setBounds(160,187,190,25);
        IdNumber.setForeground(Color.white);
        IdNumber.setBorder(null);
        IdNumber.setFont(font);
        add(IdNumber);


        // Add Name Label And Input Filed.
        name = new JLabel("Username :");
        name.setBounds(20, 237, 130, 25);
        name.setForeground(Color.green);
        name.setBackground(null);
        name.setFont(font);
        add(name);

        Name = new JTextField();
        Name.setBorder(BorderFactory.createLineBorder(Color.white));
        Name.setBackground(new Color(16,108,115));
        Name.setBounds(160,237,190,25);
        Name.setForeground(Color.white);
        Name.setEnabled(false);
        Name.setFont(font);
        add(Name);


        // Add Room Label And Input Filed.
        room = new JLabel("Room No. :");
        room.setBounds(20, 287, 130, 25);
        room.setForeground(Color.green);
        room.setBackground(null);
        room.setFont(font);
        add(room);

        Room = new JTextField();
        Room.setBorder(BorderFactory.createLineBorder(Color.white));
        Room.setBackground(new Color(16,108,115));
        Room.setBounds(160,287,190,25);
        Room.setForeground(Color.white);
        Room.setFont(font);
        add(Room);


        // Add Available Label And Input Filed.
        available = new JLabel("Availability :");
        available.setBounds(20, 337, 130, 25);
        available.setForeground(Color.green);
        available.setBackground(null);
        available.setFont(font);
        add(available);

        Available = new JComboBox<>(new String[]{"none....", "Available", "Occupied"});
        Available.setBorder(BorderFactory.createLineBorder(Color.white));
        Available.setBackground(new Color(16,108,115));
        Available.setBounds(160,337,190,25);
        Available.setForeground(Color.white);
        Available.setSelectedIndex(0);
        Available.setFont(font);
        add(Available);


        // Add Room Label And Input Filed.
        clean = new JLabel("Clean. :");
        clean.setBounds(20, 387, 130, 25);
        clean.setForeground(Color.green);
        clean.setBackground(null);
        clean.setFont(font);
        add(clean);

        Clean = new JComboBox<>(new String[]{"none....", "Cleaned", "Dirty"});
        Clean.setBorder(BorderFactory.createLineBorder(Color.white));
        Clean.setBackground(new Color(16,108,115));
        Clean.setBounds(160,387,190,25);
        Clean.setForeground(Color.white);
        Clean.setSelectedIndex(0);
        Clean.setFont(font);
        add(Clean);


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
            ResultSet rs = JDBC.setConnection().prepareStatement("select idNumber,name from customer").executeQuery();
            while(rs.next()){
                IdNumber.addItem(rs.getString("idNumber"));
            }

            ResultSet rs1 = JDBC.setConnection().prepareStatement("select name from customer where idNumber = '"+IdNumber.getSelectedItem()+"'").executeQuery();
            if(rs1.next()){
                Name.setText(rs1.getString("name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


        // Add Iterm Listener For IdNumber ComboBox.
        IdNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    ResultSet rs = JDBC.setConnection().prepareStatement("select name from customer where idNumber = '"+IdNumber.getSelectedItem()+"'").executeQuery();
                    if(rs.next()){
                        Name.setText(rs.getString("name"));
                    }
                }
                catch(Exception z){
                    z.printStackTrace();
                }
            }
        });


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
                ResultSet rs = JDBC.setConnection().prepareStatement("select room from customer where idNumber = '"+IdNumber.getSelectedItem()+"'").executeQuery();
                if(rs.next()){
                    Room.setText(rs.getString("room"));
                    roomText = rs.getString("room");
                }

                ResultSet rs1 = JDBC.setConnection().prepareStatement("select availability, cleanStatus from room where roomNumber = '"+roomText+"'").executeQuery();
                if(rs1.next()){
                    String av = rs1.getString("availability");
                    String cl = rs1.getString("cleanStatus");
                    if(av.equals("Occupied")){
                        Available.setSelectedIndex(2);
                    }
                    else if(av.equals("Available")){
                        Available.setSelectedIndex(1);
                    }
                    if(cl.equals("Cleaned")){
                        Clean.setSelectedIndex(1);
                    }
                    else if(cl.equals("Dirty")){
                        Clean.setSelectedIndex(2);
                    }
                }
            }
            catch(Exception z){
                z.printStackTrace();
            }
        }


        // Declaration Of Update Button.
        if(e.getSource()==update){
            if(Room.getText().equals("")){

            }else{
                try{
                    int x = JDBC.setConnection().prepareStatement("update customer set room = '"+Room.getText()+"' where idNumber = '"+IdNumber.getSelectedItem()+"'").executeUpdate();
                    int y = JDBC.setConnection().prepareStatement("update room set availability = '"+Available.getSelectedItem()+"', cleanStatus = '"+Clean.getSelectedItem()+"' where roomNumber = '"+roomText+"'").executeUpdate();
                    if(x>0 && y>0){
                        Room.setText(null);
                        Clean.setSelectedIndex(0);
                        Available.setSelectedIndex(0);
                        JOptionPane.showMessageDialog(this,"Data Successfully Updated!");
                    }
                }
                catch(Exception z){
                    z.printStackTrace();
                }
            }
        }

    }

}
