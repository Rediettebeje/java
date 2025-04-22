package Proj08;
import java.awt.*;
import java.awt.event.*;

public class Proj08Runner extends Frame {
    private String coordinates = "79,91"; // Initialize with default coordinates
    private int xPos = 84, yPos = 86; // Position for 79,91 + offset
    private boolean isDragging = false;
    private boolean isInside = true;

    public Proj08Runner() {

        // Print certification statement
        System.out.println("I certify that this program is my own work");
        System.out.println("and is not the work of others. I agree not");
        System.out.println("to share my solution with others.");
        System.out.println("Rediet Tebeje");

        // Set frame properties
        setTitle("Rediet Tebeje");
        setSize(300, 100);
        // setBackground(new Color(0xFEFFF0)); // Match the background color from HTML

        // Add mouse motion listener
        addMouseMotionListener(new MouseMotionHandler());

        // Add window listener for closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);

    }

    public void paint(Graphics g) {
        // Only draw coordinates if we're inside the frame or dragging outside
        if (isInside || isDragging) {
            if (isDragging) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }
            g.drawString(coordinates, xPos, yPos);
        }
    }

    private class MouseMotionHandler extends MouseMotionAdapter {
        public void mouseMoved(MouseEvent e) {
            isDragging = false;
            handleMouseEvent(e);
        }

        public void mouseDragged(MouseEvent e) {
            isDragging = true;
            handleMouseEvent(e);
        }

        private void handleMouseEvent(MouseEvent e) {
            // Get the frame dimensions
            int frameWidth = getWidth();
            int frameHeight = getHeight();

            // Get mouse position
            int x = e.getX();
            int y = e.getY();

            // Check if mouse is inside the frame
            isInside = x >= 0 && x < frameWidth && y >= 0 && y < frameHeight;

            if (isInside || isDragging) {
                // For mouseMoved, constrain coordinates to frame
                if (!isDragging) {
                    x = Math.max(0, Math.min(x, frameWidth - 1));
                    y = Math.max(0, Math.min(y, frameHeight - 1));
                }

                // Set position slightly above and to the right of pointer
                xPos = x + 5;
                yPos = y - 5;

                // Format coordinates string
                coordinates = String.format("(%d,%d)", x, y);

                // Repaint to show new coordinates
                repaint();
            }
        }
    }
}