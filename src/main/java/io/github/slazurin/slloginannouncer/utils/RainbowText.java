package io.github.slazurin.slloginannouncer.utils;

import java.util.Arrays;
import java.util.List;

public class RainbowText {
    private static final List<String> RAINBOW = Arrays.asList("§4", "§c", "§6", "§e", "§a", "§2", "§b", "§3", "§9", "§1", "§5", "§d");
    
    private int offset;
    private final String text;
    private String rainbowText;
    
    
    public RainbowText(String text) {
        this.offset = 0;
        this.text = text;
        this.rainbowText = "";
        this.applyRainbow();
    }
    
    private void applyRainbow() {
        String rainbowBuilder = "";
        char[] charArray = this.text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            String letter = Character.toString(c);
            if (!letter.equalsIgnoreCase(" ")) {
                rainbowBuilder +=  RAINBOW.get(this.offset) + letter;
                if (this.offset == RAINBOW.size() - 1) {
                    this.offset = 0;
                }
                else {
                    this.offset++;
                }
            }
            else {
                rainbowBuilder += letter;
            }
        }
        this.rainbowText = rainbowBuilder;
    }
    
    public String getText() {
        return this.text;
    }
    
    public String getRainbowText() {
        return this.rainbowText;
    }
    
    public void setOffset(int offset) {
        if (offset > RAINBOW.size() - 1 || offset < 0) {
            return;
        }
        this.offset = offset;
        this.applyRainbow();
    }
    
    public int getOffset() {
        return this.offset;
    }
}
