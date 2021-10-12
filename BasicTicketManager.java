package raffleapp;

import java.util.List;

/**
 * @author Tony
 */
public class BasicTicketManager implements TicketManager
{

    @Override
    public int numberOfEligibleEntries()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
	public int totalTicketsSubmitted()
	{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
    public void add(Ticket ticket)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ticket pick()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public List<Ticket> getAllSubmissionsFor(byte id)
	{
		// TODO Auto-generated method stub
		return null;
	}
}