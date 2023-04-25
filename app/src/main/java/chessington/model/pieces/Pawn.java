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

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        //consider refactoring with isFirstMove method in AbstractPiece
        int row = from.getRow();
        System.out.println(row);
        Move validMove;
        //empty list for the possible moves
        ArrayList<Move> possibleMoves = new ArrayList<>();
        //if piece is white, row num -1. If black, +1.
        if(checkColour() == "WHITE") {
            //if pawn on row 6 hasnt yet moved, can also move 2 spaces forward
            if(isFirstMove(from)) {
                validMove = new Move(from, from.plus(-2, 0));
                possibleMoves.add(validMove);
            }
            // add the single space valid move too
            validMove = new Move(from, from.plus(-1, 0));
            possibleMoves.add(validMove);
        } else if (checkColour() == "BLACK") {
            //if pawn on row 1 hasnt yet moved, can also move 2 spaces forward
            if(isFirstMove(from)) {
                validMove = new Move(from, from.plus(2, 0));
                possibleMoves.add(validMove);
            }
            // add the single space valid move too
            validMove = new Move(from, from.plus(1, 0));
            possibleMoves.add(validMove);
        }
        return possibleMoves;
    }
}
