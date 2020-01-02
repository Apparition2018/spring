package com.ljh;

import com.ljh.cache.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * CacheTests
 *
 * @author Arsenal
 * created on 2020/1/3 0:01
 */
@SpringBootTest
public class CacheTests {
    
    private final MenuService menuService;

    @Autowired
    public CacheTests(MenuService menuService) {
        this.menuService = menuService;
    }
    
    @Test
    public void testCache() {
        System.out.println("call: " + menuService.getMenuList());
        System.out.println("call: " + menuService.getMenuList());
    }
}
