package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import util.DataUtil;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map> execute() {
    	return DataUtil.getMovies().stream()
        		.map(mv -> ImmutableMap.of("id", mv.getId(), "title", mv.getTitle()))
        		.collect(Collectors.toList());
    }
}
