package io.softgang.weather;

import io.softgang.crypto.BitcoinListener;
import io.softgang.weather.model.WeatherData;
import io.softgang.weather.model.WeatherDescriptionData;
import io.softgang.weather.model.WeatherMainData;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherListener extends ListenerAdapter {


    private WeatherClient client;

    public WeatherListener(WeatherClient client){this.client = client;}
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("-weather"))
        {
            TextChannel channel = event.getTextChannel();
            sendWeatherDetails(channel);
        }
    }
    public void onReady(ReadyEvent event) {
        TextChannel channel = event.getJDA()
                .getGuildById("476683371179802625")
                .getTextChannelById("758351138449391686");

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        LocalDateTime midNight = LocalDate.now().atStartOfDay();
        if(LocalDate.now().isAfter(ChronoLocalDate.from(LocalDate.now().atStartOfDay().plusHours(6)))){
            midNight = midNight.plusDays(1);
        }

        Long sixAm= LocalDateTime.now().until(midNight.plusHours(6),ChronoUnit.MINUTES);
        executorService.scheduleAtFixedRate(() -> sendWeatherDetails(channel), sixAm, 1440, TimeUnit.MINUTES);

    }
    public void sendWeatherDetails(TextChannel channel){
        try{
            WeatherData weatherData = client.getWeatherData();
            StringBuilder sb = new StringBuilder();
            sb.append("The weather is currently  : **" + weatherData.getMain().getFeels_like() + "°C** in: " + weatherData.getName() +" - " + weatherData.getSys().getCountry() + "\n");
            sb.append("The weather description : **" + weatherData.getWeather()[0].getDescription() + "**\n" );
            sb.append("with a low of: **" + weatherData.getMain().getTemp_min() + "°C**\n" );
            sb.append("and a high of:** " + weatherData.getMain().getTemp_max() + "°C**\n" );
            sb.append("and wind speeds reaching: **" + weatherData.getWind().getSpeed() + " m/s**");
            channel.sendMessage(sb.toString()).queue();
        } catch (Exception e) {
            channel.sendMessage("There's no fokken weather today man").queue();
            e.printStackTrace();
        }
    }
}
