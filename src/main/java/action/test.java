package action;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class test extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance();
        String b =propertiesComponent.getValue("b");
        System.out.println(b);
    }
}
