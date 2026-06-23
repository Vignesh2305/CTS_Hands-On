package SingletonPatternExample;
class Logger
{
    private static Logger logobj = new Logger();
    private Logger()
    {
        System.out.println("Object Created");
    }
    public static Logger getInstance()
    {
        return logobj;
    }
    public void log(String str)
    {
        System.out.println("Log : " + str);
    }
}