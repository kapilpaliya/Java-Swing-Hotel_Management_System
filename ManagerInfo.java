
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
public class ManagerInfo extends JFrame{
    ManagerInfo(){
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


        // Add Name Label.
        JLabel name = new JLabel("Name");
        name.setBounds(20,10,100,30);
        name.setForeground(Color.green);
        name.setFont(font);
        add(name);


        // Add Age Label.
        JLabel age = new JLabel("Age");
        age.setBounds(110,10,100,30);
        age.setForeground(Color.green);
        age.setFont(font);
        add(age);


        // Add Gender Label.
        JLabel gender = new JLabel("Gender");
        gender.setBounds(190,10,100,30);
        gender.setForeground(Color.green);
        gender.setFont(font);
        add(gender);


        // Add JOB Title Status Label.
        JLabel job = new JLabel("JOB");
        job.setBounds(290,10,100,30);
        job.setForeground(Color.green);
        job.setFont(font);
        add(job);


        // Add Salary Label.
        JLabel salary = new JLabel("Salary");
        salary.setBounds(370,10,100,30);
        salary.setForeground(Color.green);
        salary.setFont(font);
        add(salary);


        // Add Phone Label.
        JLabel phone = new JLabel("Phone");
        phone.setBounds(460,10,100,30);
        phone.setForeground(Color.green);
        phone.setFont(font);
        add(phone);


        // Add Aadhaar Label.
        JLabel aadhaar = new JLabel("Aadhaar");
        aadhaar.setBounds(540,10,100,30);
        aadhaar.setForeground(Color.green);
        aadhaar.setFont(font);
        add(aadhaar);


        // Add Email Label.
        JLabel email = new JLabel("Email");
        email.setBounds(630,10,100,30);
        email.setForeground(Color.green);
        email.setFont(font);
        add(email);


        // Add Room Table Data In Frame.
        JTable table = new JTable();
        table.setBounds(10,40,700,500);
        table.setFont(new Font("Arial",Font.BOLD,14));
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        try{
            ResultSet rs = JDBC.setConnection().prepareStatement("select * from employee where job='Manager'").executeQuery();
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
