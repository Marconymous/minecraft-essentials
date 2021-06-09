package marconymous.dev.commands;

import marconymous.dev.classes.GlobalContainer;
import marconymous.dev.enums.SpecialRule;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Map;

public class RuleToggle implements CommandExecutor {
    private final GlobalContainer gc;

    public RuleToggle(GlobalContainer gc) {
        this.gc = gc;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        for (Map.Entry<SpecialRule, Boolean> entry : gc.getRules().entrySet()) {
            if (args.length == 1) {
                if (entry.getKey().getName().equalsIgnoreCase(args[0])) {
                    boolean newVal = !entry.getValue();
                    entry.setValue(newVal);

                    sender.sendMessage(ChatColor.GREEN + entry.getKey().getName() + " was set to: " + newVal);
                }
            } else if (args.length == 2) {
                if (entry.getKey().getName().equalsIgnoreCase(args[0])) {
                    try {
                        boolean newVal = Boolean.parseBoolean(args[1]);
                        entry.setValue(newVal);
                        sender.sendMessage(ChatColor.GREEN + entry.getKey().getName() + " was set to: " + newVal);
                    } catch (Exception ignored) {
                        sender.sendMessage(ChatColor.RED + "Incorrect Usage of this command [argument 1]");
                    }
                }
            }
        }

        return true;
    }
}
