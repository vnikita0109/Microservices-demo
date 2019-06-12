package com.stackroute.muzixservice.listener;

import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EventHandlerCommListener implements CommandLineRunner {
    @Value("${track2.id}")
    private String id;
    @Value("${track2.name}")
    private String name;
    @Value("${track2.description}")
    private String description;

    Track track=new Track();
    @Autowired
    TrackRepository trackRepository;
    @Override
    public void run(String... args) throws Exception {
        track.setId(id);
        track.setName(name);
        track.setDescription(description);
        trackRepository.save(track);
    }
}
