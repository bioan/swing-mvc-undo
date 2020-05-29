package org.example;

import org.example.models.MessageStore;
import org.example.views.CLI;
import org.example.views.Swing;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MessageStore model = new MessageStore();
        CLI view = new CLI(model);
//        Swing view = new Swing(model);
    }
}
