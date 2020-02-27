import com.intellij.openapi.components.ServiceManager;

public interface storeService {
    static storeService getInstance() {
        return ServiceManager.getService(storeService.class);
    }
}
