package marconymous.dev.commands;

import marconymous.dev.classes.DefaultMessages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EnderChest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            DefaultMessages.onlyPlayerCommand(sender, command);
            return true;
        }

        if (args.length == 0) {
            openEnderChest((Player) sender, (Player) sender);
        } else if (args.length == 1) {
            Player target = null;
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (player.getDisplayName().equalsIgnoreCase(args[0])) {
                    target = player;
                    break;
                }
            }
            if (target == null) {
                DefaultMessages.incorrectUsage(sender, command);
                return true;
            }
            openEnderChest((Player) sender, target);
        } else DefaultMessages.incorrectUsage(sender, command);

        return true;
    }

    private void openEnderChest(Player sender, Player target) {
        Inventory enderChest = target.getEnderChest();

        Inventory view = Bukkit.createInventory(null, enderChest.getSize(), ChatColor.DARK_PURPLE + "EnderChest " + ChatColor.AQUA + "of " + target.getDisplayName());

        view.setContents(enderChest.getContents());

        sender.openInventory(view);
    }
}
