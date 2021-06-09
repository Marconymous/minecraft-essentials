package marconymous.dev.tabcompleters;

import marconymous.dev.classes.GlobalFunctions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FlyTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> comps = new ArrayList<>();

        if (args.length == 1) {
            for (Player p : sender.getServer().getOnlinePlayers())
                comps.add(p.getDisplayName());
        }

        GlobalFunctions.addBoolsToList(comps);

        return comps;
    }
}
