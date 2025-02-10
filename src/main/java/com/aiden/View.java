package com.aiden;

import com.aiden.databaseWork.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class View extends JFrame{
    private String[][] data;
    private JPanel panel;

    View() {
        panel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);
        this.setSize(800, 600);
        if (this.data != null){
            render();
        }

    }

    public void setData(String data){
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

        for (String[] row : this.data) {
            System.out.println(Arrays.toString(row));
        }

        for (int subDataIndex = 0; subDataIndex < this.data.length; subDataIndex++){
            String[] subData = this.data[subDataIndex];

            for (int dataIndex = 0; dataIndex < subData.length; dataIndex++){
                String data = subData[dataIndex];
                System.out.println(data);
                findDataTypeAndRender(data, subDataIndex, dataIndex);
            }
        }
        panel.revalidate();
        panel.repaint();
    }

    private void findDataTypeAndRender(String data, int subDataIndex, int dataIndex){
        if (Objects.equals(data, "true") || Objects.equals(data, "false")){
            JCheckBox jCheckBox = new JCheckBox();
            jCheckBox.setEnabled(Boolean.parseBoolean(data));
            jCheckBox.setBounds(10*dataIndex, 10*subDataIndex, 10, 10);
            panel.add(jCheckBox);
        }
        else {
            JTextField jTextField = new JTextField(15);
            jTextField.setText(data);
            jTextField.setBounds(25*dataIndex, 10*subDataIndex, 25, 10);
            panel.add(jTextField);
        }
    }

}
