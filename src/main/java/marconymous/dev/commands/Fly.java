package marconymous.dev.commands;

import marconymous.dev.classes.DefaultMessages;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                DefaultMessages.incorrectUsage(sender, command);
                return true;
            }

            Player target = (Player) sender;
            target.setAllowFlight(!target.getAllowFlight());

            sender.sendMessage(ChatColor.GREEN + target.getDisplayName() + " allowFlight set to: " + target.getAllowFlight());
        } else if (args.length == 1)
            handleSingleArgs(sender, command, args);
        else if (args.length == 2)
            handleDoubleArgs(sender, command, args);

        return true;
    }

    public void handleSingleArgs(CommandSender sender, Command command, String[] args) {
        Player target = null;

        for (Player p : sender.getServer().getOnlinePlayers()) {
            if (p.getName().equalsIgnoreCase(args[0])) target = p;
        }

        if (target == null) {
            target = (Player) sender;
            boolean res;
            try {
                res = Boolean.parseBoolean(args[0]);
                target.setAllowFlight(res);
            } catch (Exception e) {
                DefaultMessages.incorrectUsage(sender, command);
            }
        } else {
            target.setAllowFlight(target.getAllowFlight());
        }
        sender.sendMessage(ChatColor.GREEN + target.getDisplayName() + " allowFlight set to: " + target.getAllowFlight());
    }

    public void handleDoubleArgs(CommandSender sender, Command command, String[] args) {
        Player target = null;
        boolean state;

        for (Player p : sender.getServer().getOnlinePlayers()) {
            if (p.getName().equalsIgnoreCase(args[0])) target = p;
        }

        if (target == null) {
            DefaultMessages.incorrectUsage(sender, command);
            return;
        }

        try {
            state = Boolean.parseBoolean(args[1]);
        } catch (Exception e) {
            DefaultMessages.incorrectUsage(sender, command);
            return;
        }

        target.setAllowFlight(state);
        sender.sendMessage(ChatColor.GREEN + target.getDisplayName() + " allowFlight set to: " + target.getAllowFlight());
    }
}
