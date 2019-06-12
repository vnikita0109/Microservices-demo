package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.GlobalException;
import com.stackroute.muzixservice.exception.TrackAllReadyExistException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import com.stackroute.muzixservice.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {
    private Track track;

    //Create a mock for UserRepository
    @Mock
    private TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private TrackServiceImpl trackService;
    List<Track> list = null;

    private Optional optional;
    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setId("New");
        track.setName("Dhadak");
        track.setDescription("Nice");
        list = new ArrayList<>();
        list.add(track);
        optional=Optional.of(track);
    }
    @After
    public void teardown()
    {
     //   track=null;
        optional=null;
    }
    @Test
    public void addTrackTestSuccess() throws TrackAllReadyExistException {

        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedUser = trackService.addTrack(track);
        Assert.assertEquals(track,savedUser);
        System.out.println("savedUser" + savedUser);
        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }
    @Test
    public void addTrackTestFailure() throws TrackAllReadyExistException {
        when(trackRepository.save((Track)any())).thenReturn(null);
        Track savedUser = trackService.addTrack(track);
        System.out.println("savedUser=" + savedUser);
  //      Assert.assertNotEquals(track,savedUser);
    }
    @Test
    public void getAllTracks(){
        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> userlist = trackService.getAllTracks();
        Assert.assertEquals(list,userlist);
    }
    @Test
    public void deleteTrackTest() throws TrackNotFoundException {
        when(trackRepository.findById(track.getId())).thenReturn(optional);
        Track deletedtrack=trackService.deleteTrack(track.getId(),track);
        Assert.assertEquals("New",deletedtrack.getId());
        verify(trackRepository,times(2)).findById(track.getId());
        verify(trackRepository,times(1)).deleteById(track.getId());
    }
    @Test
    public void UpdateTrackTest() throws TrackNotFoundException {
        trackRepository.save(track);
        Track savedUser = trackService.updateTrack(track.getId(),track);
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> userlist = trackService.getAllTracks();
        Assert.assertEquals(list,userlist);
    }
    @Test
    public void getById() throws TrackNotFoundException {
        when(trackRepository.findById(track.getId())).thenReturn(optional);
        Track t=trackService.getById(track.getId());
        Assert.assertEquals("New",t.getId());;
    }
}
