package com.skyler.smarthome.server.data;

import java.util.List;

import com.skyler.smarthome.server.enums.SensorStatus;
import com.skyler.smarthome.server.model.Sensor;

public interface SensorDao {

	public List<Sensor> getAllSensors();

	public Sensor getSensorById(int id);

	public List<Sensor> getSensorByStatus(SensorStatus status);

	public boolean addSensorToGateway(int gateway, Sensor sensor);

	public boolean addSensorListToGateway(int gateway, List<Sensor> sensorList);

	public boolean setSensorStatus(int sensorId,SensorStatus status);
}
