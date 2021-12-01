package lab5;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ManagerGame {
    private Connection conn;

    public ManagerGame(){

        try {
            String url = "jdbc:mysql://localhost:3306/lab_5_6";
            String user = "root";
            String pass = "12345678";

            this.conn = DriverManager.getConnection(url, user, pass);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConn() throws SQLException{
        conn.close();
    }


    //TABLE OPERATIONS
    public void createTableGame() throws SQLException{
        String table="CREATE TABLE game(Id_game INT(15) PRIMARY KEY , Name_game VARCHAR (30) NOT NULL ,"+
                " Developer VARCHAR (30) NOT NULL , Release_year VARCHAR (30) NOT NULL);";
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate(table);
    }



    public void deleteTableGame() throws SQLException{

        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate("DROP TABLE game;");
    }


    //ADD Game
    public void addGame(Game game) throws SQLException{

        PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO game VALUES (?,?,?,?);");
        stmt.setInt(1,game.getId());
        stmt.setString(2,game.getGameName());
        stmt.setString(3,game.getDeveloper());
        stmt.setString(4,game.getReleaseYear());

        stmt.execute();

        System.out.println("Added one game");
    }



    //SELECT OPERATIONS

    //1)SELECT ALL GAME
    public Collection<Game> selectAll() throws SQLException{

        Collection<Game>games = new ArrayList<Game>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM game;");
        //System.out.println("OK");
        while(rs.next()){
            //System.out.println("OK");
            Game game = new Game(rs.getInt("Id_game"),rs.getString("Name_game"),rs.getString("Developer"),rs.getString("Release_year"));
            games.add(game);
        }

        return games;

    }


    //2) SELECT GAMES WHICH ARE RELEASE IN SPECIFIC YEAR
    public Collection<Game> selectGamesForYear(String year) throws SQLException{
        ResultSet rs = null;
        Collection<Game> games = new ArrayList<Game>();

        PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM game WHERE game.Release_year=?;");
        stmt.setString(1,year);
        rs = stmt.executeQuery();

        while(rs.next()){
            Game game = new Game(rs.getInt("Id_game"),rs.getString("Name_game"),rs.getString("Developer"),rs.getString("Release_year"));
            games.add(game);
        }

        return games;
    }



    //UPDATE OPERATIONS

    //1) UPDATE DEVELOPER IN THAT GAME WHICH ARE RELEASE IN SPECIFIC YEAR
    public void updateDeveloperForYear(String developer, String year) throws SQLException{

        PreparedStatement stmt = this.conn.prepareStatement("UPDATE game SET game.Developer = ? WHERE game.Release_year=?;");
        stmt.setString(1,developer);
        stmt.setString(2,year);

        stmt.executeUpdate();
    }



    //DELETE OPERATIONS
    public void deleteForName(String nameGame) throws SQLException{

        PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM game WHERE Name_game=?;");
        stmt.setString(1,nameGame);
        stmt.executeUpdate();
    }


    public void deleteAll() throws SQLException{

        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate("DELETE FROM game WHERE TRUE;");
        System.out.println("Delete info");
    }

}
