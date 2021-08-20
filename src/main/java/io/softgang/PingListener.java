package io.softgang;

import io.softgang.util.CollectionUtil;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingListener extends ListenerAdapter {
    private static  String [] swearWords = {"poes","fuck","naai","nai","tief","shit","dick","cunt"};
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getMember().getUser().isBot()) {
            Message msg = event.getMessage();

            if(event.getMember().getUser().getId().equals("195588825240698880") && CollectionUtil.stringContainsItemFromList(msg.getContentRaw(), swearWords))
            {
                event.getChannel()
                        .sendMessage(event.getMember().getAsMention() + " you better than this")
                        .queue();
            }
            else if (CollectionUtil.stringContainsItemFromList(msg.getContentRaw(), swearWords)) {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("Jy stop swearing you naai") /* => RestAction<Message> */
                        .queue();
            }
        }
    }
}


