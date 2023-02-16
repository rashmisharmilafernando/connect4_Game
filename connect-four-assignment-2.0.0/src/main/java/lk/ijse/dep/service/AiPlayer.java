package lk.ijse.dep.service;

public class AiPlayer extends Player {

    /*int[][] virtualBoard =new int[Board.NUM_OF_COLS][Board.NUM_OF_ROWS];
    int minWinnerScore=Integer.MAX_VALUE;
    int maxWinnerScore=Integer.MIN_VALUE;
    int findColumn=0;
    int findScore;*/

    public AiPlayer(Board board) {
        super(board);
    }
    @Override
    public void movePiece(int col)  {
        //random Number...

       /* do {
            col = (int) (0+Math.random() * 6);
        }while (!(board.isLeagalMoves(col)));*/

        col=board.minimax();

        //col= findColumn();

        if(board.isLeagalMoves(col)){
            board.updateMove(col,Piece.GREEN);
            board.getBoardUI().update(col, false);
            Winner winner = board.findWinner();

            if(winner!=null){
                board.getBoardUI().notifyWinner(winner);
            }else{
                if(!board.exitLeagaMoves()){
                    board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                }
            }
        }
    }
    // minimax Algorithm......
   /* public boolean isFull(){
        for (int col=0;col<virtualBoard.length;col++){
            for (int row=0;row<virtualBoard[col].length;row++){
                if (virtualBoard[col][row]==0)
                    return false;
            }
        }
        return true;
    }

    public  void setPlace(){
        Piece [][]pieces=BoardImpl.getPieces();

        for (int col=0;col<virtualBoard.length;col++){
            for (int row=0;row<virtualBoard[col].length;row++){
                if (pieces[col][row]==Piece.BLUE){
                    virtualBoard[col][row]=1;
                }else if (pieces[col][row]==Piece.GREEN){
                    virtualBoard[col][row]=2;
                }else if(pieces[col][row]==Piece.EMPTY){
                    virtualBoard[col][row]=0;
                }
            }
        }
    }

    public  int findColumn(){
        setPlace();

        for (int col=0;col<virtualBoard.length;col++){
            for (int row=0;row<virtualBoard[col].length;row++){
                if (virtualBoard[col][row]==0) {
                    virtualBoard[col][row] = 1;
                    int getScore = minimax(virtualBoard, 0, false, col, row);
                    virtualBoard[col][row] = 0;
                        if (getScore > maxWinnerScore) {
                            minWinnerScore = getScore;
                            findColumn = col;
                        }
                    }
                }
            }
        System.out.println(findColumn);
            return  findColumn;
        }


    private int minimax(int[][] virtualBoard, int depth, boolean isMax, int col, int row) {
        int winner=findWinner(virtualBoard,col,row);
        if (depth ==4 || isFull() !=false){
            if (winner==0)
                return  findWinner(virtualBoard,col,row);
        }

        if (isMax){
            findScore=maxWinnerScore;
            for (col=0;col<virtualBoard.length;col++){
                for (row=0;row<virtualBoard[col].length;row++) {
                    if (virtualBoard[col][row]==0){
                        virtualBoard[col][row]=1;
                        int getScore=minimax(virtualBoard,depth+1,false,col,row);
                        virtualBoard[col][row]=0;
                         findScore=Math.max(getScore,findScore);
                     }
                }
            }
            return findColumn;
        }else {
            findScore=minWinnerScore;
            for (col = 0; col < virtualBoard.length; col++) {
                for (row = 0; row < virtualBoard[col].length; row++) {
                    if (virtualBoard[col][row] == 0) {
                        virtualBoard[col][row] = -1;
                        int getScore = minimax(virtualBoard, depth + 1, true, col, row);
                        virtualBoard[col][row] = 0;
                        findScore = Math.max(getScore, findScore);
                    }
                }
            }
            return findScore;
        }
    }

    private int findWinner(int[][] virtualBoard, int col, int row) {
        int player=virtualBoard[col][row];
        int count=0;
        int nextcol;
        int nextRow;

        L1: while(true) {
            for (int i = row; i >= 0; i--) {
                if (virtualBoard[col][i] == player) {
                    count++;
                   nextRow = i;
                } else {
                    break;
                }
                if (count == 4) {
                    return player;
                }
            }

            L2:while (true) {
                count = 0;
                nextcol= 0;
                nextRow = 0;
                L3:
                for (int i = col; i < virtualBoard.length; i++) {
                    if (virtualBoard[i][row] == player) {
                        count++;
                        nextcol = i;
                        nextRow= row;

                        if (count == 4) {

                            return player;
                        }

                    } else {
                        break L3;
                    }

                }


                if (col== 0) {
                    break L1;
                }

                for (int i = col; i >= 0; i--) {
                    if (i>0 && virtualBoard[i - 1][row] == player) {
                        count++;
                        nextcol= i;
                        nextRow= row;

                        if (count == 4) {

                            return player;

                        }
                    } else {
                        break L1;
                    }
                }
            }
        }
        return 0;
    }*/
}
