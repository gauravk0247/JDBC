package preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestJdbcDemo6 {
	// Update data into our Train_table Database
    public static int updateTrain(Train trainObj) {
        int status = 0;
        try {
            Connection con = JdbcUtil.getConnectionWithDB();
            String updateQuery = "update Train_Table set train_source=?, train_destination=?, train_status=?,train_date=?, train_price=? where train_number=?";
            PreparedStatement ps = con.prepareStatement(updateQuery);
            ps.setString(1, trainObj.getTrainSource());
            ps.setString(2, trainObj.getTrainDestination());
            ps.setString(3, trainObj.getTrainStatus());
            ps.setDate(4, java.sql.Date.valueOf(trainObj.getTrainRunningDate()));
            ps.setDouble(5, trainObj.getTrainPrice());
            ps.setInt(6, trainObj.getTrainNumber());

            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter existing train Number");
        int tno = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new train name");
        String tname = sc.nextLine();
        //sc.nextLine();
        System.out.println("Enter new train source");
        String tsource = sc.next();
        System.out.println("Enter new train destination");
        String tdest = sc.next();
        System.out.println("Enter new train status");
        String tstatus = sc.next();
        System.out.println("Enter new train date");
        String tdate = sc.next();
        System.out.println("Enter new train price");
        double price = sc.nextDouble();
        // parsing String into LocalDate
        // LocalDate parse(String date)
        LocalDate updateTrainDate = LocalDate.parse(tdate);
        
//        Train train = new Train(2023,"abc express","csmt", "Mumbai", null, LocalDate.now(),7000.00);
//        int updateStatus = updateTrain(train);
        
        Train train = new Train(tno,tname,tsource, tdest, null, updateTrainDate,price);
        // calling updateTrain(Train)
        int updateStatus = updateTrain(train);

        if (updateStatus > 0) {
            System.out.println(updateStatus + " updated successfully.");
        } else {
            System.out.println("No updated.");
        }
    }
}
