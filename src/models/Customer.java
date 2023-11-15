package models;

public class Customer {
    private int customerID;
    private String customerName;
    private Address address;
    private String telephoneNumber;

    public Customer(int id,String name, Address ad, String tel){
        this.customerID = id;
        this.customerName = name;
        this.address = ad;
        this.telephoneNumber = tel;
    }
    public Customer(String name, Address ad, String tel){
        this.customerName = name;
        this.address = ad;
        this.telephoneNumber = tel;
    }
    public int getCustomerID(){
        return customerID;
    }
    public String getCustomerName(){
        return customerName;
    }
    public Address getAddress(){
        return address;
    }
    public String getTelephoneNumber(){
        return telephoneNumber;
    }
    public void setCustomerName(String value){
        this.customerName = value;
    }
    public void setAddress(Address value){
        this.address = value;
    }
    public void setTelephoneNumber(String value){
        this.telephoneNumber =value;
    }
    public String toString(){
        return "Customer={id="+customerID+",name="+customerName+", address="+address+", phone="+telephoneNumber+"}";
    }
}