package marconymous.dev;

import marconymous.dev.classes.GlobalContainer;
import marconymous.dev.commands.EnderChest;
import marconymous.dev.commands.Fly;
import marconymous.dev.commands.RuleToggle;
import marconymous.dev.events.EnderChestInteraction;
import marconymous.dev.events.JoinLeaveEvent;
import marconymous.dev.events.RuleEvents;
import marconymous.dev.tabcompleters.EnderChestTabCompleter;
import marconymous.dev.tabcompleters.FlyTabCompleter;
import marconymous.dev.tabcompleters.RuleToggleCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MineEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        GlobalContainer gc = new GlobalContainer();

        getServer().getConsoleSender().sendMessage(this.getClass().getSimpleName() + " has been initialized!");

        // Events
        getServer().getPluginManager().registerEvents(new JoinLeaveEvent(), this);

        // Rules
        Objects.requireNonNull(getCommand("rlt")).setExecutor(new RuleToggle(gc));
        Objects.requireNonNull(getCommand("rlt")).setTabCompleter(new RuleToggleCompleter());
        getServer().getPluginManager().registerEvents(new RuleEvents(gc), this);

        // EnderChest
        Objects.requireNonNull(getCommand("enderchest")).setExecutor(new EnderChest());
        Objects.requireNonNull(getCommand("enderchest")).setTabCompleter(new EnderChestTabCompleter());
        getServer().getPluginManager().registerEvents(new EnderChestInteraction(), this);

        // Fly
        Objects.requireNonNull(getCommand("fly")).setExecutor(new Fly());
        Objects.requireNonNull(getCommand("fly")).setTabCompleter(new FlyTabCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
