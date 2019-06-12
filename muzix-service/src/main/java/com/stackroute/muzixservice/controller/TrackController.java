package com.stackroute.muzixservice.controller;

import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.TrackAllReadyExistException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import com.stackroute.muzixservice.service.TrackService;
import org.mapstruct.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {
    @Autowired
    private TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }
    //get all records
    @GetMapping("tracks")
    public List<Track> getAllTracks(){
        return trackService.getAllTracks();
    }
    //add single track
    @PostMapping("/tracks")
    public ResponseEntity<?> addTrack(@RequestBody Track track) throws TrackAllReadyExistException
    {
        ResponseEntity responseEntity;
        trackService.addTrack(track);
        responseEntity=new ResponseEntity<Track>(track, HttpStatus.CREATED);
        return responseEntity;
    }
    //update given track
    @PutMapping("/tracks/{id}")
    public ResponseEntity<?> updateTracks(@PathVariable String id,@RequestBody Track track) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        trackService.updateTrack(id, track);
        responseEntity = new ResponseEntity<Track>(track, HttpStatus.CREATED);
        return responseEntity;
    }
    //delete track
    @DeleteMapping("/tracks/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable ("id") String id,@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        trackService.deleteTrack(id,track);
        responseEntity=new ResponseEntity<String>("Deleted Successfully", HttpStatus.CREATED);
        return responseEntity;
    }
    //display track by id
    @GetMapping("/tracks/{id}")
    public ResponseEntity<?> getById(@PathVariable ("id") String id) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        Track newTrack=null;
        newTrack=trackService.getById(id);
        responseEntity=new ResponseEntity<Track>(newTrack, HttpStatus.CREATED);

        return responseEntity;
    }
}
