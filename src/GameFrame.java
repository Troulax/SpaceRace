import javax.swing.*;

public class GameFrame extends JFrame {

    GameFrame(){



        this.add(new GamePanel());
        this.setTitle("Space Explorer");
        //Button button = new JButton("Click to Close!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setContentPane(button);
        //button.addActionListener(e -> this.dispose());
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}