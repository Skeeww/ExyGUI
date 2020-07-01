package fr.exygames.exygui;

import fr.exygames.exygui.Commands.BuyPoints;
import fr.exygames.exygui.Commands.Farm2Win;
import fr.exygames.exygui.Commands.Info;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main instance;
    public static PluginManager pm;
    public static Economy eco;

    public static Main getInstance() {
        return instance;
    }

    public static PluginManager getPm() {
        return pm;
    }

    public static Economy getEco() {
        return eco;
    }

    @Override
    public void onEnable() {
        instance = this;
        pm = getServer().getPluginManager();
        eco = getServer().getServicesManager().getRegistration(Economy.class).getProvider();

        getCommand("f2w").setExecutor(new Farm2Win());
        getCommand("farm2win").setExecutor(new Farm2Win());

        getCommand("social").setExecutor(new Info());

        getCommand("buypoints").setExecutor(new BuyPoints());

        getServer().getConsoleSender().sendMessage("[ExyGUI] Is Started !");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("[ExyGUI] Is Stopped !");
    }
}
