package Client;

import Logic.JaccardSimilarityStrategy;
import Logic.SimilarityCalculator;
import Manager.SimilarityManager;

import javax.swing.*;

public class GuiPanel extends JPanel {
    private JTextField filePath1;
    private JTextField filePath2;
    private JLabel explainLabel;
    private JButton startButton;
    private JLabel resultLabel;

    private final SimilarityManager manager;

    public GuiPanel() {

        manager = new SimilarityManager(new SimilarityCalculator(new JaccardSimilarityStrategy()));
        initializeComps();
        setEvents();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        setBackground(GuiConstants.APP_COLOR);

        add(Box.createVerticalGlue());
        add(explainLabel);
        add(Box.createVerticalStrut(10));
        add(filePath1);
        add(Box.createVerticalStrut(20));
        add(filePath2);
        add(Box.createVerticalStrut(20));
        add(startButton);
        add(Box.createVerticalGlue());
    }

    public void initializeComps() {
        filePath1 = new JTextField();
        filePath2 = new JTextField();
        explainLabel = new JLabel("Enter the path of files");
        startButton = new JButton("Calculate file similarity");
        resultLabel = new JLabel();

        createTextField(filePath1);
        createTextField(filePath2);
        createExplainLabel(explainLabel);
        createButton(startButton);
        createResultLabel(resultLabel);
    }

    public void createTextField(JTextField field) {
        field.setMaximumSize(GuiConstants.FIELD_SIZE);
        field.setAlignmentX(CENTER_ALIGNMENT);
        field.setFont(GuiConstants.FIELD_FONT);
    }

    public void createExplainLabel(JLabel label) {
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setFont(GuiConstants.LABEL_FONT);
        label.setForeground(GuiConstants.LABEL_COLOR);
    }

    public void createResultLabel(JLabel label) {
        label.setForeground(GuiConstants.RESULT_COLOR);
        label.setFont(GuiConstants.RESULT_FONT);
    }
    public void createButton(JButton button) {
        button.setMaximumSize(GuiConstants.FIELD_SIZE);
        button.setFocusPainted(false);
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.setFont(GuiConstants.BUTTON_FONT);
        button.setForeground(GuiConstants.BUTTON_COLOR);
    }

    public void setEvents() {
        startButton.addActionListener(e -> {
            if (filePath1.getText().isEmpty() ||
                    filePath2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(GuiPanel.this, "Please fill both fields",
                        "Missing Information", JOptionPane.ERROR_MESSAGE);
            }
            else {

                double result = manager.process(filePath1.getText(), filePath2.getText());
                StringBuilder formattedResult = new StringBuilder(String.format("%.2f", result));

                if (result >= 99.99) {

                    formattedResult.append("% Similarity - Same File");
                    resultLabel.setText(formattedResult.toString());

                    JOptionPane.showMessageDialog(GuiPanel.this, resultLabel,
                            "Analysis Result", JOptionPane.PLAIN_MESSAGE);

                } else if (result >= 50.01) {

                    formattedResult.append("% Similarity - Possible Plagiarism");
                    resultLabel.setText(formattedResult.toString());

                    JOptionPane.showMessageDialog(GuiPanel.this, resultLabel,
                            "Analysis Result", JOptionPane.PLAIN_MESSAGE);

                } else {

                    formattedResult.append("% Similarity - Low Similarity");
                    resultLabel.setText(formattedResult.toString());

                    JOptionPane.showMessageDialog(GuiPanel.this, resultLabel,
                            "Analysis Result", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }
}
