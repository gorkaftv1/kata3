package software.ulpgc.arquitecture.control;

import software.ulpgc.arquitecture.io.BarchartLoader;
import software.ulpgc.arquitecture.view.BarcahrtDisplay;
import software.ulpgc.arquitecture.view.SelectDialog;

public class SelectCommand implements Command{
    private SelectDialog dialog;
    private BarchartLoader loader;

    public SelectCommand(SelectDialog dialog, BarchartLoader loader, BarcahrtDisplay display) {
        this.dialog = dialog;
        this.loader = loader;
        this.display = display;
    }

    private BarcahrtDisplay display;

    @Override
    public void execute() {
        display.show(loader.load(dialog.getSelection()));
    }
}
