package lk.ijse.dep.service;


public class BoardImpl implements  Board {
    private static Piece[][] piece = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
    private BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;

        for (int colu = 0; colu < 6; colu++) {
            for (int row = 0; row < 5; row++) {
                piece[colu][row] = Piece.EMPTY;
            }
        }
    }

    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }
    public static Piece[][] getPieces(){return  piece;}

    @Override
    public int findNextAvailableSport(int col) {
        for (int row = 0; row < 5; row++) {
            if (piece[col][row] == Piece.EMPTY) {

                return row;
            }
        }
        return -1;
    }

    @Override
    public boolean isLeagalMoves(int col) {
        if (findNextAvailableSport(col) == -1) {
            return false;
        }
        return true;
    }


    @Override
    public boolean exitLeagaMoves() {
        for (int i=0; i<6; i++){
            for (int j=0; j<5; j++) {
                if(pieces[i][j] == Piece.EMPTY){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        for (int i = 0; i < 5; i++) {
            if (piece[col][i] == Piece.EMPTY) {
                piece[col][i] = move;
                break;
            }
        }
    }

    @Override
    public void updateMove(int col, int row, Piece move) {
        piece[col][row] = move;
    }

    @Override
    public Winner findWinner() {
        Winner winner;
        //horizontally
        for (int row = 0; row <5; row++) {
            for (int column = 0; column < 3; column++) {
                if ((piece[column][row] == Piece.BLUE) & (piece[column + 1][row] == Piece.BLUE) & (piece[column + 2][row] == Piece.BLUE) & (piece[column + 3][row] == Piece.BLUE)) {
                    winner = new Winner(Piece.BLUE, column, row, column + 3, row);
                    System.out.println("\n[c][r] = "+"["+column+"]["+row+"]\t result = "+piece[column][row]);
                    return winner;
                }

            }
        }

        //vertically.
        for (int column = 0; column < 6; column++) {
            for (int row = 0; row < 2; row++) {
                if ((piece[column][row] == Piece.BLUE) & (piece[column][row + 1] == Piece.BLUE) & (piece[column][row + 2] == Piece.BLUE) & (piece[column][row + 3] == Piece.BLUE)) {
                    winner = new Winner(Piece.BLUE, column, row, column, row + 3);
                   /* System.out.println("\n[c][r] = "+"["+column+"]["+row+"]\t result = "+piece[column][row]);
                    System.out.println("\n[c][r] = "+"["+column+"]["+(row+1)+"]\t result = "+piece[column][row+1]);
                    System.out.println("\n[c][r] = "+"["+column+"]["+(row+2)+"]\t result = "+piece[column][row+2]);
                    System.out.println("\n[c][r] = "+"["+column+"]["+(row+3)+"]\t result = "+piece[column][row+3]);*/
                    return winner;
                }
            }
        }

        //horizontally
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 3; column++) {
                if ((piece[column][row] == Piece.GREEN) & (piece[column + 1][row] == Piece.GREEN) & (piece[column + 2][row] == Piece.GREEN) & (piece[column + 3][row] == Piece.GREEN)) {
                    winner = new Winner(Piece.GREEN, column, row, column + 3, row);
                    System.out.println("\n[c][r] = "+"["+column+"]["+row+"]\t result = "+piece[column][row]);
                    return winner;
                }
            }
        }
        //vertically.
        for (int column = 0; column < 6; column++) {
            for (int row = 0; row < 2; row++) {
                if ((piece[column][row] == Piece.GREEN) & (piece[column][row + 1] == Piece.GREEN) & (piece[column][row + 2] == Piece.GREEN) & (piece[column][row + 3] == Piece.GREEN)) {
                    winner = new Winner(Piece.GREEN, column, row, column, row + 3);
                    System.out.println("\n[c][r] = "+"["+column+"]["+row+"]\t result = "+piece[column][row]);
                    return winner;
                }
            }
        }
        return null;
    }


    public int minimax() {
        for (int row = 0; row <5; row++) {
            for (int column = 0; column < 3; column++) {
                if ((piece[column][row] == Piece.BLUE ) & (piece[column+1][row ] == Piece.BLUE ) & (piece[column+2][row] == Piece.BLUE ) & (piece[column+3][row] == Piece.EMPTY )) {return column;}
                if ((piece[column][row] == Piece.BLUE) & (piece[column+1][row] == Piece.BLUE) & (piece[column+2][row ] == Piece.EMPTY) & (piece[column+3][row ] == Piece.BLUE)) {return column;}
                if ((piece[column][row] == Piece.BLUE) & (piece[column+1][row ] == Piece.EMPTY) & (piece[column+2][row ] == Piece.BLUE) & (piece[column+3][row] == Piece.BLUE)) {return column;}
                if ((piece[column][row] == Piece.EMPTY) & (piece[column+1][row] == Piece.BLUE) & (piece[column+2][row ] == Piece.BLUE) & (piece[column+3][row ] == Piece.BLUE)) {return column;}
                if ((piece[column][row] == Piece.GREEN) & (piece[column+1][row] == Piece.GREEN) & (piece[column+2][row] == Piece.GREEN) & (piece[column+3][row] == Piece.EMPTY)) {return column;}
                if ((piece[column][row] == Piece.GREEN) & (piece[column+1][row] == Piece.GREEN) & (piece[column+2][row] == Piece.EMPTY) & (piece[column+3][row] == Piece.GREEN)) {return column;}
                if ((piece[column][row] == Piece.GREEN) & (piece[column+1][row] == Piece.EMPTY) & (piece[column+2][row] == Piece.GREEN) & (piece[column+3][row] == Piece.GREEN)) {return column;}
                if ((piece[column][row] == Piece.EMPTY) & (piece[column+1][row] == Piece.GREEN) & (piece[column+2][row] == Piece.GREEN) & (piece[column+3][row] == Piece.GREEN)) {return column;}
            }
        }

        for (int column = 0; column < 6; column++) {
            for (int row = 0; row < 2; row++) {
                if ((piece[column][row] == Piece.BLUE ) & (piece[column][row + 1] == Piece.BLUE ) & (piece[column][row + 2] == Piece.BLUE ) & (piece[column][row + 3] == Piece.EMPTY )) {return column;}
                if ((piece[column][row] == Piece.BLUE) & (piece[column][row + 1] == Piece.BLUE) & (piece[column][row + 2] == Piece.EMPTY) & (piece[column][row + 3] == Piece.BLUE)) {return column;}
                if ((piece[column][row] == Piece.BLUE) & (piece[column][row + 1] == Piece.EMPTY) & (piece[column][row + 2] == Piece.BLUE) & (piece[column][row + 3] == Piece.BLUE)) {return column;}
                if ((piece[column][row] == Piece.EMPTY) & (piece[column][row + 1] == Piece.BLUE) & (piece[column][row + 2] == Piece.BLUE) & (piece[column][row + 3] == Piece.BLUE)) {return column;}
                if ((piece[column][row] == Piece.GREEN) & (piece[column][row + 1] == Piece.GREEN) & (piece[column][row + 2] == Piece.GREEN) & (piece[column][row + 3] == Piece.EMPTY)) {return column;}
                if ((piece[column][row] == Piece.GREEN) & (piece[column][row + 1] == Piece.GREEN) & (piece[column][row + 2] == Piece.EMPTY) & (piece[column][row + 3] == Piece.GREEN)) {return column;}
                if ((piece[column][row] == Piece.GREEN) & (piece[column][row + 1] == Piece.EMPTY) & (piece[column][row + 2] == Piece.GREEN) & (piece[column][row + 3] == Piece.GREEN)) {return column;}
                if ((piece[column][row] == Piece.EMPTY) & (piece[column][row + 1] == Piece.GREEN) & (piece[column][row + 2] == Piece.GREEN) & (piece[column][row + 3] == Piece.GREEN)) {return column;}
            }
        }
        while(true){
            int col = (int)(Math.random() * 6);
            if(isLeagalMoves(col)){}
        }
    }
}



