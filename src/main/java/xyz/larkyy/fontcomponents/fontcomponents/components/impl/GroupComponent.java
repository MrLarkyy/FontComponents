package xyz.larkyy.fontcomponents.fontcomponents.components.impl;

import org.bukkit.entity.Player;
import xyz.larkyy.fontcomponents.fontcomponents.FontComponents;
import xyz.larkyy.fontcomponents.fontcomponents.components.FontComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.HolderWidth;

import java.util.List;

public class GroupComponent extends FontComponent {

    private final List<FontComponent> components;
    private boolean centered;

    public GroupComponent(List<FontComponent> components, boolean centered) {
        this.components = components;
        this.centered = centered;
    }

    @Override
    public String generate(Player player, HolderWidth width) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (FontComponent component : components) {
            String value = component.generate(player,width);
            if (value == null || value.isEmpty()) {
                continue;
            }
            if (!first) {
                stringBuilder.append(",");
            } else {
                first = false;
            }
            stringBuilder.append(value);
        }
        if (centered) {
            FontComponents.getInstance().getComponentRepository()
                    .generateOffset((width.getWidth())/2,width);
        }

        return stringBuilder.toString();
    }
}
