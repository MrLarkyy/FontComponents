package xyz.larkyy.fontcomponents.fontcomponents.components.impl;

import org.bukkit.entity.Player;
import xyz.larkyy.fontcomponents.fontcomponents.FontComponents;
import xyz.larkyy.fontcomponents.fontcomponents.components.FontComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.HolderWidth;

public class CenterComponent extends FontComponent {
    @Override
    public String generate(Player player, HolderWidth width) {
        return FontComponents.getInstance().getComponentRepository().generateOffset(-(width.getWidth()/2),width);
    }
}
