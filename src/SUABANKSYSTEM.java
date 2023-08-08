import javax.swing.*;
public class SUABANKSYSTEM {
    private JFrame frame;
    public void init_component(){
            frame=new JFrame("SUA BANK SYSTEM");
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setSize(400,400);
    }
    SUABANKSYSTEM(){
        init_component();
    }
}
