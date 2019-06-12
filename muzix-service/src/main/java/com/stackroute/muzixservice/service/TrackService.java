package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.TrackAllReadyExistException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    //display all records
    public List<Track> getAllTracks();
    //add new track
    public Track addTrack(Track track) throws TrackAllReadyExistException;
    //update given track
    public Track updateTrack(String id, Track track) throws TrackNotFoundException;
    //delete given track
    public Track deleteTrack(String id,Track track) throws TrackNotFoundException;
    //search record by name of track
    public Track getById(String id) throws TrackNotFoundException;
}
