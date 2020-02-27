import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class MyApplication implements ApplicationComponent {
    public MyApplication() {
    }

    @Override
    public void initComponent() {
        System.out.println("begin");
        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance();
        propertiesComponent.setValue("a", "aaa");
        // TODO: insert component initialization logic here
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "FinderApplication";
    }
}
