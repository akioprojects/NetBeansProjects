package phones;


public class Phone {

	private String provider;

	private int number;
	
	private String maker;

	private String sold;
	
	public Phone(){
		
	}
	
	public Phone(String provider, int number, String maker, String sold) {
		this.provider = provider;
		this.number = number;
		this.maker  = maker;
		this.sold = sold;
		
	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(int id) {
		this.maker = maker;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}


	public String getSold() {
		return sold;
	}

	public void setSold(String sold) {
		this.sold = sold;
	}	
	
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Employee Details - ");
		sb.append("Provider:" + getProvider());
		sb.append(", ");
		sb.append("Sold:" + getSold());
		sb.append(", ");
		sb.append("Maker:" + getMaker());
		sb.append(", ");
		sb.append("Number:" + getNumber());
		sb.append(".");
		
		return sb.toString();
	}
}
