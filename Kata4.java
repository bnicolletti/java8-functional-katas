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
        		.flatMap(mv -> mv.getVideos().stream())
        		.map(mv -> ImmutableMap.of("id", mv.getId(), "title", mv.getTitle(), 
        			"boxart", mv.getBoxarts().stream()
        			.filter(bx -> bx.getWidth().equals(150) && bx.getHeight().equals(200))
        			.map(bx -> bx.getUrl()).collect(Collectors.joining())))
        		.collect(Collectors.toList());
    }
}
