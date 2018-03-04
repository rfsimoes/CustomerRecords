import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    DistanceCalculator distanceCalculator = new DistanceCalculator();
    private static final double OFFICE_LATITUDE = 53.339428;
    private static final double OFFICE_LONGITUDE = -6.257664;
    private static final double RADIUS_WITHIN_KM = 100;
    private static final double EARTH_RADIUS_KM = 6371;

    @Test
    void isWithin() {

        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               53.2451022,
                                               -6.238335,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               53.1302756,
                                               -6.2397222,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               53.1229599,
                                               -6.2705202,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               54.0894797,
                                               -6.18671,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               53.008769,
                                               -6.1056711,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               52.986375,
                                               -6.043701,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               53.0,
                                               -7.0,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               52.966,
                                               -6.463,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               54.180238,
                                               -5.920898,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               54.133333,
                                               -6.433333,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               53.74452,
                                               -7.11167,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               53.1489345,
                                               -6.8422408,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                               OFFICE_LONGITUDE,
                                               53.0033946,
                                               -6.3877505,
                                               RADIUS_WITHIN_KM,
                                               EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                51.92893,
                                                -10.27699,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                51.8856167,
                                                -10.4240951,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                52.3191841,
                                                -8.5072391,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                53.807778,
                                                -7.714444,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                53.4692815,
                                                -9.436036,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                54.1225,
                                                -8.143333,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                52.2559432,
                                                -7.1048927,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                52.240382,
                                                -6.972413,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                51.999447,
                                                -9.742744,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                52.366037,
                                                -8.179118,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                52.228056,
                                                -7.915833,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                55.033,
                                                -8.112,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                53.521111,
                                                -9.831111,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                51.802,
                                                -9.442,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                54.374208,
                                                -8.371639,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(!distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                52.833502,
                                                -8.522366,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));
        assertTrue(distanceCalculator.isWithin(OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                               OFFICE_LATITUDE,
                                                OFFICE_LONGITUDE,
                                                RADIUS_WITHIN_KM,
                                                EARTH_RADIUS_KM));

    }
}