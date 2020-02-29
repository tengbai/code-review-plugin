package utils;

import Constants.NameConstants;
import com.intellij.ide.util.PropertiesComponent;
import org.jetbrains.annotations.Nullable;

public class PropertiesComponentUtils {

    /**
     * 设置application级别的信息变量
     *
     * @param value
     */
    public static void setValue(@Nullable String value) {
        if (value == null) {
            return;
        }
        //获取 application 级别的 PropertiesComponent
        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance();
        propertiesComponent.setValue(NameConstants.APPLICATION_NAME, value);
    }

    /**
     * 获取值得信息
     *
     * @return
     */
    public static String getValue() {

        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance();
        String value = propertiesComponent.getValue(NameConstants.APPLICATION_NAME);
        return value == null ? null : value;
    }

}
