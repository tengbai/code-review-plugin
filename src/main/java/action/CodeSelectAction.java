package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import ui.CommentCreate;

public class CodeSelectAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        String title = editor.getSelectionModel().getSelectedText();
        CommentCreate commentCreate = new CommentCreate(title);
    }
}
