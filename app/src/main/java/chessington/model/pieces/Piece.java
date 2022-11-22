package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.Move;
import chessington.model.PlayerColour;

import java.util.List;

public interface Piece {
    enum PieceType {
        PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING
    }

    PieceType getType();
    PlayerColour getColour();

    List<Move> getAllowedMoves(Coordinates from, Board board);
}
