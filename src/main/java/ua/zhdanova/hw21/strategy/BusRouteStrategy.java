package ua.zhdanova.hw21.strategy;

public class BusRouteStrategy implements RouteStrategy {
    @Override
    public String calculateRoute(String destination) {
        return "Bus rout to: " + destination;
    }
}
