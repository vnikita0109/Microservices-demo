package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.TrackAllReadyExistException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl2 implements TrackService {
    //get all records
    @Override
    public List<Track> getAllTracks() {
        return null;
    }

    @Override
    public Track addTrack(Track track) throws TrackAllReadyExistException {
        return null;
    }

    @Override
    public Track updateTrack(String id, Track track) throws TrackNotFoundException {
        return null;
    }

    @Override
    public Track deleteTrack(String id,Track track) throws TrackNotFoundException {
        return null;
    }

    @Override
    public Track getById(String id) throws TrackNotFoundException {
        return null;
    }


}
