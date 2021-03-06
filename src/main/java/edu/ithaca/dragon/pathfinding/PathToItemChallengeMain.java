package edu.ithaca.dragon.pathfinding;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.AreaGridFactory;
import edu.ithaca.dragon.pathfinding.areagrid.Location;
import edu.ithaca.dragon.pathfinding.challenge.PathToItemChallenge;
import edu.ithaca.dragon.pathfinding.io.AreaGridRecord;
//import edu.ithaca.dragon.pathfinding.pathfinder.BreadthFirstGlobalPathFinder;
//import edu.ithaca.dragon.pathfinding.pathfinder.DepthFirstGlobalPathFinder;
//import edu.ithaca.dragon.pathfinding.pathfinder.UseLocalForGlobalPathFinder;
//import edu.ithaca.dragon.pathfinding.pathfinder.PathFInderAgentCristian;
import edu.ithaca.dragon.pathfinding.pathfinder.DepthFirstAgent;
import edu.ithaca.dragon.pathfinding.pathfinder.GlobalPathFinder;
import edu.ithaca.dragon.util.JsonUtil;

public class PathToItemChallengeMain {

    public static void main(String[] args) throws IOException {
        List<GlobalPathFinder> pathFinders = Arrays.asList(new DepthFirstAgent());
        
        // Use the defaults
        // System.out.println(PathToItemChallenge.pathToItemChallenge(pathFinders));
        
        //Create a grid and save it, choose my own start and end points
        AreaGrid areaGrid = AreaGridFactory.createLoopyMaze(15, 15, 0.8);
        JsonUtil.toJsonFile("src/test/resources/test2.json", new AreaGridRecord(areaGrid.gridCopy()));
        System.out.println(areaGrid.createDisplayString());
        System.out.println(PathToItemChallenge.pathToItemChallenge(pathFinders, areaGrid, new Location(1,1), new Location(8, 8)));

        // Load a saved grid, choose my own start and end points
        // AreaGrid areaGrid = new AreaGrid(JsonUtil.fromJsonFile("src/test/resources/test1.json", AreaGridRecord.class).getGrid());
        // System.out.println(areaGrid.createDisplayString());
        // System.out.println(PathToItemChallenge.pathToItemChallenge(pathFinders, areaGrid, new Location(1,1), new Location(1, 13)));

    }
}

//To display within your own PathFinder agent
// System.out.println(PathToItemChallenge.createDisplayString(Arrays.asList(aPath), "x", map, start, goal));
// System.out.print("Enter to continue:");
// new Scanner(System.in).nextLine();
