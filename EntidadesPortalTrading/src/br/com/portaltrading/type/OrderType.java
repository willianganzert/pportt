package br.com.portaltrading.type;

public enum OrderType {

	ASC("asc"),
	DESC("desc");
	
	OrderType(String order){
		this.order=order;
	}
	
	private String order;

	public String getOrder() {
		return order;
	}
}
