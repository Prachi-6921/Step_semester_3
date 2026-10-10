package encapsulation.assignment_problems;

class TrafficLight {
    private String color;
    private final String lightId;

    public TrafficLight(String lightId) {
        this.lightId = lightId;
        color = "RED";
    }

    public void next() {
        if (color.equals("RED"))
            color = "GREEN";
        else if (color.equals("GREEN"))
            color = "YELLOW";
        else
            color = "RED";
    }

    public String getColor() {
        return color;
    }

    public String getLightId() {
        return lightId;
    }
}

public class L4_TrafficLight {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());
    }
}
