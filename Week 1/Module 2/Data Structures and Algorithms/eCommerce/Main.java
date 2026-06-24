package eCommerce;
class Main
{
    public static void main(String[] args)
    {
            Product[] products = {
            new Product(1, "Shampoo", "Cosmetics"),
            new Product(2, "Jean", "Apparel"),
            new Product(3, "Gold Chain", "Jewellery"),
            new Product(4, "Laptop", "Electronics"),
            new Product(5, "Watch", "Accessories")
            };
            System.out.println("Linear Search");
            Product p = Main.linearSearch(products, 3);
            if(p != null)    p.display();
            else System.out.println("Not Found");
            System.out.println("Binary Search");
            p = Main.binarySearch(products, 3);
            if(p != null)   p.display();
            else    System.out.println("Not found");
    }
    /*
    Linear search is a simple searching algorithm with O(n) time complexity.
    Worst case : O(n), Best case : O(1), Average case : O(n)
    */
    public static Product linearSearch(Product[] products, int id)
    {
        for(Product p : products)
        {
            if(p.productID == id)   return p;
        }
        return null;
    }
    /*
    Binary search is an efficient searching technique that works in O(log n) time
    complexity.
    It requires the array to be sorted in order to work.
    Worst case : O(log n), Best case : O(1), Average case : O(log n)
    */
    public static Product binarySearch(Product[] products, int id)
    {
        int l = 0, r = products.length - 1, mid = products.length / 2;
        while(l <= r)
        {
            if(products[mid].productID == id) return products[mid];
            else if(products[mid].productID > id) r = mid - 1;
            else l = mid + 1;
            mid = (l + r) / 2;
        }
        return null;
    }
    /*
    For our platform binary search is better as the product ID is inserted in 
    sorted order.
    */
}