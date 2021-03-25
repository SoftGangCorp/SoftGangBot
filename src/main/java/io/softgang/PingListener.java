package io.softgang;

import io.softgang.util.CollectionUtil;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Locale;

public class PingListener extends ListenerAdapter {
    private static  String [] swearWords = {"poes","fuck","naai","nai","tief","shit","dick","cunt"};
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getMember().getUser().isBot()) {
            Message msg = event.getMessage();
            if (CollectionUtil.stringContainsItemFromList(msg.getContentRaw(), swearWords)) {
                MessageChannel channel = event.getChannel();
                long time = System.currentTimeMillis();
                channel.sendMessage("Jy stop swearing you naai") /* => RestAction<Message> */
                        .queue();
            }
        }
    }
}
