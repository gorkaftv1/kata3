package software.ulpgc.app;

import software.ulpgc.arquitecture.control.SelectCommand;
import software.ulpgc.arquitecture.io.BarchartLoader;
import software.ulpgc.arquitecture.io.FileWoodLoader;
import software.ulpgc.arquitecture.io.TsvWoodDeserializer;
import software.ulpgc.arquitecture.view.MainFrame;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWoodLoader fileLoader = fileLoader();
        MainFrame frame = new MainFrame();
        BarchartLoader loader = new BarchartLoader(fileLoader);
        frame.put("select", new SelectCommand(frame.dialog(), loader, frame.display()));
        frame.display().show(loader.load(0));
        frame.setVisible(true);
    }

    private static FileWoodLoader fileLoader() throws IOException {
        File file = new File("C:/Users/gorka/Downloads/WoodsData.tsv");
        FileWoodLoader loader = new FileWoodLoader(file, new TsvWoodDeserializer());
        return loader;
    }
}
