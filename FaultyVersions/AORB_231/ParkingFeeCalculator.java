// This is a mutant program.
// Author : ysma

package com.lwf.ustb.www.FEE.mutant.AORB_231;


import com.lwf.ustb.www.FEE.util.*;


public class ParkingFeeCalculator
{

    private  double formatDouble( double d )
    {
        java.lang.String t = String.format( "%.2f", d );
        double r = new java.lang.Double( t );
        return r;
    }

    private  double parkingFeeWithoutDiscount( int typeOfVehicle, int typeOfCar, int dayOfWeek, double apd )
    {
        double fee = 0.0;
        if (apd <= 0 || apd > 24) {
            return -1;
        }
        if (typeOfVehicle != com.lwf.ustb.www.FEE.util.Vehicle.MOTORCYCLE && typeOfVehicle != com.lwf.ustb.www.FEE.util.Vehicle.CAR) {
            return -1;
        }
        if (typeOfVehicle == com.lwf.ustb.www.FEE.util.Vehicle.CAR && typeOfCar != com.lwf.ustb.www.FEE.util.Car.TWO_DOOR_COUPE && typeOfCar != com.lwf.ustb.www.FEE.util.Car.OTHERS) {
            return -1;
        }
        if (dayOfWeek != com.lwf.ustb.www.FEE.util.Day.WEEKDAY && dayOfWeek != com.lwf.ustb.www.FEE.util.Day.WEEKEND) {
            return -1;
        }
        int parkingHours;
        if (apd % 1 == 0) {
            parkingHours = (int) apd;
        } else {
            parkingHours = (int) apd + 1;
        }
        switch (dayOfWeek) {
        case com.lwf.ustb.www.FEE.util.Day.WEEKDAY :
            if (parkingHours <= 2) {
                if (typeOfVehicle == com.lwf.ustb.www.FEE.util.Vehicle.MOTORCYCLE) {
                    fee = parkingHours * 4;
                } else {
                    if (typeOfCar == com.lwf.ustb.www.FEE.util.Car.TWO_DOOR_COUPE) {
                        fee = parkingHours * 4.5;
                    } else {
                        fee = parkingHours * 5;
                    }
                }
            } else {
                if (parkingHours <= 4) {
                    if (typeOfVehicle == com.lwf.ustb.www.FEE.util.Vehicle.MOTORCYCLE) {
                        fee = 2 * 4 + (parkingHours - 2) * 5;
                    } else {
                        if (typeOfCar == com.lwf.ustb.www.FEE.util.Car.TWO_DOOR_COUPE) {
                            fee = 2 * 4.5 + (parkingHours - 2) * 5.5;
                        } else {
                            fee = 2 * 5 + (parkingHours - 2) * 6;
                        }
                    }
                } else {
                    if (typeOfVehicle == com.lwf.ustb.www.FEE.util.Vehicle.MOTORCYCLE) {
                        fee = 2 * 4 + 2 * 5 + (parkingHours - 4) * 6;
                    } else {
                        if (typeOfCar == com.lwf.ustb.www.FEE.util.Car.TWO_DOOR_COUPE) {
                            fee = 2 * 4.5 + 2 * 5.5 + (parkingHours - 4) * 6.5;
                        } else {
                            fee = 2 * 5 + 2 * 6 + (parkingHours - 4) * 7;
                        }
                    }
                }
            }
            break;

        case com.lwf.ustb.www.FEE.util.Day.WEEKEND :
            if (parkingHours <= 2) {
                if (typeOfVehicle == com.lwf.ustb.www.FEE.util.Vehicle.MOTORCYCLE) {
                    fee = parkingHours * 5;
                } else {
                    if (typeOfCar == com.lwf.ustb.www.FEE.util.Car.TWO_DOOR_COUPE) {
                        fee = parkingHours * 6;
                    } else {
                        fee = parkingHours * 7;
                    }
                }
            } else {
                if (parkingHours <= 4) {
                    if (typeOfVehicle == com.lwf.ustb.www.FEE.util.Vehicle.MOTORCYCLE) {
                        fee = 2 * 5 + (parkingHours - 2) * 6.5;
                    } else {
                        if (typeOfCar == com.lwf.ustb.www.FEE.util.Car.TWO_DOOR_COUPE) {
                            fee = 2 * 6 + (parkingHours - 2) * 7.5;
                        } else {
                            fee = 2 * 7 + (parkingHours - 2) * 8.5;
                        }
                    }
                } else {
                    if (typeOfVehicle == com.lwf.ustb.www.FEE.util.Vehicle.MOTORCYCLE) {
                        fee = 2 * 5 + 2 * 6.5 + (parkingHours - 4) * 8;
                    } else {
                        if (typeOfCar == com.lwf.ustb.www.FEE.util.Car.TWO_DOOR_COUPE) {
                            fee = 2 * 6 + 2 + 7.5 + (parkingHours - 4) * 9;
                        } else {
                            fee = 2 * 7 + 2 * 8.5 + (parkingHours - 4) * 10;
                        }
                    }
                }
            }
            break;

        default  :

        }
        return formatDouble( fee );
    }

    private  double parkingFeeWithDiscountCoupon( int typeOfVehicle, int typeOfCar, int dayOfWeek, double apd )
    {
        return formatDouble( parkingFeeWithoutDiscount( typeOfVehicle, typeOfCar, dayOfWeek, apd ) * 0.5 );
    }

    private  double parkingFeeWithEstimation( int typeOfVehicle, int typeOfCar, int dayOfWeek, double apd, java.lang.String estimation )
    {
        if (estimation.equals( "(0, 2]" ) && apd > 0 && apd <= 2 || estimation.equals( "(2, 4]" ) && apd > 2 && apd <= 4 || estimation.equals( "(4, 24]" ) && apd > 4 && apd <= 24) {
            return formatDouble( parkingFeeWithoutDiscount( typeOfVehicle, typeOfCar, dayOfWeek, apd ) * 0.4 );
        } else {
            if (!estimation.equals( "(0, 2]" ) && !estimation.equals( "(2, 4]" ) && !estimation.equals( "(4, 24]" )) {
                return -1;
            } else {
                return formatDouble( parkingFeeWithoutDiscount( typeOfVehicle, typeOfCar, dayOfWeek, apd ) * 1.2 );
            }
        }
    }

    public  double parkingFee( int typeOfVehical, int typeOfCar, int dayOfWeek, double apd, boolean discountCoupon, java.lang.String estimation )
    {
        double fee = -1;
        if (discountCoupon && estimation != null) {
            fee = -1;
        } else {
            if (discountCoupon) {
                fee = parkingFeeWithDiscountCoupon( typeOfVehical, typeOfCar, dayOfWeek, apd );
            } else {
                if (estimation != null) {
                    fee = parkingFeeWithEstimation( typeOfVehical, typeOfCar, dayOfWeek, apd, estimation );
                } else {
                    fee = parkingFeeWithoutDiscount( typeOfVehical, typeOfCar, dayOfWeek, apd );
                }
            }
        }
        return fee;
    }

}
