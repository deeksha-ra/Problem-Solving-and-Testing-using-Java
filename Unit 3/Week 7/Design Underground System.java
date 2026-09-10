import java.util.*;

class UndergroundSystem {
    static class CheckIn {
        String station;
        int time;
        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
    static class Route {
        int totalTime;
        int count;
        Route(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
    HashMap<Integer, CheckIn> checkIns;
    HashMap<String, Route> routes;
    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }
    public void checkOut(int id, String stationName, int t) {
        CheckIn in = checkIns.get(id);
        int travelTime = t - in.time;
        String route = in.station + "#" + stationName;
        if (routes.containsKey(route)) {
            Route r = routes.get(route);
            r.totalTime += travelTime;
            r.count++;
        }
         else {
            routes.put(route, new Route(travelTime, 1));
        }
        checkIns.remove(id);
    }
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "#" + endStation;
        Route r = routes.get(route);
        return (double) r.totalTime / r.count;
    }
}
Input
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
Expected
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
