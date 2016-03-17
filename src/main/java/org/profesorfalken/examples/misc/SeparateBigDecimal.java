/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profesorfalken.examples.misc;

import java.math.BigDecimal;

/**
 *
 * @author javier
 */
public class SeparateBigDecimal {

    public static void main(String[] args) {
        BigDecimal big = new BigDecimal("925.0000");
        System.out.println("result: " + big.toString());
        String[] parts = big.toString().split("\\.");
        System.out.println("Parte entera: " + parts[0]);
        System.out.println("Parte decimal: " + parts[1]);
    }
}
