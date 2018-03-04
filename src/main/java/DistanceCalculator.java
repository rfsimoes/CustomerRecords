class DistanceCalculator {


    public boolean isWithin(double officeLatitude,
                            double officeLongitude,
                            double customerLatitude,
                            double customerLongitude,
                            double radius,
                            double earthRadiusKm) {

        if(officeLatitude==customerLatitude && officeLongitude==customerLongitude)
            return true;

        double distance = distanceCalculator(officeLatitude,
                                             officeLongitude,
                                             customerLatitude,
                                             customerLongitude,
                                             earthRadiusKm);

        return distance < radius;
    }

    private double distanceCalculator(double officeLatitude,
                                      double officeLongitude,
                                      double customerLatitude,
                                      double customerLongitude,
                                      double earthRadiusKm) {

        officeLatitude = convertToRadians(officeLatitude);
        officeLongitude = convertToRadians(officeLongitude);
        customerLatitude = convertToRadians(customerLatitude);
        customerLongitude = convertToRadians(customerLongitude);


        double absoluteDifference = Math.abs(customerLongitude - officeLongitude);

        double centralAngle = Math.acos(Math.sin(officeLatitude) * Math.sin(customerLatitude) +
                                        Math.cos(officeLatitude) *
                                        Math.cos(customerLatitude) *
                                        Math.cos(absoluteDifference));

        return earthRadiusKm * centralAngle;

    }

    private double convertToRadians(double degrees) {
        return Math.toRadians(degrees);
    }
}
