package raffleapp;

/**
 * @author Tony
 */
public class Ticket implements Comparable<Ticket>
{
    private byte number;
    private String name;

    public Ticket(byte number, String name)
    {
        this.number = number;
        this.name = name;
    }

    public byte getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return number + ": " + name;
    }

    @Override
    public int compareTo(Ticket o)
    {
        return number - o.number;
    }

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (number != other.number)
			return false;
		return true;
	}
    
    
}
