import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.util.concurrent.TimeUnit;
import static net.mindview.util.SwingConsole.*;

public class SubmitSwingProgram extends JFrame {
    static JLabel label;
    public SubmitSwingProgram(){
        super("Hello Swing");
        label=new JLabel("A label");
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        setVisible(true);
    }
    static SubmitSwingProgram ssp;

    public static void main(String[] args) throws Exception{
    SwingUtilities.invokeLater(() -> ssp=new SubmitSwingProgram());
        TimeUnit.SECONDS.sleep(1);
        JFrame frame=new JFrame("head");
        frame.add(label);
        SwingConsole.run(frame,100,100);
        label.setText("Hello World");
    }


}
