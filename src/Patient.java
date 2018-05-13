public class Patient {
	
	//first row
    private Integer Id; //purposly using integer here because Id can also be NULL in convinience.
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    //private String companyName;
    
    //second row
    private String paymentMethod;
    //private int patientId;
    private int prescriberId;
    private String dateOfFilled;
    private String drugName;
    
    //third row
    private double drugCost;
    private double amount;
    private int unit;
    private int dose;
    private String drugCompany;
    private int drugId;
    
    public Patient(){}
    
    public Patient(
    		Integer Id, String firstName, String lastName, String phoneNumber, String address,// String companyName,
    		String paymentMethod, /*int patientId,*/int prescriberId, String dateOfFilled, String drugName,
    		double drugCost, double amount, int unit, int dose, String drugCompany, int drugId){
    	//first row
        setID(Id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);	
        setAddress(address);
        //setCompanyName(companyName);
        //second row
        setPaymentMethod(paymentMethod);
        //setPatiendId(patientId);
        setPrescriberId(prescriberId);
        setDateOfFilled(dateOfFilled);
        setDrugName(drugName);
        //third row
        setDrugCost(drugCost);
        setAmount(amount);
        setUnit(unit);
        setDose(dose);
        setDrugCompany(drugCompany);
        setDrugId(drugId);
        
    }
    
    //first row setters
    public void setID(int Id){ this.Id=Id; }
    
    public void setFirstName(String set){
        this.firstName = set;
    }
    public void setLastName(String set){
        this.lastName = set;
    }
    public void setPhoneNumber(String set){
        this.phoneNumber = set;
    }
    public void setAddress(String set){
    	this.address = set;
    }
    
    //public void setCompanyName(String set){
   // 	this.companyName = set;
    //}
    
    //second row setters
    public void setPaymentMethod(String set){
    	this.paymentMethod = set;
    }
    
   // public void setPatiendId(int set){
    	//this.patientId = set;
    //}
    
    public void setPrescriberId(int set){
    	this.prescriberId = set;
    }
    
    public void setDateOfFilled(String set){
    	this.dateOfFilled = set;
    }

    public void setDrugName(String set){
    	this.drugName = set;
    }
    
    
    //third row setters
    public void setDrugCost(double set){
    	this.drugCost = set;
    }
    
    public void setAmount(double set){
    	this.amount = set;
    }
    
    public void setUnit(int set){
    	this.unit = set;
    }
    
    public void setDose(int set){
    	this.dose = set;
    }
    
    public void setDrugCompany(String set){
    	this.drugCompany = set;
    }
    
    public void setDrugId(int set){
    	this.drugId = set;
    }
    
    
    public int getID(){
        return this.Id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getAddress(){
    	return this.address;
    }
    
   //public String getCompanyName(){
    //	return this.companyName;
    //}
    
    public String getPaymentMethod(){
    	return this.paymentMethod;
    }
    
  //  public int getPatientId(){
    	//return this.patientId;
   // }
    
    public int getPrescriberId(){
    	return this.prescriberId;
    }
    
    public String getDateOfFilled(){
    	return this.dateOfFilled;
    }
    
    public String getDrugName(){
    	return this.drugName;
    }
    
    public double getDrugCost(){
    	return this.drugCost;
    }
    
    public double getAmount(){
    	return this.amount;
    }
    
    public int getUnit(){
    	return this.unit;
    }
    
    public int getDose(){
    	return this.dose;
    }
    
    public String getDrugCompany(){
    	return this.drugCompany;
    }
    
    public int getDrugId(){
    	return this.drugId;
    }
}
