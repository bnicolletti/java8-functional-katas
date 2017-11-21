package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import util.DataUtil;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
    	return DataUtil.getMovieLists().stream()
    		.flatMap(movieList -> movieList.getVideos().stream())
    		.map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(), 
    			"url", video.getBoxarts().stream().reduce((min, box) -> { 
        			int minSize = min.getWidth() * min.getHeight();
        			int boxSize = box.getWidth() * box.getHeight();
        			return (boxSize < minSize) ? box : min;
    			}).map(BoxArt::getUrl)))
    		.collect(Collectors.toList());
    }
}
