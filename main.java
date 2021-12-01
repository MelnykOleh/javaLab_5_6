package lab5;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class main {
    public static void main(String[] args) throws SQLException {

        Game game_1 = new Game(1,"Game_1","Dev_1","2018");
        Game game_2 = new Game(2,"Game_2","Dev_2","2020");
        Game game_3 = new Game(3,"Game_3","Dev_3","2019");
        Game game_4 = new Game(4,"Game_4","Dev_4","2020");
        Game game_5 = new Game(5,"Game_5","Dev_5","2017");

        Character character_1  = new Character(1,"character_1", "type_attack_1", 41, 25, 74,1);
        Character character_2  = new Character(2,"character_2", "type_attack_2", 12, 31, 99,5);
        Character character_3  = new Character(3,"character_3", "type_attack_3", 19, 35, 85,2);
        Character character_4  = new Character(4,"character_4", "type_attack_4", 38, 13, 93,3);
        Character character_5  = new Character(5,"character_5", "type_attack_5", 64, 11, 77,1);
        Character character_6  = new Character(6,"character_6", "type_attack_6", 36, 21, 91,3);
        Character character_7  = new Character(7,"character_7", "type_attack_7", 29, 49, 70,5);
        Character character_8  = new Character(8,"character_8", "type_attack_8", 94, 13, 58,1);
        Character character_9  = new Character(9,"character_9", "type_attack_9", 56, 23, 54,5);
        Character character_10  = new Character(10,"character_10", "type_attack_10", 49, 12, 23,5);
        Character character_11  = new Character(11,"character_11", "type_attack_11", 80, 24, 79,4);
        Character character_12  = new Character(12,"character_12", "type_attack_12", 43, 15, 45,1);
        Character character_13  = new Character(13,"character_13", "type_attack_13", 55, 19, 40,3);
        Character character_14  = new Character(14,"character_14", "type_attack_14", 82, 43, 20,4);
        Character character_15  = new Character(15,"character_15", "type_attack_15", 60, 23, 64,5);

        ManagerGame managerGame = new ManagerGame();
        managerGame.createTableGame();

        ManagerCharacter managerCharacter = new ManagerCharacter();
        managerCharacter.createTableCharacters();

        managerGame.addGame(game_1);
        managerGame.addGame(game_2);
        managerGame.addGame(game_3);
        managerGame.addGame(game_4);
        managerGame.addGame(game_5);

        managerCharacter.addCharacterToTable(character_1);
        managerCharacter.addCharacterToTable(character_2);
        managerCharacter.addCharacterToTable(character_3);
        managerCharacter.addCharacterToTable(character_4);
        managerCharacter.addCharacterToTable(character_5);
        managerCharacter.addCharacterToTable(character_6);
        managerCharacter.addCharacterToTable(character_7);
        managerCharacter.addCharacterToTable(character_8);
        managerCharacter.addCharacterToTable(character_9);
        managerCharacter.addCharacterToTable(character_10);
        managerCharacter.addCharacterToTable(character_11);
        managerCharacter.addCharacterToTable(character_12);
        managerCharacter.addCharacterToTable(character_13);
        managerCharacter.addCharacterToTable(character_14);
        managerCharacter.addCharacterToTable(character_15);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        //1)SELECT ALL CHARACTERS
        System.out.println("-------------------------SELECT ALL CHARACTERS-------------------------");
        Collection<Character> characters_1 = managerCharacter.selectAll();
        for (Character character: characters_1
        ) {
            System.out.println(character);
        }



        //2) CHARACTER WHO HAVE HEALTH MORE THAN GIVEN
        System.out.println("-------------------------CHARACTER WHO HAVE HEALTH MORE THAN GIVEN-------------------------");
        Collection<Character> characters_2 = managerCharacter.selectMoreHealth(50);
        for (Character character: characters_2
        ) {
            System.out.println(character);
        }

        //3) CHARACTERS WHO ARE IN GAME
        System.out.println("-------------------------CHARACTERS WHO ARE IN GAME-------------------------");
        Collection<Character> characters_3 = managerCharacter.selectCharacterInGame("Game_5");
        for (Character character: characters_3
        ) {
            System.out.println(character);
        }

        //1)UPDATE HEALTH CHARACTERS WHERE ATTACK>PROTECTION
        System.out.println("-------------------------UPDATE HEALTH (*1.5) CHARACTERS WHERE ATTACK>PROTECTION-------------------------");
        managerCharacter.UpdateHealth(1.5);
        Collection<Character> characters_4 = managerCharacter.selectAll();
        for (Character character: characters_4
        ) {
            System.out.println(character);
        }

        //2)UPDATE PROTECTION CHARACTERS WHERE PROTECTION < 10
        System.out.println("-------------------------UPDATE PROTECTION CHARACTERS WHERE PROTECTION < 30-------------------------");
        managerCharacter.UpdateProtection();
        Collection<Character> characters_5 = managerCharacter.selectAll();
        for (Character character: characters_5
        ) {
            System.out.println(character);
        }

        //1) DELETE CHARACTERS WITH NAME
        System.out.println("-------------------------DELETE CHARACTERS WITH NAME (character_1)-------------------------");
        managerCharacter.DeleteCharactersWithName("character_1");
        Collection<Character> characters_6 = managerCharacter.selectAll();
        for (Character character: characters_6
        ) {
            System.out.println(character);
        }

        //2) DELETE CHARACTERS WHO HAVE GIVEN NAME_OF_ATTACK
        System.out.println("-------------------------DELETE CHARACTERS WHO HAVE GIVEN NAME_OF_ATTACK (type_attack_2)-------------------------");
        managerCharacter.deleteCharactersWithNameOfAttack("type_attack_2");
        Collection<Character> characters_7 = managerCharacter.selectAll();
        for (Character character: characters_7
        ) {
            System.out.println(character);
        }

        //3)DELETE ALL CHARACTERS
        System.out.println("-------------------------DELETE ALL CHARACTERS-------------------------");
        managerCharacter.deleteAll();
        Collection<Character> characters_8 = managerCharacter.selectAll();
        for (Character character: characters_8
        ) {
            System.out.println(character);
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //1) SELECT ALL GAME
        System.out.println("-------------------------SELECT ALL GAME-------------------------");
        Collection<Game> games_1 = managerGame.selectAll();
        for (Game game: games_1
        ) {
            System.out.println(game);
        }

        //2) SELECT GAMES WHICH ARE RELEASE IN SPECIFIC YEAR
        System.out.println("-------------------------SELECT GAMES WHICH ARE RELEASE IN SPECIFIC YEAR (2020)-------------------------");
        Collection<Game> games_2 = managerGame.selectGamesForYear("2020");
        for (Game game: games_2
        ) {
            System.out.println(game);
        }

        //1) UPDATE DEVELOPER IN THAT GAME WHICH ARE RELEASE IN SPECIFIC YEAR
        System.out.println("-------------------------UPDATE DEVELOPER (new_developer) IN THAT GAME WHICH ARE RELEASE IN SPECIFIC YEAR (2019)-------------------------");
        managerGame.updateDeveloperForYear("new_Developer","2019");
        Collection<Game> games_3 = managerGame.selectAll();
        for (Game game: games_3
        ) {
            System.out.println(game);
        }

        //1)DELETE BY NAME (Game_3)
        System.out.println("-------------------------DELETE BY NAME (Game_3)-------------------------");
        managerGame.deleteForName("Game_3");
        Collection<Game> games_4 = managerGame.selectAll();
        for (Game game: games_4
        ) {
            System.out.println(game);
        }

        //2)DELETE ALL GAMES
        System.out.println("-------------------------DELETE ALL-------------------------");
        managerGame.deleteAll();
        Collection<Game> games_5 = managerGame.selectAll();
        for (Game game: games_5
        ) {
            System.out.println(game);
        }

        managerCharacter.deleteTable();
        managerGame.deleteTableGame();


        managerGame.closeConn();
        managerCharacter.closeConn();

    }
}
