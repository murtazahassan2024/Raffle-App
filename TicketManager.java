package raffleapp;

import java.util.List;

/**
 *
 * @author Tony
 */
public interface TicketManager
{
    /**
     * @return The number of tickets eligible to win
     */
    int numberOfEligibleEntries();
    
    /**
     * @return The total number of tickets submitted, including duplicates
     */
    int totalTicketsSubmitted();
    
    /**
     * Add a ticket to the raffle.  The first ticket submitted is the eligible one
     *  but the system should record all duplicates for auditing
     * @param ticket 
     */
    void add(Ticket ticket);
    
    /**
     * Randomly select one of the the entries to win
     * (The winner is removed from future picks. 
     *  You must add the ticket a second time to be eligible
     *  for additional picks.)
     * @return the winning ticket
     */
    Ticket pick();
    
    /**
     * Get all eligible and duplicate submissions for the given ID
     * @param id - the requested ticket id
     * @return a list of tickets
     */
    List<Ticket> getAllSubmissionsFor(byte id);
}