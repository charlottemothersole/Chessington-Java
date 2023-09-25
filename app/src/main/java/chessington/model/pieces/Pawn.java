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
        //Use current coords of piece
        //Calculate valid moves coords - same col, row -1
        //return the list of the valid moves
        Move validMove = new Move(from, from.plus(-1, 0));
        ArrayList<Move> possibleMoves = new ArrayList<>();
        possibleMoves.add(validMove);
        return possibleMoves;
    }
}
