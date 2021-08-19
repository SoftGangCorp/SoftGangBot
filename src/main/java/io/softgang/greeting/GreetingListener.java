package io.softgang.greeting;

import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GreetingListener extends ListenerAdapter {

    @Override
    public void onUserActivityStart(UserActivityStartEvent event) {

        if (event.getNewActivity().getName().equals("VALORANT")) {
            event.getJDA()
                    .getGuildById("476683371179802625")
                    .getTextChannelById("772206231976411146")
                    .sendMessage("@here " + event.getMember().getAsMention() + " started playing " + event.getNewActivity().getName() + ", JOIN THE FUCK UP!")
                    .queue();
        }
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
