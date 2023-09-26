package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.Move;
import chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    public boolean isFirstMove(Coordinates from) {
        boolean isFirstMove = true;
        int row = from.getRow();
        if(checkColour() == "WHITE" && row != 6) {
            isFirstMove = false;
        } else if (checkColour() == "BLACK" && row != 1) {
            isFirstMove = false;
        }
        return isFirstMove;
    }

    public String checkColour() {
        String colour = this.colour.name();
        return colour;
    }

    public boolean isSpaceEmpty(Board board, Coordinates moveTo) {
        boolean isSpaceEmpty;
            if(board.get(moveTo) != null) {
                isSpaceEmpty = false;
            } else {
                isSpaceEmpty = true;
            }
        return isSpaceEmpty;
    }

    public boolean isWithinBoardBoundary(int potentialMoveRow, int finalRow) {
        boolean isWithinBoardBoundary;
        if(checkColour() == "WHITE" && potentialMoveRow < finalRow) {
            isWithinBoardBoundary = false;
        } else if (checkColour() == "BLACK" && potentialMoveRow > finalRow) {
            isWithinBoardBoundary = false;
        } else {
            isWithinBoardBoundary = true;
        }
        return isWithinBoardBoundary;
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        //consider refactoring with isFirstMove method in AbstractPiece?
        //ASK HOW THIS WORKS
        int direction = (this.colour == PlayerColour.WHITE) ? -1 : 1;
        Coordinates oneSquareAhead = from.plus(direction, 0);
        Coordinates twoSquaresAhead = from.plus(direction * 2, 0);
        Move potentialMove;
        //empty list for the possible moves
        ArrayList<Move> availableMoves = new ArrayList<>();
        //check if piece is white to decide if it is first move of piece or not
        if(checkColour() == "WHITE") {
            //if pawn on row 6 hasnt yet moved, can move 2 spaces forward
            if(isFirstMove(from) && isWithinBoardBoundary(twoSquaresAhead.getRow(), 0)) {
            //if potential move is not outside the board boundary, continue
                potentialMove = new Move(from, twoSquaresAhead);
                //if potential space is == null then can move to it
                if(isSpaceEmpty(board, twoSquaresAhead)) {
                    availableMoves.add(potentialMove);
                }
            }
            if(isWithinBoardBoundary(oneSquareAhead.getRow(), 0)) {
                // add the single space valid move too
                potentialMove = new Move(from, oneSquareAhead);
                if(isSpaceEmpty(board, oneSquareAhead)) {
                    availableMoves.add(potentialMove);
                }
            }
        } else if (checkColour() == "BLACK") {
            //if pawn on row 1 hasnt yet moved, can also move 2 spaces forward
            if(isFirstMove(from) && isWithinBoardBoundary(twoSquaresAhead.getRow(), 7)) {
                potentialMove = new Move(from, twoSquaresAhead);
                if(isSpaceEmpty(board, twoSquaresAhead)) {
                    availableMoves.add(potentialMove);
                }
            }
            if(isWithinBoardBoundary(oneSquareAhead.getRow(), 7)) {
                potentialMove = new Move(from, oneSquareAhead);
                if(isSpaceEmpty(board, oneSquareAhead)) {
                    availableMoves.add(potentialMove);
                }
            }
        }
        return availableMoves;
    }
}
