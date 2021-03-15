package io.softgang;


import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main {
    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault("ODIxMDk0MjgyOTkxMjM5MTg5.YE-tpA.VO59yhqUTmiBxWrt5i8xveGZhIM");

        // Disable parts of the cache
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        // Enable the bulk delete event
        builder.setBulkDeleteSplittingEnabled(false);
        // Disable compression (not recommended)
        builder.setCompression(Compression.NONE);
        // Set activity (like "playing Something")
        builder.setActivity(Activity.watching("Google"));

        try {
            builder.addEventListeners(new PingListener()).build();

        }
        catch (Exception except){
            except.printStackTrace();
        }
    }

}
