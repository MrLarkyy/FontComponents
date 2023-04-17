package xyz.larkyy.fontcomponents.fontcomponents.components.impl;

import org.bukkit.entity.Player;
import xyz.larkyy.fontcomponents.fontcomponents.Utils;
import xyz.larkyy.fontcomponents.fontcomponents.components.FontComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.HolderWidth;

import java.util.function.Predicate;

public class ConditionalComponent extends FontComponent {

    private final String text;
    private final String font;
    private final int width;
    private final Predicate<Player> predicate;

    public ConditionalComponent(String text, String font, int width, Predicate<Player> predicate) {
        this.text = text;
        this.font = font;
        this.width = width;
        this.predicate = predicate;
    }

    public String generate(Player player, HolderWidth width) {

        if (predicate.test(player)) {
            width.add(this.width);
            return Utils.toJson(text,font);
        }
        return "";
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder{

        private String text;
        private String font;
        private int width;
        private Predicate<Player> predicate;

        private Builder() {
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
        public Builder setText(String text) {
            this.text = text;
            return this;
        }
        public ConditionalComponent build() {
            return new ConditionalComponent(text,font,width,predicate);
        }
    }
}
