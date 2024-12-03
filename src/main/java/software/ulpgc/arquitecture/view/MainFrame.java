package software.ulpgc.arquitecture.view;

import software.ulpgc.arquitecture.control.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private final BarcahrtDisplay display;
    private SelectDialog dialog;

    public MainFrame(){
        setLayout(new BorderLayout());
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Statistics");
        add(BorderLayout.NORTH, toolbar());
        add(display = displayer());
        commands = new HashMap<>();
    }

    public BarcahrtDisplay display(){return display;}
    public SelectDialog dialog(){return dialog;}
    public void put(String name, Command command) {
        commands.put(name, command);
    }

    private BarcahrtDisplay displayer() {
        return new BarcahrtDisplay();
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(selector());
        return panel;
    }

    private Component selector() {
        JComboBox<String> combo = new JComboBox<>();
        combo.addItem("quality");
        combo.addItem("exporter");
        combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() != ItemEvent.SELECTED) return;
                commands.get("select").execute();
            }
        });
        dialog = new SelectDialog() {
            @Override
            public int getSelection() {
                return combo.getSelectedIndex();
            }
        };
        return combo;
    }
}
