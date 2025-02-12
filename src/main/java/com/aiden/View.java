package com.aiden;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class View extends JFrame{
    private String[][] data;
    private JScrollPane pane;
    private JPanel panel;

    private JButton newRowButton;
    private JButton removeRowButton;
    private JButton saveTableButton;
    private JTextField tableName;
    private JButton showTableButton;

    private JPanel infoPanel;


    View() {

        newRowButton = new JButton("New Row");
        showTableButton = new JButton("Show Inputted Table");
        removeRowButton = new JButton("Remove Bottom Row");
        saveTableButton = new JButton("Save The Table");
        tableName = new JTextField(10);

        panel = new JPanel();
        pane = new JScrollPane(panel);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.add(pane);
        this.setSize(800, 600);
        if (this.data != null){
            render();
        }

        infoPanel = new JPanel();
        infoPanel.setName("infoPanel");

        infoPanel.add(removeRowButton);
        infoPanel.add(showTableButton);
        infoPanel.add(newRowButton);
        infoPanel.add(saveTableButton);
        infoPanel.add(tableName);

        panel.add(infoPanel);
    }

    public void setData(String data){
        panel.removeAll();
        panel.add(infoPanel);
        String[] data1 = data.split("\\|");

        String[][] data2 = new String[data1.length][];

        for (int i = 0; i < data1.length; i++) {
            String[] newO = data1[i].split(" ");
            data2[i] = newO;
        }

        this.data = data2;
        render();
    }

    public void render(){

        for (int subDataIndex = 0; subDataIndex < this.data.length; subDataIndex++){
            String[] subData = this.data[subDataIndex];

            JPanel subPanel = new JPanel();
            for (int dataIndex = 0; dataIndex < subData.length; dataIndex++){
                String data = subData[dataIndex];
                findDataTypeAndRender(data, subPanel);
            }
            panel.add(subPanel);
        }

        panel.revalidate();
        panel.repaint();
    }

    private void findDataTypeAndRender(String data, JPanel subPanel){

        if (Objects.equals(data, "true") || Objects.equals(data, "false")){
            JCheckBox jCheckBox = new JCheckBox("Present");
            jCheckBox.setSelected(Boolean.parseBoolean(data));
            subPanel.add(jCheckBox);
        }
        else {
            JTextField jTextField = new JTextField(15);
            jTextField.setText(data);
            subPanel.add(jTextField);
        }
    }

    void addNewRowListener(ActionListener listener){
        newRowButton.addActionListener(listener);
    }

    public void newRow(){
        renderNewRow();
        panel.revalidate();
        panel.repaint();
    }

    private void renderNewRow(){
        JPanel subPanel = new JPanel();

        for (int i = 0; i < 4; i++) {
            if (i == 3){
                JCheckBox jCheckBox = new JCheckBox("Present");
                subPanel.add(jCheckBox);
            }
            else {
                JTextField jTextField = new JTextField(15);

                subPanel.add(jTextField);
            }
        }
        panel.add(subPanel);
    }

    public Object[][] getOutData() {
        int rows = (int) Arrays.stream(panel.getComponents())
                .filter(c -> c instanceof JPanel)
                .count();

        Object[][] returnData = new Object[rows-1][4];
        int thingsBeforePanels = 0;

        for (int i = 0; i < panel.getComponents().length; i++) {
            Component p = panel.getComponents()[i];
            if (p instanceof JPanel && p.getName() != "infoPanel") {
                Component[] components = ((JPanel) p).getComponents();

                for (int j = 0; j < 4; j++) {
                    Component component = components[j];

                    if (component instanceof JTextField) {
                        returnData[i-thingsBeforePanels][j] = ((JTextField) component).getText();
                    } else if (component instanceof JCheckBox) {
                        returnData[i-thingsBeforePanels][j] = ((JCheckBox) component).isSelected();
                    }
                }
            }
            else {
                thingsBeforePanels++;
            }
        }


        return returnData;
    }

    public String getInputtedTableName(){
        return tableName.getText();
    }

    public void removeBottomRow(){
        int lastIndex = panel.getComponents().length;
        if (!Objects.equals(panel.getComponents()[lastIndex-1].getName(), "infoPanel")) {
            panel.remove(lastIndex - 1);
        }

        panel.revalidate();
        panel.repaint();
    }

    void addNewRowToDatabaseListener(ActionListener listener){
        saveTableButton.addActionListener(listener);
    }

    void removeBottomRowListener(ActionListener listener){
        removeRowButton.addActionListener(listener);
    }

    void showTableListener(ActionListener listener){
        showTableButton.addActionListener(listener);
    }

    void displayError(String error){
        JOptionPane.showMessageDialog(this, error);
    }

}
