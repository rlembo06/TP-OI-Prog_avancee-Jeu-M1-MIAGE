package movements;

import annotations.movements.Movement;
import annotations.movements.RandomPath;
import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

@Movement
public class Random {

    @RandomPath
    public PathTransition createPathPlayer(Node shape) {
        PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(javafx.util.Duration.millis(1200));
        pathTransition.setPath(createRandomPath());
        pathTransition.setNode(shape);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(2);
        pathTransition.setAutoReverse(true);
        pathTransition.setOnFinished(e -> {
            pathTransition.setPath(createRandomPath());
            pathTransition.play();
        });
        return pathTransition;
    }

    private Path createRandomPath() {
        java.util.Random ran = new java.util.Random();
        int loc = ran.nextInt(600 - 400 + 1) + 300;  // min=400 , max=600

        Path path = new Path();
        path.getElements().add(new MoveTo(ran.nextInt(100), ran.nextInt(100)));
        path.getElements().add(new LineTo(loc, ran.nextInt(350)));

        return path;
    }
}
