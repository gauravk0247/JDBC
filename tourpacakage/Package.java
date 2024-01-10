package tourpacakage;

public class Package {
	private String packageId;
	private String source;
	private String destination;
	private int nod;
	private double packageCost;
	public Package(String packageId, String source, String destination, int nod, double packageCost) {
		super();
		this.packageId = packageId;
		this.source = source;
		this.destination = destination;
		this.nod = nod;
		this.packageCost = packageCost;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNod() {
		return nod;
	}
	public void setNod(int nod) {
		this.nod = nod;
	}
	public double getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}
}