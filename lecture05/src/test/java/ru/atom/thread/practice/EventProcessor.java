package ru.atom.thread.practice;

import java.util.List;

/**
 * @author apomosov
 * @since 15.03.17
 */
public class EventProcessor {
    private static long good = 0, bad = 0;


    public static void produceEvents(List<EventProducer> eventProducers) {
        for (EventProducer i : eventProducers) {
            i.run();
        }
    }
    private static void countAll()
    {
        while (!EventQueue.getInstance().isEmpty())
        {
            Event theEvent = EventQueue.getInstance().poll();
            if (theEvent.getEventType() == Event.EventType.GOOD)
                good++;
            else bad++;
        }
    }

    public static long countTotalNumberOfGoodEvents() {
        countAll();
        return good;

    }

    public static long countTotalNumberOfBadEvents() {
        countAll();
        return bad;
    }
}
