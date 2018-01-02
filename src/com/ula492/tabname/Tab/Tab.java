package com.ula492.tabname.Tab;

import com.ula492.tabname.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getServer;

/**
 * Created by Ula on 8/5/16.
 */
public class Tab implements Listener {

    private final Main plugin;


    public Tab(Main plugin)
    {
        this.plugin = plugin;
    }

    Plugin isPEXEnabled = getServer().getPluginManager().getPlugin("PermissionsEx-1.23.4");
    Plugin isGMEnabled = getServer().getPluginManager().getPlugin("EssentialsGroupManager.jar");

    @EventHandler
    public void TabPrefix(PlayerJoinEvent e){
        Player p = e.getPlayer();

        String group = Main.chat.getPrimaryGroup(p);
        String Prefix = Main.chat.getGroupPrefix(p.getWorld(), group);

        String Suffix = Main.chat.getGroupSuffix(p.getWorld(), group);

        if(getServer().getPluginManager().isPluginEnabled("PermissionsEx")){
        //     p.setDisplayName(format(Prefix + p.getName()));
            p.setPlayerListName(format(Prefix + " " + p.getName() + Suffix));

        }else if(getServer().getPluginManager().isPluginEnabled("GroupManager")) {
    //             p.setDisplayName(format(Prefix + " " + p.getName()));
                 p.setPlayerListName(format(Prefix + " " + p.getName() + Suffix));

         }



    }

    public static String format(String format){
        return ChatColor.translateAlternateColorCodes('&', format);
    }
}
