package io.softgang.crypto;

import io.softgang.crypto.model.PriceData;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BitcoinListener extends ListenerAdapter {

    Double previousPrice;
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("-price"))
        {
            TextChannel channel = event.getTextChannel();
            sendBitcoinPrice(channel);
        }
    }

    public void onReady(ReadyEvent event) {
        TextChannel channel = event.getJDA()
                .getGuildById("476683371179802625")
                .getTextChannelById("772206231976411146");
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> sendBitcoinPrice(channel), 0, 30, TimeUnit.MINUTES);
    }

    public void sendBitcoinPrice(TextChannel channel) {
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
