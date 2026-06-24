package eCommerce;
class Product
{
    int productID;
    String productName;
    String category;
    public Product(int id, String name, String category)
    {
        this.productID = id;
        this.productName = name;
        this.category = category;
    }
    public void display()
    {
        System.out.println("Product Id = " + this.productID);
        System.out.println("Product Name = " + this.productName);
        System.out.println("Category = " + this.category);
    }
}