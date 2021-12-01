package lab5;

import java.sql.*;
import java.util.*;
import java.util.List;

public class Game {

    private int id;
    private String gameName;
    private String developer;
    private String releaseYear;

    public Game(int id, String gameName, String developer, String releaseYear) {
        this.id = id;
        this.gameName = gameName;
        this.developer = developer;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameName='" + gameName + '\'' +
                ", developer='" + developer + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
