package com.stackroute.muzixservice.listener;

import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config.properties")
public class EventHandlerAppListener implements ApplicationListener<ContextRefreshedEvent> {
    Track track=new Track();
    @Autowired
    TrackRepository trackRepository;
    @Autowired
    private Environment environment;
    @Override

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            track.setId(environment.getProperty("track1.id"));
            track.setName(environment.getProperty("track1.name"));
            track.setDescription(environment.getProperty("track1.description"));
            trackRepository.save(track);

    }
}
