//package component;
//
//import com.intellij.openapi.components.ApplicationComponent;
//import com.intellij.openapi.editor.EditorFactory;
//import com.intellij.openapi.editor.event.EditorEventMulticaster;
//import com.sun.tools.hat.internal.server.QueryListener;
//import org.jetbrains.annotations.NotNull;
//
//public class CodeSelectComponent implements ApplicationComponent {
//    private QueryListener queryListener;
//
//    public CodeSelectComponent() {
//    }
//
//    @Override
//    public void initComponent() {
//        queryListener = new QueryListener();
//        EditorEventMulticaster eventMulticaster = EditorFactory.getInstance().getEventMulticaster();
//        eventMulticaster.addEditorMouseListener(queryListener);
//    }
//
//    @Override
//    public void disposeComponent() {
//    }
//
//    @Override
//    @NotNull
//    public String getComponentName() {
//        return "CodeSelectComponent";
//    }
//}
