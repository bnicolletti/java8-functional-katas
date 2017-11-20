package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Create a datastructure from the given data:

    This time we have 4 seperate arrays each containing lists, videos, boxarts, and bookmarks respectively.
    Each object has a parent id, indicating its parent.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id, title, bookmark time, and smallest boxart url.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber",
                    "time": 32432,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"
                },
                {
                    "id": 675465,
                    "title": "Fracture",
                    "time": 3534543,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard",
                    "time": 645243,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys",
                    "time": 984934,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos(), DataUtil.getBoxArts(), DataUtil.getBookmarkList()
    Output: the given datastructure
*/
public class Kata11 {
    public static List<Map> execute() {
    	return DataUtil.getLists().stream()
    		.map(ls -> ImmutableMap.of("name", ls.get("name"), "videos", 
				DataUtil.getVideos().stream()
				.filter(mv -> mv.get("listId").equals(ls.get("id")))
				.map(mv -> ImmutableMap.of("id", mv.get("id"), "title", mv.get("title"), 
					"time", DataUtil.getBookmarkList().stream()
					.filter(bk -> bk.get("videoId").equals(mv.get("id")))
					.map(bk -> bk.get("time")).collect(Collectors.toList()).get(0),
					"boxart", DataUtil.getBoxArts().stream()
					.filter(bx -> bx.get("videoId").equals(mv.get("id")))
					.reduce((min, box) -> { 
	        			int minSize = (Integer) min.get("width") * (Integer) min.get("height");
	        			int boxSize = (Integer) box.get("width") * (Integer) box.get("height");
	        			return (boxSize < minSize) ? box : min;
        			}).map(bx -> bx.get("url")).get()))
				.collect(Collectors.toList())))
    		.collect(Collectors.toList());
    }
}
