package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableMap;

import model.Bookmark;
import model.Movie;
import util.DataUtil;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {
    public static List<Map> execute() {
    	return StreamUtils.zip(DataUtil.getMovies().stream().map(Movie::getId), 
				DataUtil.getBookMarks().stream().map(Bookmark::getId), 
				(movie, bookmark) -> ImmutableMap.of("videoId", movie, "bookmarkId", bookmark))
    		.collect(Collectors.toList());
    }
}
