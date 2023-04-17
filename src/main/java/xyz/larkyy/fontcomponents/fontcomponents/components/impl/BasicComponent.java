package xyz.larkyy.fontcomponents.fontcomponents.components.impl;

import org.bukkit.entity.Player;
import xyz.larkyy.fontcomponents.fontcomponents.Utils;
import xyz.larkyy.fontcomponents.fontcomponents.components.FontComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.HolderWidth;

public class BasicComponent extends FontComponent {

    private final String text;
    private final String font;
    private final int width;

    public BasicComponent(String text, String font, int width) {
        this.text = text;
        this.font = font;
        this.width = width;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String generate(Player player, HolderWidth width) {
        width.add(this.width);
        return Utils.toJson(text,font);
    }

    public static class Builder {

        private String text;
        private String font;
        private int width;

        private Builder() {
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
    }
}
