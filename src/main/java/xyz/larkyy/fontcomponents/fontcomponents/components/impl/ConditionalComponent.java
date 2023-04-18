package xyz.larkyy.fontcomponents.fontcomponents.components.impl;

import org.bukkit.entity.Player;
import xyz.larkyy.fontcomponents.fontcomponents.FontComponents;
import xyz.larkyy.fontcomponents.fontcomponents.Utils;
import xyz.larkyy.fontcomponents.fontcomponents.components.FontComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.HolderWidth;

import java.util.function.Predicate;

public class ConditionalComponent extends FontComponent {

    private final String text;
    private final String font;
    private final String color;
    private final int width;
    private boolean centered;
    private final Predicate<Player> predicate;

    public ConditionalComponent(String text, String font, String color, int width, Predicate<Player> predicate, boolean centered) {
        this.text = text;
        this.font = font;
        this.color = color;
        this.width = width;
        this.predicate = predicate;
        this.centered = centered;
    }

    public void setCentered(boolean centered) {
        this.centered = centered;
    }

    public String generate(Player player, HolderWidth width) {
        String string = "";
        if (predicate.test(player)) {
            width.add(this.width);
            if (centered) {
                string += FontComponents.getInstance().getComponentRepository()
                        .generateOffset(-(width.getWidth()/2),width);
                string += ",";
            }
            return string+Utils.toJson(text,font,color);
        }
        return "";
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder{

        private String text;
        private String font;
        private String color;
        private int width;
        private boolean centered = false;
        private Predicate<Player> predicate;

        private Builder() {
        }

        public Builder setCentered(boolean centered) {
            this.centered = centered;
            return this;
        }

        public Builder setPredicate(Predicate<Player> predicate) {
            this.predicate = predicate;
            return this;
        }
        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }
        public Builder setFont(String font) {
            this.font = font;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }
        public ConditionalComponent build() {
            return new ConditionalComponent(text,font,color,width,predicate,centered);
        }
    }
}
