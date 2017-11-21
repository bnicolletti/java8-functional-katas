package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import util.DataUtil;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
    	return DataUtil.getMovieLists().stream()
    		.flatMap(movieList -> movieList.getVideos().stream())
    		.map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(), 
    			"boxart", video.getBoxarts().stream()
    			.filter(boxart -> boxart.getWidth().equals(150) && boxart.getHeight().equals(200))
    			.map(boxart -> boxart.getUrl()).collect(Collectors.joining())))
    		.collect(Collectors.toList());
    }
}
