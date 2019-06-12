package com.stackroute.muzixservice.repository;

import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {
    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp() {
        track = new Track();
        track.setId("new");
        track.setName("Dhadak");
        track.setDescription("Nice songs");
    }

    @After
    public void tearDown() {

        trackRepository.deleteAll();
    }
    @Test
    public void testGetAllTracks(){
        Track t = new Track("New","Dhadak","Nice song");
        Track t1 = new Track("two","aapasa","Boring");
        trackRepository.save(t);
        trackRepository.save(t1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("New",list.get(0).getId());
    }
    @Test
    public void testAddTrack(){
        Track t = new Track("New","Dhadak","Nice song");
        Track t1 = new Track("New","Dhadak","Nice song");
        trackRepository.save(t);
        Assert.assertEquals(t,t1);
    }
    @Test
    public void testAddTrackFailure(){
        Track input = new Track("Old","Dhadak","Nice song");
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getId()).get();
        Assert.assertNotEquals(fetchUser,input);
    }
//    @Test
//    public void testDeleteTrack(){
//        Track input1 = new Track("New","Dhadak","Nice song");
//        Track input2 = new Track("two","aapasa","Boring");
//        trackRepository.save(input1);
//        trackRepository.save(input2);
//        trackRepository.delete(input1);
//        List<Track> list = trackRepository.findAll();
//        Assert.assertSame("New",list.get(0).getId());
//    }
    @Test
    public void testDeleteTrackFailure(){
        Track t = new Track("New","Dhadak","Nice song");
        Track t1 = new Track("two","aapasa","Boring");
        trackRepository.save(t);
        trackRepository.save(t1);
        trackRepository.delete(t1);
        List<Track> list = trackRepository.findAll();
        Assert.assertNotSame("two",list.get(0).getId());
    }
    @Test
    public void testGetById() throws TrackNotFoundException {
        Track t = new Track("New","Dhadak","Nice song");
        Track t1 = new Track("two","aapasa","Boring");
        trackRepository.save(t);
        trackRepository.save(t1);
        Track t3=trackRepository.findById("two").get();
        Assert.assertEquals(t1,t3);
    }
}