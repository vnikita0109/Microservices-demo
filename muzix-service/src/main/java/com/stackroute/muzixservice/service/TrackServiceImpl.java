package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.TrackAllReadyExistException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import com.stackroute.muzixservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Primary
@Service
public class TrackServiceImpl implements TrackService {
    @Autowired

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    //get all records
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    //add single track
    @Override
    public Track addTrack(Track track) throws TrackAllReadyExistException {
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAllReadyExistException("Track already exist!!!");
        }
        return trackRepository.save(track);
    }

    //update given track
    @Override
    public Track updateTrack(String id, Track track) throws TrackNotFoundException {
        if (trackRepository.existsById(track.getId()))
            track.setDescription(track.getDescription());
        if (track == null)
            throw new TrackNotFoundException("Track not exist!!!");
        return trackRepository.save(track);
    }

    //delete given track
    @Override
    public Track deleteTrack(String id, Track track) throws TrackNotFoundException {
        track = null;
        Optional optional = trackRepository.findById(id);
        if (optional.isPresent()) {
            track = trackRepository.findById(id).get();
            trackRepository.deleteById(id);
        } else {
            throw new TrackNotFoundException("Track does not exist");
        }
        return track;
    }

    //display track by id
    @Override
    public Track getById(String id) throws TrackNotFoundException {
        Track track = null;
        Optional optional = trackRepository.findById(id);
        if (optional.isPresent()) {
            track = trackRepository.findById(id).get();
            trackRepository.deleteById(id);
        } else {
            throw new TrackNotFoundException("Track does not exist");
        }
        return track;
    }
}

