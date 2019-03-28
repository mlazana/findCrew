package ContactRequestJava;

public class ContactRequest {

	private String crew_id;
	private int shipowner_id;
	private String start;
	private String end;
	private String departure;
	private String description;
	private int idcontact_request;

	public ContactRequest(String crew_id,int shipowner_id, String start, String end, String departure, String description) {

			this.crew_id = crew_id;
			this.shipowner_id = shipowner_id;
			this.start = start;
			this.end = end;
			this.departure = departure;
			this.description = description;
	}

	public ContactRequest(int idcontact_request, String crew_id,int shipowner_id, String start, String end, String departure, String description) {

	            this.idcontact_request = idcontact_request;
				this.crew_id = crew_id;
				this.shipowner_id = shipowner_id;
				this.start = start;
				this.end = end;
				this.departure = departure;
				this.description = description;
	}

	 public int getIdcontact_request() {
	   		return idcontact_request;
	   	}


    public void setIdcontact_request(int idcontact_request) {
	   	this.idcontact_request = idcontact_request;
   	}

   public String getCrew_id() {
   		return crew_id;
   	}


	  public void setCrew_id(String crew_id) {
		this.crew_id = crew_id;
   	}

   public int getShipowner_id() {
		return shipowner_id;
	}


   public void setShipowner_id(int shipowner_id) {
		this.shipowner_id = shipowner_id;
	}


	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getEnd() {
		return end;
	}


	public void setEnd(String end) {
		this.end = end;
	}


	public String getDeparture() {
		return departure;
	}


	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Contact Request [Crew_id: "+ crew_id +"Shipowner_id=" + shipowner_id + ", start=" + start  + ", end=" + end + ", departure=" + departure +", description="+description + "]";
	}



}