package java.domain.model.training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Workout {

    private final long id;
    private final String type;
    private final Date date;
    private final int clientId;
    private final List<Exercise> exercises;

    private Workout(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.date = builder.date;
        this.clientId = builder.clientId;
        this.exercises = builder.exercises;
    }

    @Override
    public String toString() {
        return "WorkoutJavaVersion(id=" + id + ", type='" + type + "', date=" + date +
                ", clientId=" + clientId + ", exercises=\n" + exercisesToString() + ")";
    }

    private String exercisesToString() {
        StringBuilder result = new StringBuilder();
        for (Exercise exercise : exercises) {
            result.append(exercise).append("\n");
        }
        return result.toString();
    }

    public static class Builder {

        private final String type;
        private final Date date;
        private final int clientId;
        private long id = 0L;
        private final List<Exercise> exercises = new ArrayList<>();

        public Builder(String type, Date date, int clientId) {
            this.type = type;
            this.date = date;
            this.clientId = clientId;
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder addExercise(Exercise exercise) {
            this.exercises.add(exercise);
            return this;
        }

        public Workout build() {
            return new Workout(this);
        }
    }
}
