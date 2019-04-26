package com.common.test;

import com.common.service.InterfaceService;
import com.common.service.InterfaceServiceImpl;
import org.junit.Test;

public class CommonTest {

    @Test
    public void test1() {
        System.out.println(InterfaceService.getName2());
        InterfaceService interfaceService = new InterfaceServiceImpl();
        System.out.println(interfaceService.getName());
    }
}
