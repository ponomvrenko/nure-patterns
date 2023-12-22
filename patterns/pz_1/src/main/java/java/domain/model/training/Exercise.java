package java.domain.model.training;

import java.sql.Time; // Assuming you are using java.sql.Time for the 'time' field
import java.util.List;

public class Exercise {
    private long id;
    private String name;
    private byte sets;
    private short repetitionsFrom;
    private short repetitionsTo;
    private Short weightFrom;
    private Short weightTo;
    private Time time;
    private String notes;
    private List<CompletedSet> completedSets;
    private long workoutId;

    public Exercise() {
        this.id = 0;
        this.weightFrom = null;
        this.weightTo = null;
        this.time = null;
        this.notes = null;
        this.completedSets = null;
    }

    public Exercise(
            long id, String name, byte sets, short repetitionsFrom, short repetitionsTo,
            Short weightFrom, Short weightTo, Time time, String notes, List<CompletedSet> completedSets, long workoutId
    ) {
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.repetitionsFrom = repetitionsFrom;
        this.repetitionsTo = repetitionsTo;
        this.weightFrom = weightFrom;
        this.weightTo = weightTo;
        this.time = time;
        this.notes = notes;
        this.completedSets = completedSets;
        this.workoutId = workoutId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte getSets() {
        return sets;
    }

    public short getRepetitionsFrom() {
        return repetitionsFrom;
    }

    public short getRepetitionsTo() {
        return repetitionsTo;
    }

    public Short getWeightFrom() {
        return weightFrom;
    }

    public Short getWeightTo() {
        return weightTo;
    }

    public Time getTime() {
        return time;
    }

    public String getNotes() {
        return notes;
    }

    public List<CompletedSet> getCompletedSets() {
        return completedSets;
    }

    public long getWorkoutId() {
        return workoutId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSets(byte sets) {
        this.sets = sets;
    }

    public void setRepetitionsFrom(short repetitionsFrom) {
        this.repetitionsFrom = repetitionsFrom;
    }

    public void setRepetitionsTo(short repetitionsTo) {
        this.repetitionsTo = repetitionsTo;
    }

    public void setWeightFrom(Short weightFrom) {
        this.weightFrom = weightFrom;
    }

    public void setWeightTo(Short weightTo) {
        this.weightTo = weightTo;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setCompletedSets(List<CompletedSet> completedSets) {
        this.completedSets = completedSets;
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
}
