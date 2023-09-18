
// Class And Package Import Statements.
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
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

public class AddEmployee extends JFrame implements ActionListener{
    // Variable Declaration.
    JLabel name, age, gender, job, salary, phone, aadhaar, email, heading, IMAGE; JComboBox<String> Job;
    JTextField Name, Age, Salary, Phone, Aadhaar, Email; JButton Add, Back; ButtonGroup radioButtonGroup;
    JRadioButton male, female, other;
    ImageIcon Logo = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
                IMAGES = new ImageIcon(ClassLoader.getSystemResource("icon/Employee2.png"));
    Image b_Image = IMAGES.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
    Font font = new Font("Arial",Font.BOLD,16);
    AddEmployee(){
        // Create Frame.
        getContentPane().setBackground(new Color(3,45,48));
        setBounds(400,150,800,450);
        setIconImage(Logo.getImage());
        setUndecorated(true);
        setResizable(false);
        setLayout(null);
        revalidate();


        // Add Heading In Top Of Frame.
        heading = new JLabel("Add Employee Details");
        heading.setFont(new Font("Arial",Font.BOLD,25));
        heading.setBounds(270, 5, 260, 40);
        heading.setForeground(Color.white);
        heading.setBackground(null);
        add(heading);


        // Add Image In Right Image Type Is Symbol.
        IMAGE = new JLabel(new ImageIcon(b_Image));
        IMAGE.setBounds(450,75,300,300);
        add(IMAGE);


        // Add Username Label And Input filed.
        name = new JLabel("Username :");
        name.setBounds(30, 50, 120, 30);
        name.setForeground(Color.white);
        name.setBackground(null);
        name.setFont(font);
        add(name);

        Name = new JTextField();
        Name.setBorder(BorderFactory.createLineBorder(Color.white));
        Name.setBounds(170,50,200,30);
        Name.setForeground(Color.black);
        Name.setBackground(new Color(16,108,115));
        Name.setFont(font);
        add(Name);


        // Add Age Label And Input filed.
        age = new JLabel("Age :");
        age.setBounds(30, 100, 120, 30);
        age.setForeground(Color.white);
        age.setBackground(null);
        age.setFont(font);
        add(age);

        Age = new JTextField();
        Age.setBorder(BorderFactory.createLineBorder(Color.white));
        Age.setBounds(170,100,200,30);
        Age.setForeground(Color.black);
        Age.setBackground(new Color(16,108,115));
        Age.setFont(font);
        add(Age);


        // Add Gender Label And Input filed.
        gender = new JLabel("Gender :");
        gender.setBounds(30, 150, 120, 30);
        gender.setForeground(Color.white);
        gender.setBackground(null);
        gender.setFont(font);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(170,150,60,30);
        male.setForeground(Color.cyan);
        male.setSelected(true);
        male.setBackground(null);
        male.setBorder(null);
        male.setFont(font);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(230,150,80,30);
        female.setForeground(Color.cyan);
        female.setBackground(null);
        female.setBorder(null);
        female.setFont(font);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(310,150,80,30);
        other.setForeground(Color.cyan);
        other.setBackground(null);
        other.setBorder(null);
        other.setFont(font);
        add(other);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(male);
        radioButtonGroup.add(female);
        radioButtonGroup.add(other);


        // Add JOB Title Label And Input filed.
        job = new JLabel("JOB Title :");
        job.setBounds(30, 200, 120, 30);
        job.setForeground(Color.white);
        job.setBackground(null);
        job.setFont(font);
        add(job);

        Job = new JComboBox<String>(new String[]{"Front Desk", "Housekeeping", "Kitchen Staff", "Manager", "Accountant", "Chef"});
        Job.setBorder(null);
        Job.setBounds(170,200,200,30);
        Job.setForeground(Color.black);
        Job.setBackground(new Color(16,108,115));
        Job.setFont(font);
        add(Job);


        // Add Salary Label And Input filed.
        salary = new JLabel("Salary :");
        salary.setBounds(30, 250, 120, 30);
        salary.setForeground(Color.white);
        salary.setBackground(null);
        salary.setFont(font);
        add(salary);

        Salary = new JTextField();
        Salary.setBorder(BorderFactory.createLineBorder(Color.white));
        Salary.setBounds(170,250,200,30);
        Salary.setForeground(Color.black);
        Salary.setBackground(new Color(16,108,115));
        Salary.setFont(font);
        add(Salary);


        // Add Phone Number Label And Input filed.
        phone = new JLabel("Phone :");
        phone.setBounds(30, 300, 120, 30);
        phone.setForeground(Color.white);
        phone.setBackground(null);
        phone.setFont(font);
        add(phone);

        Phone = new JTextField();
        Phone.setBorder(BorderFactory.createLineBorder(Color.white));
        Phone.setBounds(170,300,200,30);
        Phone.setForeground(Color.black);
        Phone.setBackground(new Color(16,108,115));
        Phone.setFont(font);
        add(Phone);


        // Add Aadhaar Label And Input filed.
        aadhaar = new JLabel("Aadhaar :");
        aadhaar.setBounds(30, 350, 120, 30);
        aadhaar.setForeground(Color.white);
        aadhaar.setBackground(null);
        aadhaar.setFont(font);
        add(aadhaar);

        Aadhaar = new JTextField();
        Aadhaar.setBorder(BorderFactory.createLineBorder(Color.white));
        Aadhaar.setBounds(170,350,200,30);
        Aadhaar.setForeground(Color.black);
        Aadhaar.setBackground(new Color(16,108,115));
        Aadhaar.setFont(font);
        add(Aadhaar);


        // Add Email ID Label And Input filed.
        email = new JLabel("Email ID :");
        email.setBounds(30, 400, 120, 30);
        email.setForeground(Color.white);
        email.setBackground(null);
        email.setFont(font);
        add(email);

        Email = new JTextField();
        Email.setBorder(BorderFactory.createLineBorder(Color.white));
        Email.setBounds(170,400,200,30);
        Email.setForeground(Color.black);
        Email.setBackground(new Color(16,108,115));
        Email.setFont(font);
        add(Email);


        // Add EmployeeAdd Button In Frame.
        Add = new JButton("Add");
        Add.setBounds(465,400,120,30);
        Add.setBackground(Color.black);
        Add.setForeground(Color.white);
        Add.addActionListener(this);
        Add.setBorder(null);
        Add.setFont(font);
        add(Add);


        // Add Back Button In Frame.
        Back = new JButton("Back");
        Back.setBounds(615,400,120,30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        Back.setBorder(null);
        Back.setFont(font);
        add(Back);


        setVisible(true);

    }


    // Override The ActionListener Methods.
    @Override
    public void actionPerformed(ActionEvent e){

        // Declaration Of Add Button.
        if(e.getSource()==Add){
            String nameText = Name.getText();
            String ageText = Age.getText();
            String genderText = null;
            if(male.isSelected()) genderText=male.getText();
            else if( female.isSelected()) genderText=female.getText();
            else if (other.isSelected()) genderText = other.getText();
            String jobText = (String)Job.getSelectedItem();
            String salaryText = Salary.getText();
            String phoneText = Phone.getText();
            String aadhaarText = Aadhaar.getText();
            String emailText = Email.getText();

            String Query = "insert into employee values('"+nameText+"', '"+ageText+"', '"+genderText+"', '"+jobText+"','"+salaryText+"', '"+phoneText+"', '"+aadhaarText+"', '"+emailText+"')";
            if(nameText.equals("")||ageText.equals("")||salaryText.equals("")||phoneText.equals("")||aadhaarText.equals("")||emailText.equals("")){
                JOptionPane.showMessageDialog(this,"Data Field Is Empty!","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    int x = JDBC.setConnection().prepareStatement(Query).executeUpdate();
                    if(x>0){
                        Name.setText(null);
                        Age.setText(null);
                        Salary.setText(null);
                        Phone.setText(null);
                        Aadhaar.setText(null);
                        Email.setText(null);
                        male.setSelected(true);
                        Job.setSelectedIndex(0);
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
