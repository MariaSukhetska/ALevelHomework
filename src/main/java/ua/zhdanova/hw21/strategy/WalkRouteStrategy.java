package ua.zhdanova.hw21.strategy;

public class WalkRouteStrategy implements RouteStrategy {
    @Override
    public String calculateRoute(String destination) {
        return "Walking route to: " + destination;
    }
}
