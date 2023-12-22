package java.domain.model.training;

import java.sql.Time;

public class CompletedSet {
    private long id;
    private byte setNumber;
    private short repetitions;
    private Short weight;
    private Time time;
    private String notes;
    private long exerciseId;

    public CompletedSet() {
        this.id = 0;
        this.weight = null;
        this.time = null;
        this.notes = null;
    }

    public CompletedSet(long id, byte setNumber, short repetitions, Short weight, Time time, String notes, long exerciseId) {
        this.id = id;
        this.setNumber = setNumber;
        this.repetitions = repetitions;
        this.weight = weight;
        this.time = time;
        this.notes = notes;
        this.exerciseId = exerciseId;
    }

    public long getId() {
        return id;
    }

    public byte getSetNumber() {
        return setNumber;
    }

    public short getRepetitions() {
        return repetitions;
    }

    public Short getWeight() {
        return weight;
    }

    public Time getTime() {
        return time;
    }

    public String getNotes() {
        return notes;
    }

    public long getExerciseId() {
        return exerciseId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSetNumber(byte setNumber) {
        this.setNumber = setNumber;
    }

    public void setRepetitions(short repetitions) {
        this.repetitions = repetitions;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setExerciseId(long exerciseId) {
        this.exerciseId = exerciseId;
    }
}
