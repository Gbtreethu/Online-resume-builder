package com.company;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
public class CV {
    private JPanel cvPanel;
    private JTextField name;
    private JTextField address;
    private JTextField contact;
    private JTextField email;
    private JTextField skills1;
    private JTextField skills2;
    private JTextField skills3;
    private JTextField skills4;
    private JComboBox work;
    private JTextField college;
    private JTextField qualiA;
    private JButton SELECTIMAGEButton;
    private JLabel img;
    private JButton GENERATERESUMEButton;
    private JTextField qualiB;
    private JTextField location;

    JFrame frame = new JFrame();

    public CV() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cvPanel = new JPanel(); // Initialize the cvPanel
        cvPanel.setLayout(new GridLayout(0,2)); // Set the layout as 2 columns
        name = new JTextField(20);
        address = new JTextField(20);
        contact = new JTextField(20);
        email = new JTextField(20);
        skills1 = new JTextField(20);
        skills2 = new JTextField(20);
        skills3 = new JTextField(20);
        skills4 = new JTextField(20);
        work = new JComboBox<>(new String[]{"no experience","0-3 years", "4-6 years", "more than 6 years"}); // Replace with your work options
        college = new JTextField(20);
        qualiA = new JTextField(20);
        qualiB = new JTextField(20);

        SELECTIMAGEButton = new JButton("Select Image");

        img = new JLabel();
        img.setPreferredSize(new Dimension(200, 200)); // Set the preferred size for the image
        cvPanel.add(img);
        GENERATERESUMEButton = new JButton("Generate Resume");
        location = new JTextField(20);
        frame.setContentPane(cvPanel);
        frame.pack();
        JPanel contentPane = new JPanel();
// Add your components to the content pane
        

        frame.setVisible(true);
        SELECTIMAGEButton = new JButton("Select Image"); // Initialize the SELECTIMAGEButton
        SELECTIMAGEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE","jpg","png");
                fileChooser.addChoosableFileFilter(filter);
                int rs = fileChooser.showSaveDialog(null);
                if(rs==JFileChooser.APPROVE_OPTION){
                    File selectedImage = fileChooser.getSelectedFile();
                    location.setText(selectedImage.getAbsolutePath());
                    img.setIcon(resize(location.getText()));
                }
            }
        });
        // Add all the components to the cvPanel

        cvPanel.add(new JLabel("Name:"));
        cvPanel.add(name);
        cvPanel.add(new JLabel("Address:"));
        cvPanel.add(address);
        cvPanel.add(new JLabel("Contact:"));
        cvPanel.add(contact);
        cvPanel.add(new JLabel("Email:"));
        cvPanel.add(email);
        cvPanel.add(new JLabel("Skills 1:"));
        cvPanel.add(skills1);
        cvPanel.add(new JLabel("Skills 2:"));
        cvPanel.add(skills2);
        cvPanel.add(new JLabel("Skills 3:"));
        cvPanel.add(skills3);
        cvPanel.add(new JLabel("Skills 4:"));
        cvPanel.add(skills4);
        cvPanel.add(new JLabel("Work:"));
        cvPanel.add(work);
        cvPanel.add(new JLabel("College:"));
        cvPanel.add(college);
        cvPanel.add(new JLabel("Tittle of Qualification A:"));
        cvPanel.add(qualiA);
        cvPanel.add(new JLabel("tittle of Qualification B:"));
        cvPanel.add(qualiB);
        cvPanel.add(new JLabel("Location:"));
        cvPanel.add(location);
        cvPanel.add(new JLabel("Image:"));
        cvPanel.add(img);
        cvPanel.add(SELECTIMAGEButton);
        cvPanel.add(GENERATERESUMEButton);

        // Add the cvPanel to the frame
        frame.setContentPane(cvPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        SELECTIMAGEButton = new JButton("Select Image"); // Initialize the SELECTIMAGEButton
        GENERATERESUMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(name.getText()==null||contact.getText()==null||address.getText()==null||email.getText()==null){
                    JOptionPane.showMessageDialog(null,"PLEASE ENTER ALL DETAILS TO GENERATE CV");
                }else{
                    try {
                        // Create the directory
                        File directory = new File("D:\\CVPDF\\PDFYAHA");
                        directory.mkdirs();

                        // Specify the file path
                        String nameOfFile = "D:\\CVPDF\\PDFYAHA\\my.pdf";
                        Document myDocument = new Document();
                        PdfWriter.getInstance(myDocument, new FileOutputStream(nameOfFile));
                        myDocument.open();
                        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(location.getText());
                        img.setAbsolutePosition(473f, 750f);
                        img.scaleAbsolute(80f,70f);
                        PdfPTable table = new PdfPTable(2);
                        myDocument.add(img);
                        myDocument.add(new Paragraph(name.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,32, com.itextpdf.text.Font.BOLD,BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph("",FontFactory.getFont(FontFactory.TIMES_BOLD,9,BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("",FontFactory.getFont(FontFactory.TIMES_BOLD,9, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("CONTACT DETAILS",FontFactory.getFont(FontFactory.TIMES_BOLD,9, com.itextpdf.text.Font.BOLD,BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph(email.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph(contact.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph(address.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7, BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("SKILLS",FontFactory.getFont(FontFactory.TIMES_BOLD,9, com.itextpdf.text.Font.BOLD,BaseColor.DARK_GRAY )));
                        table.setHeaderRows(1);
                        table.addCell(skills1.getText());
                        table.addCell(skills2.getText());
                        table.addCell(skills3.getText());
                        table.addCell(skills4.getText());
                        myDocument.add(table);
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("QUALIFICATIONS", FontFactory.getFont(FontFactory.TIMES_BOLD,9, com.itextpdf.text.Font.BOLD, BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph(college.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph(qualiA.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph(qualiB.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("WORK EXPERIENCE",FontFactory.getFont(FontFactory.TIMES_BOLD,10, com.itextpdf.text.Font.BOLD,BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph(""+work.getSelectedItem(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("REFERENCES",FontFactory.getFont(FontFactory.TIMES_BOLD,9, com.itextpdf.text.Font.BOLD,BaseColor.DARK_GRAY )));
                        myDocument.add(new Paragraph("Available upon request",FontFactory.getFont(FontFactory.TIMES_BOLD,6,BaseColor.DARK_GRAY )));
                        myDocument.close();
                        JOptionPane.showMessageDialog(null,"CV was successfully generated");
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null,ex);
                    }
                }
            }
        });
    }
    public ImageIcon resize(String path){
        ImageIcon myImg = new ImageIcon(path);
        Image image = myImg.getImage();
        Image newImage = image.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(newImage);
        return finalImage;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CV();
            }
        });
    }
}


