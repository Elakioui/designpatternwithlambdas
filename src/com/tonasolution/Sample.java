package com.tonasolution;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

@SuppressWarnings("Unchecked")
class Camera {

    private Function<Color, Color> filter;

    public Camera(Function<Color, Color>... filters) {
        setFilters(filters);
    }

    private void setFilters( Function<Color, Color>... filters){
        filter = Stream.of(filters)
              .reduce(
                Function.identity(),
                Function::andThen
              );

    }

    public Color snap(Color input){
        return filter.apply(input);
    }
}

public class Sample {

    public static void printSnap( Camera camera ) {
        System.out.println(camera.snap(new Color(125 , 255, 255)));
    }

    public static void main(String[] args) {
        printSnap(new Camera());
        printSnap(new Camera(Color::brighter));
        printSnap(new Camera( Color::darker));

    }
}
