import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class SUABANKSYSTEM {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private Connection con;
    private PreparedStatement ps;

    // FOR SETTING EVERTHINK ABOUT NEW ACCOUNT
    private JLabel name;
    private JLabel account_no;
    private  JLabel address;
    private JLabel phone_no;
    private JLabel date;
    private JTextField name1;
    private JTextField account_no1;
    private JTextField address1;
    private JTextField phone_no1;
    private JPanel panel1;
    private JButton create;

    // FOR SETTING FRAME
    public void init_component(){

        // FOR SETTING FRAME
        frame=new JFrame("SUA BANK SYSTEM");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400,400);
        tabbedPane=new JTabbedPane();
        // FOR SETTING  About New account holder

        // LABEL OF NEW ACCOUNT HOLDER
        name=new JLabel("NAME");
        account_no=new JLabel("ACCOUNT NUMBER");
        address=new JLabel("Address");
        phone_no=new JLabel("PHONE NUMBER");


        //  FOR TEXTFILED ABOUT NEW Account
        name1=new JTextField();
        account_no1=new JTextField();
        address1=new JTextField();;
        phone_no1=new JTextField();

        // FOR SET BONDDS
        name.setBounds(50,50,200,20);
        account_no.setBounds(50,100,200,20);
        address.setBounds(50,150,200,20);
        phone_no.setBounds(50,200,200,20);

        name1.setBounds(170,50,100,20);
        account_no1.setBounds(170,100,100,20);
        address1.setBounds(170,150,100,20);
        phone_no1.setBounds(170,200,100,20);

        // FOR SETTING BUTTION
        create=new JButton("CREATE ACCOUNT");
        create.setBounds(70,300,150,20);
        // FOR ADDING PANEL
        panel1=new JPanel();
        panel1.setLayout(null);
        panel1.add(name);
        panel1.add(account_no);
        panel1.add(address);
        panel1.add(phone_no);
        panel1.add(name1);
        panel1.add(address1);
        panel1.add(phone_no1);
        panel1.add(account_no1);
        panel1.add(create);

        // FOR HANDLING BUTTON EVENET
        create.addActionListener(new NewAccount() );
        // FOR ADDING IN TAPPED PANE
        tabbedPane.add(panel1);
        frame.add(tabbedPane);
    }
    SUABANKSYSTEM(){
        Connectivity();
        init_component();
    }
    class NewAccount implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String name=name1.getText().toString();
                String acc=account_no1.getText().toString();
                String add=address1.getText().toString();
                String pho=phone_no1.getText().toString();
                String q="insert into bank(name,accno,address,phone_no,Balanace)values(?,?,?,?,0);";
                ps=con.prepareStatement(q);
                ps.setString(1,name);
                ps.setString(2,acc);
                ps.setString(3,add);
                ps.setString(4,pho);
                ps.executeUpdate();
                name1.setText("");

                account_no1.setText("");
                address1.setText("");
                phone_no1.setText("");
            }
            catch (SQLException m){
                m.getMessage();
            }
        }
    }
    // FOR CONNCECTIVITY
    void Connectivity(){
        String url="jdbc:mysql://localhost:3306/merabank";
        try {
            con = DriverManager.getConnection(url, "root", "ayush2312");
            if(con!=null)
                System.out.println("CONNCECTION ESTABLIHED");
        }
        catch (SQLException E){
            E.getMessage();
        }
    }
}
