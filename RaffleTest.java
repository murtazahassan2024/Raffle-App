package raffleapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import raffleapp.BasicTicketManager;
import raffleapp.Ticket;

public class RaffleTest 
{
    private final int NUMBER_OF_ENTRIES = 200;
    private final int MAX_ID            = 10;//Byte.MAX_VALUE;
    private Random idGenerator          = new Random();
    private List<Ticket> allEntries     = new ArrayList<>();
    private List<Ticket> uniqueEntries  = new ArrayList<>();

    private void fill(BasicTicketManager uut)
    {
	    for (short i = 0; i < NUMBER_OF_ENTRIES; i++)
	    { 
	    	Ticket t = new Ticket((byte) idGenerator.nextInt(MAX_ID), "Entry " + i);
	        uut.add(t);
	        allEntries.add(t);
	        if (! uniqueEntries.contains(t))
	        {
	        	uniqueEntries.add(t);
	        }
	    }
    }
    
	@Test		
    @GradedTest(name="Test add(), numberOfEligibleEntries(), and totalTicketsSubmitted()", max_score=10)
    public void testAdd() 
    {
		BasicTicketManager uut = new BasicTicketManager();
		fill(uut);
		assertEquals("The number of eligible entries in your manager did not match", uniqueEntries.size(), uut.numberOfEligibleEntries());
		assertEquals("The number of total entries in your manager did not match", allEntries.size(), uut.totalTicketsSubmitted());
    }

	@Test		
    @GradedTest(name="Test pick()", max_score=10)
    public void testPick() 
    {
		BasicTicketManager uut = new BasicTicketManager();
		fill(uut);
		
		List<Ticket> winners = new ArrayList<>();
		assertEquals("The number of eligible entries in your manager did not match", uniqueEntries.size(), uut.numberOfEligibleEntries());
		for(int i = uniqueEntries.size(); i > 0; i--)
		{
			Ticket picked = uut.pick();
			assertNotNull("Your manager picked a null ticket", picked);
			int matching = uniqueEntries.indexOf(picked);
			assertFalse("This ticket was already picked", winners.contains(picked));
			winners.add(picked);
			assertEquals("You did not keep the first ticket number submitted as the eligible ticket", 
					     uniqueEntries.get(matching).getName(), picked.getName());
			assertEquals("The number of remaining tickets does not match", i - 1, uut.numberOfEligibleEntries());
		}
    }

	@Test		
    @GradedTest(name="Test getAllSubmissionsFor()", max_score=5)
    public void testDuplicates() 
    {
		BasicTicketManager uut = new BasicTicketManager();
		fill(uut);
		
		for (Ticket unique : uniqueEntries)
		{
			List<Ticket> all = uut.getAllSubmissionsFor(unique.getNumber());
			int count = 0;
			for (Ticket t : allEntries)
			{
				if (t.getNumber() == unique.getNumber())
				{
					count = count + 1;
				}
			}
			assertEquals("The total tickets do not match for " + unique.getName(),
					     count, all.size());
		}
    }	
}