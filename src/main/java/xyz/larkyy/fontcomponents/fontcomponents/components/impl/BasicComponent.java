package xyz.larkyy.fontcomponents.fontcomponents.components.impl;

import org.bukkit.entity.Player;
import xyz.larkyy.fontcomponents.fontcomponents.FontComponents;
import xyz.larkyy.fontcomponents.fontcomponents.Utils;
import xyz.larkyy.fontcomponents.fontcomponents.components.FontComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.HolderWidth;

public class BasicComponent extends FontComponent {

    private final String text;
    private final String font;
    private boolean centered;
    private final int width;

    public BasicComponent(String text, String font, int width, boolean centered) {
        this.text = text;
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
        if (centered) {
            FontComponents.getInstance().getComponentRepository()
                    .generateOffset((width.getWidth()+this.width)/2,width);
        }
        width.add(this.width);
        return Utils.toJson(text,font);
    }

    public static class Builder {

        private String text;
        private String font;
        private int width;
        private boolean centered = false;

        private Builder() {
        }

        public Builder setCentered(boolean centered) {
            this.centered = centered;
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
            return new BasicComponent(text,font,width,centered);
        }
    }
}
