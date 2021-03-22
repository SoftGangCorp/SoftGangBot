package io.softgang.exchange;

import io.softgang.exchange.model.ExchangeData;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.text.DecimalFormat;

public class ExchangeListener extends ListenerAdapter {
    private ExchangeClient client;
    public ExchangeListener(ExchangeClient client){this.client=client;}
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        Message msg = event.getMessage();
        if (msg.getContentRaw().startsWith("!exchange"))
        {
            String currency = "USD";
            String[] commands = msg.getContentRaw().split(" ");
            if (commands.length > 1) {
                currency = commands[1].toUpperCase();
            }
            MessageChannel channel = event.getChannel();
            try {
                ExchangeData exchangeData = client.getExchangeRate();
                if (exchangeData.getRates().containsKey(currency)){
                    Double currencyValue = exchangeData.getRates().get(currency);
                    DecimalFormat df = new DecimalFormat("#.##");
                    channel.sendMessage("The value of one " + currency + " is : **R" + df.format(1/currencyValue) +"**" ).queue();
                } else {
                    channel.sendMessage("Currency not available").queue();
                }
            } catch (Exception e) {
                channel.sendMessage("Kak isn't working.").queue();
                e.printStackTrace();
            }
        }
    }
}
