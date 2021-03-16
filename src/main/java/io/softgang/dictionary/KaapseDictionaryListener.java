package io.softgang.dictionary;

import io.softgang.dictionary.model.WordData;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class KaapseDictionaryListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("-random"))
        {
            MessageChannel channel = event.getChannel();
            KaapseDictionaryClient client=new KaapseDictionaryClient();
            try {
                WordData wordData = client.getRandomWord();
                String wordId = wordData.getId();
                String description= wordData.getData().getExplanation()[0].getDefinition();
                channel.sendMessage("The Random Word Is : **" + wordId + "**\nMeaning: " + description).queue();
            } catch (Exception e) {
                channel.sendMessage("Kak isn't working.").queue();
                e.printStackTrace();
            }
        }
    }
}