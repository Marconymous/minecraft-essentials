package marconymous.dev.classes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class DefaultMessages {
    public static void incorrectUsage(CommandSender sender, Command command) {
        sender.sendMessage(ChatColor.RED + "Incorrect usage of the following command: " + command.getUsage());
    }

    public static void onlyPlayerCommand(CommandSender sender, Command cmd) {
        sender.sendMessage(ChatColor.RED + "The command (" + cmd.getName() + ") is only available for Players!");
    }
}
