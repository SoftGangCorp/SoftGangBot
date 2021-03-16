package io.softgang.crypto;

import io.softgang.crypto.model.PriceData;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BitcoinListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("-price"))
        {
            MessageChannel channel = event.getChannel();
            BitcoinClient client=new BitcoinClient();
            try {
                PriceData priceData = client.getBitcoinPrice();
                String price = priceData.getBpi().getUSD().getRate();
                channel.sendMessage("The price of Bitcoin in USD is: " + price).queue();
            } catch (Exception e) {
                channel.sendMessage("Kak isn't working.").queue();
                e.printStackTrace();
            }
        }
    }
}
