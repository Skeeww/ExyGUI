package fr.exygames.exygui.Commands;

import fr.exygames.exygui.Interfaces.Farm2Win.Index;
import fr.exygames.exygui.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Farm2Win implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Index index = new Index((Player) sender);
            Main.getPm().registerEvents(index, Main.getInstance());
            index.run();
            return true;
        }
        return false;
    }
}
