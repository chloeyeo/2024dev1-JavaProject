package javaSample;

public class LgTV implements TV {
	public LgTV() {
		System.out.println("created a new Lg TV");
	}
	
	@Override
	public void turnOn() {
		System.out.println("turned on the Lg TV");
	}
	
	@Override
	public void turnOff() {
		System.out.println("turned off the Lg TV");
	}
	
	@Override
	public void soundOn() {
		System.out.println("turned on the sound of the Lg TV");
	}
	
	@Override
	public void soundOff() {
		System.out.println("turned off the sound of the Lg TV");
	}
}
