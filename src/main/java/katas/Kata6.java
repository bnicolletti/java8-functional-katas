package katas;

import java.util.stream.Collectors;

import model.BoxArt;
import util.DataUtil;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        Integer largest = DataUtil.getMovies().stream()
    		.flatMap(movie -> movie.getBoxarts().stream())
    		.map(boxart -> boxart.getWidth() * boxart.getHeight())
    		.reduce(Integer::max)
    		.orElse(0);

        return DataUtil.getMovies().stream()
    		.flatMap(movie -> movie.getBoxarts().stream())
    		.filter(boxart -> largest.equals(boxart.getWidth() * boxart.getHeight()))
    		.map(BoxArt::getUrl)
    		.collect(Collectors.joining());
    }
}
