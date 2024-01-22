import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GUI_Main {

    StudentRegister studentRegister;        //reference to the StudentRegister controller object

    int addressFieldWidth = 20;             //the width of the address field text boxes
    int moduleFieldWidth = 10;              //the width of the module field text boxes

    //-------------------
    //new_panel variables
    //-------------------
    JPanel new_panel,
            new_addressPanel;            //new student panel
    JLabel new_firstNameLabel,
            new_lastNameLabel,
            new_addressLn1Label,
            new_addressLn2Label,
            new_postCodeLabel,
            new_cityLabel,
            new_countryLabel,
            new_phoneNumberLabel,
            new_emailLabel,
            new_courseLabel,
            new_module1Label,
            new_module2Label,
            new_module3Label,
            new_module4Label,
            new_module5Label,
            new_module6Label,
            new_module1ScoreLabel,
            new_module2ScoreLabel,
            new_module3ScoreLabel,
            new_module4ScoreLabel,
            new_module5ScoreLabel,
            new_module6ScoreLabel;


    JTextField
            new_firstNameTextField,
            new_lastNameTextField,
            new_addressLn1TextField,
            new_addressLn2TextField,
            new_postCodeTextField,
            new_cityTextField,
            new_countryTextField,
            new_phoneNumberTextField,
            new_emailTextField,
            new_courseTextField,
            new_module1TextField,
            new_module2TextField,
            new_module3TextField,
            new_module4TextField,
            new_module5TextField,
            new_module6TextField,
            new_module1ScoreTextField,
            new_module2ScoreTextField,
            new_module3ScoreTextField,
            new_module4ScoreTextField,
            new_module5ScoreTextField,
            new_module6ScoreTextField,



    new_age_textField,
            new_courseType_textField;


    JPanel  new_coursePanel,
            new_courseModulePanel,
            new_module1Panel,
            new_module2Panel,
            new_module3Panel,
            new_module4Panel,
            new_module5Panel,
            new_module6Panel;

    JComboBox new_courseComboBox,
            new_module1ComboBox,
            new_module2ComboBox,
            new_module3ComboBox,
            new_module4ComboBox,
            new_module5ComboBox,
            new_module6ComboBox;






    //-------------------
    //edit_panel variables
    //-------------------
    JPanel edit_panel,
            edit_addressPanel,
            edit_updateDeleteButtonsPanel;           //edit student panel



    JLabel edit_firstNameLabel,
            edit_idLabel,
            edit_id,
            edit_lastNameLabel,
            edit_addressLn1Label,
            edit_addressLn2Label,
            edit_postCodeLabel,
            edit_cityLabel,
            edit_countryLabel,
            edit_phoneNumberLabel,
            edit_emailLabel,
            edit_courseLabel,
            edit_module1Label,
            edit_module2Label,
            edit_module3Label,
            edit_module4Label,
            edit_module5Label,
            edit_module6Label,
            edit_module1ScoreLabel,
            edit_module2ScoreLabel,
            edit_module3ScoreLabel,
            edit_module4ScoreLabel,
            edit_module5ScoreLabel,
            edit_module6ScoreLabel,
            queryResultLabel,
            spacerLabel;






    JTextField
            edit_idTextField,
            edit_firstNameTextField,
            edit_lastNameTextField,
            edit_addressLn1TextField,
            edit_addressLn2TextField,
            edit_postCodeTextField,
            edit_cityTextField,
            edit_countryTextField,
            edit_phoneNumberTextField,
            edit_emailTextField,
            edit_courseTextField,
            edit_module1TextField,
            edit_module2TextField,
            edit_module3TextField,
            edit_module4TextField,
            edit_module5TextField,
            edit_module6TextField,
            edit_module1ScoreTextField,
            edit_module2ScoreTextField,
            edit_module3ScoreTextField,
            edit_module4ScoreTextField,
            edit_module5ScoreTextField,
            edit_module6ScoreTextField,
            queryResultTextField,


    edit_age_textField,
            edit_courseType_textField;

    JPanel edit_coursePanel,
            edit_courseModulePanel,
            edit_module1Panel,
            edit_module2Panel,
            edit_module3Panel,
            edit_module4Panel,
            edit_module5Panel,
            edit_module6Panel;













    JPanel master_panel,

    filters_panel,          //panel to contain all filter box panels
            filterBox1_panel,
            filterBox2_panel,
            filterBox3_panel,
            filterBox4_panel,
            filterBox5_panel,
            searchButton_panel;
    private JTextArea thisIsATextTextArea;



    //new student box variables here...?



    private JTextField textField1,

    filterBox1_textField,
            filterBox2_textField,
            filterBox3_textField,
            filterBox4_textField,
            filterBox5_textField;
    private JButton button1, addStudentBtn, deleteStudentBtn, updateBtn;

    private JTable table1;


    private JComboBox filterBox1, filterBox1_operator,
            filterBox2, filterBox2_operator,
            filterBox3, filterBox3_operator,
            filterBox4, filterBox4_operator,
            filterBox5, filterBox5_operator;



    //student list...
    JList<Student> myList;








    public GUI_Main(StudentRegister sR) {

        //set the reference to the StudentRegister controller object
        this.studentRegister = sR;

        //System.out.println("Is this thing working or not?");


        //try set look and feel to system default:
        //Bruce Eckel - Thinking in Java p.1373
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e) {
            throw new RuntimeException(e);
        }


        JFrame myWindow = new JFrame("Student Registration System v1.0");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //exit the app when window '[x]' clicked

        //The panel to hold all the window elements...
        master_panel = new JPanel();

        master_panel.setLayout(new GridLayout(2,1));   //two halves to the screen: top, bottom

        //System Logo/Label
        //JLabel systemLabel = new JLabel("University Registration System v1.0");
        //master_panel.add(systemLabel);


        JPanel topHalfPanel = new JPanel();
        JPanel bottomHalfPanel = new JPanel();
        //bottomHalfPanel.setLayout(new GridLayout(2,1));


        //========================
        // new & edit panel
        //========================


        JPanel newAndEditPanel = new JPanel();


        //============================
        //         New_Panel
        //============================
        new_panel = new JPanel();       //create new_panel





        //----------------------------
        //NEW       ADDRESS PANEL
        //----------------------------

        new_addressPanel = new JPanel();    //create new_addressPanel

        //new_panel.setLayout(new GridLayout(9,2, 5,5)); //set layout to 2 cols, 6 rows with gap between
        //new_panel.setLayout(new GridLayout(10,2)); //set layout to 2 cols, 6 rows with gap between
        //new_panel.setLayout(new GridLayout(17,2)); //set layout to 2 cols, 6 rows with gap between
        new_addressPanel.setLayout(new GridLayout(9,2));

        //first name...
        new_firstNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        new_addressPanel.add(new_firstNameLabel);

        new_firstNameTextField = new JTextField(addressFieldWidth);   //name field 32 chars long
        new_addressPanel.add(new_firstNameTextField);

        //last name...
        new_lastNameLabel = new JLabel("Last Name:", SwingConstants.RIGHT);
        new_addressPanel.add(new_lastNameLabel);

        new_lastNameTextField = new JTextField(addressFieldWidth);
        new_addressPanel.add(new_lastNameTextField);

        //address ln1...
        new_addressLn1Label = new JLabel("Address Line1:", SwingConstants.RIGHT);
        new_addressPanel.add(new_addressLn1Label);

        new_addressLn1TextField = new JTextField(addressFieldWidth);
        new_addressPanel.add(new_addressLn1TextField);

        //address ln2...
        new_addressLn2Label = new JLabel("Address Line2:", SwingConstants.RIGHT);
        new_addressPanel.add(new_addressLn2Label);

        new_addressLn2TextField = new JTextField(addressFieldWidth);
        new_addressPanel.add(new_addressLn2TextField);

        //address postcode...
        new_postCodeLabel = new JLabel("Post Code:", SwingConstants.RIGHT);
        new_addressPanel.add(new_postCodeLabel);

        new_postCodeTextField = new JTextField(addressFieldWidth);
        new_addressPanel.add(new_postCodeTextField);


        //city...
        new_cityLabel = new JLabel("City:", SwingConstants.RIGHT);
        new_addressPanel.add(new_cityLabel);

        new_cityTextField = new JTextField(addressFieldWidth);
        new_addressPanel.add(new_cityTextField);

        //country...
        new_countryLabel = new JLabel("Country:", SwingConstants.RIGHT);
        new_addressPanel.add(new_countryLabel);

        new_countryTextField = new JTextField(addressFieldWidth);
        new_addressPanel.add(new_countryTextField);

        //phoneNumber...
        new_phoneNumberLabel = new JLabel("Phone:", SwingConstants.RIGHT);
        new_addressPanel.add(new_phoneNumberLabel);

        new_phoneNumberTextField = new JTextField(addressFieldWidth);
        new_addressPanel.add(new_phoneNumberTextField);


        //email...
        new_emailLabel = new JLabel("Email:", SwingConstants.RIGHT);
        new_addressPanel.add(new_emailLabel);

        new_emailTextField = new JTextField(addressFieldWidth);
        new_addressPanel.add(new_emailTextField);
















        //----------------------------------
        //NEW       COURSE/MODULE PANEL
        //----------------------------------
        new_courseModulePanel = new JPanel();
        //may need to add a grid layout to this JPanel
        new_courseModulePanel.setLayout(new GridLayout(7,1));


        //course...            Should look like -    Course: Computer Science
        new_coursePanel = new JPanel();

        new_courseLabel = new JLabel("Course:", SwingConstants.RIGHT);
        new_coursePanel.add(new_courseLabel);

        //new_courseTextField = new JTextField(15);
        //new_coursePanel.add(new_courseTextField);



        //=============================
        //    new_Course JComboBox
        //=============================

        //field selection...
        new_courseComboBox = new JComboBox();
        new_courseComboBox.addItem("CS1");
        new_courseComboBox.addItem("CS2");
        new_courseComboBox.addItem("CS3");
        new_courseComboBox.addItem("CS4");
        new_courseComboBox.addItem("CS5");

        new_coursePanel.add(new_courseComboBox);
















        new_courseModulePanel.add(new_coursePanel);     //add constructed course panel to overall new_courseModulePanel



        //module 1...          panel e.g.    Module 1:  Programming 101   Score:   57.3
        new_module1Panel = new JPanel();

        new_module1Label = new JLabel("Module 1:", SwingConstants.RIGHT);
        new_module1Panel.add(new_module1Label);

        //new_module1TextField = new JTextField(moduleFieldWidth);
        //new_module1Panel.add(new_module1TextField);


        //=============================
        //    new_module1 JComboBox
        //=============================


        //field selection...
        new_module1ComboBox = new JComboBox();
        new_module1ComboBox.addItem("Mod1");
        new_module1ComboBox.addItem("Mod2");
        new_module1ComboBox.addItem("Mod3");
        new_module1ComboBox.addItem("Mod4");
        new_module1ComboBox.addItem("Mod5");
        new_module1ComboBox.addItem("Mod6");
        new_module1ComboBox.addItem("Mod7");
        new_module1ComboBox.addItem("Mod8");
        new_module1ComboBox.addItem("Mod9");
        new_module1ComboBox.addItem("Mod10");


        new_module1Panel.add(new_module1ComboBox);










        new_module1ScoreLabel = new JLabel("Score:");
        new_module1Panel.add(new_module1ScoreLabel);

        new_module1ScoreTextField = new JTextField(3);
        new_module1Panel.add(new_module1ScoreTextField);

        new_courseModulePanel.add(new_module1Panel); //add constructed module 1 panel to overall new_courseModulePanel




        //module 2...
        new_module2Panel = new JPanel();

        new_module2Label = new JLabel("Module 2:", SwingConstants.RIGHT);
        new_module2Panel.add(new_module2Label);

        //new_module2TextField = new JTextField(moduleFieldWidth);
        //new_module2Panel.add(new_module2TextField);



        //=============================
        //    new_module2 JComboBox
        //=============================


        //field selection...
        new_module2ComboBox = new JComboBox();
        new_module2ComboBox.addItem("Mod1");
        new_module2ComboBox.addItem("Mod2");
        new_module2ComboBox.addItem("Mod3");
        new_module2ComboBox.addItem("Mod4");
        new_module2ComboBox.addItem("Mod5");
        new_module2ComboBox.addItem("Mod6");
        new_module2ComboBox.addItem("Mod7");
        new_module2ComboBox.addItem("Mod8");
        new_module2ComboBox.addItem("Mod9");
        new_module2ComboBox.addItem("Mod10");


        new_module2Panel.add(new_module2ComboBox);


        new_module2ScoreLabel = new JLabel("Score:");
        new_module2Panel.add(new_module2ScoreLabel);

        new_module2ScoreTextField = new JTextField(3);
        new_module2Panel.add(new_module2ScoreTextField);

        new_courseModulePanel.add(new_module2Panel); //add constructed module 2 panel to overall new_courseModulePanel


        //module 3...
        new_module3Panel = new JPanel();

        new_module3Label = new JLabel("Module 3:", SwingConstants.RIGHT);
        new_module3Panel.add(new_module3Label);

        //new_module3TextField = new JTextField(moduleFieldWidth);
        //new_module3Panel.add(new_module3TextField);



        //=============================
        //    new_module3 JComboBox
        //=============================


        //field selection...
        new_module3ComboBox = new JComboBox();
        new_module3ComboBox.addItem("Mod1");
        new_module3ComboBox.addItem("Mod2");
        new_module3ComboBox.addItem("Mod3");
        new_module3ComboBox.addItem("Mod4");
        new_module3ComboBox.addItem("Mod5");
        new_module3ComboBox.addItem("Mod6");
        new_module3ComboBox.addItem("Mod7");
        new_module3ComboBox.addItem("Mod8");
        new_module3ComboBox.addItem("Mod9");
        new_module3ComboBox.addItem("Mod10");


        new_module3Panel.add(new_module3ComboBox);



        new_module3ScoreLabel = new JLabel("Score:");
        new_module3Panel.add(new_module3ScoreLabel);

        new_module3ScoreTextField = new JTextField(3);
        new_module3Panel.add(new_module3ScoreTextField);

        new_courseModulePanel.add(new_module3Panel); //add constructed module 3 panel to overall new_courseModulePanel

        //module 4...
        new_module4Panel = new JPanel();

        new_module4Label = new JLabel("Module 4:", SwingConstants.RIGHT);
        new_module4Panel.add(new_module4Label);

        //new_module4TextField = new JTextField(moduleFieldWidth);
        //new_module4Panel.add(new_module4TextField);




        //=============================
        //    new_module4 JComboBox
        //=============================


        //field selection...
        new_module4ComboBox = new JComboBox();
        new_module4ComboBox.addItem("Mod1");
        new_module4ComboBox.addItem("Mod2");
        new_module4ComboBox.addItem("Mod3");
        new_module4ComboBox.addItem("Mod4");
        new_module4ComboBox.addItem("Mod5");
        new_module4ComboBox.addItem("Mod6");
        new_module4ComboBox.addItem("Mod7");
        new_module4ComboBox.addItem("Mod8");
        new_module4ComboBox.addItem("Mod9");
        new_module4ComboBox.addItem("Mod10");


        new_module4Panel.add(new_module4ComboBox);



        new_module4ScoreLabel = new JLabel("Score:");
        new_module4Panel.add(new_module4ScoreLabel);

        new_module4ScoreTextField = new JTextField(3);
        new_module4Panel.add(new_module4ScoreTextField);

        new_courseModulePanel.add(new_module4Panel); //add constructed module 4 panel to overall new_courseModulePanel


        //module 5...
        new_module5Panel = new JPanel();

        new_module5Label = new JLabel("Module 5:", SwingConstants.RIGHT);
        new_module5Panel.add(new_module5Label);

        //new_module5TextField = new JTextField(moduleFieldWidth);
        //new_module5Panel.add(new_module5TextField);


        //=============================
        //    new_module5 JComboBox
        //=============================


        //field selection...
        new_module5ComboBox = new JComboBox();
        new_module5ComboBox.addItem("Mod1");
        new_module5ComboBox.addItem("Mod2");
        new_module5ComboBox.addItem("Mod3");
        new_module5ComboBox.addItem("Mod4");
        new_module5ComboBox.addItem("Mod5");
        new_module5ComboBox.addItem("Mod6");
        new_module5ComboBox.addItem("Mod7");
        new_module5ComboBox.addItem("Mod8");
        new_module5ComboBox.addItem("Mod9");
        new_module5ComboBox.addItem("Mod10");


        new_module5Panel.add(new_module5ComboBox);



        new_module5ScoreLabel = new JLabel("Score:");
        new_module5Panel.add(new_module5ScoreLabel);

        new_module5ScoreTextField = new JTextField(3);
        new_module5Panel.add(new_module5ScoreTextField);

        new_courseModulePanel.add(new_module5Panel); //add constructed module 5 panel to overall new_courseModulePanel


        //module 6...
        new_module6Panel = new JPanel();

        new_module6Label = new JLabel("Module 6:", SwingConstants.RIGHT);
        new_module6Panel.add(new_module6Label);

        //new_module6TextField = new JTextField(moduleFieldWidth);
        //new_module6Panel.add(new_module6TextField);

        //=============================
        //    new_module6 JComboBox
        //=============================


        //field selection...
        new_module6ComboBox = new JComboBox();
        new_module6ComboBox.addItem("Mod1");
        new_module6ComboBox.addItem("Mod2");
        new_module6ComboBox.addItem("Mod3");
        new_module6ComboBox.addItem("Mod4");
        new_module6ComboBox.addItem("Mod5");
        new_module6ComboBox.addItem("Mod6");
        new_module6ComboBox.addItem("Mod7");
        new_module6ComboBox.addItem("Mod8");
        new_module6ComboBox.addItem("Mod9");
        new_module6ComboBox.addItem("Mod10");


        new_module6Panel.add(new_module6ComboBox);













        new_module6ScoreLabel = new JLabel("Score:");
        new_module6Panel.add(new_module6ScoreLabel);

        new_module6ScoreTextField = new JTextField(3);
        new_module6Panel.add(new_module6ScoreTextField);

        new_courseModulePanel.add(new_module6Panel); //add constructed module 6 panel to overall new_courseModulePanel








        //add "new address panel" and  "new courseModule panel" to "new panel"
        new_panel.add(new_addressPanel);
        new_panel.add(new_courseModulePanel);



        //add student button....
        addStudentBtn = new JButton("Add Student");
        addStudentBtn.addActionListener(e -> addStudent());    //add action listener

        new_panel.add(addStudentBtn);

        new_panel.setBackground(new Color(139, 213, 102));  //set background colour of panel to green

        //master_panel.add(new_panel);
        newAndEditPanel.add(new_panel);

















        //============================
        //         edit_Panel
        //============================
        edit_panel = new JPanel();       //create new_panel
        edit_panel.setBackground(new Color(213, 102, 102)); //set background red

        //new_panel.setLayout(new GridLayout(9,2, 5,5)); //set layout to 2 cols, 6 rows with gap between
        //edit_panel.setLayout(new GridLayout(11,2)); //set layout to 2 cols, 6 rows with gap between

        edit_addressPanel = new JPanel();
        edit_addressPanel.setLayout(new GridLayout(10,2)); // roughly right? copied from new_addressPanel



        /* ORIGNAL EDIT PANEL CODE...*/


        //id
        edit_idLabel = new JLabel("ID:", SwingConstants.RIGHT);
        edit_addressPanel.add(edit_idLabel);


        edit_idTextField = new JTextField(addressFieldWidth);   //name field addressFieldWidth chars long
        edit_addressPanel.add(edit_idTextField);

        //id should be displayed BUT not be editable, put ID into a label...
        //edit_id = new JLabel("");
        //edit_addressPanel.add(edit_id);



        //first name...
        edit_firstNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        edit_addressPanel.add(edit_firstNameLabel);

        edit_firstNameTextField = new JTextField(addressFieldWidth);   //name field addressFieldWidth chars long
        edit_addressPanel.add(edit_firstNameTextField);

        //last name...
        edit_lastNameLabel = new JLabel("Last Name:", SwingConstants.RIGHT);
        edit_addressPanel.add(edit_lastNameLabel);

        edit_lastNameTextField = new JTextField(addressFieldWidth);
        edit_addressPanel.add(edit_lastNameTextField);

        //address ln1...
        edit_addressLn1Label = new JLabel("Address Line1:", SwingConstants.RIGHT);
        edit_addressPanel.add(edit_addressLn1Label);

        edit_addressLn1TextField = new JTextField(addressFieldWidth);
        edit_addressPanel.add(edit_addressLn1TextField);

        //address ln2...
        edit_addressLn2Label = new JLabel("Address Line2:", SwingConstants.RIGHT);
        edit_addressPanel.add(edit_addressLn2Label);

        edit_addressLn2TextField = new JTextField(addressFieldWidth);
        edit_addressPanel.add(edit_addressLn2TextField);

        //address postcode...
        edit_postCodeLabel = new JLabel("Post Code:", SwingConstants.RIGHT);
        edit_addressPanel.add(edit_postCodeLabel);

        edit_postCodeTextField = new JTextField(addressFieldWidth);
        edit_addressPanel.add(edit_postCodeTextField);


        //city...
        edit_cityLabel = new JLabel("City:", SwingConstants.RIGHT);
        edit_addressPanel.add(edit_cityLabel);

        edit_cityTextField = new JTextField(addressFieldWidth);
        edit_addressPanel.add(edit_cityTextField);

        //country...
        edit_countryLabel = new JLabel("Country:", SwingConstants.RIGHT);
        edit_addressPanel.add(edit_countryLabel);

        edit_countryTextField = new JTextField(addressFieldWidth);
        edit_addressPanel.add(edit_countryTextField);

        //phoneNumber...
        edit_phoneNumberLabel = new JLabel("Phone:", SwingConstants.RIGHT);
        edit_addressPanel.add(edit_phoneNumberLabel);

        edit_phoneNumberTextField = new JTextField(addressFieldWidth);
        edit_addressPanel.add(edit_phoneNumberTextField);


        //email...
        edit_emailLabel = new JLabel("Email:", SwingConstants.RIGHT);
        edit_addressPanel.add(edit_emailLabel);

        edit_emailTextField = new JTextField(addressFieldWidth);
        edit_addressPanel.add(edit_emailTextField);



        /* END ORIGINAL EDIT PANEL CODE */






        /////////////////////////////
        // NEW EDIT PANEL CODE....
        /////////////////////////////


        //----------------------------------
        //EDIT       COURSE/MODULE PANEL
        //----------------------------------
        edit_courseModulePanel = new JPanel();
        //may need to add a grid layout to this JPanel
        edit_courseModulePanel.setLayout(new GridLayout(7,1));


        //course...            Should look like -    Course: Computer Science
        edit_coursePanel = new JPanel();

        edit_courseLabel = new JLabel("Course:", SwingConstants.RIGHT);
        edit_coursePanel.add(edit_courseLabel);

        edit_courseTextField = new JTextField(15);
        edit_coursePanel.add(edit_courseTextField);

        edit_courseModulePanel.add(edit_coursePanel);     //add constructed course panel to overall edit_courseModulePanel

        //module 1...          panel e.g.    Module 1:  Programming 101   Score:   57.3
        edit_module1Panel = new JPanel();

        edit_module1Label = new JLabel("Module 1:", SwingConstants.RIGHT);
        edit_module1Panel.add(edit_module1Label);

        edit_module1TextField = new JTextField(moduleFieldWidth);
        edit_module1Panel.add(edit_module1TextField);

        edit_module1ScoreLabel = new JLabel("Score:");
        edit_module1Panel.add(edit_module1ScoreLabel);

        edit_module1ScoreTextField = new JTextField(3);
        edit_module1Panel.add(edit_module1ScoreTextField);

        edit_courseModulePanel.add(edit_module1Panel); //add constructed module 1 panel to overall edit_courseModulePanel




        //module 2...
        edit_module2Panel = new JPanel();

        edit_module2Label = new JLabel("Module 2:", SwingConstants.RIGHT);
        edit_module2Panel.add(edit_module2Label);

        edit_module2TextField = new JTextField(moduleFieldWidth);
        edit_module2Panel.add(edit_module2TextField);

        edit_module2ScoreLabel = new JLabel("Score:");
        edit_module2Panel.add(edit_module2ScoreLabel);

        edit_module2ScoreTextField = new JTextField(3);
        edit_module2Panel.add(edit_module2ScoreTextField);

        edit_courseModulePanel.add(edit_module2Panel); //add constructed module 2 panel to overall edit_courseModulePanel


        //module 3...
        edit_module3Panel = new JPanel();

        edit_module3Label = new JLabel("Module 3:", SwingConstants.RIGHT);
        edit_module3Panel.add(edit_module3Label);

        edit_module3TextField = new JTextField(moduleFieldWidth);
        edit_module3Panel.add(edit_module3TextField);

        edit_module3ScoreLabel = new JLabel("Score:");
        edit_module3Panel.add(edit_module3ScoreLabel);

        edit_module3ScoreTextField = new JTextField(3);
        edit_module3Panel.add(edit_module3ScoreTextField);

        edit_courseModulePanel.add(edit_module3Panel); //add constructed module 3 panel to overall edit_courseModulePanel

        //module 4...
        edit_module4Panel = new JPanel();

        edit_module4Label = new JLabel("Module 4:", SwingConstants.RIGHT);
        edit_module4Panel.add(edit_module4Label);

        edit_module4TextField = new JTextField(moduleFieldWidth);
        edit_module4Panel.add(edit_module4TextField);

        edit_module4ScoreLabel = new JLabel("Score:");
        edit_module4Panel.add(edit_module4ScoreLabel);

        edit_module4ScoreTextField = new JTextField(3);
        edit_module4Panel.add(edit_module4ScoreTextField);

        edit_courseModulePanel.add(edit_module4Panel); //add constructed module 4 panel to overall edit_courseModulePanel


        //module 5...
        edit_module5Panel = new JPanel();

        edit_module5Label = new JLabel("Module 5:", SwingConstants.RIGHT);
        edit_module5Panel.add(edit_module5Label);

        edit_module5TextField = new JTextField(moduleFieldWidth);
        edit_module5Panel.add(edit_module5TextField);

        edit_module5ScoreLabel = new JLabel("Score:");
        edit_module5Panel.add(edit_module5ScoreLabel);

        edit_module5ScoreTextField = new JTextField(3);
        edit_module5Panel.add(edit_module5ScoreTextField);

        edit_courseModulePanel.add(edit_module5Panel); //add constructed module 5 panel to overall edit_courseModulePanel


        //module 6...
        edit_module6Panel = new JPanel();

        edit_module6Label = new JLabel("Module 6:", SwingConstants.RIGHT);
        edit_module6Panel.add(edit_module6Label);

        edit_module6TextField = new JTextField(moduleFieldWidth);
        edit_module6Panel.add(edit_module6TextField);

        edit_module6ScoreLabel = new JLabel("Score:");
        edit_module6Panel.add(edit_module6ScoreLabel);

        edit_module6ScoreTextField = new JTextField(3);
        edit_module6Panel.add(edit_module6ScoreTextField);

        edit_courseModulePanel.add(edit_module6Panel); //add constructed module 6 panel to overall edit_courseModulePanel








        //add "edit address panel" and  "edit courseModule panel" to "edit panel"
        edit_panel.add(edit_addressPanel);
        edit_panel.add(edit_courseModulePanel);




















        //=================================
        // UPDATE, DELETE, QUERY RESULT
        //=================================

        //update and DELETE buttons panel
        edit_updateDeleteButtonsPanel = new JPanel();
        //edit_updateDeleteButtonsPanel.setLayout(new GridLayout(5,1));
        edit_updateDeleteButtonsPanel.setLayout(new GridLayout(4,1));

        //update button
        //updateBtn = new JButton("Update Student");
        //updateBtn.addActionListener(e -> updateStudent());
        //edit_updateDeleteButtonsPanel.add(updateBtn);

        //edit_panel.add(updateBtn);

        //delete student button
        deleteStudentBtn = new JButton("(x) DELETE STUDENT");
        deleteStudentBtn.addActionListener(e -> deleteStudent());    //add action listener

        edit_updateDeleteButtonsPanel.add(deleteStudentBtn);
        //edit_panel.add(deleteStudentBtn);

        spacerLabel = new JLabel(" ");
        edit_updateDeleteButtonsPanel.add(spacerLabel);

        queryResultLabel = new JLabel("Query Result: ", SwingConstants.CENTER);
        edit_updateDeleteButtonsPanel.add(queryResultLabel);

        queryResultTextField = new JTextField();
        edit_updateDeleteButtonsPanel.add(queryResultTextField);







        edit_panel.add(edit_updateDeleteButtonsPanel);


        //master_panel.add(edit_panel);
        newAndEditPanel.add(edit_panel);



        //master_panel.add(newAndEditPanel);
        topHalfPanel.add(newAndEditPanel);









        //============================
        //       Filters Panel
        //============================
        //panel to contain all the filter boxes...
        filters_panel = new JPanel();
        filters_panel.setLayout(new GridLayout(2,5));

        //=============================
        //          FilterBox1
        //=============================

        filterBox1_panel = new JPanel();

        //field selection...
        filterBox1 = new JComboBox();
        filterBox1.addItem("id");
        filterBox1.addItem("firstName");
        filterBox1.addItem("lastName");
        filterBox1.addItem("addressLn1");
        filterBox1.addItem("addressLn2");
        filterBox1.addItem("city");
        filterBox1.addItem("postCode");
        filterBox1.addItem("country");
        filterBox1.addItem("phoneNumber");
        filterBox1.addItem("email");
        filterBox1.addItem("courseType");
        filterBox1.addItem("modules");
        filterBox1.addItem("HIGH_Score");
        filterBox1.addItem("LOW_Score");
        filterBox1.addItem("AVG_Score");


        filterBox1_panel.add(filterBox1);

        //operator selection...
        filterBox1_operator = new JComboBox();
        filterBox1_operator.addItem("--");
        filterBox1_operator.addItem("=");
        filterBox1_operator.addItem("contains");
        filterBox1_operator.addItem(">");
        filterBox1_operator.addItem("<");
        filterBox1_operator.addItem("sort_Asc");
        filterBox1_operator.addItem("sort_Dsc");

        filterBox1_panel.add(filterBox1_operator);

        //filter text box...
        filterBox1_textField = new JTextField(15);
        filterBox1_textField.setText("Filter 1");
        filterBox1_panel.add(filterBox1_textField);

        //add whole filter panel to master panel...
        //master_panel.add(filterBox1_panel);
        filters_panel.add(filterBox1_panel);






        //=============================
        //          FilterBox2
        //=============================

        filterBox2_panel = new JPanel();

        //field selection...
        filterBox2 = new JComboBox();

        filterBox2.addItem("id");
        filterBox2.addItem("firstName");
        filterBox2.addItem("lastName");
        filterBox2.addItem("addressLn1");
        filterBox2.addItem("addressLn2");
        filterBox2.addItem("city");
        filterBox2.addItem("postCode");
        filterBox2.addItem("country");
        filterBox2.addItem("phoneNumber");
        filterBox2.addItem("email");
        filterBox2.addItem("courseType");
        filterBox2.addItem("modules");
        filterBox2.addItem("HIGH_Score");
        filterBox2.addItem("LOW_Score");
        filterBox2.addItem("AVG_Score");

        filterBox2_panel.add(filterBox2);

        //operator selection...
        filterBox2_operator = new JComboBox();
        filterBox2_operator.addItem("--");
        filterBox2_operator.addItem("=");
        filterBox2_operator.addItem("contains");
        filterBox2_operator.addItem(">");
        filterBox2_operator.addItem("<");
        filterBox2_operator.addItem("sort_Asc");
        filterBox2_operator.addItem("sort_Dsc");

        filterBox2_panel.add(filterBox2_operator);

        //filter text box...
        filterBox2_textField = new JTextField(15);
        filterBox2_textField.setText("Filter 2");
        filterBox2_panel.add(filterBox2_textField);

        //add whole filter panel to master panel...
        //master_panel.add(filterBox2_panel);
        filters_panel.add(filterBox2_panel);




        //=============================
        //          FilterBox3
        //=============================

        filterBox3_panel = new JPanel();

        //field selection...
        filterBox3 = new JComboBox();

        filterBox3.addItem("id");
        filterBox3.addItem("firstName");
        filterBox3.addItem("lastName");
        filterBox3.addItem("addressLn1");
        filterBox3.addItem("addressLn2");
        filterBox3.addItem("city");
        filterBox3.addItem("postCode");
        filterBox3.addItem("country");
        filterBox3.addItem("phoneNumber");
        filterBox3.addItem("email");
        filterBox3.addItem("courseType");
        filterBox3.addItem("modules");
        filterBox3.addItem("HIGH_Score");
        filterBox3.addItem("LOW_Score");
        filterBox3.addItem("AVG_Score");

        filterBox3_panel.add(filterBox3);


        //operator selection...
        filterBox3_operator = new JComboBox();
        filterBox3_operator.addItem("--");
        filterBox3_operator.addItem("=");
        filterBox3_operator.addItem("contains");
        filterBox3_operator.addItem(">");
        filterBox3_operator.addItem("<");
        filterBox3_operator.addItem("sort_Asc");
        filterBox3_operator.addItem("sort_Dsc");

        filterBox3_panel.add(filterBox3_operator);

        //filter text box...
        filterBox3_textField = new JTextField(15);
        filterBox3_textField.setText("Filter 3");
        filterBox3_panel.add(filterBox3_textField);

        //add whole filter panel to master panel...
        //master_panel.add(filterBox3_panel);
        filters_panel.add(filterBox3_panel);




        //=============================
        //          FilterBox4
        //=============================

        filterBox4_panel = new JPanel();

        //field selection...
        filterBox4 = new JComboBox();

        filterBox4.addItem("id");
        filterBox4.addItem("firstName");
        filterBox4.addItem("lastName");
        filterBox4.addItem("addressLn1");
        filterBox4.addItem("addressLn2");
        filterBox4.addItem("city");
        filterBox4.addItem("postCode");
        filterBox4.addItem("country");
        filterBox4.addItem("phoneNumber");
        filterBox4.addItem("email");
        filterBox4.addItem("courseType");
        filterBox4.addItem("modules");
        filterBox4.addItem("HIGH_Score");
        filterBox4.addItem("LOW_Score");
        filterBox4.addItem("AVG_Score");

        filterBox4_panel.add(filterBox4);


        //operator selection...
        filterBox4_operator = new JComboBox();
        filterBox4_operator.addItem("--");
        filterBox4_operator.addItem("=");
        filterBox4_operator.addItem("contains");
        filterBox4_operator.addItem(">");
        filterBox4_operator.addItem("<");
        filterBox4_operator.addItem("sort_Asc");
        filterBox4_operator.addItem("sort_Dsc");

        filterBox4_panel.add(filterBox4_operator);

        //filter text box...
        filterBox4_textField = new JTextField(15);
        filterBox4_textField.setText("Filter 4");
        filterBox4_panel.add(filterBox4_textField);

        //add whole filter panel to master panel...
        //master_panel.add(filterBox4_panel);
        filters_panel.add(filterBox4_panel);



        //=============================
        //          FilterBox5
        //=============================

        filterBox5_panel = new JPanel();

        //field selection...
        filterBox5 = new JComboBox();

        filterBox5.addItem("id");
        filterBox5.addItem("firstName");
        filterBox5.addItem("lastName");
        filterBox5.addItem("addressLn1");
        filterBox5.addItem("addressLn2");
        filterBox5.addItem("city");
        filterBox5.addItem("postCode");
        filterBox5.addItem("country");
        filterBox5.addItem("phoneNumber");
        filterBox5.addItem("email");
        filterBox5.addItem("courseType");
        filterBox5.addItem("modules");
        filterBox5.addItem("HIGH_Score");
        filterBox5.addItem("LOW_Score");
        filterBox5.addItem("AVG_Score");

        filterBox5_panel.add(filterBox5);



        //operator selection...
        filterBox5_operator = new JComboBox();
        filterBox5_operator.addItem("--");
        filterBox5_operator.addItem("=");
        filterBox5_operator.addItem("contains");
        filterBox5_operator.addItem(">");
        filterBox5_operator.addItem("<");
        filterBox5_operator.addItem("sort_Asc");
        filterBox5_operator.addItem("sort_Dsc");

        filterBox5_panel.add(filterBox5_operator);

        //filter text box...
        filterBox5_textField = new JTextField(15);
        filterBox5_textField.setText("Filter 5");
        filterBox5_panel.add(filterBox5_textField);

        //add whole filter panel to master panel...
        //master_panel.add(filterBox5_panel);
        filters_panel.add(filterBox5_panel);




        //================
        //search button
        //================
        searchButton_panel = new JPanel();

        button1 = new JButton("Search");

        button1.addActionListener(e -> studentSearch());    //add action listener

        searchButton_panel.add(button1);

        filters_panel.add(searchButton_panel);

        //master_panel.add(searchButton_panel);




        //add filters panel to master panel...
        //master_panel.add(filters_panel);
        bottomHalfPanel.add(filters_panel);






        //======================================
        //         STUDENT LIST DISPLAY
        //======================================


        DefaultListModel<Student> myStudentsModel = new DefaultListModel<>();

        Student myStudent = new Student(0000, "**************************************************************** SEARCH", "WITH", "- -","OPERATOR","FOR","FULL","LISTING OF","STUDENTS","****************************************", Student.CourseType.CS3, new HashMap<Student.Module, Double>(),0.0 );


        myStudentsModel.addElement(myStudent);

        //initialise student list
        myList = new JList<Student>(myStudentsModel);


        //got this list selection code from:
        // https://stackoverflow.com/questions/32922623/java-swing-how-to-detect-a-list-selection-event


        //when a list item is selected, populates the edit student text fields...
        myList.addListSelectionListener(new ListSelectionListener() {


            @Override
            public void valueChanged(ListSelectionEvent e) {
                //System.out.println("LIST ITEM SELECTED: Hello you selected me!  "
                // + myList.getSelectedValue());
                //System.out.println("SELECTED INDEX IS: " + myList.getSelectedIndex());
                //System.out.println("SELECTED VALUE IS: " + myList.getSelectedValue());

                Student tempStudent = myList.getSelectedValue();        //returns a Student object. store in tempStudent

                //may need to detect empty tempStudent and populate with default values

                edit_idTextField.setText("" + tempStudent.getId());        //convert int to String ""
                edit_firstNameTextField.setText(tempStudent.getFirstName());
                edit_lastNameTextField.setText(tempStudent.getLastName());
                edit_addressLn1TextField.setText(tempStudent.getAddressLn1());
                edit_addressLn2TextField.setText(tempStudent.getAddressLn2());
                edit_cityTextField.setText(tempStudent.getCity());
                edit_postCodeTextField.setText(tempStudent.getPostCode());
                edit_countryTextField.setText(tempStudent.getCountry());
                edit_emailTextField.setText(tempStudent.getEmail());
                edit_phoneNumberTextField.setText((tempStudent.getPhoneNumber()));
                edit_courseTextField.setText(tempStudent.getCourseType().toString());      //get courseType enum value as String



                //modules HashMap expansion...


                //got iterator code help from:
                //https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap/1066603#1066603

                Iterator studentModules = tempStudent.getModules().entrySet().iterator(); //get iterator for student.modules  HashMap   (Student.Module enum: Double)


                //module 1
                //--------
                if(studentModules.hasNext()) { //module exists...
                    Map.Entry entry = (Map.Entry) studentModules.next();    //read module
                    String moduleName = entry.getKey().toString();          //seperate module name
                    String moduleScore = entry.getValue().toString();       //seperate module score

                    edit_module1TextField.setText(moduleName);
                    edit_module1ScoreTextField.setText(moduleScore);

                } else {    //no module
                    edit_module1TextField.setText("");              //set clear
                    edit_module1ScoreTextField.setText("");         //set clear
                }



                //module 2
                //--------
                if(studentModules.hasNext()) { //module exists...
                    Map.Entry entry = (Map.Entry) studentModules.next();    //read module
                    String moduleName = entry.getKey().toString();          //seperate module name
                    String moduleScore = entry.getValue().toString();       //seperate module score

                    edit_module2TextField.setText(moduleName);
                    edit_module2ScoreTextField.setText(moduleScore);

                } else {    //no module
                    edit_module2TextField.setText("");              //set clear
                    edit_module2ScoreTextField.setText("");         //set clear
                }





                //module 3
                //--------
                if(studentModules.hasNext()) { //module exists...
                    Map.Entry entry = (Map.Entry) studentModules.next();    //read module
                    String moduleName = entry.getKey().toString();          //seperate module name
                    String moduleScore = entry.getValue().toString();       //seperate module score

                    edit_module3TextField.setText(moduleName);
                    edit_module3ScoreTextField.setText(moduleScore);

                } else {    //no module
                    edit_module3TextField.setText("");              //set clear
                    edit_module3ScoreTextField.setText("");         //set clear
                }



                //module 4
                //--------
                if(studentModules.hasNext()) { //module exists...
                    Map.Entry entry = (Map.Entry) studentModules.next();    //read module
                    String moduleName = entry.getKey().toString();          //seperate module name
                    String moduleScore = entry.getValue().toString();       //seperate module score

                    edit_module4TextField.setText(moduleName);
                    edit_module4ScoreTextField.setText(moduleScore);

                } else {    //no module
                    edit_module4TextField.setText("");              //set clear
                    edit_module4ScoreTextField.setText("");         //set clear
                }




                //module 5
                //--------
                if(studentModules.hasNext()) { //module exists...
                    Map.Entry entry = (Map.Entry) studentModules.next();    //read module
                    String moduleName = entry.getKey().toString();          //seperate module name
                    String moduleScore = entry.getValue().toString();       //seperate module score

                    edit_module5TextField.setText(moduleName);
                    edit_module5ScoreTextField.setText(moduleScore);

                } else {    //no module
                    edit_module5TextField.setText("");              //set clear
                    edit_module5ScoreTextField.setText("");         //set clear
                }




                //module 6
                //--------
                if(studentModules.hasNext()) { //module exists...
                    Map.Entry entry = (Map.Entry) studentModules.next();    //read module
                    String moduleName = entry.getKey().toString();          //seperate module name
                    String moduleScore = entry.getValue().toString();       //seperate module score

                    edit_module6TextField.setText(moduleName);
                    edit_module6ScoreTextField.setText(moduleScore);

                } else {    //no module
                    edit_module6TextField.setText("");              //set clear
                    edit_module6ScoreTextField.setText("");         //set clear
                }




                queryResultTextField.setText("" + tempStudent.getQueryResult());        //update queryResult field (Double)


                //could create a read(Student stu) method that reads a student objects fields into GUI text fields



            }
        });


        //setting scrollbars to always appear came from:
        //https://stackoverflow.com/questions/6347768/how-to-increase-the-size-of-jscrollpane-pane

        //JScrollPane myScrollPane = new JScrollPane(myList);
        JScrollPane myScrollPane = new JScrollPane(myList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //JScrollBar myBar = myScrollPane.getHorizontalScrollBar();
        //myBar.setSize(new Dimension(30,0));

        //master_panel.add(myScrollPane);
        bottomHalfPanel.add(myScrollPane);















        //add panel halves to master_panel...

        master_panel.add(topHalfPanel);
        master_panel.add(bottomHalfPanel);


        //add master panel to window...
        myWindow.add(master_panel);







        myWindow.pack();


        //myWindow.setSize(300,300);
        myWindow.setVisible(true);


        //displayStudents(studentRegister.getAll());  //display list of all students - When this is run it seems to resize the students list so scroll bars are not visible

        //list all students
        studentSearch();


    }
















    //======================
    // studentSearch
    //======================
    //Called when 'Search' button clicked...
    public void studentSearch() {


        ArrayList<Student> resultList;      //container for result


        //read filter field boxes and send to studentRegister.query....
        resultList = studentRegister.query(
                filterBox1.getSelectedItem().toString(), filterBox1_operator.getSelectedItem().toString(), filterBox1_textField.getText(),    //read filter 1
                filterBox2.getSelectedItem().toString(), filterBox2_operator.getSelectedItem().toString(), filterBox2_textField.getText(),    //read filter 2
                filterBox3.getSelectedItem().toString(), filterBox3_operator.getSelectedItem().toString(), filterBox3_textField.getText(),    //read filter 3
                filterBox4.getSelectedItem().toString(), filterBox4_operator.getSelectedItem().toString(), filterBox4_textField.getText(),    //read filter 4
                filterBox5.getSelectedItem().toString(), filterBox5_operator.getSelectedItem().toString(), filterBox5_textField.getText()     //read filter 5
        );







        //display query result...
        displayStudents(resultList);



    }//end studentSearch()

















    //================
    // add student
    //================

    private void addStudent() {

        //read GUI 'new' fields into student register add method...
        studentRegister.add(
                new_firstNameTextField.getText(),
                new_lastNameTextField.getText(),
                new_addressLn1TextField.getText(),
                new_addressLn2TextField.getText(),
                new_cityTextField.getText(),
                new_postCodeTextField.getText(),
                new_countryTextField.getText(),
                new_phoneNumberTextField.getText(),
                new_emailTextField.getText(),
                //CourseType
                //new_courseType_textField.getText(),
                //Student.CourseType.valueOf(new_courseTextField.getText()), //decode String to CourseType enum
                Student.CourseType.valueOf(new_courseComboBox.getSelectedItem().toString()), //get ComboBox selection and decode String to Module enum NOTE: this throws an IllegalArgumentException if there is not a match

                //module 1
                //Student.Module.valueOf(new_module1TextField.getText()), //decode String to Module enum NOTE: this throws an IllegalArgumentException if there is not a match
                Student.Module.valueOf(new_module1ComboBox.getSelectedItem().toString()), //get ComboBox selection and decode String to Module enum NOTE: this throws an IllegalArgumentException if there is not a match
                Double.parseDouble(new_module1ScoreTextField.getText()), //convert String to Double








                //module 2
                //Student.Module.valueOf(new_module2TextField.getText()), //decode String to Module enum
                Student.Module.valueOf(new_module2ComboBox.getSelectedItem().toString()), //get ComboBox selection and decode String to Module enum NOTE: this throws an IllegalArgumentException if there is not a match
                Double.parseDouble(new_module2ScoreTextField.getText()),//convert String to Double



                //module 3
                //Student.Module.valueOf(new_module3TextField.getText()), //decode String to Module enum
                Student.Module.valueOf(new_module3ComboBox.getSelectedItem().toString()), //get ComboBox selection and decode String to Module enum NOTE: this throws an IllegalArgumentException if there is not a match
                Double.parseDouble(new_module3ScoreTextField.getText()),//convert String to Double



                //module 4
                //Student.Module.valueOf(new_module4TextField.getText()), //decode String to Module enum
                Student.Module.valueOf(new_module4ComboBox.getSelectedItem().toString()), //get ComboBox selection and decode String to Module enum NOTE: this throws an IllegalArgumentException if there is not a match
                Double.parseDouble(new_module4ScoreTextField.getText()),//convert String to Double




                //module 5
                //Student.Module.valueOf(new_module5TextField.getText()), //decode String to Module enum
                Student.Module.valueOf(new_module5ComboBox.getSelectedItem().toString()), //get ComboBox selection and decode String to Module enum NOTE: this throws an IllegalArgumentException if there is not a match
                Double.parseDouble(new_module5ScoreTextField.getText()),//convert String to Double




                //module 6
                //Student.Module.valueOf(new_module6TextField.getText()), //decode String to Module enum
                Student.Module.valueOf(new_module6ComboBox.getSelectedItem().toString()), //get ComboBox selection and decode String to Module enum NOTE: this throws an IllegalArgumentException if there is not a match
                Double.parseDouble(new_module6ScoreTextField.getText()), //convert String to Double



                //QueryResult - nothing to enter as a 'NEW' student. This is field is auto generated in search calculations. Set default blank (0.0)
                0.0


        );

        //update List display...
        displayStudents(studentRegister.getAll());

        //clear new student input fields
        this.clearNewStudentFields();

    }


    //=======================
    // Update Student
    //=======================
    //not used as yet.
    //now possible as data structure moved from type Record (immutable) to Class mutable
    private void updateStudent() {

        //read edit box fields and send to update query in studentRegister...

        //not yet implemented

        studentRegister.update();

    }




    //=======================
    // Delete Student
    //=======================
    public void deleteStudent() {

        int studentID = Integer.parseInt(edit_idTextField.getText());

        //boolean success = studentRegister.delete(1);
        boolean success = studentRegister.delete(studentID);

        if(success) { //successfully deleted student...

            //clear edit student input fields...
            clearEditStudentFields();

            System.out.println("Delete Successful");

            //update List display...
            displayStudents(studentRegister.getAll());



        }else { //student NOT deleted...
            //leave fields filled
            System.out.println("Delete NOT Successful");
        }

    }//end deleteStudent()






    //==========================
    // Display Students
    //==========================
    /***
     * Displays ArrayList<Student> list contents in the GUI JList
     * @param studentList ArrayList<Student> The list of Student objects to be displayed in the window JList
     */
    public void displayStudents(ArrayList<Student> studentList) {


        //Just setModel() and allow garbage collection to clear up old model

        //create new data model for the JList...
        DefaultListModel<Student> displayList = new DefaultListModel<Student>();


        //loop over studentList - functional/lambda way...
        studentList.forEach(s -> { displayList.addElement(s);});


        //loop over studentList - Object Oriented way...
        /*
        for (Student s: studentList) {

            displayList.addElement(s);

        }//end for
        */


        //set JList to new content model
        myList.setModel(displayList);


    }



    //============================
    // clearNewStudentFields
    //============================
    /***
     * clears the input fields of new student
     */
    private void clearNewStudentFields() {

        new_firstNameTextField.setText("");
        new_lastNameTextField.setText("");
        new_addressLn1TextField.setText("");
        new_addressLn2TextField.setText("");
        new_postCodeTextField.setText("");
        new_cityTextField.setText("");
        new_countryTextField.setText("");
        new_phoneNumberTextField.setText("");
        new_emailTextField.setText("");
                /*
                new_courseTextField.setText("");
                new_module1TextField.setText("");
                new_module2TextField.setText("");
                new_module3TextField.setText("");
                new_module4TextField.setText("");
                new_module5TextField.setText("");
                new_module6TextField.setText("");
                */
        //reset course and module combo boxes...
        new_courseComboBox.setSelectedIndex(0);
        new_module1ComboBox.setSelectedIndex(0);
        new_module2ComboBox.setSelectedIndex(0);
        new_module3ComboBox.setSelectedIndex(0);
        new_module4ComboBox.setSelectedIndex(0);
        new_module5ComboBox.setSelectedIndex(0);
        new_module6ComboBox.setSelectedIndex(0);



        new_module1ScoreTextField.setText("");
        new_module2ScoreTextField.setText("");
        new_module3ScoreTextField.setText("");
        new_module4ScoreTextField.setText("");
        new_module5ScoreTextField.setText("");
        new_module6ScoreTextField.setText("");


    }



    //==========================
    // clearEditStudentFields
    //==========================
    /***
     * clears the input fields of edit student
     */
    private void clearEditStudentFields() {

        edit_idTextField.setText("");
        edit_firstNameTextField.setText("");
        edit_lastNameTextField.setText("");
        edit_addressLn1TextField.setText("");
        edit_addressLn2TextField.setText("");
        edit_postCodeTextField.setText("");
        edit_cityTextField.setText("");
        edit_countryTextField.setText("");
        edit_phoneNumberTextField.setText("");
        edit_emailTextField.setText("");
        edit_courseTextField.setText("");
        edit_module1TextField.setText("");
        edit_module2TextField.setText("");
        edit_module3TextField.setText("");
        edit_module4TextField.setText("");
        edit_module5TextField.setText("");
        edit_module6TextField.setText("");
        edit_module1ScoreTextField.setText("");
        edit_module2ScoreTextField.setText("");
        edit_module3ScoreTextField.setText("");
        edit_module4ScoreTextField.setText("");
        edit_module5ScoreTextField.setText("");
        edit_module6ScoreTextField.setText("");
        queryResultTextField.setText("");


    }









    //=============
    // main
    //=============

    public static void main(String[] args) {


        //create the StudentRegister - controller object
        StudentRegister sR = new StudentRegister();

        //create the gui... and pass reference to sR StudentRegister - controller object
        GUI_Main gui = new GUI_Main(sR);




    }//end main()




}
