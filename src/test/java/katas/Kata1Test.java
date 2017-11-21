package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;


public class Kata1Test {

    @Test
    public void testSize() {
        Assert.assertThat(Kata1.execute().size(), equalTo(4));
    }
    
    @Test
    public void testResult() {
    	List<Map> videos = new ArrayList<>();
    	videos.add(ImmutableMap.of("id", 70111470, "title", "Die Hard"));
    	videos.add(ImmutableMap.of("id", 654356453, "title", "Bad Boys"));
    	videos.add(ImmutableMap.of("id", 65432445, "title", "The Chamber"));
    	videos.add(ImmutableMap.of("id", 675465, "title", "Fracture"));
        Assert.assertThat(Kata1.execute(), equalTo(videos));
    }
    
}
