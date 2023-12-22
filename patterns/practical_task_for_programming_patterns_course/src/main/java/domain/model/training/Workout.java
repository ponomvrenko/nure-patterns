package domain.model.training;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private Date date;
    private int clientId;

    @ManyToMany
    @JoinTable(name = "workouts_exercises",
            joinColumns = @JoinColumn(name = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private List<Exercise> exercises;

    public Workout() {
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public int getClientId() {
        return clientId;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    @Override
    public String toString() {
        return "Workout(id=" + id + ", type='" + type + "', date=" + date +
                ", clientId=" + clientId + ", exercises=\n" + exercisesToString() + ")";
    }

    private String exercisesToString() {
        StringBuilder result = new StringBuilder();
        for (Exercise exercise : exercises) {
            result.append(exercise).append("\n");
        }
        return result.toString();
    }
}
