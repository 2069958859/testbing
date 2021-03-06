package controller;

import Music.Music;
import model.ChessComponent;
import view.Chessboard;

import java.io.File;

import static model.ChessComponent.playclick;

public class ClickController {
    private final Chessboard chessboard;
    private ChessComponent first;
    public static int n = 0;
    Music audioPlayWave2 = new Music("aa.wav");
    public ClickController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }
    public void onClick(ChessComponent chessComponent) {
        n++;
        if (first == null) {
            if (handleFirst(chessComponent)) {
                chessComponent.setSelected(true);
                first = chessComponent;

                playclick(new File(".\\yinxiao\\aa.wav"));
                first.repaint();

            }
        } else {
            if (first == chessComponent) {
                // 再次点击取消选取
                chessComponent.setSelected(false);
                ChessComponent recordFirst = first;
                first = null;
                playclick(new File(".\\yinxiao\\aa.wav"));

                recordFirst.repaint();
            } else if (handleSecond(chessComponent)) {
                //repaint in swap chess method.

                chessboard.swapChessComponents(first, chessComponent);
                chessboard.swapColor();
                chessboard.repaint();
                first.setSelected(false);
                first = null;
                playclick(new File(".\\yinxiao\\aa.wav"));

            }

        }
    }

    /**
     * @param chessComponent 目标选取的棋子
     * @return 目标选取的棋子是否与棋盘记录的当前行棋方颜色相同
     */

    private boolean handleFirst(ChessComponent chessComponent) {
        return chessComponent.getChessColor() == chessboard.getCurrentColor();
    }

    /**
     * @param chessComponent first棋子目标移动到的棋子second
     * @return first棋子是否能够移动到second棋子位置
     */

    private boolean handleSecond(ChessComponent chessComponent) {
        return chessComponent.getChessColor() != chessboard.getCurrentColor() && first.canMoveTo(chessboard.getChessComponents(), chessComponent.getChessboardPoint());
    }


}
