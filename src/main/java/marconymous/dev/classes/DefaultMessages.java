package marconymous.dev.classes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class DefaultMessages {
    public static void incorrectUsage(CommandSender sender, Command command) {
        sender.sendMessage(ChatColor.RED + "Incorrect usage of the following command: " + command.getUsage());
    }
}
