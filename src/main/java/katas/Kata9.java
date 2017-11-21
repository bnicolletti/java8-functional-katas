package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.InterestingMoment;
import util.DataUtil;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
    	return DataUtil.getMovieLists().stream()
    		.flatMap(movieList -> movieList.getVideos().stream())
    		.map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(), 
				"url", video.getBoxarts().stream().reduce((min, box) -> { 
        			int minSize = min.getWidth() * min.getHeight();
        			int boxSize = box.getWidth() * box.getHeight();
        			return (boxSize < minSize) ? box : min;
        		}).map(BoxArt::getUrl), 
				"time", video.getInterestingMoments().stream()
					.filter(interestingMoment -> "Middle".equals(interestingMoment.getType()))
					.map(InterestingMoment::getTime)
					.findFirst()))
    		.collect(Collectors.toList());
    }
}
