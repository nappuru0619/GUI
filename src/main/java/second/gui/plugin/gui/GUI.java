package second.gui.plugin.gui;

import org.bukkit.plugin.java.JavaPlugin;

public final class GUI extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new GUI2(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
