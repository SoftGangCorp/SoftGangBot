package io.softgang;


import io.softgang.crypto.BitcoinClient;
import io.softgang.crypto.BitcoinListener;
import io.softgang.dictionary.KaapseDictionaryClient;
import io.softgang.dictionary.KaapseDictionaryListener;
import io.softgang.exchange.ExchangeClient;
import io.softgang.exchange.ExchangeListener;
import io.softgang.greeting.GreetingListener;
import io.softgang.weather.WeatherClient;
import io.softgang.weather.WeatherListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main {
    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault(System.getenv("BOT_TOKEN"));

        // Disable parts of the cache
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.enableCache(CacheFlag.ACTIVITY);
        builder.setMemberCachePolicy(MemberCachePolicy.ONLINE);
        // Enable the bulk delete event
        builder.setBulkDeleteSplittingEnabled(false);
        // Disable compression (not recommended)
        builder.setCompression(Compression.NONE);
        // Set activity (like "playing Something")
        builder.setActivity(Activity.watching("Google"));
        builder.enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS));

        try {
            builder
                    .addEventListeners(new PingListener())
                    .addEventListeners(new KaapseDictionaryListener(new KaapseDictionaryClient()))
                    .addEventListeners(new BitcoinListener(new BitcoinClient()))
                    .addEventListeners(new GreetingListener())
                    .addEventListeners(new ExchangeListener(new ExchangeClient()))
                    .addEventListeners(new WeatherListener(new WeatherClient()))
                    .build();
        }
        catch (Exception except){
            except.printStackTrace();
        }

    }

}
