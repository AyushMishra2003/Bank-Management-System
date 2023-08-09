import java.sql.*;
import javax.swing.*;
public class SUABANKSYSTEM {
    private JFrame frame;
    private Connection con;

    // FOR SETTING FRAME
    public void init_component(){
        frame=new JFrame("SUA BANK SYSTEM");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400,400);
    }
    SUABANKSYSTEM(){
        Connectivity();
        init_component();
    }
    // FOR CONNCECTIVITY
    void Connectivity(){
        String url="jdbc:mysql://localhost:3306/merabank";
        try {
            con = DriverManager.getConnection(url, "root", "ayush2312");
            if(con!=null)
                System.out.println("CONNCECTION ESTABLIHED");
        }
        catch (SQLException e){
            e.getMessage();
        }
    }
}
