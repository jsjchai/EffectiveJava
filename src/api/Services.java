package api;

import provider.Provider;
import service.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by chai on 16-10-25.
 */
public class Services {

    private Services() {

    }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();
    public static final String DEFAULT_PROVIDER_NAME = "default";

    public static void registerDefaultProvider(Provider p) {
        registerDefaultProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerDefaultProvider(String name, Provider p) {
        providers.put(name, p);
    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException("No provider registered with name:" + name);
        }
        return p.newService();
    }
}
