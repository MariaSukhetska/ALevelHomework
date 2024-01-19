package ua.zhdanova.hw21.strategy;

public class Main {
    public static void main(String[] args) {
        // Використання Strategy
        Navigator navigator = new Navigator(new BusRouteStrategy());
        System.out.println("Bus route: " + navigator.calculateRoute("Destination: Kharkiv - Lutsk"));

        navigator.setRouteStrategy(new WalkRouteStrategy());
        System.out.println("Walking route: " + navigator.calculateRoute("Destination ATB -> walking outside on the street"));

        navigator.setRouteStrategy(new CarRouteStrategy());
        System.out.println("Car route: " + navigator.calculateRoute("Destination Kyiv -> Lutsk -> Odessa -> Kharkiv"));
    }
}

