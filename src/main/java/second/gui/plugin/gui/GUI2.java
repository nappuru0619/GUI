package second.gui.plugin.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI2 implements Listener {
    private Inventory gui;
    //GUIの名前を決める

    public void openNewGUI(Player p) {
        gui = Bukkit.createInventory(null, InventoryType.CHEST);
        //GUIのインベントリの種類を決める

        ItemStack item = new ItemStack(Material.GREEN_CONCRETE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§2This is a button!");
        item.setItemMeta(meta);
        //インベントリを開いたときになんのブロックを出すか決める

        gui.setItem(2, item);
        //何ブロック目にセットするか決める

        p.openInventory(gui);
        //インベントリを開く

    }

    @EventHandler
    public void guiClickEvent(InventoryClickEvent e) {
        if (!e.getInventory().equals(gui)) {
            return;

        }

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();

        switch(e.getSlot()) {
            case 2: {
                p.closeInventory();
                p.sendMessage("§3You clicked the button!");
                break;
                ////インベントリをクリックしたときのイベントを処理する
            }
        }
    }

    @EventHandler
    public void openInventory(PlayerDropItemEvent e) {
        openNewGUI(e.getPlayer());
    }

}
