package io.softgang.botInfo;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BotInfoListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("-servertime")||msg.getContentRaw().equals("-st"))
        {
            MessageChannel channel = event.getChannel();
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
            channel.sendMessage("Current Server Date/time: " + now.format(formatter)).queue();

        }
    }
}
