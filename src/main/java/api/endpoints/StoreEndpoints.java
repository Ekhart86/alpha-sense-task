package api.endpoints;

import properties.Properties;

public class StoreEndpoints {
    public final static String STORE_BASE_PATH = System.getProperty(Properties.API_VERSION) + "/store";
    public final static String ORDER_BASE_PATH = STORE_BASE_PATH + "/order";
}
