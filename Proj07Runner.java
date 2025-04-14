import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Proj07Runner {
    private JFrame jFrame;
    private JPanel panel;
    private Point lastPoint = new Point(106, 60); // Initialize with default coordinates

    public Proj07Runner() {

        // Print certification statement
        System.out.println("Rediet Tebeje");

        // Create the JFrame
        jFrame = new JFrame("Rediet Tebeje"); 
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 100);

        
        // Create the JPanel
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (lastPoint != null) {
                    g.drawString(lastPoint.x + "," + lastPoint.y, lastPoint.x, lastPoint.y);
                }
            }
        };
        
        // Set up mouse listener
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lastPoint = e.getPoint();
                panel.repaint();
            }
        });
        
        // Add panel to frame and display
        jFrame.add(panel);
        jFrame.setVisible(true);
  
    }

    public JFrame getJFrame() {
        return jFrame;
    }
}