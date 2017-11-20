package katas;

import java.util.List;
import java.util.stream.Collectors;

import model.Movie;
import util.DataUtil;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<Integer> execute() {
    	return DataUtil.getMovies().stream()
        		.filter(mv -> mv.getRating().equals(5.0))
        		.map(Movie::getId)
        		.collect(Collectors.toList());
    }
}
