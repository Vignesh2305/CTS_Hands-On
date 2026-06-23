package SingletonPatternExample;
class Main
{
    public static void main(String[] args)
    {
        Logger l1 = Logger.getInstance();
        l1.log("From l1");
        Logger l2 = Logger.getInstance();
        l2.log("From l2");
        if(l1 == l2)    System.out.println("Same Instance");
        else System.out.println("Different Instance");
    }
}