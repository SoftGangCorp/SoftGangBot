package io.softgang.greeting;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GreetingListener extends ListenerAdapter {

    @Override
    public void onUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event) {

        if(event.getOldOnlineStatus().equals(OnlineStatus.OFFLINE)) {
            event.getJDA()
                    .getGuildById("476683371179802625")
                    .getTextChannelById("758351138449391686")
                    .sendMessage("Awe " + event.getMember().getAsMention() + " welcome back you nai")
                    .queue();
        }
    }

    @Override
    public void onUserActivityStart(UserActivityStartEvent event) {
        event.getJDA()
                .getGuildById("476683371179802625")
                .getTextChannelById("772206231976411146")
                .sendMessage("@here " + event.getMember().getAsMention() + " started " + event.getNewActivity().getName())
                .queue();
    }

    @Override
    public void onUserTyping(UserTypingEvent event) {
        if(event.getMember().getUser().getId().equals("582212162970189841")) {
            event.getChannel()
                    .sendMessage(event.getMember().getAsMention() + " nobody cares, shut the bloody hell up")
                    .queue();
        }
    }
}
