package action;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import store.CommentDTO;
import store.Store;


public class ShowCommentsAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Store store = new Store();
        store.appendComment(CommentDTO.builder().id(1).content("1").build());
        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance();
        String a =propertiesComponent.getValue("a");
        propertiesComponent.setValue("b", "bbb");
        System.out.println(a);
    }
}
