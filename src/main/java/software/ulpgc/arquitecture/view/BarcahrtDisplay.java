package software.ulpgc.arquitecture.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.arquitecture.model.Barchart;

import javax.swing.*;
import java.awt.*;

public class BarcahrtDisplay extends JPanel {
    public BarcahrtDisplay(){
        setLayout(new BorderLayout());
    }
    public void show(Barchart barchart) {
        removeAll();
        add(new ChartPanel(adapt(barchart)));
        revalidate();

    }

    private JFreeChart adapt(Barchart barchart) {
        return ChartFactory.createBarChart(barchart.title(), barchart.xAxis(), barchart.yAxis(), datasetOf(barchart));
    }

    private CategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        for(String n : barchart.keySet()) defaultCategoryDataset.addValue(barchart.get(n), "", n);
        return defaultCategoryDataset;
    }
}
