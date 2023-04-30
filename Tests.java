import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Tests {
    final String PROD_ID001 = "prod001";
    final String PROD_ID002 = "prod002";
    final String PROD_NAME = "iphone";

    @Test
    public void testOne(){
        Data data = new Data();
        data.saveProduct(PROD_ID001, PROD_NAME, 2800);
        assertEquals(0, data.getQuantity(PROD_ID001));
        data.purchaseProduct(PROD_ID001, 5, 2500);
        assertEquals(5, data.getQuantity(PROD_ID001));
        assertEquals(2500, data.getAverage(PROD_ID001),  0);
        data.orderProduct(PROD_ID001, 4);
        assertEquals(data.getQuantity(PROD_ID001), 1);
        assertEquals(1200.0, data.getProfit(PROD_ID001), 0);

    }

    @Test
    public void testTwo(){
        Data data = new Data();
        data.saveProduct(PROD_ID001, PROD_NAME, 2800);
        data.purchaseProduct(PROD_ID001, 5, 2500);
        data.purchaseProduct(PROD_ID001, 5, 3000);
        assertEquals(10, data.getQuantity(PROD_ID001));
        assertEquals(2750, data.getAverage(PROD_ID001),  0);
        data.orderProduct(PROD_ID001, 4);
        assertEquals(data.getQuantity(PROD_ID001), 6);
        assertEquals(200, data.getProfit(PROD_ID001), 0);

    }
}
