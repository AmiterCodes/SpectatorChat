package me.amitnave.spectatorchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
if(e.getPlayer().getGameMode().equals(GameMode.SPECTATOR)) {
    Bukkit.getOnlinePlayers()
            .stream()
            .filter(player -> player.getGameMode().equals(GameMode.SPECTATOR))
            .forEach(player -> player
                    .sendMessage(ChatColor.GRAY + e.getPlayer().getName() + " > " + e.getMessage()));
    Bukkit.getConsoleSender().sendMessage(e.getPlayer().getName() + " > " + e.getMessage());
    e.setCancelled(true);
}

    }
}
