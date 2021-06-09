package marconymous.dev.tabcompleters;

import marconymous.dev.enums.SpecialRule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class RuleToggleCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> autoCompletes = new ArrayList<>();

        switch (args.length) {
            case 1:
                for (SpecialRule s : SpecialRule.values()) {
                    autoCompletes.add(s.getName());
                }
                break;

            case 2:
                autoCompletes.add("true");
                autoCompletes.add("false");
                break;
        }

        return autoCompletes;
    }
}
