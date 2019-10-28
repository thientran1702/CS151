public class DumpArray
{

    public static void dumpArray(Object[] objects)
    {
        for(int i = 0; i < objects.length; i++)
        {
            System.out.println(objects[i].toString());
        }
    }

    public static void main(String[] args)
    {
        Object[] objects = {"Hello",8 , "World", 26.11, "new Rectangle(50, 80)"};
        dumpArray(objects);
    }

}