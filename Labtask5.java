import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class IITDUFootballLeagueForm {

    public static void main(String[] args) {
        JFrame frame = new JFrame("IITDU Football League Registration Form");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(14, 2, 5, 5));

        JLabel labelName = new JLabel("Name:");
        JTextField fieldName = new JTextField();

        JLabel labelPhone = new JLabel("Phone:");
        JTextField fieldPhone = new JTextField();

        JLabel labelEmail = new JLabel("Email:");
        JTextField fieldEmail = new JTextField();

        JLabel labelAddress = new JLabel("Address:");
        JTextField fieldAddress = new JTextField();

        JLabel labelGender = new JLabel("Gender:");
        JComboBox<String> comboGender = new JComboBox<>(new String[]{"Male", "Female"});

        JLabel labelDOB = new JLabel("Date of Birth (DD/MM/YYYY):");
        JTextField fieldDOB = new JTextField();

        JLabel labelDegree = new JLabel("Degree:");
        JComboBox<String> comboDegree = new JComboBox<>(new String[]{"B.Tech", "M.Tech", "Ph.D"});

        JLabel labelPicture = new JLabel("Picture (Path):");
        JTextField fieldPicture = new JTextField();

        JLabel labelPosition = new JLabel("Preferred Position:");
        JTextField fieldPosition = new JTextField();

        JLabel labelExperience = new JLabel("Football Experience (Years):");
        JTextField fieldExperience = new JTextField();

        JLabel labelInterDepartment = new JLabel("Played in Inter-Departmental Competition?");
        JComboBox<String> comboInterDepartment = new JComboBox<>(new String[]{"Yes", "No"});

        JButton submitButton = new JButton("Submit");

        panel.add(labelName);
        panel.add(fieldName);

        panel.add(labelPhone);
        panel.add(fieldPhone);

        panel.add(labelEmail);
        panel.add(fieldEmail);

        panel.add(labelAddress);
        panel.add(fieldAddress);

        panel.add(labelGender);
        panel.add(comboGender);

        panel.add(labelDOB);
        panel.add(fieldDOB);

        panel.add(labelDegree);
        panel.add(comboDegree);

        panel.add(labelPicture);
        panel.add(fieldPicture);

        panel.add(labelPosition);
        panel.add(fieldPosition);

        panel.add(labelInterDepartment);
        panel.add(comboInterDepartment);

        panel.add(labelExperience);
        panel.add(fieldExperience);

        panel.add(new JLabel());
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = fieldName.getText();
                String phone = fieldPhone.getText();
                String email = fieldEmail.getText();
                String address = fieldAddress.getText();
                String gender = (String) comboGender.getSelectedItem();
                String dob = fieldDOB.getText();
                String degree = (String) comboDegree.getSelectedItem();
                String picture = fieldPicture.getText();
                String position = fieldPosition.getText();
                String interDepartment = (String) comboInterDepartment.getSelectedItem();
                String experience = fieldExperience.getText();

                if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() || gender.isEmpty() ||
                    dob.isEmpty() || degree.isEmpty() || picture.isEmpty() || position.isEmpty() || experience.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all the fields.", "Incomplete Data", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("IITDU_Football_League_Participants.txt", true))) {
                    writer.write("Name: " + name + "\n");
                    writer.write("Phone: " + phone + "\n");
                    writer.write("Email: " + email + "\n");
                    writer.write("Address: " + address + "\n");
                    writer.write("Gender: " + gender + "\n");
                    writer.write("Date of Birth: " + dob + "\n");
                    writer.write("Degree: " + degree + "\n");
                    writer.write("Picture: " + picture + "\n");
                    writer.write("Preferred Position: " + position + "\n");
                    writer.write("Inter-Departmental Experience: " + interDepartment + "\n");
                    writer.write("Football Experience: " + experience + "\n");
                    writer.write("\n" + "----------------------------------------" + "\n");

                    JOptionPane.showMessageDialog(frame, "Your data has been successfully saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

