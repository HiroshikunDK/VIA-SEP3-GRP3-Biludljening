package Persistence;

import Model.Car;

import java.sql.SQLException;

public interface Database
{
  boolean registerCar(Car car) throws SQLException;
}
