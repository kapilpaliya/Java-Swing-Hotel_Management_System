
// Class And Package Import Statements.
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Room extends JFrame{
    Room(){
        // Create Frame.
        setBounds(568,135,720,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(3,45,48));
        setResizable(false);
        setTitle("Login Face");
        setLayout(null);
        revalidate();
        setUndecorated(true);


        // Add Font Style In Frame.
        Font font = new Font("Arial",Font.BOLD,18);


        // Add RoomNumber Label.
        JLabel roomNumber = new JLabel("Room");
        roomNumber.setBounds(50,10,100,30);
        roomNumber.setForeground(Color.green);
        roomNumber.setFont(font);
        add(roomNumber);


        // Add Availability Label.
        JLabel Availability = new JLabel("Availability");
        Availability.setBounds(170,10,100,30);
        Availability.setForeground(Color.green);
        Availability.setFont(font);
        add(Availability);


        // Add Price Label.
        JLabel Price = new JLabel("Price");
        Price.setBounds(330,10,100,30);
        Price.setForeground(Color.green);
        Price.setFont(font);
        add(Price);


        // Add Clean Status Label.
        JLabel cleanStatus = new JLabel("Clean");
        cleanStatus.setBounds(455,10,100,30);
        cleanStatus.setForeground(Color.green);
        cleanStatus.setFont(font);
        add(cleanStatus);


        // Add Bed Type Label.
        JLabel bedType = new JLabel("Bed");
        bedType.setBounds(600,10,100,30);
        bedType.setForeground(Color.green);
        bedType.setFont(font);
        add(bedType);


        // Add Room Table Data In Frame.
        JTable table = new JTable();
        table.setBounds(10,40,700,500);
        table.setFont(font);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        try{
            ResultSet rs = JDBC.setConnection().prepareStatement("select * from room").executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e){
            e.printStackTrace();
        }
        add(table);


        // Add Cancel Button.
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(310,550,100,25);
        cancel.setForeground(Color.white);
        cancel.setBackground(null);
        cancel.setBorder(BorderFactory.createLineBorder(Color.white));
        cancel.setForeground(Color.white);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancel.setFont(font);
        add(cancel);


        setVisible(true);
    }
}
