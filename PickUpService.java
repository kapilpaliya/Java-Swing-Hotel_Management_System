
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
import java.sql.ResultSet;
public class PickUpService extends JFrame{
    PickUpService(){
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


        // Add Pic Up Service For Customer Label.
        JLabel PUS = new JLabel("Pic Up Service For Customer");
        PUS.setBounds(190,15,340,30);
        PUS.setForeground(Color.magenta);
        PUS.setFont(new Font("Arail",Font.BOLD,25));
        add(PUS);


        // Add Car Label And ComboBox.
        JLabel Car = new JLabel("Car Company :");
        Car.setBounds(10,100,150,25);
        Car.setForeground(Color.green);
        Car.setFont(font);
        add(Car);

        JComboBox<String>car = new JComboBox<String>();
        car.setBackground(new Color(16,108,115));
        car.setBounds(130,100,150,25);
        car.setForeground(Color.white);
        car.setBorder(null);
        car.setFont(font);
        add(car);


        // Add Name Label.
        JLabel Name = new JLabel("Name");
        Name.setBounds(15,170,100,30);
        Name.setForeground(Color.green);
        Name.setFont(font);
        add(Name);


        // Add Age Label.
        JLabel Age = new JLabel("Age");
        Age.setBounds(110,170,100,30);
        Age.setForeground(Color.green);
        Age.setFont(font);
        add(Age);


        // Add Gender Label.
        JLabel Gender = new JLabel("Gender");
        Gender.setBounds(210,170,100,30);
        Gender.setForeground(Color.green);
        Gender.setFont(font);
        add(Gender);


        // Add Brand Status Label.
        JLabel Brand = new JLabel("Brand");
        Brand.setBounds(310,170,100,30);
        Brand.setForeground(Color.green);
        Brand.setFont(font);
        add(Brand);


        // Add Car Name Label.
        JLabel CarName = new JLabel("Car Name");
        CarName.setBounds(410,170,100,30);
        CarName.setForeground(Color.green);
        CarName.setFont(font);
        add(CarName);


        // Add Available Label.
        JLabel Available = new JLabel("Available");
        Available.setBounds(510,170,100,30);
        Available.setForeground(Color.green);
        Available.setFont(font);
        add(Available);


        // Add Location Label.
        JLabel Location = new JLabel("Location");
        Location.setBounds(610,170,100,30);
        Location.setForeground(Color.green);
        Location.setFont(font);
        add(Location);


        // Add Room Table Data In Frame.
        JTable table = new JTable();
        table.setBounds(10,200,700,350);
        table.setFont(new Font("Arial",Font.BOLD,14));
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        add(table);


        // Add Cancel Button.
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(410,550,100,25);
        cancel.setForeground(Color.white);
        cancel.setBackground(null);
        cancel.setBorder(BorderFactory.createLineBorder(Color.white));
        cancel.setForeground(Color.white);
        cancel.setFont(font);
        add(cancel);

        // Add Cancel Button.
        JButton search = new JButton("Search");
        search.setBounds(210,550,100,25);
        search.setForeground(Color.white);
        search.setBackground(null);
        search.setBorder(BorderFactory.createLineBorder(Color.white));
        search.setForeground(Color.white);
        search.setFont(font);
        add(search);


        // Set Driver Data In Table.
        try{
            ResultSet rs = JDBC.setConnection().prepareStatement("select * from driver").executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            ResultSet rs1 = JDBC.setConnection().prepareStatement("select carcompany from driver").executeQuery();
            while(rs1.next()){
                car.addItem(rs1.getString("carcompany"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


        // Add ActionListener For Cancel Button.
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        // Add ActionListener For Search Button.
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ResultSet rs = JDBC.setConnection().prepareStatement("select * from driver where carcompany='"+car.getSelectedItem()+"'").executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception z){
                    z.printStackTrace();
                }
            }
        });


        setVisible(true);
    }
}
