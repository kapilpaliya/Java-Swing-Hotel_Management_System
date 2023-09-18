
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

public class CustomerInfo extends JFrame{
    CustomerInfo(){
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
        Font font = new Font("Arial",Font.BOLD,16);


        // Add ID Label.
        JLabel ID = new JLabel("Customer ID");
        ID.setBounds(2,10,100,30);
        ID.setForeground(Color.green);
        ID.setFont(font);
        add(ID);


        // Add Number Label.
        JLabel Number = new JLabel("ID Number");
        Number.setBounds(105,10,100,30);
        Number.setForeground(Color.green);
        Number.setFont(font);
        add(Number);


        // Add Name Label.
        JLabel Name = new JLabel("Name");
        Name.setBounds(195,10,100,30);
        Name.setForeground(Color.green);
        Name.setFont(font);
        add(Name);


        // Add Gender Status Label.
        JLabel Gender = new JLabel("Gender");
        Gender.setBounds(290,10,100,30);
        Gender.setForeground(Color.green);
        Gender.setFont(font);
        add(Gender);


        // Add Country Label.
        JLabel Country = new JLabel("Country");
        Country.setBounds(370,10,100,30);
        Country.setForeground(Color.green);
        Country.setFont(font);
        add(Country);


        // Add Room Label.
        JLabel Room = new JLabel("Room");
        Room.setBounds(460,10,100,30);
        Room.setForeground(Color.green);
        Room.setFont(font);
        add(Room);


        // Add Date Label.
        JLabel Date = new JLabel("Date");
        Date.setBounds(540,10,100,30);
        Date.setForeground(Color.green);
        Date.setFont(font);
        add(Date);


        // Add Deposited Label.
        JLabel deposited = new JLabel("Deposited");
        deposited.setBounds(630,10,100,30);
        deposited.setForeground(Color.green);
        deposited.setFont(font);
        add(deposited);


        // Add Room Table Data In Frame.
        JTable table = new JTable();
        table.setBounds(10,40,700,500);
        table.setFont(new Font("Arial",Font.BOLD,14));
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        try{
            ResultSet rs = JDBC.setConnection().prepareStatement("select * from customer").executeQuery();
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
