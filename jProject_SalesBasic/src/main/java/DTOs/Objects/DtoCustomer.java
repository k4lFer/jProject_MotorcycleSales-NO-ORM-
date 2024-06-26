package DTOs.Objects;

import DTOs.Other.DtoMessageObject;

/**
 *
 * @author kalfe
 */
public class DtoCustomer extends DtoMessageObject{
    private int customerID;
    private String dni;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public DtoCustomer() {
    }

    public DtoCustomer(int customerID, String dni, String firstName, String lastName, String address, String phone) {
        this.customerID = customerID;
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
        
}
