package com.example.JavaFinalBackend.dto;

import com.example.JavaFinalBackend.db.GetConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRequest {
    public static void deleteAccount(int id) {
    try {
        GetConnect connection = new GetConnect();
        Connection conn = connection.get();
        PreparedStatement st = conn.prepareStatement("DELETE FROM siteUsers WHERE id = ?");
        st.setInt(1, id);
        st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
