package com.example.JavaFinalBackend.db;


import com.example.JavaFinalBackend.core.Game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Games {
    //    GETS THE CONNECTION
    private static Connection connect() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql:main", "basecamp", "pgpass");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
            return null;
        }
    }

    //    GETTING ALL THE GAMES
    public static List<Game> all() {
        try{
            Connection c = connect();
            PreparedStatement st = c.prepareStatement("SELECT * FROM games;");
            ResultSet rs = st.executeQuery();
            ArrayList<Game> allgames = new ArrayList<Game>();
            while (rs.next()) {
                allgames.add(new Game(
                        rs.getInt("home_id"),
                        rs.getInt("home_score"),
                        rs.getInt("away_id"),
                        rs.getInt("away_score")
                ));
            }
            return allgames;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
        }

    }
}
