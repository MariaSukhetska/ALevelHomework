package ua.zhdanova.hw21.strategy;

public class Navigator {
    private RouteStrategy routeStrategy;

    public Navigator(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public String calculateRoute(String destination) {
        return routeStrategy.calculateRoute(destination);
    }
}
