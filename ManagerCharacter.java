package lab5;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ManagerCharacter {

    private Connection conn;

    public ManagerCharacter(){

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

    public void createTableCharacters() throws SQLException{

//        String t="CREATE TABLE characters(Id_characters INT(15) PRIMARY KEY , Name VARCHAR (30) NOT NULL ," +
//                " Name_of_attack VARCHAR (30) NOT NULL , Health DECIMAL (10) NOT NULL , Attack DECIMAL (10) NOT NULL,"+
//                " Protection DECIMAL (10) NOT NULL , Game_id INT(15) NOT NULL, FOREIGN KEY(Game_id) REFERENCES game(Id_game));";

        String t="CREATE TABLE characters(Id_characters INT(15) PRIMARY KEY , Name VARCHAR (30) NOT NULL ," +
                "Name_of_attack VARCHAR (30) NOT NULL, Health DECIMAL (10) NOT NULL, Attack DECIMAL (10) NOT NULL," +
                "Protection DECIMAL (10) NOT NULL, Game_id INT(15) NOT NULL, FOREIGN KEY(Game_id) REFERENCES game(Id_game));";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t);



    }


    public void deleteTable() throws SQLException{

        String t1 = "DROP TABLE characters;";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t1);
        System.out.println("Deleted table");



    }



    //ADD CHARACTER
    public void addCharacterToTable(Character obj) throws SQLException{

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO characters VALUES(?,?,?,?,?,?,?);");
        stmt.setInt(1,obj.getId());
        stmt.setString(2,obj.getName());
        stmt.setString(3,obj.getNameOfAttack());
        stmt.setDouble(4,obj.getHealth());
        stmt.setDouble(5,obj.getAttack());
        stmt.setDouble(6,obj.getProtection());
        stmt.setInt(7,obj.getGameId());

        stmt.execute();


        System.out.println("Added 1 worker");

    }


/*
    private int id;
    private String name;
    private String nameOfAttack;
    private double health;
    private double attack;
    private double protection;
    private int gameId;*/

    //SELECT OPERATIONS

    //1) SELECT ALL AVAILABLE CHARACTERS;

    public Collection<Character> selectAll() throws SQLException{
        Collection<Character> workers = new ArrayList<Character>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM characters;");

        while(rs.next()){
            Character c1 = new Character(rs.getInt("Id_characters"),rs.getString("Name"),rs.getString("Name_of_attack"),rs.getDouble("Health"),rs.getDouble("Attack"),rs.getDouble("Protection"),rs.getInt("Game_id"));
            workers.add(c1);
        }

        return workers;
    }



        //2) CHARACTER WHO HAVE HEALTH MORE THAN GIVEN
    public Collection<Character> selectMoreHealth(double new_health) throws SQLException{
        Collection<Character> characters = new ArrayList<Character>();
        ResultSet rs = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM characters WHERE Health > ?;");
        stmt.setDouble(1,new_health);
        rs = stmt.executeQuery();

        while(rs.next()){
            Character c1 = new Character(rs.getInt("Id_characters"),rs.getString("Name"),rs.getString("Name_of_attack"),rs.getDouble("Health"),rs.getDouble("Attack"),rs.getDouble("Protection"),rs.getInt("Game_id"));
            characters.add(c1);
        }

        return characters;
    }



        //3) CHARACTERS WHO ARE IN GAME
    public  Collection<Character> selectCharacterInGame(String name) throws SQLException{
        Collection<Character> characters = new ArrayList<Character>();

        ResultSet rs = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM characters, game WHERE characters.Game_id=game.Id_game AND game.Name_game=?;");
        stmt.setString(1,name);
        rs = stmt.executeQuery();

        while(rs.next()){
            Character c1 = new Character(rs.getInt("Id_characters"),rs.getString("Name"),rs.getString("Name_of_attack"),rs.getDouble("Health"),rs.getDouble("Attack"),rs.getDouble("Protection"),rs.getInt("Game_id"));
            characters.add(c1);
        }

        return characters;
    }


    //UPDATE OPERATIONS

    //1)UPDATE HEALTH CHARACTERS WHERE ATTACK>PROTECTION
    public void UpdateHealth(double k_health) throws SQLException{
        Collection<Character> workers = new ArrayList<Character>();
        PreparedStatement stmt = conn.prepareStatement("UPDATE characters SET Health=Health*? WHERE Attack>Protection;");
        stmt.setDouble(1,k_health);
        stmt.executeUpdate();
    }

    //2)UPDATE PROTECTION CHARACTERS WHERE PROTECTION < 30
    public void UpdateProtection() throws SQLException{
        Collection<Character> workers = new ArrayList<Character>();

        Statement stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE characters SET Protection=Protection*2 WHERE Protection < 30;");

    }



    //DELETE OPERATIONS

    //1) DELETE CHARACTERS WITH NAME
    public void DeleteCharactersWithName(String name) throws SQLException{
        Collection<Character> workers = new ArrayList<Character>();

        PreparedStatement stmt = conn.prepareStatement("DELETE FROM characters WHERE Name = ?");
        stmt.setString(1,name);
        stmt.executeUpdate();

    }


    //2) DELETE CHARACTERS WHO HAVE GIVEN NAME_OF_ATTACK

    public void deleteCharactersWithNameOfAttack(String nameOfAttack) throws SQLException{
        Collection<Character> characters = new ArrayList<Character>();

        PreparedStatement stmt = conn.prepareStatement("DELETE FROM characters WHERE Name_of_attack = ?");
        stmt.setString(1,nameOfAttack);
        stmt.executeUpdate();

    }


    //3) DELETE ALL INFORMATION FROM TABLE
    public void deleteAll() throws SQLException{

        String t1 = "DELETE FROM characters WHERE TRUE ;";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t1);
        System.out.println("Deleted info");
    }
}
