/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ninja_squad.tpdi.DAO;
import com.ninja_squad.tpdi.Service;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;


/**
 *
 * @author Lauriane
 */
public class ServiceTest {
    
    DAO mockDao;
    Service service;
    
    @Before
    public void setUp() {
        mockDao = Mockito.mock(DAO.class);
        service = new Service(mockDao);
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testTrouver() throws Exception {
        Mockito.when(mockDao.readSpectacles()).thenReturn(Arrays.asList("toto", "titi"));
        assertEquals(0, service.trouver("tr").size());
        assertEquals(2, service.trouver("t").size());
        assertEquals(1, service.trouver("ot").size());
        
    }
}
