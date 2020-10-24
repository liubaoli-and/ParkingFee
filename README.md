# ParkingFee

   The parking billing program is a program implemented according to the charging standards of a certain parking lot. The program is based on the driver's vehicle type (motorcycle or car), car type (sports car or sedan), parking date (weekdays or weekends), discount coupons Calculate the parking fee with the parking time.<br>

1. Input specifications

<table><tr>
<td>Input </td> <td>type </td><td>limits</td><td> Description</td></tr>
<tr><td>typeOfVehical</td><td> int</td><td> only the numbers 0, 1 0, 1</td><td> represent motorcycles and cars respectively</td></tr>
<tr><td>typeOfCar</td><td> int</td> <td> only the numbers 0,1 0,1 </td><td>represent sports cars and cars respectively</td></tr>
<tr><td>dayOfWeek</td><td> int</td><td> only the numbers 0,1 0,1</td><td> represent weekdays and weekends respectively</td></tr>
<tr><td>apd</td> <td>double</td> <td>only a real number between 0-24</td><td> Actual parking time</td></tr>
    <tr><td>discountCoupon </td><td>boolean</td> <td></td><td>whether to use a coupon</td></tr>
<tr><td>estimation</td> <td>String</td><td> is only: "(0.0,2.0]", "(2.0,4.0]", "(4.0,24.0]", null</td><td> The estimated parking time of the driver, divided into four time periods, where null means that the driver did not give an estimate Estimate parking time.</td></tr>
</table>


2.  Output specifications

   Call the parking fee interface of the program to get the double output parameter fee. The output result is divided into three situations according to the input:

   (a) The user provides coupons: When the user provides coupons, they can enjoy a 50% discount on the original parking fee.

   (b) The user chooses the estimated parking time: The user can choose the estimated parking time according to his situation, divided into three time periods, "no more than 2 hours", "2 hours to 4 hours" and "4 hours to 24 hours". If the parking time is within the estimated time, the driver can enjoy a 40% discount. On the contrary, the driver needs to pay an additional 20% additional management fee in addition to the original parking fee.

   (c) The user has neither coupons nor estimated parking time: If the driver does not provide coupons or estimated parking time, the parking fee will not be discounted.

     It should be noted that the user cannot give the estimated parking time while providing the coupon, and can only choose one preferential method or neither.

     When the input meets the program specifications, the final parking fee is calculated according to the parking time, whether to enjoy a discount and the parking unit price. The calculation method of the parking unit price is shown in the table.

<table><tr>
<td rowspan="3">Parking time(Unit: hour)</td><td colspan="6"> Parking unit price (unit: ¥)</td></tr>
</td><td colspan="3">Weekday</td><td colspan="3"> weekend</td></tr>
<tr><td>Motorcycle</td><td> sports car</td> <td>sedan</td> <td>motorcycle </td><td>sports car </td><td>sedan</td></tr>
<tr><td>(0.0,2.0)</td> <td>4.00 </td><td>4.50</td> <td>5.00</td><td> 5.00</td> <td>6.00 </td><td>7.00</td></tr>
<tr><td>(2.0,4.0)</td><td> 5.00</td><td> 5.50</td><td> 6.00 </td><td>6.50 </td><td>7.50</td><td> 8.50</td></tr>
<tr><td>(4.0,24.0)</td> <td>6.00 </td><td>6.50</td> <td>7.00</td><td> 8.00 </td><td>9.00 </td><td>10.00</td></tr>
</table>


3. Description of MRs<br>
   A total of 5 MRs are shown in the table.

<table><tr><td>No</td><td> R </td><td>Rf</td></tr>
   <tr><td colspan="3"><center>1. estimation="(0.0,2.0]"</center></td></tr>
<tr><td>MR1 </td><td>apd_=apd+0.1(0.0 &lt; apd<=1.9)</td> <td> fee_>=fee</td></tr>
    <tr><td colspan="3"><center>2. estimation="(2.0,4.0]"</center></td></tr>
<tr><td>MR2 </td><td>apd_=apd+0.1(2.0&lt;apd<=3.9)</td><td> fee_>=fee</td></tr>
    <tr><td colspan="3"><center>3. estimation="(4.0,24.0]"</center></td></tr>
<tr><td>MR3</td><td> apd_=apd+0.1(4.0&lt;apd<=23.9)</td> <td>fee_>=fee</td></tr>
    <tr><td colspan="3"><center>4. estimation=null</center></td></tr>
<tr><td>MR4</td><td> apd_=apd+0.1(0.0&lt;apd<=23.9) </td><td>fee_>=fee</td></tr>
    <tr><td colspan="3"><center>5. Attribute MR</center></td></tr>
<tr><td>MR5</td> <td>apd_=ceil(apd)(0.0&lt;apd<=24.0)</td> <td>fee_=fee</td></tr>
</table>


Note:The ceil() in MR5 stands for rounding up.

