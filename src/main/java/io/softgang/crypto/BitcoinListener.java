package io.softgang.crypto;

import io.softgang.crypto.model.PriceData;
import io.softgang.util.MathUtil;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.MessageAction;

import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BitcoinListener extends ListenerAdapter {

    private BitcoinClient client;
    private Double previousAmount;
    public BitcoinListener(BitcoinClient client) {
        this.client = client;
    }
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
        executorService.scheduleAtFixedRate(() -> sendBitcoinPrice(channel), 0, 30, TimeUnit.SECONDS);
    }

    public void sendBitcoinPrice(TextChannel channel) {
        try {
            PriceData priceData = client.getBitcoinPrice();
            float price = priceData.getBpi().getUSD().getRate_float();
            double change = getPercentageDifference(Double.valueOf(price));
            DecimalFormat df = new DecimalFormat("#.##");
            MessageAction action = channel.sendMessage("The price of Bitcoin in USD is: " + df.format(price)+ " change: " + df.format(change) + "%");
            action.queue();
        } catch (Exception e) {
            channel.sendMessage("Kak isn't working.").queue();
            e.printStackTrace();
        }
    }

    public double getPercentageDifference(Double currentAmount){
        if(previousAmount != null) {
            double change = MathUtil.percentageDifference(previousAmount, currentAmount);
            previousAmount = currentAmount;
            return change;
        }
        previousAmount = currentAmount;
        return 0;
    }
}
