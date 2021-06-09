package marconymous.dev;

import marconymous.dev.classes.GlobalContainer;
import marconymous.dev.commands.Fly;
import marconymous.dev.commands.RuleToggle;
import marconymous.dev.events.JoinLeaveEvent;
import marconymous.dev.events.RuleEvents;
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
        getServer().getPluginManager().registerEvents(new RuleEvents(gc), this);

        // Commands

        // Rule Toggle
        Objects.requireNonNull(getCommand("rlt")).setExecutor(new RuleToggle(gc));
        Objects.requireNonNull(getCommand("rlt")).setTabCompleter(new RuleToggleCompleter());

        //Fly
        Objects.requireNonNull(getCommand("fly")).setExecutor(new Fly());
        Objects.requireNonNull(getCommand("fly")).setTabCompleter(new FlyTabCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
