package com.izavasconcelos.coreengineering.tema06;

public class Contact {

    private String name;
    private String phone;
    private int id;
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "\n#  Name: " + name + "  # Phone: " + phone + "  # Contact Id: " + id;
    }
}
