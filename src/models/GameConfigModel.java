
package models;
/**
 * @author yee
 * Game config model
 * Information holder for Game configuration values. Includes difficulty, mapType, and num of players
 */
public class GameConfigModel {
    // Instance vars
	private int difficulty;
	private int mapType;
	private int numberOfPlayers;
	
	

	/**
	 *  Init an empty Game Config Model
	 */
	public GameConfigModel()
	{
		difficulty = 0;
		mapType = 0;
		numberOfPlayers = 0;
	}
	

	/**
	 * @return difficulty
	 */
	public int getDifficulty()
	{
		return difficulty;
	}
	
	/**
	 * @param difficulty set difficulty from 0-3
	 */
	public void setDifficulty(int difficulty)
	{
		this.difficulty = difficulty;
	}
	

	/**
	 * @return map type integer value
	 */
	public int getMapType()
	{
		return mapType;
	}
	
	/**
	 * @param mapType set map type
	 */
	public void setMapType(int mapType)
	{
		this.mapType = mapType;
	}
	
	/**
	 * @return num of players in game
	 */
	public int getNumberOfPlayers()
	{
		return numberOfPlayers;
	}
	

	/**
	 * @param numberOfPlayers set number of players in the game
	 */
	public void setNumberOfPlayers(int numberOfPlayers)
	{
		this.numberOfPlayers = numberOfPlayers;
	}
	
}

