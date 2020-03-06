package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import ui.CommentCreate;

@Slf4j
public class CodeSelectAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        new CommentCreate(
                getProjectName(e),
                getFileName(e),
                getSelectedLineNumber(e)
        );
    }

    private int getSelectedLineNumber(AnActionEvent e) {
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        assert editor != null;
        return editor.getCaretModel().getLogicalPosition().line + 1;
    }

    @NotNull
    private String getFileName(AnActionEvent e) {
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        assert psiFile != null;
        String fileName = psiFile.getVirtualFile().getName();
        log.info("FileName:{}", fileName);
        return fileName;
    }

    @NotNull
    private String getProjectName(AnActionEvent e) {
        Project project = e.getData(CommonDataKeys.PROJECT);
        assert project != null;
        String projectName = project.getName();
        log.info("projectName:{}", projectName);
        return projectName;
    }
}
