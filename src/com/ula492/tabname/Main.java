package com.ula492.tabname;

import com.ula492.tabname.Tab.Tab;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;



/**
 * Created by Ula on 8/5/16.
 */
public class Main extends JavaPlugin {

    public static Permission perms = null;
    public static Chat chat = null;
    private static Plugin plugin;
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }
    Server server = Bukkit.getServer();

    ConsoleCommandSender console = server.getConsoleSender();

    String TabName = ChatColor.AQUA + "" + ChatColor.BOLD + "TabName >";

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");
        Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "TabName by Ula was successfully Enabled");
        Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");
        instance = this;
        plugin = this;
        setupPermissions();
        setupChat();

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Tab(this), this);

        if(getServer().getPluginManager().isPluginEnabled("PermissionsEx")){
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.GREEN +  "" + ChatColor.BOLD +"PermissionsEX found. Hooking to it.");
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");
        }else{
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.RED + "" + ChatColor.BOLD + "PermissionEX was not found. Trying GroupManager");
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");
        }
        if(getServer().getPluginManager().isPluginEnabled("GroupManager")){
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.GREEN + "" + ChatColor.BOLD + "GroupManager found. Hooking to it.");
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");

        }else{
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.RED + "" + ChatColor.BOLD + "GroupManager was not found, Trying PermissionsEx.");
            Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");
        }
    }



    public boolean setupChat()
    {
        RegisteredServiceProvider rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = (Chat)rsp.getProvider();
        return chat != null;
    }

    public boolean setupPermissions() {
        RegisteredServiceProvider rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = (Permission)rsp.getProvider();
        return perms != null;
    }


    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");
        Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.DARK_RED + "" + ChatColor.BOLD + "TabName by Ula was successfully Disabled");
        Bukkit.getConsoleSender().sendMessage(TabName + ChatColor.BLUE + "" + ChatColor.BOLD + "=======================================");    }

}
