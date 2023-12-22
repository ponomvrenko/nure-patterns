package data.dao;

import domain.model.training.CompletedSet;

import java.util.List;

public interface CompletedSetsDao extends BaseDao<CompletedSet> {

    List<CompletedSet> getByExerciseId(long exerciseId);
}
