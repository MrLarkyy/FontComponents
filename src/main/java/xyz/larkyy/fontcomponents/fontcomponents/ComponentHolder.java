package xyz.larkyy.fontcomponents.fontcomponents;

import org.bukkit.entity.Player;
import xyz.larkyy.fontcomponents.fontcomponents.components.FontComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.HolderWidth;

import java.util.ArrayList;
import java.util.List;

public class ComponentHolder {

    private final List<FontComponent> components;

    public ComponentHolder(List<FontComponent> components) {
        this.components = components;
    }

    public ComponentHolder() {
        this.components = new ArrayList<>();
    }

    public List<FontComponent> getComponents() {
        return components;
    }
    public void addComponent(FontComponent component) {
        this.components.add(component);
    }

    public String generate(Player player) {
        HolderWidth width = new HolderWidth();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[\"\"");
        if (components == null) {
            return "";
        }
        for (FontComponent component : components) {
            stringBuilder.append(",");
            stringBuilder.append(component.generate(player,width));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
