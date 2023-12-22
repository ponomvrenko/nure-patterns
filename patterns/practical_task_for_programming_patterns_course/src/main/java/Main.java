import data.dao.ClientsDao;
import data.dao.CompletedSetsDao;
import data.dao.ExercisesDao;
import data.dao.RequestsDao;
import data.dao.TrainersDao;
import data.dao.WorkoutsDao;
import data.factory.impl.MySqlClientsDaoFactory;
import data.factory.impl.MySqlCompletedSetsDaoFactory;
import data.factory.impl.MySqlExercisesDaoFactory;
import data.factory.impl.MySqlRequestsDaoFactory;
import data.factory.impl.MySqlTrainersDaoFactory;
import data.factory.impl.MySqlWorkoutsDaoFactory;
import domain.model.training.CompletedSet;
import domain.model.training.Exercise;
import domain.model.training.Time;
import domain.model.training.Workout;
import domain.model.users.RequestDB;
import domain.model.users.RequestStatus;
import domain.model.users.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TrainersDao trainersDao = new MySqlTrainersDaoFactory().create();
        ClientsDao clientsDao = new MySqlClientsDaoFactory().create();
        RequestsDao requestsDao = new MySqlRequestsDaoFactory().create();
        WorkoutsDao workoutsDao = new MySqlWorkoutsDaoFactory().create();
        ExercisesDao exercisesDao = new MySqlExercisesDaoFactory().create();
        CompletedSetsDao completedSetsDao = new MySqlCompletedSetsDaoFactory().create();

        trainersDao.create(new User(
                1,
                "name",
                "surname",
                "login",
                "qwerty",
                "12345678",
                "email1"
        ));
        System.out.println(trainersDao.getById(1));
        trainersDao.update(new User(
                1,
                "name1",
                "surname1",
                "login1",
                "87654321",
                "0996661313",
                "email1"
        ));
        System.out.println(trainersDao.getById(1));
        System.out.println(trainersDao.getNumberOfClients(1));

        clientsDao.create(new User(
                2,
                "name2",
                "surname2",
                "login2",
                "12345678",
                "0996661313",
                "email2"
        ));
        System.out.println(clientsDao.getById(1));
        clientsDao.update(new User(
                2,
                "name2",
                "surname2",
                "login2",
                "87654321",
                "0996661313",
                "email2"
        ));
        System.out.println(clientsDao.getById(1));

        requestsDao.create(new RequestDB(1, 1, 1, RequestStatus.UNCHECKED));
        System.out.println(requestsDao.getByClientId(1));
        System.out.println(requestsDao.getByTrainerId(1));
        requestsDao.update(new RequestDB(1, 1, 1, RequestStatus.CONFIRMED));
        System.out.println(requestsDao.getByClientId(1));
        System.out.println(requestsDao.getByTrainerId(1));
        System.out.println(trainersDao.getNumberOfClients(1));

        workoutsDao.create(new Workout(
                "workout1",
                new Date(),
                1
        ).build());
        System.out.println(workoutsDao.getByClientId(1, 0, 1));

        workoutsDao.update(new Workout(
                "workout2",
                new Date(),
                1
        ).build());
        System.out.println(workoutsDao.getByClientId(1, 0, 1));

        // Create an Exercise object using the parameterized constructor
        List<CompletedSet> completedSets = new ArrayList<>();
        completedSets.add(new CompletedSet(
                1L,
                (byte) 1,
                (short) 12,
                (short) 70,
                new Time((byte) 0, (byte) 0, (byte) 20),
                "",
                1
        ));

        Workout workout = new Workout(3, "","workout3", new Date(), 1)
                .setId(1)
                .addExercise(new Exercise(
                        1L,
                        "exercise1",
                        (byte) 14,
                        (short) 16,
                        (short) 3,
                        (short) 6,
                        (short) 24,
                        new Time((byte) 0, (byte) 0, (byte) 45),
                        "be happy",
                        completedSets,
                        1
                ))
                .build();
        System.out.println(workout);
        exercisesDao.create(new Exercise(
                2L,
                "exercise2",
                (byte) 13,
                (short) 15,
                (short) 2,
                (short) 5,
                (short) 23,
                new Time((byte) 0, (byte) 0, (byte) 30),
                "be strong",
                completedSets,
                1
        ));
        System.out.println(exercisesDao.getByWorkoutId(1));
        exercisesDao.update(new Exercise(
                2L,
                "exercise3",
                (byte) 12,
                (short) 14,
                (short) 1,
                (short) 4,
                (short) 22,
                new Time((byte) 0, (byte) 0, (byte) 45),
                "be powerful",
                completedSets,
                2
        ));
        System.out.println(exercisesDao.getByWorkoutId(1));

        completedSetsDao.create(new CompletedSet(
                2L,
                (byte) 2,
                (short) 16,
                (short) 80,
                new Time((byte) 0, (byte) 0, (byte) 20),
                "",
                2
        ));
        System.out.println(completedSetsDao.getByExerciseId(1));
        completedSetsDao.update(new CompletedSet(
                3L,
                (byte) 3,
                (short) 18,
                (short) 90,
                new Time((byte) 0, (byte) 0, (byte) 20),
                "",
                3
        ));
        System.out.println(completedSetsDao.getByExerciseId(1));

        trainersDao.delete(new User(
                1,
                "name1",
                "surname1",
                "login1",
                "87654321",
                "0996661313",
                "email1"
        ));
        System.out.println(trainersDao.getById(1));
        System.out.println(clientsDao.getById(1));
        System.out.println(workoutsDao.getByClientId(1, 0, 1));
        System.out.println(exercisesDao.getByWorkoutId(1));
        System.out.println(completedSetsDao.getByExerciseId(1));

        clientsDao.delete(new User(
                1,
                "name2",
                "surname2",
                "login2",
                "87654321",
                "0996661313",
                "email2"
        ));
        System.out.println(clientsDao.getById(1));
        System.out.println(workoutsDao.getByClientId(1, 0, 1));
        System.out.println(exercisesDao.getByWorkoutId(1));
        System.out.println(completedSetsDao.getByExerciseId(1));
    }
}
