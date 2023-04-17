package xyz.larkyy.fontcomponents.fontcomponents;

public class Utils {

    public static String toJson(String text, String font) {
        if (font == null) {
            font = "minecraft:default";
        }
        if (text == null) {
            text = "";
        }
        return "{\"text\":\""+text+"\",\"font\":\""+font+"\"}";
    }

}
