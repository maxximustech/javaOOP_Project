package models;

public class Address {
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String country;
    private String postCode;



    public Address(String address1, String country, String pc){
        this.addressLine1 = address1;
        this.country = country;
        this.postCode = pc;
    }
    public Address(String address1, String address2, String country, String pc){
        this.addressLine1 = address1;
        this.addressLine2 = address2;
        this.country = country;
        this.postCode = pc;
    }
    public Address(String address1, String address2, String address3, String country, String pc){
        this.addressLine1 = address1;
        this.addressLine2 = address2;
        this.addressLine3 = address3;
        this.country = country;
        this.postCode=pc;
    }
    public String toString(){
        return "Address{addressLine1="+addressLine1+", addressLine2="+addressLine2+", addressLine3="+addressLine3+", country="+country+", postCode="+postCode+"}";
    }
    public void setPostCode(String value){
        this.postCode = value;
    }
    public void setCountry(String value){
        this.country = value;
    }
    public void setAddressLine3(String value){
        this.addressLine3 = value;
    }
    public void setAddressLine2(String value){
        this.addressLine2 = value;
    }
    public void setAddressLine1(String value){
        this.addressLine1 = value;
    }
    public String getPostCode(){
        return postCode;
    }
    public String getCountry(){
        return country;
    }
    public String getAddressLine3(){
        return addressLine3;
    }
    public String getAddressLine2(){
        return addressLine2;
    }
    public String getAddressLine1(){
        return addressLine1;
    }

}
