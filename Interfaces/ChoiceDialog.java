package Interfaces;

import javax.swing.*;
import java.util.List;

public class ChoiceDialog extends JDialog {
    JList options;

    public ChoiceDialog(String[] choices){
        options = new JList<>(choices);
    }
    @Override
    protected void dialogInit() {
        super.dialogInit();
        this.add(options);
    }


}
