package data.factory.impl;

import data.dao.ExercisesDao;
import data.dao.impl.MySqlExercisesDaoImpl;
import data.factory.DaoFactory;
import data.utils.MySqlDBConnector;

public class MySqlExercisesDaoFactory implements DaoFactory<ExercisesDao> {

    @Override
    public ExercisesDao create() {
        return new MySqlExercisesDaoImpl(MySqlDBConnector.getInstance());
    }
}