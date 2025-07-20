package Logik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logik.MaterialBrush.Materials;



public class MaterialSelectorPanel extends JPanel {
    private final MaterialBrush brush;
    private final JButton[] buttons;
    private final ImageIcon brushIcon = new ImageIcon(
    new ImageIcon("resources/brush.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)
);

    public MaterialSelectorPanel(MaterialBrush brush) {
        this.brush = brush;
        this.setLayout(new GridLayout(1, Materials.values().length));
        this.setPreferredSize(new Dimension(400, 50));

        buttons = new JButton[Materials.values().length];

        int i = 0;
        for (Materials mat : Materials.values()) {
            JButton button = new JButton(mat.name());
            button.setBackground(getColorForMaterial(mat));
            button.setOpaque(true);
            button.setBorderPainted(false);
            int finalI = i;

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    brush.setMaterial(mat);
                    updateHighlight();
                }
            });

            buttons[i++] = button;
            this.add(button);
        }

        updateHighlight(); // Highlight initially selected
    }

    private void updateHighlight() {
    for (int i = 0; i < buttons.length; i++) {
        Materials mat = Materials.values()[i];
        JButton button = buttons[i];

        if (brush.material == mat) {
            button.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
            button.setFont(button.getFont().deriveFont(Font.BOLD));
            button.setIcon(brushIcon);                       // Add brush icon
            button.setHorizontalTextPosition(SwingConstants.LEFT); // Text left, icon right
            button.setText(mat.name());
        } else {
            button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
            button.setFont(button.getFont().deriveFont(Font.PLAIN));
            button.setIcon(null);                            // No icon for unselected
            button.setText(mat.name());
        }
    }
}





    private Color getColorForMaterial(Materials mat) {
        return switch (mat) {
            case Sand -> new Color(242, 209, 109);
            case Water -> new Color(40, 130, 219);
            case Air -> new Color(162, 241, 245);
            case Stone -> new Color(97, 97, 97);
            case Oil -> new Color(0, 0, 0);
        };
    }
}
