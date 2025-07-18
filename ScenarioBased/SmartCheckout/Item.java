class Item {
    private String name;
    private double price;
    private int stock;

    public Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public boolean isAvailable(int quantity) {
        return stock >= quantity;
    }

    public void reduceStock(int quantity) {
        if (quantity <= stock)
            stock -= quantity;
    }

    @Override
    public String toString() {
        return name + " (₹" + price + ", stock: " + stock + ")";
    }
}
