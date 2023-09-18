
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

public class Department extends JFrame{
    Department(){
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


        // Add Department Label.
        JLabel department = new JLabel("Department");
        department.setBounds(100,10,150,30);
        department.setForeground(Color.green);
        department.setFont(font);
        add(department);


        // Add Budget Label.
        JLabel budget = new JLabel("Budget");
        budget.setBounds(430,10,100,30);
        budget.setForeground(Color.green);
        budget.setFont(font);
        add(budget);


        // Add Room Table Data In Frame.
        JTable table = new JTable();
        table.setBounds(10,40,700,500);
        table.setFont(font);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        try{
            ResultSet rs = JDBC.setConnection().prepareStatement("select * from department").executeQuery();
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
