package ScenarioBased;
interface SensorReadable{
	void readSensorData();
}
abstract class IrrigationUnit implements SensorReadable{
	private double calibrationFactor;
	public IrrigationUnit() {
		this(1.0);
	}
	public IrrigationUnit(double calibrationFactor) {
		// TODO Auto-generated constructor stub
		this.calibrationFactor = calibrationFactor;
	}
	
	protected void calibrate() {
		System.out.println("Calibrating With Factor: "+ calibrationFactor);
	}
	public abstract void startWatering();
}
class  Sprinkler extends IrrigationUnit{
	public Sprinkler() {
		super(1.5);
	}
	@Override
	public void startWatering() {
		calibrate();
		System.out.println("Sprinkler System Activated. Spraying Water Evenly");
	}
	@Override
	public void readSensorData() {
		System.out.println("Sprinkler read Moisture data..");
	}
}
class DripSystem extends IrrigationUnit{
	public DripSystem() {
		super(0.8);
	}
	@Override
	public void startWatering() {
		calibrate();
		System.out.println("Drip system activated. Delivering water directly to roots.");
	}
	@Override
	public void readSensorData() {
		System.out.println("Drip system reading soil nutrient sensor data....");
	}
}
public class AgroBot{
	public static void main (String[] args) {
		IrrigationUnit unit1 =new Sprinkler();
		IrrigationUnit unit2 = new DripSystem();
		
		unit1.readSensorData();
		unit1.startWatering();
		
		unit2.readSensorData();
		unit2.startWatering();
	}
}
