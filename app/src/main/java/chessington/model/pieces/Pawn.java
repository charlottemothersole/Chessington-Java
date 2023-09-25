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

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        //get the colour of the piece instance
        String colour = this.colour.name();
        Move validMove;
        //empty list for the possible moves
        ArrayList<Move> possibleMoves = new ArrayList<>();
        //if piece is white, row num -1. If black, +1.
        if(colour == "WHITE") {
            validMove = new Move(from, from.plus(-1, 0));
            possibleMoves.add(validMove);
        } else if (colour == "BLACK") {
            validMove = new Move(from, from.plus(1, 0));
            possibleMoves.add(validMove);
        }
        return possibleMoves;
    }
}
