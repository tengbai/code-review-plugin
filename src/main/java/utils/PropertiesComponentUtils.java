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
    public static void setValue(@Nullable String key, @Nullable String value) {
        if (value == null) {
            return;
        }
        //获取 application 级别的 PropertiesComponent
        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance();
        propertiesComponent.setValue(key, value);
    }

    /**
     * 获取值得信息
     *
     * @return
     */
    public static String getValue(String key) {

        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance();
        String value = propertiesComponent.getValue(key);
        return value == null ? null : value;
    }

    public static void appendValue(String key, String value) {
        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance();
        String oldValue = propertiesComponent.getValue(key);
        String totalValue = oldValue + "\n" + value;
        propertiesComponent.setValue(key, totalValue);
    }
}
