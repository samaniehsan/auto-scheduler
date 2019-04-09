package org.txstate.auto_batcher.tests;

import org.txstate.auto_batcher.Main;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MainTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
		Main.main(new String []);
        assertTrue( true );
    }

    @Test
    public void shouldAnswerWithFalse()
    {
		Main.main(new String []);
        assertFalse( "Should not Fail", false );
    }
}
