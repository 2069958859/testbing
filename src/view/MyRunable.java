package view;

import model.ChessColor;

import java.awt.*;

import static view.ChessGameFrame.*;
import static view.Chessboard.*;

public class MyRunable implements Runnable {
    public ChessGameFrame chessGameFrame;

    public MyRunable(ChessGameFrame chessGameFrame) {
        this.chessGameFrame = chessGameFrame;
    }

    @Override
    public void run() {
        for (int i = 0; i < recordchessboard.size(); i++) {
            chessGameFrame.getGameController().getChessboard().getLastChessBoard(recordchessboard.size() - i);
            if (Chessboard.getRecordchessboard().get(getRecordchessboard().size() - 1).charAt(Chessboard.getRecordchessboard().get(getRecordchessboard().size() - 1).length() - 1) == 'w') {
                setCurrentColor(ChessColor.BLACK);
            }
            if (Chessboard.getRecordchessboard().get(getRecordchessboard().size() - 1).charAt(Chessboard.getRecordchessboard().get(getRecordchessboard().size() - 1).length() - 1) == 'b') {
                setCurrentColor(ChessColor.WHITE);
            }

            chessGameFrame.repaint();
            try {
                showwhite();
                if (Chessboard.getRecordchessboard().get(i).charAt(Chessboard.getRecordchessboard().get(getRecordchessboard().size() - 1).length() - 1) == 'w') {
                    showwhite();
                }
                if (Chessboard.getRecordchessboard().get(i).charAt(Chessboard.getRecordchessboard().get(getRecordchessboard().size() - 1).length() - 1) == 'b') {
                    showblack();
                }
//                recordchessboard.add("R0N0B0Q0K0B0N0R0*P0P0P0P0P0P0P0P0*_0_0_0_0_0_0_0_0*_0_0_0_0_0_0_0_0*_0_0_0_0_0_0_0_0*_0_0_0_0_0_0_0_0*p0p0p0p0p0p0p0p0*r0n0b0q0k0b0n0r0*w");

                chessGameFrame.repaint();
//                if (Chessboard.getRecordchessboard().get(i).charAt(Chessboard.getRecordchessboard().get(getRecordchessboard().size() - 1).length() - 1) == 'b') {
//                    showwhite();
//                }
//                if (Chessboard.getRecordchessboard().get(i).charAt(Chessboard.getRecordchessboard().get(getRecordchessboard().size() - 1).length() - 1) == 'w') {
//                    showblack();
//                }
                Thread.sleep(500);


            } catch (Exception e) {

            }
        }
        chessGameFrame.getGameController().getChessboard().initall();
        showwhite();
        setCurrentColor(ChessColor.WHITE);
        chessGameFrame.repaint();


    }


}
