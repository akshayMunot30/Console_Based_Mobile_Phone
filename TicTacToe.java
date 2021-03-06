import java.util.Scanner;

public class TicTacToe
{
    private int counter;
    private   char posn[]=new char[10];
    private   char player;


    public  void newBoard()
    {
        char posndef[] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};    // Define the 9 positions on board
        int i;
        counter = 0;
        player = 'X';
        for (i=1; i<10; i++)
            posn[i]=posndef[i];    //naming the positions with numbers
        currentBoard();


    }
    public  String currentBoard()
    {
        // Creating the board on the console with position numbers
        System.out.println(  "\n\t\t" + posn [1] + "   | " +posn [2]+ "  | " +posn [3]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t ___|____|___ " );
        System.out.println(  "\t\t" +posn [4]+ "   | " +posn [5]+ "  | " +posn [6]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t ___|____|___ " );
        System.out.println(  "\t\t" +posn [7]+ "   | " +posn [8]+ "  | " +posn [9]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  "\n" );
        return "currentBoard";
    }

    // initiating the game
    public  void play()
    {
        int spot;
        char blank = ' ';

        System.out.println(  "Player " + getPlayer() +" will go first and be the letter 'X'" );

        do {
            currentBoard();              // display current board

            System.out.println(  "Player " + getPlayer() +" choose a posn." );   //player chooses his position

            boolean posTaken = true;
            while (posTaken) {

                Scanner in =new Scanner (System.in);    // take input as which position to be marked
                spot=in.nextInt();
                posTaken = checkPosn(spot);    //check if position is taken
                if(posTaken==false)
                    posn[spot]=getPlayer();
            }

            System.out.println(  "Nice move." );

            currentBoard();              // display current board after player plays

            nextPlayer();    //prompt the next player to play
        }while ( checkWinner() == blank );

    }

    // function to check if any wining combinations occurred
    public  char checkWinner()
    {
        char Winner = ' ';

        // Check if X wins
        if (posn[1] == 'X' && posn[2] == 'X' && posn[3] == 'X')
            Winner = 'X';
        if (posn[4] == 'X' && posn[5] == 'X' && posn[6] == 'X')
            Winner = 'X';
        if (posn[7] == 'X' && posn[8] == 'X' && posn[9] == 'X')
            Winner = 'X';
        if (posn[1] == 'X' && posn[4] == 'X' && posn[7] == 'X')
            Winner = 'X';
        if (posn[2] == 'X' && posn[5] == 'X' && posn[8] == 'X')
            Winner = 'X';
        if (posn[3] == 'X' && posn[6] == 'X' && posn[9] == 'X')
            Winner = 'X';
        if (posn[1] == 'X' && posn[5] == 'X' && posn[9] == 'X')
            Winner = 'X';
        if (posn[3] == 'X' && posn[5] == 'X' && posn[7] == 'X')
            Winner = 'X';
        if (Winner == 'X' )
        {
            System.out.println("Player1 wins the game." );
            return Winner;
        }

        // Check if O wins
        if (posn[1] == 'O' && posn[2] == 'O' && posn[3] == 'O')
            Winner = 'O';
        if (posn[4] == 'O' && posn[5] == 'O' && posn[6] == 'O')
            Winner = 'O';
        if (posn[7] == 'O' && posn[8] == 'O' && posn[9] == 'O')
            Winner = 'O';
        if (posn[1] == 'O' && posn[4] == 'O' && posn[7] == 'O')
            Winner = 'O';
        if (posn[2] == 'O' && posn[5] == 'O' && posn[8] == 'O')
            Winner = 'O';
        if (posn[3] == 'O' && posn[6] == 'O' && posn[9] == 'O')
            Winner = 'O';
        if (posn[1] == 'O' && posn[5] == 'O' && posn[9] == 'O')
            Winner = 'O';
        if (posn[3] == 'O' && posn[5] == 'O' && posn[7] == 'O')
            Winner = 'O';
        if (Winner == 'O' )
        {
            System.out.println( "Player2 wins the game." );
            return Winner;
        }

        // check for Tie
        for(int i=1;i<10;i++)
        {
            if(posn[i]=='X' || posn[i]=='O')
            {
                if(i==9)
                {
                    char Draw='D';
                    System.out.println(" Game is stalemate ");
                    return Draw;
                }
                continue;
            }
            else
                break;

        }

        return Winner;
    }

    //check if position is already taken
    public  boolean checkPosn(int spot)
    {


        if (posn[spot] == 'X' || posn[spot] == 'O')
        {
            System.out.println("That posn is already taken, please choose another");
            return true;
        }
        else {
            return false;
        }

    }

    //prompt next player on console
    public  void nextPlayer()
    {
        if (player == 'X')
            player = 'O';
        else
            player = 'X';
    }

    public String getTitle()
    {
        return "Tic Tac Toe" ;
    }

    public  char getPlayer()
    {
        return player;
    }

}