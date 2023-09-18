
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

public class AddDriver extends JFrame implements ActionListener{
    // Variable Declaration.
    JLabel name, age, gender, carCompany, carName,available, location, heading, IMAGE; JComboBox<String> Available;
    JTextField Name, Age, CarCompany, CarName, Location; JButton Add, Back; ButtonGroup radioButtonGroup;
    JRadioButton male, female, other;
    ImageIcon Logo = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
            IMAGES = new ImageIcon(ClassLoader.getSystemResource("icon/Driver2.png"));
    Image b_Image = IMAGES.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
    Font font = new Font("Arial",Font.BOLD,16);
    AddDriver(){
        // Create Frame.
        getContentPane().setBackground(new Color(3,45,48));
        setBounds(400,150,800,450);
        setIconImage(Logo.getImage());
        setTitle("Login Face");
        setUndecorated(true);
        setResizable(false);
        setLayout(null);
        revalidate();


        // Add Heading In Top Of Frame.
        heading = new JLabel("Add Driver Details");
        heading.setFont(new Font("Arial",Font.BOLD,25));
        heading.setBounds(290, 5, 220, 40);
        heading.setForeground(Color.white);
        heading.setBackground(null);
        add(heading);


        // Add Image In Right Image Type Is Symbol.
        IMAGE = new JLabel(new ImageIcon(b_Image));
        IMAGE.setBounds(450,75,300,300);
        add(IMAGE);


        // Add Driver Label And Input filed.
        name = new JLabel("Driver Name :");
        name.setBounds(30, 75, 120, 30);
        name.setForeground(Color.white);
        name.setBackground(null);
        name.setFont(font);
        add(name);

        Name = new JTextField();
        Name.setBorder(BorderFactory.createLineBorder(Color.white));
        Name.setBounds(170,75,200,30);
        Name.setForeground(Color.black);
        Name.setBackground(new Color(16,108,115));
        Name.setFont(font);
        add(Name);


        // Add Age Label And Input filed.
        age = new JLabel("Age :");
        age.setBounds(30, 125, 120, 30);
        age.setForeground(Color.white);
        age.setBackground(null);
        age.setFont(font);
        add(age);

        Age = new JTextField();
        Age.setBorder(BorderFactory.createLineBorder(Color.white));
        Age.setBounds(170,125,200,30);
        Age.setForeground(Color.black);
        Age.setBackground(new Color(16,108,115));
        Age.setFont(font);
        add(Age);


        // Add Gender Label And Input filed.
        gender = new JLabel("Gender :");
        gender.setBounds(30, 175, 120, 30);
        gender.setForeground(Color.white);
        gender.setBackground(null);
        gender.setFont(font);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(170,175,60,30);
        male.setSelected(true);
        male.setForeground(Color.cyan);
        male.setBackground(null);
        male.setBorder(null);
        male.setFont(font);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(230,175,80,30);
        female.setForeground(Color.cyan);
        female.setBackground(null);
        female.setBorder(null);
        female.setFont(font);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(310,175,80,30);
        other.setForeground(Color.cyan);
        other.setBackground(null);
        other.setBorder(null);
        other.setFont(font);
        add(other);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(male);
        radioButtonGroup.add(female);
        radioButtonGroup.add(other);


        // Add Car Company Label And Input filed.
        carCompany = new JLabel("Car Company :");
        carCompany.setBounds(30, 225, 120, 30);
        carCompany.setForeground(Color.white);
        carCompany.setBackground(null);
        carCompany.setFont(font);
        add(carCompany);

        CarCompany = new JTextField();
        CarCompany.setBorder(BorderFactory.createLineBorder(Color.white));
        CarCompany.setBounds(170,225,200,30);
        CarCompany.setForeground(Color.black);
        CarCompany.setBackground(new Color(16,108,115));
        CarCompany.setFont(font);
        add(CarCompany);


        // Add Car Name Label And Input filed.
        carName = new JLabel("Car Name :");
        carName.setBounds(30, 275, 120, 30);
        carName.setForeground(Color.white);
        carName.setBackground(null);
        carName.setFont(font);
        add(carName);

        CarName = new JTextField();
        CarName.setBorder(BorderFactory.createLineBorder(Color.white));
        CarName.setBounds(170,275,200,30);
        CarName.setForeground(Color.black);
        CarName.setBackground(new Color(16,108,115));
        CarName.setFont(font);
        add(CarName);


        // Add Car Available Condition Label And Input filed.
        available = new JLabel("Driver Available :");
        available.setBounds(30, 325, 130, 30);
        available.setForeground(Color.white);
        available.setBackground(null);
        available.setFont(font);
        add(available);

        Available = new JComboBox<String>(new String[]{"Yes", "No"});
        Available.setBorder(null);
        Available.setBounds(170,325,200,30);
        Available.setForeground(Color.black);
        Available.setBackground(new Color(16,108,115));
        Available.setFont(font);
        add(Available);


        // Add Location Label And Input filed.
        location = new JLabel("Location :");
        location.setBounds(30, 375, 120, 30);
        location.setForeground(Color.white);
        location.setBackground(null);
        location.setFont(font);
        add(location);

        Location = new JTextField();
        Location.setBorder(BorderFactory.createLineBorder(Color.white));
        Location.setBounds(170,375,200,30);
        Location.setForeground(Color.black);
        Location.setBackground(new Color(16,108,115));
        Location.setFont(font);
        add(Location);


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
            String carCompanyText = CarCompany.getText();
            String carNameText = CarName.getText();
            String availableText = (String)Available.getSelectedItem();
            String locationText = Location.getText();
            String Query = "insert into driver values('"+nameText+"', '"+ageText+"', '"+genderText+"', '"+carCompanyText+"','"+carNameText+"', '"+availableText+"', '"+locationText+"')";
            if(nameText.equals("")||ageText.equals("")||CarCompany.equals("")||CarName.equals("")||Location.equals("")){
                JOptionPane.showMessageDialog(this,"Data Field Is Empty!","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    int x = JDBC.setConnection().prepareStatement(Query).executeUpdate();
                    if(x>0){
                        Name.setText(null);
                        Age.setText(null);
                        CarCompany.setText(null);
                        CarName.setText(null);
                        Location.setText(null);
                        male.setSelected(true);
                        Available.setSelectedIndex(0);
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
