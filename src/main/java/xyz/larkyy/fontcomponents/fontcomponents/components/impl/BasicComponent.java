package xyz.larkyy.fontcomponents.fontcomponents.components.impl;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.larkyy.fontcomponents.fontcomponents.FontComponents;
import xyz.larkyy.fontcomponents.fontcomponents.Utils;
import xyz.larkyy.fontcomponents.fontcomponents.components.FontComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.HolderWidth;

public class BasicComponent extends FontComponent {

    private final String text;
    private final String font;
    private final String color;
    private boolean centered;
    private final int width;

    public BasicComponent(String text, String font, String color, int width, boolean centered) {
        this.text = text;
        this.color = color;
        this.font = font;
        this.width = width;
        this.centered = centered;
    }

    public void setCentered(boolean centered) {
        this.centered = centered;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String generate(Player player, HolderWidth width) {
        String string = "";
        width.add(this.width);
        if (centered) {
            string += FontComponents.getInstance().getComponentRepository()
                    .generateOffset(-(width.getWidth()/2),width);
            string+=",";
        }
        return string+Utils.toJson(text,font,color);
    }

    public static class Builder {

        private String text;
        private String font;
        private String color;
        private int width;
        private boolean centered = false;

        private Builder() {
        }

        public Builder setCentered(boolean centered) {
            this.centered = centered;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
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
        public BasicComponent build() {
            return new BasicComponent(text,font,color,width,centered);
        }
    }
}
