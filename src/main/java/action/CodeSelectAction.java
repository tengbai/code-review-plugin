package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import ui.CommentCreate;

public class CodeSelectAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getData(CommonDataKeys.PROJECT);
        String projectName = project.getName();

        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        String className = psiFile.getVirtualFile().getName();

        Editor editor = e.getData(CommonDataKeys.EDITOR);
        String line = String.valueOf(editor.getLineHeight());

        String title = projectName + ": "+ className + "(line "+ line+")";
        new CommentCreate(title);
    }
}
