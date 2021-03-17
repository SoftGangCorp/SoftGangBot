package io.softgang;


import io.softgang.crypto.BitcoinListener;
import io.softgang.dictionary.KaapseDictionaryListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main {
    public static void main(String[] args) {
       JDABuilder builder = JDABuilder.createDefault(System.getenv("BOT_TOKEN"));

        // Disable parts of the cache
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        // Enable the bulk delete event
        builder.setBulkDeleteSplittingEnabled(false);
        // Disable compression (not recommended)
        builder.setCompression(Compression.NONE);
        // Set activity (like "playing Something")
        builder.setActivity(Activity.watching("Google"));

        try {
            builder
                    .addEventListeners(new PingListener())
                    .addEventListeners(new KaapseDictionaryListener())
                    .addEventListeners(new BitcoinListener())
                    .build();
        }
        catch (Exception except){
            except.printStackTrace();
        }

    }

}
