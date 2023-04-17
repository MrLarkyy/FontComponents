package xyz.larkyy.fontcomponents.fontcomponents;

import org.bukkit.plugin.java.JavaPlugin;

public class FontComponents {

    private static FontComponents instance;
    private final JavaPlugin plugin;
    private final ComponentRepository componentRepository;

    private FontComponents(JavaPlugin plugin) {
        this.plugin = plugin;
        this.componentRepository = new ComponentRepository();
    }

    public static FontComponents initialize(JavaPlugin plugin) {
        if (instance != null) {
            return instance;
        }
        instance = new FontComponents(plugin);
        return instance;
    }

    public static FontComponents getInstance() {
        return instance;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public ComponentRepository getComponentRepository() {
        return componentRepository;
    }
}
