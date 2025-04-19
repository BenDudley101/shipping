package com.shipco.domain.carrier;


/*

Simple model, example extension is to add agreement, etc

              CUSTOMER
                 1 |
                   | books
                 * |
                VOYAGE ------------------------
                 1 |            * |        1  |
                   | moves        |           | pay
                 * |              |        1  |
          ------ SHIPMENT         |        PRICE
       * |        1 |             |
         |          | contains    |
  assign |        * |             |
         |       SHIPMENT         | ports
         |         ITEM           |
       1 |                        |
         |                        |
          ------- SHIP            |
                 * |              |
                   | travels      |
                 1 |            1 |
                 ROUTE-------------

 */
