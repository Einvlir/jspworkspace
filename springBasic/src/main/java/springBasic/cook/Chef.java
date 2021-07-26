package springBasic.cook;

public class Chef {
	private Pan pan;
	public Chef() {
		//pan = new FriPan();
	}
	public void setPan(Pan pan) {
		this.pan = pan;
	}
	public void cook() {
		pan.warm();
	}
}
