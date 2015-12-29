package meteoSpringBoot.weatherStatement;

public class Humidity
{
    private int value;
    private String unity;

    public int getValue()
    {
        return value;
    }

    public void setValue(final int value)
    {
        this.value = value;
    }

    public String getUnity()
    {
        return unity;
    }

    public void setUnity(final String unity)
    {
        this.unity = unity;
    }

    public Humidity(){}

    public Humidity(final int value, final String unity)
    {
        this.value = value;
        this.unity = unity;
    }

    @Override
    public String toString()
    {
        return String.format("Humidity[value=%s, unity=%s]",value,unity);
    }

}
