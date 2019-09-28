package tests.ApiTests;

public class Basket {

    String capacity;
    String forward_url;

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getForward_url() {
        return forward_url;
    }

    public void setForward_url(String forward_url) {
        this.forward_url = forward_url;
    }

    public Basket(String capacity, String forward_url) {
        this.capacity = capacity;
        this.forward_url = forward_url;
    }
}

