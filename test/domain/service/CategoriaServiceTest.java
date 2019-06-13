/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import domain.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 141812
 */
public class CategoriaServiceTest {
    private final CategoriaService service = new CategoriaService();
    private final List<Categoria> saved = new ArrayList<>();
    
    public CategoriaServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        saved.forEach((c) -> {
            service.remove(c);
        });
    }

    @Test
    public void getAllTest() {
        List<Categoria> result = service.getAll(Categoria.class);
        Categoria notExpResult = null;
        
        assertNotEquals(result, notExpResult);
    }
    
    @Test
    public void getById() {
        Categoria expResult = null;
        Categoria result = service.getById(Categoria.class, -100);
        assertEquals(result, expResult);
        
        result = service.getById(Categoria.class, 202);
        if(result != null) {
            assertEquals(result.getId(), 202);
        }
    }
    
    @Test
    public void saveTest() {
        Categoria obj = new Categoria();
        Categoria result = service.save(obj);
        Categoria expResult = null;
        if(result != null) {
            saved.add(result);
        }
        
        assertEquals(expResult, result);
        
        obj = new Categoria();
        obj.setDescricao("Teste");
        result = service.save(obj);
        expResult = obj;
        
        if(result != null) {
            saved.add(result);
        }
        
        assertNotEquals(null, result);
        assertEquals(result.toString(), expResult.toString());
    }
    
    @Test
    public void removeTest() {
        Categoria obj = new Categoria();
        obj.setDescricao("Teste");
        Categoria result = service.save(obj);
        assertNotEquals(null, result);
        
        boolean expResult = true;
        boolean removeResult = service.remove(result);
        assertEquals(expResult, removeResult);
    }
    
    
}
