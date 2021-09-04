import java.io.Serializable;

public class Message implements Serializable{
  
    private String [] name;
    private String AdmNo;
    private String [] suDetails;
    private String thankYou;

    public Message(String [] names,String AdmNo,String [] suDetails,String thankYou){
        this.name = names;
        this.AdmNo = AdmNo;
        this.suDetails = suDetails;
        this.thankYou = thankYou;
    }
    public String [] getName(){
        return name;
    }
    public String [] suDetails(){
        return suDetails;
    }
    public String  getAdmNo(){
        return AdmNo;
    }
    public String getThankYou(){
        return thankYou;
    }
}
