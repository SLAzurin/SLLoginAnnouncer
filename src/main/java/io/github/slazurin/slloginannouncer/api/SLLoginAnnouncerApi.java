package io.github.slazurin.slloginannouncer.api;

public class SLLoginAnnouncerApi {
    private final String[] loginMessages;
    
    public SLLoginAnnouncerApi() {
        this.loginMessages = new String[]{
            "GUESS WHO'S HERE?! <NAME> IS HERE!",
            "~\\o/ <NAME> has joined the partaaay! WoOHoO!! \\o/~",
            "<NAME> has arrived! Quick, PINATA TIME!!",
            "Quick, hide! <NAME> has appeared!! EEK >A<!!",
            "<NAME> has joined the game. Yep, That's it.",
            "Oh wow- It's <NAME>! HELLO <NAME>!!",
            "Welcome back, <NAME>!",
            "<NAME>! <NAME>! <NAME>! <NAME>!"
        };
    }
    
    public String getRandomLoginMessage() {
        return this.loginMessages[(int) (Math.random() * this.loginMessages.length)];
    }
    
    
    
    
}
