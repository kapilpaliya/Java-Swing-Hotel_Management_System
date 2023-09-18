
// Class And Package Import Statements.
import net.proteanit.sql.DbUtils;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
public class SearchRoom extends JFrame{
    SearchRoom(){
        // Create Frame.
        getContentPane().setBackground(new Color(3,45,48));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(568,135,720,600);
        setTitle("Login Face");
        setUndecorated(true);
        setResizable(false);
        setLayout(null);
        revalidate();


        // Add Heading In Frame.
        JLabel heading = new JLabel("Search Room For New Customer");
        heading.setFont(new Font("Arial", Font.BOLD,25));
        heading.setBounds(160,5,400,30);
        heading.setForeground(Color.MAGENTA);
        add(heading);


        // Add Font Style In Frame.
        Font font = new Font("Arial",Font.BOLD,18);


        // Add RoomNumber Label.
        JLabel roomNumber = new JLabel("Room");
        roomNumber.setBounds(50,50,100,30);
        roomNumber.setForeground(Color.green);
        roomNumber.setFont(font);
        add(roomNumber);


        // Add Availability Label.
        JLabel Availability = new JLabel("Availability");
        Availability.setBounds(170,50,100,30);
        Availability.setForeground(Color.green);
        Availability.setFont(font);
        add(Availability);


        // Add Price Label.
        JLabel Price = new JLabel("Price");
        Price.setBounds(330,50,100,30);
        Price.setForeground(Color.green);
        Price.setFont(font);
        add(Price);


        // Add Clean Status Label.
        JLabel cleanStatus = new JLabel("Clean");
        cleanStatus.setBounds(455,50,100,30);
        cleanStatus.setForeground(Color.green);
        cleanStatus.setFont(font);
        add(cleanStatus);


        // Add Bed Type Label.
        JLabel bedType = new JLabel("Bed");
        bedType.setBounds(600,50,100,30);
        bedType.setForeground(Color.green);
        bedType.setFont(font);
        add(bedType);


        // Add Room Table Data In Frame.
        JTable table = new JTable();
        table.setBounds(10,100,700,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        table.setFont(font);
        add(table);


        // Add Cancel Button.
        JButton cancel = new JButton("Cancel");
        cancel.setBorder(BorderFactory.createLineBorder(Color.white));
        cancel.setBounds(450,550,100,25);
        cancel.setForeground(Color.white);
        cancel.setForeground(Color.white);
        cancel.setBackground(null);
        cancel.setFont(font);
        add(cancel);


        // Add Bed Type Label And Combo Box.
        JLabel bedType1 = new JLabel("Bed Type :");
        bedType1.setBounds(100,550,150,25);
        bedType1.setForeground(Color.green);
        bedType1.setBackground(null);
        bedType1.setFont(font);
        add(bedType1);

        JComboBox<String>Room = new JComboBox<String>(new String[]{"All Rooms", "All Available Room", "Single Bed", "Double Bed"});
        Room.setBackground(new Color(16,108,115));
        Room.setBounds(200,550,140,25);
        Room.setForeground(Color.white);
        Room.setSelectedIndex(0);
        Room.setBorder(null);
        Room.setFont(font);
        add(Room);


        // Display Room Table Data In Table.
        try{
            ResultSet rs = JDBC.setConnection().prepareStatement("select * from room").executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }


        // Add Cancel Button Listener.
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        // Add Item Listener For Room Lable.
        Room.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    if(Room.getSelectedItem().equals("Single Bed")){
                        Room.setSize(140,25);
                        ResultSet rs = JDBC.setConnection().prepareStatement("select * from room where bedType='Single Bad' and availability = 'Available'").executeQuery();
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    else if(Room.getSelectedItem().equals("Double Bed")){
                        Room.setSize(140,25);
                        ResultSet rs = JDBC.setConnection().prepareStatement("select * from room where bedType='Double Bad' and availability = 'Available'").executeQuery();
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    else if(Room.getSelectedItem().equals("All Available Room")){
                        Room.setSize(200,25);
                        ResultSet rs = JDBC.setConnection().prepareStatement("select * from room where availability = 'Available'").executeQuery();
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    else{
                        Room.setSize(140,25);
                        ResultSet rs = JDBC.setConnection().prepareStatement("select * from room ").executeQuery();
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                }
                catch(Exception z){
                    z.printStackTrace();
                }
            }
        });


        setVisible(true);

    }
}
