package marconymous.dev.tabcompleters;

import marconymous.dev.classes.GlobalFunctions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class EnderChestTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> out = new ArrayList<>();

        if (args.length == 1){
            GlobalFunctions.addPlayersToList(out);
        }

        return out;
    }
}
