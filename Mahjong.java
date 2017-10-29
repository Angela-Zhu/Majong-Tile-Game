/*  Name: Angela Zhu
    Teacher: Ms. Dyke
    Date: Dec. 12, 2014
    Assignment: ICS ISP - The Mahjong Tile Game
		There would be a splash screen at first, showing the programmer name, and some animations.
		After that, the user would be at the main menu. There are 6 choices: easy level, medium level, hard level, instructions, high scores, and exit. The user needs to choose his/her option by entering the number of the choice.
		  If the user enters something that's not 1, 2, 3, 4, 5, or 6, there will be an error message window telling the user to enter the correct number.
		If the user chooses 1 in main menu, the program will go to the easy level (level 1) of the game. There would be a game board with 5 rows, 6 columns and 2 layers, with a total of 48 tiles.
		If the user chooses 2 in main menu, the program will go to the medium level (level 2) of the game. There would be a game board with 6 rows, 6 columns and 3 layers, with a total of 56 tiles.
		If the user chooses 3 in main menu, the program will go to the hard level (level 3) of the game. There would be a game board with 6 rows, 8 columns and 2 layers, with a total of 64 tiles.
		  In all three levels of the game, the user would be required to enter the row and the column of two tiles to select them and eliminate them.
		    If the user enters something that's not an integer, or a number that's out of the game board for row/col, the user would need to re-enter that line of data (row/col).
		    If the row and column that the user selected is blank (no tile), or that tile cannot be moved (there's another tile to the left and the right), the user would need to re-enter the row and the column.
		    If the two tiles that the user selected are not the same, which cannot be eliminated, nothing happens to the game board and the user need to re-enter the row & column for 2 tiles.
		  If it gets to a situation where there are no eliminations, there would be a message box telling the user it's shuffling, and the tiles would shuffle.
		  If all tiles are eliminated, the user wins, and there would be a message window telling the user his/her score, and the user would need to enter the user name.
		If the user chooses 4 in main menu, the program will go to the instructions screen, which tells the user how to use this program.
		  When the user presses a key to continue, the program would go back to the main menu.
		If the user chooses 5 in main menu, the program will go to the high scores screen (the user need to win a game first), which the top ten high scores would be showed on the screen and output to the high score file.
		  When the user presses a key to continue, the program would go back to the main menu.
		  If the user presses 'c' or 'C', all the data would be cleared, therefore the user cannot come back to the high scores screen until he/she wins another game.
		If the user chooses 6 in main menu, the program will go to the goodbye screen, which thanks the user for using this program.
		  When the user presses a key to continue, the program (window) would automatically close by itself.

    *** Variable chart -- instance & class variables
    Name        |    Type           |    Purpose
    ------------|-------------------|----------------------------------------------------------------------------
    c           |    reference      |    This is the reference variable associated with the class,
		|    variable       |    it gives access to all the methods already written in the Console file.
    ------------|-------------------|----------------------------------------------------------------------------
    choice      |    String         |    This is the variable used to store the choice of the user in main menu.
		|                   |    The expected values are 1, 2, 3, 4, 5, and 6.
    ------------|-------------------|----------------------------------------------------------------------------
    gameWon     |    boolean        |    This is the variable of whether the user has won a game or not.
		|                   |    It is used to determine if the user can go to the high scores screen.
    ------------|-------------------|----------------------------------------------------------------------------
    row1        |    int            |    The user input of the row of the first tile to select.
    ------------|-------------------|----------------------------------------------------------------------------
    row2        |    int            |    The user input of the row of the second tile to select.
    ------------|-------------------|----------------------------------------------------------------------------
    col1        |    int            |    The user input of the column of the first tile to select.
    ------------|-------------------|----------------------------------------------------------------------------
    col2        |    int            |    The user input of the column of the second tile to select.
    ------------|-------------------|----------------------------------------------------------------------------
    userName    |    String         |    The user input of the user name.
    ------------|-------------------|----------------------------------------------------------------------------
    score       |    int            |    The score calculated when the user wins a game.
    ------------|-------------------|----------------------------------------------------------------------------
    level       |    int            |    The level of the game that the user wins.
    ------------|-------------------|----------------------------------------------------------------------------
    tiles       |    int[][][]      |    The number of the tiles, from 1 to 36, 0 represents a blank.
		|                   |    Would be initialized in different game methods, by [row][column][layer].
    ------------|-------------------|----------------------------------------------------------------------------
    picture     |    Image          |    The pictures of the 42 tiles.
    ------------|-------------------|----------------------------------------------------------------------------
    background  |    Color          |    The background color of the program screen.
    ------------|-------------------|----------------------------------------------------------------------------
    WIDTH       |  static final int |    The width of the picture of each tile. Used for drawing purpose.
    ------------|-------------------|----------------------------------------------------------------------------
    LENGTH      |  static final int |    The length of the picture of each tile. Used for drawing purpose.
*/

// Library Files
import java.awt.*;
import java.io.*;   // for file IO
import java.applet.*;   // for picture import
import javax.swing.JComponent;  // for JOptionPane
import javax.swing.JOptionPane; //
import hsa.*;   // for Console and message box

// The Mahjong Class
public class Mahjong
{
    Console c;
    TimerClass t;
    String choice;
    boolean gameWon;
    int row1, row2, col1, col2;
    String userName;
    int score, level;
    int[] [] [] tiles = new int [6] [8] [3];
    Image[] picture = new Image [42];
    Color background = new Color (35, 130, 50);
    static final int LENGTH = 78;
    static final int WIDTH = 61;

    /* private method - drawTitle, clear screen, output title + 1 blank line + background graphics

    *** Variable chart -- local variables
    Name   |    Type           |    Purpose
    -------|-------------------|------------------------------------------------------------------
    x      |    int            |    This is a variable used in the loop, used to draw the letters.

    *** Loops
    * For Loop #1:
      Used to draw the 8 flower and season tiles.
      It uses the loop variable x, starts from 0, ends when x gets to 4, with an increment of +1.
    * For Loop #2:
      Used to draw part of the letter "W".
      It uses the loop variable x, starts from 0, ends when x gets to 30, with an increment of +1.
    * For Loop #3:
      Used to draw part of the letter "R".
      It uses the loop variable x, starts from 0, ends when x gets to 40, with an increment of +1.
    * For Loop #4:
      Used to draw part of the letter "N"
      It uses the loop variable x, starts from 0, ends when x gets to 39, with an increment of +1.
    */
    private void drawTitle ()
    {
	c.clear ();
	c.setColor (background);
	c.fillRect (0, 0, 880, 640);
	c.setTextBackgroundColor (background);
	c.setFont (new Font ("Arial", Font.PLAIN, 12));
	c.print (' ', 51);
	c.println ("Mahjong");
	c.println ();

	for (int x = 0 ; x < 4 ; x++)
	{
	    c.drawImage (picture [38 + x], 20 + 70 * x, 400, null);
	    c.drawImage (picture [34 + x], 589 + 70 * x, 500, null);
	}
	c.setColor (new Color (255, 128, 128));
	// F
	c.fillRect (350, 400, 50, 10);
	c.fillRect (350, 400, 10, 78);
	c.fillRect (350, 430, 45, 10);
	// L
	c.fillRect (420, 400, 10, 78);
	c.fillRect (420, 468, 50, 10);
	// O
	c.fillRect (490, 400, 50, 10);
	c.fillRect (490, 400, 10, 78);
	c.fillRect (530, 400, 10, 78);
	c.fillRect (490, 468, 50, 10);
	// W
	c.fillRect (560, 400, 10, 78);
	c.fillRect (625, 400, 10, 78);
	for (int x = 0 ; x < 30 ; x++)
	{
	    c.drawLine (560 + x, 477 - x, 575 + x, 477 - x);
	    c.drawLine (620 - x, 477 - x, 634 - x, 477 - x);
	}
	// E
	c.fillRect (655, 400, 50, 10);
	c.fillRect (655, 400, 10, 78);
	c.fillRect (655, 430, 45, 10);
	c.fillRect (655, 468, 50, 10);
	// R
	c.fillRect (725, 400, 50, 10);
	c.fillRect (725, 400, 10, 78);
	c.fillRect (725, 430, 50, 10);
	c.fillRect (765, 400, 10, 30);
	for (int x = 0 ; x < 40 ; x++)
	    c.drawLine (725 + x, 440 + x, 740 + x, 440 + x);

	// S
	c.fillRect (140, 500, 50, 10);
	c.fillRect (140, 500, 10, 39);
	c.fillRect (140, 535, 50, 10);
	c.fillRect (180, 540, 10, 38);
	c.fillRect (140, 568, 50, 10);
	// E
	c.fillRect (210, 500, 50, 10);
	c.fillRect (210, 500, 10, 78);
	c.fillRect (210, 530, 45, 10);
	c.fillRect (210, 568, 50, 10);
	// A
	c.fillRect (280, 500, 50, 10);
	c.fillRect (280, 500, 10, 78);
	c.fillRect (320, 500, 10, 78);
	c.fillRect (280, 530, 50, 10);
	// S
	c.fillRect (350, 500, 50, 10);
	c.fillRect (350, 500, 10, 39);
	c.fillRect (350, 535, 50, 10);
	c.fillRect (390, 540, 10, 38);
	c.fillRect (350, 568, 50, 10);
	// O
	c.fillRect (420, 500, 50, 10);
	c.fillRect (420, 500, 10, 78);
	c.fillRect (460, 500, 10, 78);
	c.fillRect (420, 568, 50, 10);
	// N
	c.fillRect (490, 500, 10, 78);
	c.fillRect (530, 500, 10, 78);
	for (int x = 0 ; x < 39 ; x++)
	    c.fillRect (490 + x, 500 + 2 * x, 10, 2);
    }


    // private method - pauseProgram, stays on the screen until the user presses a key
    private void pauseProgram ()
    {
	c.println ();
	c.println ("Press any key to continue...");
	c.getChar ();
    }


    /* private method - askLocation, asks the user to enter the location (row & column) of two tiles to select the tiles

    *** Variable chart -- local variables
    Name   |  Type               |    Purpose
    -------|---------------------|-----------------------------------------------------------------------
    e      |  Exception variable |    The variable for the NumberFormatException.
    -------|---------------------|-----------------------------------------------------------------------
    x      |  int                |    This is a variable used in the loop, used to clear the input lines.

    *** Loops
    * While Loop #1:
      Used to let the user input the row and column of the first tile (row1 & col1).
      The loop exits if the tile at the location that the user entered can be selected, or the user chooses to exit (enter "99").
    * While Loop #2 (in loop #1):
      Used to let the user input the row of the first tile (row1).
      The loop exits when the value of row1 is valid, or the user chooses to exit (enter "99").
    * While Loop #3 (in loop #1):
      Used to let the user input the column of the first tile (col1).
      The loop exits when the value of col1 is valid.
    * While Loop #4:
      Used to let the user input the row and column of the second tile (row2 & col2).
      The loop exits if the tile at the location that the user entered can be selected.
    * While Loop #5 (in loop #4):
      Used to let the user input the row of the first tile (row2).
      The loop exits when the value of row2 is valid.
    * While Loop #6 (in loop #4):
      Used to let the user input the column of the first tile (col2).
      The loop exits when the value of col2 is valid.
    * For Loop:
      Used to clear the four lines of user input lines.
      It uses the loop variable x, starts from 0, ends when x gets to 4, with an increment of +1.

    *** Conditional Statements
    * If Structure #1:
      Used to check if the user input of row1 is valid.
      If the value is 99, or is larger than 0 and is not larger than the max row of the game board, then while loop #2 would break.
    * If Structure #2:
      Used to check if the user chooses to exit.
      If the value of row1 is 99, then while loop #1 would break. If not, row1 would -1.
    * If Structure #3:
      Used to check if the user input of col1 is valid.
      If the value is larger than 0 and is not larger than the max column of the game board, then while loop #3 would break.
    * If Structure #4:
      Used to check if the tile at the location can be selected.
      If the tile can be selected, then while loop #1 would break.
    * If Structure #5:
      Used to check if the user chose to exit
      If the value of row1 is not 99, the user would continue to enter the row & column of second tile.
    * If Structure #6:
      Used to check if the user input of row2 is valid.
      If the value is larger than 0 and is not larger than the max row of the game board, then while loop #5 would break.
    * If Structure #7:
      Used to check if the user input of col2 is valid.
      If the value is larger than 0 and is not larger than the max column of the game board, then while loop #6 would break.
    * If Structure #8:
      Used to check if the tile at the location can be selected, and is not the same tile as the first selection.
      If the tile can be selected, and row2&col2 does not equal to row1&col1, then while loop #4 would break.

    *** Segment Block
    * Try Block #1, #2, #3, #4:
      Used for the conversion from a string to an int (4 blocks for 4 values).
      Catches a NumberFormatException if the user input cannot be converted into an int.
    */
    private void askLocation ()
    {
	while (true)
	{
	    c.setCursor (28, 1);
	    c.println ("Please enter the row of the first tile: ");
	    while (true)
	    {
		try
		{
		    c.setCursor (28, 41);
		    row1 = Integer.parseInt (c.readLine ());
		    if (row1 == 99 || (row1 > 0 && ((choice.equals ("1") && row1 <= 5) || ((choice.equals ("2") || choice.equals ("3")) && row1 <= 6))))
			break;
		}
		catch (NumberFormatException e)
		{
		}
		c.setCursor (28, 41);
		c.println ();
	    }
	    if (row1 == 99)
		break;
	    else
		row1--;

	    c.print ("Please enter the column of the first tile: ");
	    while (true)
	    {
		try
		{
		    c.setCursor (29, 44);
		    col1 = Integer.parseInt (c.readLine ());
		    if (col1 > 0 && ((choice.equals ("3") && col1 <= 8) || ((choice.equals ("1") || choice.equals ("2")) && col1 <= 6)))
			break;
		}
		catch (NumberFormatException e)
		{
		}
		c.setCursor (29, 44);
		c.println ();
	    }
	    col1--;
	    if (isBlocked (row1, col1) == false)
		break;
	    c.setCursor (28, 1);
	    c.println ();
	    c.println ();
	}
	if (row1 != 99)
	{
	    while (true)
	    {
		c.setCursor (30, 1);
		c.print ("Please enter the row of the second tile: ");
		while (true)
		{
		    try
		    {
			c.setCursor (30, 42);
			row2 = Integer.parseInt (c.readLine ());
			if (row2 > 0 && ((choice.equals ("1") && row2 <= 5) || ((choice.equals ("2") || choice.equals ("3")) && row2 <= 6)))
			    break;
		    }
		    catch (NumberFormatException e)
		    {
		    }
		    c.setCursor (30, 42);
		    c.println ();
		}
		row2--;

		c.print ("Please enter the column of the second tile: ");
		while (true)
		{
		    try
		    {
			c.setCursor (31, 45);
			col2 = Integer.parseInt (c.readLine ());
			if (col2 > 0 && ((choice.equals ("3") && col2 <= 8) || ((choice.equals ("1") || choice.equals ("2")) && col2 <= 6)))
			    break;
		    }
		    catch (NumberFormatException e)
		    {
		    }
		    c.setCursor (31, 45);
		    c.println ();
		}
		col2--;
		if (isBlocked (row2, col2) == false && !(row2 == row1 && col2 == col1))
		    break;
		c.setCursor (30, 1);
		c.println ();
		c.println ();
	    }
	    c.setCursor (28, 1);
	    for (int x = 0 ; x < 4 ; x++)
		c.println ();
	}
    }


    /* private method - sort, sorts the high scores

    *** Variable chart -- local variables
    Name       |    Type           |    Purpose
    -----------|-------------------|-------------------------------------------------------------------
    userNames  |    String[]       |    The parameter pass variable for the list of userNames, max. 10.
    -----------|-------------------|-------------------------------------------------------------------
    scores     |    int[]          |    The parameter pass variable for the list of scores, max. 10.
    -----------|-------------------|-------------------------------------------------------------------
    levels     |    int[]          |    The parameter pass variable for the list of levels, max. 10.
    -----------|-------------------|-------------------------------------------------------------------
    count      |    int            |    The number of existing scores that > score.
    -----------|-------------------|-------------------------------------------------------------------
    output     |    int            |    The number of existing scores.
    -----------|-------------------|-------------------------------------------------------------------
    fileExist  |    boolean        |    The variable of whether the file for the high scores exist.
    -----------|-------------------|-------------------------------------------------------------------
    x          |    int            |    The loop variable used in the for loops.
    -----------|-------------------|-------------------------------------------------------------------
    e          | Exception variable|    The variable for the IOException, NumberFormatException and NullPointerException.

    *** Loops
    * While Loop #1:
      Used to check the number of existing scores that > score.
      The loop exits if the existing score is > score.
    * For Loop #1:
      Used to read in the existing high scores.
      It uses the loop variable x, starts from 0, ends when x gets to 10, with an increment of +1.
    * For Loop #2:
      Used to output the existing high scores that < score.
      It uses the loop variable x, starts from 0, ends when x gets to count, with an increment of +1.
    * For Loop #3:
      Used to output the existing high scores that > score.
      It uses the loop variable x, starts from count, ends when x gets to output, with an increment of +1.

    *** Conditional Statements
    * If Structure #1:
      Used to check if the high score file exists.
      If the line read in is the header, then fileExist = true.
    * If Structure #2:
      Used to check if the high score file should be recreated.
      If the fileExist is false, then create the high score file.
    * If Structure #3:
      Used to check if the header in the file is correct.
      If the header is correct, then read in the data.
    * If Structure #4:
      Used to check for the situation where there aren't 10 existing scores.
      If the user name read in is null, then break for loop #1.
    * If Structure #5:
      Used to check if the user has just won a game.
      If score does not equal to 0, which the user has won a game, then output that score.

    *** Segment Block
    * Try Block #1, #3, #4 (the numbers are in order):
      Used for File IO, catches an IOException.
    * Try Block #2:
      Used to check if file exists, catches a NullPointerException.
    * Try Block #3:
      Used for converting String to an int, catches a NumberFormatException.
    */
    private void sort (String[] userNames, int[] scores, int[] levels)
    {
	int count = 0;
	int output = 0;
	boolean fileExist = false;

	try
	{
	    BufferedReader in = new BufferedReader (new FileReader ("High Scores.ang"));
	    if (in.readLine ().equals ("Mahjong Scores"))
		fileExist = true;
	}
	catch (IOException e)
	{
	}
	catch (NullPointerException e)
	{
	    fileExist = false;
	}

	if (fileExist == false)
	{
	    try
	    {
		PrintWriter out = new PrintWriter (new FileWriter ("High Scores.ang"));
		out.println ("Mahjong Scores");
		out.close ();
	    }
	    catch (IOException e)
	    {
	    }
	}

	try
	{
	    BufferedReader in = new BufferedReader (new FileReader ("High Scores.ang"));
	    if (in.readLine ().equals ("Mahjong Scores"))
	    {
		for (int x = 0 ; x < 10 ; x++)
		{
		    userNames [x] = in.readLine ();
		    if (userNames [x] == null)
			break;
		    scores [x] = Integer.parseInt (in.readLine ());
		    levels [x] = Integer.parseInt (in.readLine ());
		    output++;
		}
	    }
	    while (scores [count] > score && count < output)
	    {
		count++;
	    }
	    PrintWriter out = new PrintWriter (new FileWriter ("High Scores.ang"));
	    out.println ("Mahjong Scores");
	    for (int x = 0 ; x < count ; x++)
	    {
		out.println (userNames [x]);
		out.println (scores [x]);
		out.println (levels [x]);
	    }
	    if (score != 0)
	    {
		out.println (userName);
		out.println (score);
		out.println (level);
	    }
	    for (int x = count ; x < output ; x++)
	    {
		out.println (userNames [x]);
		out.println (scores [x]);
		out.println (levels [x]);
	    }
	    out.close ();
	}
	catch (IOException e)
	{
	}
	catch (NumberFormatException e)
	{
	}
    }


    /* private method - calculate score, used to calculate the score depending on the level

    *** Variable chart -- local variables
    Name       |    Type           |    Purpose
    -----------|-------------------|-------------------------------------------------------------------
    total      |    int            |    The parameter pass variable for the total number of tiles.
    -----------|-------------------|-------------------------------------------------------------------
    SCORE      |    final int      |    The score of 1 tile.

    *** Conditional Statements
    * If Structure:
      Used to check the level.
      If total is 48, it's level 1. If total is 56, level is 2. If none of above, level is 3.
    */
    private void calculateScore (int total)
    {
	final int SCORE = 50;
	int bonus = 0;
	if (total == 48)
	{
	    level = 1;
	    bonus = 300 - t.getTime ();
	    score = total * SCORE + bonus;
	}
	else if (total == 56)
	{
	    level = 2;
	    score = total * SCORE + (480 - t.getTime ());
	}
	else
	{
	    level = 3;
	    score = total * SCORE + (600 - t.getTime ());
	}
    }


    /* private method - draw, for redrawing pictures of tile after elimination

    *** Variable chart -- local variables
    Name       |    Type           |    Purpose
    -----------|-------------------|-------------------------------------------------------------------
    row        |    int            |    The parameter pass for the number of rows in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    col        |    int            |    The parameter pass for the number of columns in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    layer      |    int            |    The parameter pass for the number of layers in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    rowSpace   |    int            |    The parameter pass for the spacing to the left of the grid (game board).
    -----------|-------------------|-------------------------------------------------------------------
    colSpace   |    int            |    The parameter pass for the spacing above the grid.
    -----------|-------------------|-------------------------------------------------------------------
    random     |    int[]          |    The parameter pass for the number of the picture (1-4) for the flower and season tiles.
    -----------|-------------------|-------------------------------------------------------------------
    counter    |    int            |    To count for the number of season & flower tiles.
    -----------|-------------------|-------------------------------------------------------------------
    x          |    int            |    The loop variable used in the for loops.
    -----------|-------------------|-------------------------------------------------------------------
    y          |    int            |    The loop variable used in the for loops.
    -----------|-------------------|-------------------------------------------------------------------
    z          |    int            |    The loop variable used in the for loops.

    *** Loops
    * For Loop #1:
      Used to draw the horizontal lines of the grid.
    * For Loop #2:
      Used to draw the vertical lines of the grid.
    * For Loop #3:
      Used to count through the layers of the game board for drawing the pictures.
    * For Loop #4:
      Used to count through the rows of the game board for drawing the pictures.
    * For Loop #5:
      Used to count through the columns of the game board for drawing the pictures.

    *** Conditional Statements
    * If Structure #1:
      Used to check if there is supposed to be a tile at that location (of row x, column y, layer z).
      If the value of tiles[x][y][z] is between 0 and 34, then there should be a tile that's not season/flower. Else, go to if #2.
    * If Structure #2:
      Used to check if there is a season or slower tile at that location.
      If the value of tiles[x][y][z] id 35 or 36, which there is a season/flower tile, then go to if #3.
    * If Structure #3:
      Used to check if the tile at the location is a season tile or flower tile.
      If it's a season tile, draw the season tile. Else, draw the flower tile.
    */
    private void draw (int row, int col, int layer, int rowSpace, int colSpace, int[] random)
    {
	c.setColor (background);
	c.fillRect (colSpace - 5, rowSpace - 5, col * WIDTH + 5, row * LENGTH + 5);
	c.setColor (Color.black);
	c.drawRect (colSpace, rowSpace, col * WIDTH, row * LENGTH);
	for (int x = 1 ; x < row ; x++)
	    c.drawLine (colSpace, rowSpace + x * LENGTH, colSpace + col * WIDTH, rowSpace + x * LENGTH);
	for (int x = 1 ; x < col ; x++)
	    c.drawLine (colSpace + x * WIDTH, rowSpace, colSpace + x * WIDTH, rowSpace + row * LENGTH);

	int counter = 0;
	for (int z = layer - 1 ; z >= 0 ; z--)
	{
	    for (int x = 0 ; x < row ; x++)
	    {
		for (int y = 0 ; y < col ; y++)
		{
		    if (tiles [x] [y] [z] > 0 && tiles [x] [y] [z] <= 34)
			c.drawImage (picture [tiles [x] [y] [z] - 1], WIDTH * y + colSpace - 5 * (layer - 1 - z), LENGTH * x + rowSpace - 5 * (layer - 1 - z), null);
		    else
		    {
			if (tiles [x] [y] [z] == 35 || tiles [x] [y] [z] == 36)
			{
			    if (tiles [x] [y] [z] == 35)
			    {
				c.drawImage (picture [tiles [x] [y] [z] + random [counter]], WIDTH * y + colSpace - 5 * (layer - 1 - z), LENGTH * x + rowSpace - 5 * (layer - 1 - z), null);
				counter++;
			    }
			    else
			    {
				c.drawImage (picture [tiles [x] [y] [z] + 3 + random [counter]], WIDTH * y + colSpace - 5 * (layer - 1 - z), LENGTH * x + rowSpace - 5 * (layer - 1 - z), null);
				counter++;

			    }
			}
		    }
		}
	    }
	}
    }


    /* private method - shuffle, for shuffling tiles when there are no more available moves

    *** Variable chart -- local variables
    Name       |    Type           |    Purpose
    -----------|-------------------|-------------------------------------------------------------------
    row        |    int            |    The parameter pass for the number of rows in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    col        |    int            |    The parameter pass for the number of columns in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    layer      |    int            |    The parameter pass for the number of layers in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    counter    |    int            |    To count for the number of tiles that are not eliminated yet.
    -----------|-------------------|------------------------------------------------------------------
    tile       |    int[]          |    The number of the tiles in this level of game.
    -----------|-------------------|------------------------------------------------------------------
    rand       |    int            |    The number of the tile to switch.
    -----------|-------------------|------------------------------------------------------------------
    num        |    int            |    The middle variable for switching tiles.
    -----------|-------------------|------------------------------------------------------------------
    tileNum    |    int            |    The number of tiles that are initialized.
    -----------|-------------------|-------------------------------------------------------------------
    r          |    int            |    To store the row of the tile in a certain situation.
    -----------|-------------------|-------------------------------------------------------------------
    c          |    int            |    To store the column of the tile in a certain situation.
    -----------|-------------------|-------------------------------------------------------------------
    l          |    int            |    To store the layer of the tile in a certain situation.
    -----------|-------------------|-------------------------------------------------------------------
    x          |    int            |    The loop variable used in the for loops.
    -----------|-------------------|-------------------------------------------------------------------
    y          |    int            |    The loop variable used in the for loops.
    -----------|-------------------|-------------------------------------------------------------------
    z          |    int            |    The loop variable used in the for loops.

    *** Loops
    * While Loop:
      Used to shuffle the tiles until there are available moves (eliminations) on the game board.
    * For Loop #1, #2, #3:
      Used to go through all rows, columns and layers, and count for the number of tiles that are not eliminated.
    * For Loop #4, #5, #6:
      Used to go through all rows, columns and layers, and store the row, column and layer of the first tile that it finds, then break.
    * For Loop #7, #8, #9:
      Used to go through all rows, columns and layers, and store all numbers of the tiles from tiles[][][] to tile[].
    * For Loop #10:
      Used to shuffle (switch the positions) of the tiles stored in tile[].
    * For Loop #11, #12, #13:
      Used to go through all rows, columns and layers, and assign tiles[][][] the value of the shuffled tile[] at the same position as before shuffling.

    *** Conditional Statements
    * If Structure #1:
      Used to check if there is a tile at that location (of row x, column y, layer z).
    * If Structure #2:
      Used to check if there are only 2 tiles left on the game board.
    * If Structure #3:
      Used to check if there is a tile at the location, is there is then store the location of that tile and break the loop.
    * If Structure #4:
      Used to check if the two tiles left are in the situation which, one tile is on top of the other.
    * If Structure #5:
      Used to check if the two tiles are at the edge of the game board.
    * If Structure #6:
      Used to check if there is supposed to be a tile at that location, is for assigning tile[] the values of tiles[][][].
    * If Structure #7:
      Used to check if there is supposed to be a tile at that location, is for re-assigning values of tiles[][][].
    */
    private void shuffle (int row, int col, int layer)
    {
	while (!isMoveable (row, col, layer))
	{
	    int counter = 0;
	    for (int x = 0 ; x < row ; x++)
	    {
		for (int y = 0 ; y < col ; y++)
		{
		    for (int z = 0 ; z < layer ; z++)
		    {
			if (tiles [x] [y] [z] != 0)
			    counter++;
		    }
		}
	    }
	    if (counter == 2)
	    {
		int r = 0, c = 0, l = 0;
		for (int x = 0 ; x < row ; x++)
		{
		    for (int y = 0 ; y < col ; y++)
		    {
			for (int z = 0 ; z < layer ; z++)
			{
			    if (tiles [x] [y] [z] != 0)
			    {
				r = x;
				c = y;
				l = z;
				break;
			    }
			}
		    }
		}
		if (tiles [r] [c] [l] == tiles [r] [c] [l + 1])
		{
		    if (c == col)
			tiles [r] [c - 1] [l + 1] = tiles [r] [c] [l + 1];
		    else
			tiles [r] [c + 1] [l + 1] = tiles [r] [c] [l + 1];
		    tiles [r] [c] [l] = 0;
		}
	    }
	    int[] tile = new int [counter];
	    int rand, num, tileNum = 0;

	    for (int x = 0 ; x < row ; x++)
	    {
		for (int y = 0 ; y < col ; y++)
		{
		    for (int z = 0 ; z < layer ; z++)
		    {
			if (tiles [x] [y] [z] != 0)
			{
			    tile [tileNum] = tiles [x] [y] [z];
			    tileNum++;
			}
		    }
		}
	    }
	    for (int x = 0 ; x < counter / 2 ; x++)
	    {
		rand = (int) (Math.random () * counter);
		num = tile [x];
		tile [x] = tile [rand];
		tile [rand] = num;
	    }

	    num = counter - 1;
	    for (int x = 0 ; x < row ; x++)
	    {
		for (int y = 0 ; y < col ; y++)
		{
		    for (int z = 0 ; z < layer ; z++)
		    {
			if (tiles [x] [y] [z] != 0)
			{
			    tiles [x] [y] [z] = tile [num];
			    num--;
			}
		    }
		}
	    }
	}
    }


    /* private method - userInput, let the user select tiles to eliminate until the user wins or chooses to exit

    *** Variable chart -- local variables
    Name       |    Type           |    Purpose
    -----------|-------------------|-------------------------------------------------------------------
    row        |    int            |    The parameter pass for the number of rows in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    col        |    int            |    The parameter pass for the number of columns in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    layer      |    int            |    The parameter pass for the number of layers in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    total      |    int            |    The parameter pass for the total number of tiles in the game.
    -----------|-------------------|-------------------------------------------------------------------
    random     |    int[]          |    The parameter pass for the number of the picture (1-4) for the flower and season tiles.
    -----------|-------------------|-------------------------------------------------------------------
    x          |    int            |    The loop variable used in the for loops.
    -----------|---------------------|-----------------------------------------------------------------------
    e          |  Exception variable |    The variable for the NumberFormatException.

    *** Loops
    * While Loop #1:
      Used to ask the user to select tiles to eliminate until the user wins (or chooses to exit).
    * While Loop #2:
      Used to ask the user to select tiles to eliminate until there are no more available moves.
    * Do While Loop:
      Used to ask the user to select tiles to eliminate until the two tiles selected can be eliminated
    * For Loop #1, #2:
      Used to go through all layers, to check which is the top tile at the row & column that user entered (for row1 col1 and row2 col2).

    *** Conditional Statements
    * If Structure #1:
      Used to check if the user chose to exit (entered 99), if yes then break do while.
    * If Structure #2:
      Used to check if the user chose to exit (entered 99), if yes then break while #2.
    * If Structure #3, #4:
      Used to check for the top tile at the row & column that user entered (for row1 col1 and row2 col2). Breaks the for loop and reset row1, col1, row2, col2 to 0.
    * If Structure #5:
      Used to check if the user chose to exit (entered 99), if yes then break while #1.
    * If Structure #6:
      Used to check if the user has won the game. If yes then calculate score, else, which means there are still tiles left on game board, then shuffle.
    * If Structure #7:
      Used to check if the user chose to exit (entered 99), if not then ask user name.

    *** Segment Block
    * Try Block:
      Used for the user input of the user name, using JOptionPane.
      Catches a NullPointerException, which the user clicks "cancel", then make user name "NO NAME".
    */
    private void userInput (int row, int col, int layer, int total, int[] random)
    {
	time ();
	while (!isWon (row, col, layer))
	{
	    draw (row, col, layer, 60, (880 - WIDTH * col) / 2, random);
	    while (isMoveable (row, col, layer))
	    {
		do
		{
		    askLocation ();
		    if (row1 == 99)
			break;
		}
		while (!isSame (row1, row2, col1, col2));
		if (row1 == 99)
		    break;

		for (int x = 0 ; x < layer ; x++)
		{
		    if (tiles [row1] [col1] [x] != 0)
		    {
			tiles [row1] [col1] [x] = 0;
			row1 = 0;
			col1 = 0;
			break;
		    }
		}
		for (int x = 0 ; x < layer ; x++)
		{
		    if (tiles [row2] [col2] [x] != 0)
		    {
			tiles [row2] [col2] [x] = 0;
			row2 = 0;
			col2 = 0;
			break;
		    }
		}
		draw (row, col, layer, 60, (880 - WIDTH * col) / 2, random);
	    }
	    if (row1 == 99)
		break;

	    if (isWon (row, col, layer) == true)
	    {
		gameWon = true;
		calculateScore (total);
	    }
	    else
	    {
		JOptionPane.showMessageDialog (null, "No more available moves! Shuffling...", "Shuffling", JOptionPane.INFORMATION_MESSAGE);
		shuffle (row, col, layer);
	    }
	}
	if (row1 != 99)
	{
	    try
	    {
		do
		{
		    userName = JOptionPane.showInputDialog (null, "Congratulations! Your score is: " + score + ". Please enter your user name!", "You won!", JOptionPane.QUESTION_MESSAGE);
		}
		while (userName.length () > 20);
	    }
	    catch (NullPointerException e)
	    {
		userName = "NO NAME";
	    }
	}
    }


    /* black box method - returns a boolean, checks if he tile can be selected or not

    *** Variable chart -- local variables
    Name   |    Type           |    Purpose
    -------|-------------------|-------------------------------------------------------------------
    row    |    int            |    The parameter pass for the number of rows in the game board.
    -------|-------------------|-------------------------------------------------------------------
    col    |    int            |    The parameter pass for the number of columns in the game board.
    -------|-------------------|------------------------------------------------------------------
    x      |    int            |    This is a variable used in the loop.

    *** Loops
    * For Loop:
      Used to go through all layers, to check which is the top tile at the row & column that user entered (for row1 col1 and row2 col2).

    *** Conditional Statements
    * If Structure #1:
      Used to check for the top tile at the row & column that user entered.
    * If Structure #2:
      Used to check if that tile is blocked (cannot be moved). If the tile is at the edge of the game board or there is no tile to the left/right of it, then it is not blocked, return false.
    */
    private boolean isBlocked (int row, int col)
    {
	int x;
	for (x = 0 ; x < 3 ; x++)
	{
	    if (tiles [row] [col] [x] != 0)
		break;
	}
	if (x != 3 && (col == 0 || col == 7 || tiles [row] [col - 1] [x] == 0 || tiles [row] [col + 1] [x] == 0))
	    return false;
	return true;
    }


    /* black box method - returns boolean, checks if the two tiles are the same

    *** Variable chart -- local variables
    Name   |    Type           |    Purpose
    -------|-------------------|-------------------------------------------------------------------
    row    |    int            |    The parameter pass for the row that the first tile is located.
    -------|-------------------|-------------------------------------------------------------------
    col    |    int            |    The parameter pass for the column that the first tile is located.
    -------|-------------------|-------------------------------------------------------------------
    row2   |    int            |    The parameter pass for the row that the second tile is located.
    -------|-------------------|-------------------------------------------------------------------
    col2   |    int            |    The parameter pass for the column that the second tile is located.
    -------|-------------------|------------------------------------------------------------------
    x      |    int            |    The layer that the first tile is located at.
    -------|-------------------|------------------------------------------------------------------
    y      |    int            |    The layer that the second tile is located at.

    *** Loops
    * While Loop #1:
      x (layer of the first tile) keeps on adding until there is a tile at that location or it gets to the last layer.
    * While Loop #2:
      y (layer of the second tile) keeps on adding until there is a tile at that location or it gets to the last layer.

    *** Conditional Statements
    * If Structure:
      Used to check if the two tiles that the user selected are the same (have the same value). If yes, then return true.
    */
    private boolean isSame (int row, int row2, int col, int col2)
    {
	int x = 0, y = 0;
	while (tiles [row] [col] [x] == 0 && x < 3)
	{
	    x++;
	}
	while (tiles [row2] [col2] [y] == 0 && y < 3)
	{
	    y++;
	}
	if (tiles [row] [col] [x] == tiles [row2] [col2] [y])
	    return true;
	return false;
    }


    /* black box method - returns boolean, checks if the user is not able to select any more tiles

    *** Variable chart -- local variables
    Name       |    Type           |    Purpose
    -----------|-------------------|-------------------------------------------------------------------
    row        |    int            |    The parameter pass for the number of rows in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    col        |    int            |    The parameter pass for the number of columns in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    layer      |    int            |    The parameter pass for the number of layers in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    count      |    int            |    The number of tiles that can be selected.
    -----------|-------------------|-------------------------------------------------------------------
    t          |    int[]          |    The value of the tiles that can be selected.
    -----------|-------------------|-------------------------------------------------------------------
    x          |    int            |    The loop variable used in the for loops.
    -----------|-------------------|-------------------------------------------------------------------
    y          |    int            |    The loop variable used in the for loops.
    -----------|-------------------|-------------------------------------------------------------------
    z          |    int            |    The loop variable used in the for loops.

    *** Loops
    * For Loop #1, #2, #3:
      Used to go through all rows, columns and layers, and count for the number of tiles that are on the edge, which can be selected, and store the tile values into t[].
    * For Loop #1, #2:
      Used to go through all saved tile values, check all tiles with each other to see if any of the two tiles equals (which can be eliminated).

    *** Conditional Statements
    * If Structure #1:
      Used to check if the tile at that location is on a edge which can be selected.
      If the tile is on the egde of the game board or there are no tiles to the left/right, and on top of it, then that tile is not blocked, can be selected.
    * If Structure #2:
      Used to check if the two tiles (t[x] and t[y]) have the same values, which can be eliminated. If yes, return true.
    */
    private boolean isMoveable (int row, int col, int layer)
    {
	int count = -1;
	int[] t = new int [24];
	for (int x = 0 ; x < layer ; x++)
	{
	    for (int y = 0 ; y < row ; y++)
	    {
		for (int z = 0 ; z < col ; z++)
		{
		    if (tiles [y] [z] [x] != 0 && (z == 0 || z == col - 1 || tiles [y] [z - 1] [x] == 0 || tiles [y] [z + 1] [x] == 0) && (x == 0 || tiles [y] [z] [x - 1] == 0))
		    {
			count++;
			t [count] = tiles [y] [z] [x];
		    }
		}
	    }
	}
	for (int x = 0 ; x <= count ; x++)
	{
	    for (int y = x + 1 ; y <= count ; y++)
	    {
		if (t [x] == t [y])
		    return true;
	    }
	}
	return false;
    }


    /* black box method - returns a boolean, checks if the user has won the game.

    *** Variable chart -- local variables
    Name       |    Type           |    Purpose
    -----------|-------------------|-------------------------------------------------------------------
    row        |    int            |    The parameter pass for the number of rows in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    col        |    int            |    The parameter pass for the number of columns in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    layer      |    int            |    The parameter pass for the number of layers in the game board.
    -----------|-------------------|-------------------------------------------------------------------
    num        |    int            |    The number blank spaces on the game board.
    -----------|-------------------|-------------------------------------------------------------------
    x          |    int            |    The loop variable used in the for loops.
    -----------|-------------------|-------------------------------------------------------------------
    y          |    int            |    The loop variable used in the for loops.
    -----------|-------------------|-------------------------------------------------------------------
    z          |    int            |    The loop variable used in the for loops.

    *** Loops
    * For Loop #1, #2, #3:
      Used to go through all rows, columns and layers, and check for the number of blank spaces on the game board. Breaks if it finds an existing tile.

    *** Conditional Statements
    * If Structure #1:
      Used to check if the there is a tile at that location.
      If the value equals to 0, then break the for loop. Else, num++.
    * If Structure #2:
      Used to check if all the spaces on the game board is blank. If yes, return true.
    */
    private boolean isWon (int row, int col, int layer)
    {
	int num = 0;
	for (int x = 0 ; x < row ; x++)
	{
	    for (int y = 0 ; y < col ; y++)
	    {
		for (int z = 0 ; z < layer ; z++)
		{
		    if (tiles [x] [y] [z] != 0)
			break;
		    else
			num++;
		}
	    }
	}
	if (num == row * col * layer)
	{
	    return true;
	}
	return false;
    }


    /* public method - loadImage, for loading all 42 tile pics

    *** Variable chart -- local variables
    Name   |    Type           |    Purpose
    -------|-------------------|------------------------------------------------------------------
    x      |    int            |    This is a variable used in the loop, used to load all images.
    -------|-------------------|------------------------------------------------------------------
    e      | Exception variable|    The variable for the InterruptedException.

    *** Loops
    * For Loop:
      Used to load all 42 images.
      It uses the loop variable x, starts from 0, ends when x gets to 42, with an increment of +1.

    *** Conditional Statements
    * If Structure:
      Used to check if there is an error when loading images.

    *** Segment Block
    * Try Block:
      Used for loading images, catches an InterruptedException.
    */
    public void loadImage ()
    {
	MediaTracker tracker = new MediaTracker (new Frame ());
	for (int x = 0 ; x < 42 ; x++)
	{
	    picture [x] = Toolkit.getDefaultToolkit ().getImage ("Tile" + (x + 1) + ".jpg");
	    tracker.addImage (picture [x], x);
	}
	try
	{
	    tracker.waitForAll ();
	}
	catch (InterruptedException e)
	{
	}
	if (tracker.isErrorAny ())
	{
	    new Message ("Couldn't load picture!", "ERROR");
	    return;
	}
    }


    /* public method - splashScreen, output splash screen

    *** Variable chart -- local variables
    Name        |    Type           |    Purpose
    ------------|-------------------|----------------------------------------------------------------------------
    a           |    reference      |    This is the reference variable associated with the Animation class,
		|    variable       |    it gives access to all the methods in the class.
    */
    public void splashScreen ()
    {
	c.setColor (new Color (170, 145, 190));
	c.fillRect (0, 0, 880, 640);
	c.setColor (Color.black);
	c.setFont (new Font ("Bradley Hand ITC", Font.PLAIN, 20));
	c.drawString ("Programmer: Angela Zhu", 320, 600);
	Animation a = new Animation (c);
	a.run ();
    }


    /* public method - mainMenu, outputs the main menu, asks for the user's choice of continuing program

    *** Loops
    * While Loop:
      Used to let the user input his/her option to continue program.
      The loop exits when choice equals 1, 2, 3, 4, 5, or 6.

    *** Conditional Statements
    * If Structure:
      Used to check if the user inputs the right number.
      If the user inputs 1, 2, 3, 4, 5, or 6, then the while loop breaks.
    */
    public void mainMenu ()
    {
	drawTitle ();
	c.println ("1. Easy (Level 1)");
	c.println ();
	c.println ("2. Medium (Level 2)");
	c.println ();
	c.println ("3. Hard (Level 3)");
	c.println ();
	c.println ("4. Instructions");
	c.println ();
	c.println ("5. Show High Scores");
	c.println ();
	c.println ("6. Exit");
	c.println ();
	c.println ("Please enter the number of your choice: ");
	while (true)
	{
	    c.setCursor (15, 41);
	    choice = c.readLine ();
	    if (choice.equals ("1") || choice.equals ("2") || choice.equals ("3") || choice.equals ("4") || choice.equals ("5") || choice.equals ("6"))
		break;
	    new Message ("Please enter an integer betwen 1-6!", "ERROR");
	    c.setCursor (15, 41);
	    c.println ();
	}
    }


    // public method - instructions, shows intructions of the game, goes back to main menu
    public void instructions ()
    {
	drawTitle ();
	c.println ("Instructions");
	c.println ();
	c.println ("How to play the Mahjong Tile game:");
	c.println ("Match the tiles on the edge that have the same pattern to eliminate them.");
	c.println ("You can match any flower tiles together, or any season tiles together.");
	c.println ("You would win when all tiles are eliminated.");
	c.println ("Scores would be calculated depending on the time you spent.");
	c.println ();
	c.println ("There are 3 dificulties:");
	c.println ("1. Easy: bridge shape, 5 rows, 6 columns, 2 layers, 48 tiles.");
	c.println ("2. Medium: pyramid shape, 6 rows, 6 columns, 3 layers, 56 tiles.");
	c.println ("3. Hard: heart shape, 6 rows, 8 columns, 2 layers, 64 tiles.");
	c.println ();
	c.println ("Choose your option of game at the main menu.");
	c.println ("The only place that you can chose to exit the game is the main menu.");
	pauseProgram ();
    }


    /* public method - highScore, shows the top ten scores, with the corresponding user name and level, also saves data in file, user can choose to clear it

    *** Variable chart -- local variables
    Name       |    Type           |    Purpose
    -----------|-------------------|-------------------------------------------------------------------
    userNames  |    String[]       |    The variable for the list of userNames, max. 10.
    -----------|-------------------|-------------------------------------------------------------------
    scores     |    int[]          |    The variable for the list of scores, max. 10.
    -----------|-------------------|-------------------------------------------------------------------
    levels     |    int[]          |    The variable for the list of levels, max. 10.
    -----------|-------------------|-------------------------------------------------------------------
    TOTAL      |    final int      |    The max. number of scores, which is 10.
    -----------|-------------------|-------------------------------------------------------------------
    count      |    int            |    The number of existing scores.
    -----------|-------------------|-------------------------------------------------------------------
    key        |    char           |    The choice of the user to go back to menu or clear data.
    -----------|-------------------|-------------------------------------------------------------------
    x          |    int            |    The loop variable used in the for loops.
    -----------|-------------------|-------------------------------------------------------------------
    e          | Exception variable|    The variable for the IOException, NumberFormatException.

    *** Loops
    * For Loop #1:
      Used to read in the existing high scores.
      It uses the loop variable x, starts from 0, ends when x gets to 10, with an increment of +1.
    * For Loop #2:
      Used to output the existing high scores to the screen.
      It uses the loop variable x, starts from 0, ends when x gets to count, with an increment of +1.

    *** Conditional Statements
    * If Structure #1:
      Used to check if the header in the file is correct.
      If the header is correct, then read in the data.
    * If Structure #2:
      Used to check for the situation where there aren't 10 existing scores.
      If the user name read in is null, then break for loop #1.
    * If Structure #3:
      Used to check if the user chooses to clear data.
      If the key is 'c' or 'C', then clear data.

    *** Segment Block
    * Try Block #1, #3 (the numbers are in order):
      Used for File IO, catches an IOException.
    * Try Block #2:
      Used to convert String to an int, catches a NumberFormatException.
    */
    public void highScore ()
    {
	drawTitle ();
	c.println ("High Scores");

	final int TOTAL = 10;
	String[] userNames = new String [TOTAL];
	int[] scores = new int [TOTAL];
	int[] levels = new int [TOTAL];

	sort (userNames, scores, levels);

	int count = 0;
	try
	{
	    BufferedReader in = new BufferedReader (new FileReader ("High Scores.ang"));
	    if (in.readLine ().equals ("Mahjong Scores"))
	    {
		for (int x = 0 ; x < TOTAL ; x++)
		{
		    userNames [x] = in.readLine ();
		    if (userNames [x] == null)
			break;
		    scores [x] = Integer.parseInt (in.readLine ());
		    levels [x] = Integer.parseInt (in.readLine ());
		    count++;
		}
	    }
	}
	catch (IOException e)
	{
	}
	catch (NumberFormatException e)
	{
	}

	char key;
	c.print (' ', 20);
	c.print ("User Name", 32);
	c.print ("Score", 32);
	c.println ("Level");
	c.println ();

	for (int x = 0 ; x < count ; x++)
	{
	    c.print (x + 1 + ".", 20);
	    c.print (userNames [x] + "", 32);
	    c.print (scores [x] + "", 32);
	    c.println (levels [x]);
	}

	c.println ();
	c.println ("Press any key to go back to the main menu...");
	c.print ("Or press 'c' to clear all data.");
	key = c.getChar ();
	if (key == 'c' || key == 'C')
	{
	    try
	    {
		PrintWriter out = new PrintWriter (new FileWriter ("High Scores.ang"));
		out.println ("Mahjong Scores");
	    }
	    catch (IOException e)
	    {
	    }
	    gameWon = false;
	}
	score = 0;
    }


    /* public method - easy, the easy level (Level 1) of the game, a 5*6*2 game board, 48 tiles

    *** Variable chart -- local variables
    Name   |    Type       |    Purpose
    -------|---------------|------------------------------------------------------------------
    x      |    int        |    This is a variable used in multiple loops.
    -------|---------------|------------------------------------------------------------------
    y      |    int        |    This is a variable used in multiple loops.
    -------|---------------|------------------------------------------------------------------
    z      |    int        |    This is a variable used in multiple loops.
    -------|---------------|------------------------------------------------------------------
    R      |    final int  |    The number of rows of the game board.
    -------|---------------|------------------------------------------------------------------
    C      |    final int  |    The number of columns of the game board.
    -------|---------------|------------------------------------------------------------------
    L      |    final int  |    The number of layers of the game board.
    -------|---------------|------------------------------------------------------------------
    NUMBER |    final int  |    The number of tiles in this level of game.
    -------|---------------|------------------------------------------------------------------
    tile   |    int[]      |    The number of the tiles in this level of game.
    -------|---------------|------------------------------------------------------------------
    rand   |    int        |    The number of the tile to switch.
    -------|---------------|------------------------------------------------------------------
    num    |    int        |    The middle variable for switching tiles.
    -------|---------------|------------------------------------------------------------------
    tileNum|    int        |    The number of tiles that are initialized.
    -------|---------------|------------------------------------------------------------------
    counter|    int        |    The number of flower and season tiles.
    -------|---------------|------------------------------------------------------------------
    random |    int[]      |    The number of the picture (1-4) for the flower and season tiles.

    *** Loops
    * For Loop #1:
      Used to get random tiles, making sure there are at least 2 of the same tiles in the game.
    * For Loop #2:
      Used to shuffle the tiles (in for loop 1, each tile has a same one beside it).
    * For Loops #3-7:
      Used to initialize tiles[][][] in the pattern of this game.
    * For Loop #8:
      Used to get the random numbers betweeen 0 and 3 inclusive for the pictures of the flower and season tiles.
    * For Loop #9:
      Used to output the row numbers beside the game board rows.
    * For Loop #10:
      Used to output the column numbers above the game board columns.
    */
    public void easy ()
    {
	drawTitle ();
	c.setColor (background);
	c.fillRect (0, 40, 880, 600);
	c.println ("Easy - Level 1");
	c.println ();
	c.println ("You may enter 99");
	c.println ("for the row of the");
	c.println ("first tile to exit");
	c.println ("the game. Your game");
	c.println ("would not be saved.");

	final int R = 5, C = 6, L = 2;
	final int NUMBER = 48;
	int[] tile = new int [NUMBER];
	int rand, num, tileNum = 0;
	int counter = 0;

	for (int x = 0 ; x < NUMBER ; x += 2)
	{
	    tile [x] = (int) (Math.random () * 36 + 1);
	    tile [x + 1] = tile [x];
	    if (tile [x] == 35 || tile [x] == 36)
		counter += 2;
	}
	for (int x = 0 ; x < NUMBER / 2 ; x++)
	{
	    rand = (int) (Math.random () * NUMBER);
	    num = tile [x];
	    tile [x] = tile [rand];
	    tile [rand] = num;
	}
	// initialize loops
	for (int z = 0 ; z < 2 ; z++)
	{
	    for (int x = 0 ; x < 5 ; x++)
	    {
		for (int y = 0 ; y < 2 ; y++)
		{
		    tiles [x] [y] [z] = tile [tileNum];
		    tileNum++;
		    tiles [x] [y + 4] [z] = tile [tileNum];
		    tileNum++;
		}
	    }
	    for (int x = 1 ; x < 3 ; x++)
	    {
		for (int y = 2 ; y < 4 ; y++)
		{
		    tiles [x] [y] [z] = tile [tileNum];
		    tileNum++;
		}
	    }
	}

	int[] random = new int [counter];
	for (int x = 0 ; x < counter ; x++)
	    random [x] = (int) (Math.random () * 4 - 1);

	c.setColor (Color.black);
	for (int x = 1 ; x <= R ; x++)
	    c.drawString (x + "", 230, 103 + (x - 1) * LENGTH);
	for (int x = 1 ; x <= C ; x++)
	    c.drawString (x + "", 280 + (x - 1) * WIDTH, 45);

	userInput (R, C, L, NUMBER, random);
    }


    /* public method - medium, the medium level (Level 2) of the game, a 6*6*3 game board, 56 tiles
       all variables and loops are the same as the method easy, just that the variables have different values, and initializing loops are slightly different.
    */
    public void medium ()
    {
	drawTitle ();
	c.setColor (background);
	c.fillRect (0, 40, 880, 600);
	c.println ("Medium - Level 2");
	c.println ();
	c.println ("You may enter 99");
	c.println ("for the row of the");
	c.println ("first tile to exit");
	c.println ("the game. Your game");
	c.println ("would not be saved.");

	final int R = 6, C = 6, L = 3;
	final int NUMBER = 56;
	int[] tile = new int [NUMBER];
	int rand, num, tileNum = 0;
	int counter = 0;

	for (int x = 0 ; x < NUMBER ; x += 2)
	{
	    tile [x] = (int) (Math.random () * 36 + 1);
	    tile [x + 1] = tile [x];
	    if (tile [x] == 35 || tile [x] == 36)
		counter += 2;
	}
	for (int x = 0 ; x < NUMBER / 2 ; x++)
	{
	    rand = (int) (Math.random () * NUMBER);
	    num = tile [x];
	    tile [x] = tile [rand];
	    tile [rand] = num;
	}

	// initialize loops
	for (int x = 0 ; x < 6 ; x++)
	{
	    for (int y = 0 ; y < 6 ; y++)
	    {
		tiles [x] [y] [2] = tile [tileNum];
		tileNum++;
	    }
	}
	for (int x = 1 ; x < 5 ; x++)
	{
	    for (int y = 1 ; y < 5 ; y++)
	    {
		tiles [x] [y] [1] = tile [tileNum];
		tileNum++;
	    }
	}
	for (int x = 2 ; x < 4 ; x++)
	{
	    for (int y = 2 ; y < 4 ; y++)
	    {
		tiles [x] [y] [0] = tile [tileNum];
		tileNum++;
	    }
	}

	int[] random = new int [counter];
	for (int x = 0 ; x < counter ; x++)
	    random [x] = (int) (Math.random () * 4 - 1);

	c.setColor (Color.black);
	for (int x = 1 ; x <= R ; x++)
	    c.drawString (x + "", 230, 103 + (x - 1) * LENGTH);
	for (int x = 1 ; x <= C ; x++)
	    c.drawString (x + "", 285 + (x - 1) * WIDTH, 45);

	userInput (R, C, L, NUMBER, random);
    }


    /* public method - hard, the hard level (Level 3) of the game, a 6*8*2 game board, 64 tiles
       all variables and loops are the same as the method easy, just that the variables have different values, and initializing loops are slightly different.
    */
    public void hard ()
    {
	drawTitle ();
	c.setColor (background);
	c.fillRect (0, 40, 880, 600);
	c.println ("Hard - Level 3");
	c.println ();
	c.println ("You may enter 99");
	c.println ("for the row of the");
	c.println ("first tile to exit");
	c.println ("the game. Your game");
	c.println ("would not be saved.");

	final int R = 6, C = 8, L = 2;
	final int NUMBER = 64;
	int[] tile = new int [NUMBER];
	int rand, num, tileNum = 0;
	int counter = 0;

	for (int x = 0 ; x < NUMBER ; x += 2)
	{
	    tile [x] = (int) (Math.random () * 36 + 1);
	    tile [x + 1] = tile [x];
	    if (tile [x] == 35 || tile [x] == 36)
		counter += 2;
	}
	for (int x = 0 ; x < NUMBER / 2 ; x++)
	{
	    rand = (int) (Math.random () * NUMBER);
	    num = tile [x];
	    tile [x] = tile [rand];
	    tile [rand] = num;
	}

	// initialize loops
	for (int z = 0 ; z < 2 ; z++)
	{
	    for (int x = 1 ; x < 3 ; x++)
	    {
		tiles [0] [x] [z] = tile [tileNum];
		tileNum++;
		tiles [0] [x + 4] [z] = tile [tileNum];
		tileNum++;
		tiles [5] [x + 2] [z] = tile [tileNum];
		tileNum++;
		for (int y = 0 ; y < 8 ; y++)
		{
		    tiles [x] [y] [z] = tile [tileNum];
		    tileNum++;
		}
	    }
	    for (int x = 2 ; x < 6 ; x++)
	    {
		tiles [4] [x] [z] = tile [tileNum];
		tileNum++;
	    }
	    for (int x = 1 ; x < 7 ; x++)
	    {
		tiles [3] [x] [z] = tile [tileNum];
		tileNum++;
	    }
	}

	int[] random = new int [counter];
	for (int x = 0 ; x < counter ; x++)
	    random [x] = (int) (Math.random () * 4 - 1);

	c.setColor (Color.black);
	for (int x = 1 ; x <= R ; x++)
	    c.drawString (x + "", 170, 103 + (x - 1) * LENGTH);
	for (int x = 1 ; x <= C ; x++)
	    c.drawString (x + "", 220 + (x - 1) * WIDTH, 45);

	userInput (R, C, L, NUMBER, random);
    }


    // public method - goodbye, outputs the goodbye screen, window closes when user presses a key
    public void goodbye ()
    {
	drawTitle ();
	c.println ("Thank you for using this program!");
	c.println ("Hope you enjoyed!");
	c.println ();
	c.println ("This program will automatically close when you press a key.");
	pauseProgram ();
	c.close ();
    }


    private void time ()
    {
	t = new TimerClass (c, gameWon);
	t.start ();
    }


    // class constructor
    public Mahjong ()
    {
	c = new Console (32, 110, "The Mahjong Tile Game!");
    }


    /* main method

    *** Variable chart -- class variables
    Name        |    Type           |    Purpose
    ------------|-------------------|----------------------------------------------------------------------------
    m           |    reference      |    This is the reference variable associated with the class,
		|    variable       |    it gives access to all the methods written in this class.

    *** Loops
    * Do-While Loop:
      Used to make the program keep on going back to the main menu until the user chooses to exit.
      The loop exits when choice equals to '6', which the user chooses to exit.

    *** Conditional Statements
    * If Structure #1:
      Used to check if choice equals to '6', which the user chooses to exit.
      If choice does not equal to '6', then it goes to the next if structure.
    * If Structure #2:
      Used to check the value of choice, and goes to different screens depending on different values of choice.
    */
    public static void main (String[] args)
    {
	Mahjong m = new Mahjong ();
	m.loadImage ();
	//m.splashScreen ();
	do
	{
	    m.mainMenu ();
	    if (!m.choice.equals ("6"))
	    {
		if (m.choice.equals ("1"))
		    m.easy ();
		else if (m.choice.equals ("2"))
		    m.medium ();
		else if (m.choice.equals ("3"))
		    m.hard ();
		else if (m.choice.equals ("5") && m.gameWon == true)
		    m.highScore ();
		else
		    if (m.choice.equals ("4"))
			m.instructions ();
	    }
	}
	while (!m.choice.equals ("6"));
	m.goodbye ();
    }
}
